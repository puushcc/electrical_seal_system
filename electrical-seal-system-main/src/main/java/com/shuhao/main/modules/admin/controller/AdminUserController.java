package com.shuhao.main.modules.admin.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.admin.dto.EntriInformation;
import com.shuhao.main.modules.admin.dto.UserInformation;
import com.shuhao.main.modules.admin.service.IAdminUserService;
import com.shuhao.main.modules.login.dto.UserLoginParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户管理
 */
@Controller
@Api(tags = "AdminController",value = "用户管理")
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private IAdminUserService adminUserService;

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<UserInformation>> getuser(@RequestHeader(value = "Authorization") String token){
        return adminUserService.getuser(token);
    }

    @ApiOperation(value = "禁用或启用账号")
    @RequestMapping(value = "/upStates",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult upStates(@RequestHeader(value = "Authorization") String token,@Validated @RequestBody UserInformation userInformation){
        return adminUserService.upStates(token,userInformation);
    }


    @ApiOperation(value = "获取企业信息")
    @RequestMapping(value = "/getentri",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<EntriInformation>> getentri(@RequestHeader(value = "Authorization") String token){
        return adminUserService.getentri(token);
    }

    @ApiOperation(value = "企业审核")
    @RequestMapping(value = "/review",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult review(@RequestHeader(value = "Authorization") String token,@Validated @RequestBody EntriInformation entriInformation){
        return adminUserService.review(token,entriInformation);
    }

}
