package com.shuhao.main.modules.contract.service.impl;

import com.shuhao.main.dao.ContractMapper;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.contract.dto.ContractParam;
import com.shuhao.main.modules.contract.service.ContractService;
import com.shuhao.main.modules.fileupload.FileUploadService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.Contract;
import com.shuhao.main.vo.ContractExample;
import com.shuhao.main.vo.ElectricalSealUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private FileUploadService fileUploadService;


    @Override
    public JsonResult sendContract(String token, Contract contract) {
        if (contract.getContractName().isEmpty() || contract.getContractFile().isEmpty() || contract.getContractReceiver().isEmpty() || contract.getContractDate() == null){
            return ResultTool.error();
        }
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        String contractReceiver = contract.getContractReceiver();
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(contractReceiver);
        if (userByUsername == null){
            return ResultTool.error();
        }
        contract.setContractSponsor(account);
        contract.setContractStatus("1");
        Date date = new Date();
        contract.setContractCreatetime(date);
        int i = contractMapper.insertSelective(contract);
        if (i>0){
            return ResultTool.success();
        }else {
            return ResultTool.error();
        }
    }

    @Override
    public JsonResult<List<Contract>> getContract(String token) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        List<Contract> contracts = contractMapper.selectContract(account);
        for (Contract contract : contracts) {
            if (contract.getContractStatus().equals("1") || contract.getContractStatus().equals("2")){
                Date contractDate = contract.getContractDate();
                Date date = new Date();
                boolean after = contractDate.after(date);
                if (!after){
                    contract.setContractStatus("4");
                    contractMapper.updateByPrimaryKeySelective(contract);
                }
            }
        }
        return ResultTool.success(contracts);
    }

    @Override
    public JsonResult<Contract> getContractByid(String token, Integer id) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        Contract contract = contractMapper.selectByPrimaryKey(id);
        return ResultTool.success(contract);

    }

    @Override
    public JsonResult onContract(String token, ContractParam contractParam) throws Exception {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        if (contractParam.getContractId() == null){
            return ResultTool.error();
        }else if (contractParam.getSealUrl().isEmpty() && contractParam.getSignUrl().isEmpty()){
                return ResultTool.error();
            }else {
            Contract contract = contractMapper.selectByPrimaryKey(contractParam.getContractId());
            String contractStatus = contract.getContractStatus();
            if (contractStatus == "1"){
                if (!contract.getContractReceiver().equals(account)){
                    return ResultTool.error();
                }
            }
            if (contractStatus == "2"){
                if (!contract.getContractSponsor().equals(account)){
                    return ResultTool.error();
                }
            }
            if (contractStatus == "3" || contractStatus == "4"){
                return ResultTool.error();
            }
            String contractFile = contract.getContractFile();
            fileUploadService.downloadFile(contractFile,"/usr/contract.pdf");
            float SealWidth = 0;
            float SealHeight= 0;
            float SignWidth= 0;
            float SignHeight= 0;
            if (!contractParam.getSealWidth().isEmpty() && !contractParam.getSealHeight().isEmpty()){
                SealWidth = Float.parseFloat(contractParam.getSealWidth().replace("px",""));
                SealHeight = Float.parseFloat(contractParam.getSealHeight().replace("px",""));
                SealWidth = 592 * ( (SealWidth-470) / 592 );
                SealHeight = 840 * ( 1- ( (SealHeight-10) / 839) );
            }
            if (!contractParam.getSignWidth().isEmpty() && !contractParam.getSignHeight().isEmpty() ){
                SignWidth = Float.parseFloat(contractParam.getSignWidth().replace("px",""));
                SignHeight = Float.parseFloat(contractParam.getSignHeight().replace("px",""));
                System.out.println(SignHeight);
                SignWidth = 592 * ( (SignWidth-470) / 592 );
                SignHeight = 840 * ( 1- ( (SignHeight-82) / 839) );
            }

            if ( !contractParam.getSealUrl().isEmpty() ){
                fileUploadService.downloadFile(contractParam.getSealUrl(),"/usr/seal.png");
//                System.out.println(SealWidth);
//                System.out.println(SealHeight);
//                System.out.println(SignWidth);
//                System.out.println(SignHeight);
                byte[] sign = SignPdf.sign("123456", "/usr/keystore.p12", "/usr/contract.pdf",
                        "/usr/seal.png", SealWidth, SealHeight, contractParam.getPageNum(), 120, 120);
                FileOutputStream f = new FileOutputStream(new File("/usr/contract.pdf"));
                f.write(sign);
                f.close();
            }
            if ( !contractParam.getSignUrl().isEmpty() ){
//                System.out.println(SealWidth);
//                System.out.println(SealHeight);
//                System.out.println(SignWidth);
//                System.out.println(SignHeight);
                fileUploadService.downloadFile(contractParam.getSignUrl(),"/usr/sign.png");
                byte[] sign = SignPdf.sign("123456", "/usr/keystore.p12", "/usr/contract.pdf",
                        "/usr/sign.png", SignWidth, SignHeight, contractParam.getPageNum(), 120, 48);
                FileOutputStream f = new FileOutputStream(new File("/usr/contract.pdf"));
                f.write(sign);
                f.close();
            }
            //将合同上传到服务器
            File file = new File("/usr/contract.pdf");
            String upload = fileUploadService.upload(file);
            System.out.println(upload);
            //修改数据库表
            contract.setContractFile(upload);
            Date date = new Date();
            contract.setContractCompletetime(date);
            if (contract.getContractStatus().equals("1")){
                contract.setContractStatus("2");
            }else if (contract.getContractStatus().equals("2")){
                contract.setContractStatus("3");
            }
            contractMapper.updateByPrimaryKeySelective(contract);
            return ResultTool.success();
            }
    }
}
