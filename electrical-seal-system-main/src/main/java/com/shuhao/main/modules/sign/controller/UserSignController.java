package com.shuhao.main.modules.sign.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.sign.service.UserSignService;
import com.shuhao.main.vo.SealUserSign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 个人签名操作接口入口
 *
 */
@RestController
@Api(tags = "个人签名操作接口入口")
@RequestMapping("/sign")
public class UserSignController {

    @Autowired
    private UserSignService userSignService;

    @ApiOperation(value = "添加个人签名")
    @RequestMapping(value = "/addUserSign",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addUserSign(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody SealUserSign sealUserSign){
        return userSignService.addUserSign(token,sealUserSign.getSignUrl());
    }


    @ApiOperation(value = "获取个人签名")
    @RequestMapping(value = "/selectUserSign",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<SealUserSign>> selectUserSign(@RequestHeader(value = "Authorization") String token){
        return userSignService.selectUserSign(token);
    }


    @ApiOperation(value = "删除个人签名")
    @RequestMapping(value = "/delUserSign",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delUserSign(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody SealUserSign sealUserSign){
        return userSignService.delUserSign(token,sealUserSign.getSignUrl());
    }

}
