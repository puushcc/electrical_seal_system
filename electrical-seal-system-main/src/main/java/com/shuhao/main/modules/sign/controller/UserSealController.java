package com.shuhao.main.modules.sign.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.sign.service.UserSealService;
import com.shuhao.main.vo.Seal;
import com.shuhao.main.vo.SealUserSign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 印章管理操作接口入口
 */
@RestController
@Api(tags = "印章管理操作接口入口")
@RequestMapping("/enterpriseSeal")
public class UserSealController {

    @Autowired
    private UserSealService userSealService;

    @ApiOperation(value = "添加印章")
    @RequestMapping(value = "/addEnterpriseSeal",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addEnterpriseSeal(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody Seal seal){
        return userSealService.addEnterpriseSeal(token,seal);
    }

    @ApiOperation(value = "获取印章")
    @RequestMapping(value = "/selectEnterpriseSeal",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<Seal>> selectEnterpriseSeal(@RequestHeader(value = "Authorization") String token){
        return userSealService.selectEnterpriseSeal(token);
    }

    @ApiOperation(value = "删除印章")
    @RequestMapping(value = "/delEnterpriseSeal",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delEnterpriseSeal(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody Seal seal){
        return userSealService.delEnterpriseSeal(token,seal.getSealUrl());
    }

}
