package com.shuhao.main.modules.sign.service.impl;

import com.shuhao.main.dao.SealMapper;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.fileupload.FileUploadService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.modules.sign.service.UserSealService;
import com.shuhao.main.util.BASE64DecodedMultipartFile;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.ElectricalSealUser;
import com.shuhao.main.vo.Seal;
import com.shuhao.main.vo.SealExample;
import com.shuhao.main.vo.SealUserSignExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 印章管理业务操作层
 */
@Service
public class UserSealServiceImpl implements UserSealService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Autowired
    private SealMapper sealMapper;

    @Override
    public JsonResult addEnterpriseSeal(String token, Seal seal) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        if (!seal.getSealUrl().isEmpty()) {
            //将图片base64转为MultipartFile
            MultipartFile File = BASE64DecodedMultipartFile.base64ToMultipart(seal.getSealUrl());
            if (File.isEmpty()) {
                return ResultTool.error();
            }else {
                //上传图片File到COS
                String upload = fileUploadService.upload(File);
                if (upload.isEmpty()){
                    return ResultTool.error();
                }else {
                    //添加到数据库
                    seal.setSealUrl(upload);
                    seal.setUserId(userByUsername.getId());
                    seal.setState("启用");
                    Date date = new Date();
                    seal.setCreateTimestamp(date);
                    int i = sealMapper.insertSelective(seal);
                    if (i>0){
                        return ResultTool.success();
                    }else {
                        return ResultTool.error();
                    }
                }
            }
        }else {
            return ResultTool.error();
        }



    }

    @Override
    public JsonResult<List<Seal>> selectEnterpriseSeal(String token) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        Integer userId = userByUsername.getId();
        SealExample example = new SealExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<Seal> seals = sealMapper.selectByExample(example);
        return ResultTool.success(seals);
    }

    @Override
    public JsonResult delEnterpriseSeal(String token, String url) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        Integer userId = userByUsername.getId();
        SealExample example = new SealExample();
        example.createCriteria().andUserIdEqualTo(userId).andSealUrlEqualTo(url);
        int i = sealMapper.deleteByExample(example);
        if (i > 0){
            return ResultTool.success();
        }else {
            return ResultTool.error();
        }
    }
}
