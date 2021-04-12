package com.shuhao.main.modules.contract.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.contract.dto.ContractParam;
import com.shuhao.main.modules.contract.service.ContractService;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.Contract;
import com.shuhao.main.vo.Seal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 合同操作接口入口
 */
@RestController
@Api(tags = "合同操作接口入口")
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @ApiOperation(value = "发起合同")
    @RequestMapping(value = "/sendContract",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult sendContract(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody Contract contract){
        return contractService.sendContract(token,contract);
    }


    @ApiOperation(value = "获取合同数据")
    @RequestMapping(value = "/getContract",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<Contract>> getContract(@RequestHeader(value = "Authorization") String token){
        return contractService.getContract(token);
    }

    @ApiOperation(value = "获取合同")
    @RequestMapping(value = "/getContractByid",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Contract> getContractByid(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody Contract contract){
        return contractService.getContractByid(token,contract.getContractId());
    }

    @ApiOperation(value = "签约合同")
    @RequestMapping(value = "/onContract",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult onContract(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody ContractParam contractParam) throws Exception {
        System.out.println(contractParam.getSealUrl());
        System.out.println(contractParam.getSignUrl());
        return contractService.onContract(token,contractParam);
    }


}
