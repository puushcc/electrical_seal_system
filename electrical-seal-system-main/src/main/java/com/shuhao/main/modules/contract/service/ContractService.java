package com.shuhao.main.modules.contract.service;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.contract.dto.ContractParam;
import com.shuhao.main.vo.Contract;

import java.util.List;

public interface ContractService {

    /**
     *发起合同
     */
    JsonResult sendContract(String token, Contract contract);


    /**
     *获取合同数据
     */
    JsonResult<List<Contract>>  getContract(String token);

    /**
     *获取合同
     */
    JsonResult<Contract>  getContractByid(String token,Integer id);

    /**
     *签署合同
     */
    JsonResult onContract(String token, ContractParam contractParam) throws Exception;

}
