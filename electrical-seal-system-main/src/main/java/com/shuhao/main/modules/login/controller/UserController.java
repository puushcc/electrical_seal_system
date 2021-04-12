package com.shuhao.main.modules.login.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.login.dto.RecoverParam;
import com.shuhao.main.modules.login.dto.UserRegisterParam;
import com.shuhao.main.modules.login.service.IRegisterService;
import com.shuhao.main.util.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: 用户操作，用于用户注册和找回密码
 * @author: XiaoShu
 * @date: 2020年11月25日 17:05
 */

@Controller
@Api(tags = "UserController",value = "用户操作")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IRegisterService registerService;

    @ResponseBody
    @ApiOperation("注册账号")
    @PostMapping(value = "/register")
    public JsonResult registerUserAccount(@Validated @RequestBody UserRegisterParam userRegisterParam) {
        return registerService.register(userRegisterParam);
    }

    @ResponseBody
    @ApiOperation("找回密码验证身份")
    @PostMapping(value = "/recover/code")
    public JsonResult checkRecoverCode(@Validated @RequestBody RecoverParam recoverParam){
        return registerService.checkRecover(recoverParam);
    }

    @ResponseBody
    @ApiOperation("修改密码")
    @PostMapping(value = "/recover/update")
    public JsonResult recoverPassword(@Validated @RequestBody RecoverParam recoverParam){
        return registerService.recoverPassword(recoverParam);
    }

}
