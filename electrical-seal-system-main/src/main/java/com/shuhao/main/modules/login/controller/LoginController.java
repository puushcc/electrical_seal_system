package com.shuhao.main.modules.login.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.login.dto.PhoneLoginParam;
import com.shuhao.main.modules.login.dto.UserLoginParam;
import com.shuhao.main.modules.login.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

/**
 * @Description: 登录控制类
 * @author: XiaoShu
 * @date: 2020年11月21日 20:32
 */

@Controller
@Api(tags = "LoginController",value = "登录")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @ApiOperation(value = "用户账号密码登录")
    @RequestMapping(value = "/common",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Map<String, String>> login(@Validated @RequestBody UserLoginParam userLoginParam){
        return loginService.login(userLoginParam);
    }

    @ApiOperation(value = "用户账号密码登录")
    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Map<String, String>> loginAdmin(@Validated @RequestBody UserLoginParam userLoginParam){
        return loginService.loginAdmin(userLoginParam);
    }

    @ApiOperation(value = "用户手机验证登录")
    @RequestMapping(value = "/phone",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Map<String, String>> phoneLogin(@Validated @RequestBody PhoneLoginParam phoneLoginParam){
        return loginService.phoneLogin(phoneLoginParam);
    }

}
