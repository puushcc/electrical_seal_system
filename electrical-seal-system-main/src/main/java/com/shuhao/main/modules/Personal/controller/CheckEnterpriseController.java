package com.shuhao.main.modules.Personal.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.Personal.service.ICheckEnterpriseService;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.SealEnterprise;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 企业认证控制层
 * @author: scott
 * @date:
 */
@RestController
@Api(tags = "企业认证")
@RequestMapping("/enterprise")
public class CheckEnterpriseController {

    @Autowired
    private ICheckEnterpriseService checkEnterprise;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value = "判断是否为企业用户")
    @RequestMapping(value = "/checkByUser",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<SealEnterprise> checkPersonalByUser(@RequestHeader(value = "Authorization") String token){
        String account = jwtTokenUtil.getUserNameFromToken(token);
        boolean b = checkEnterprise.checkEnterpriseByROleName(account);
        if (!b){
            SealEnterprise sealEnterprise = checkEnterprise.checkByEnterpriseName(account);
            return ResultTool.error(sealEnterprise);
        }else {
            SealEnterprise sealEnterprise = checkEnterprise.checkByEnterpriseName(account);
            return ResultTool.success(sealEnterprise);
        }
    }


    @ApiOperation(value = "企业认证申请")
    @RequestMapping(value = "/checkByEnterprise",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkPersonalUser(@Validated @RequestBody SealEnterprise sealEnterprise, @RequestHeader(value = "Authorization") String token){
        return checkEnterprise.checkByEnterprise(sealEnterprise,token);
    }



}
