package com.shuhao.main.modules.Personal.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.Personal.service.IUserOperatingService;
import com.shuhao.main.modules.fileupload.FileUploadService;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.ElectricalSealUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 用户个人信息操作类
 * @author: scott
 * @date:
 */
@RestController
@Api(tags = "用户个人信息操作类")
@RequestMapping("/information")
public class UserOperatingController {

    @Autowired
    private IUserOperatingService userOperatingService;


    @ApiOperation(value = "获取个人信息")
    @RequestMapping(value = "/getinfor",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<ElectricalSealUser> getInformation(@RequestHeader(value = "Authorization") String token){
        return userOperatingService.getUserInformation(token);
    }


    @ApiOperation(value = "修改用户名")
    @RequestMapping(value = "/updateUserName",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<ElectricalSealUser> updateUserName(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody ElectricalSealUser electricalSealUser){
        return userOperatingService.updateUserName(token,electricalSealUser);
    }



    @ApiOperation(value = "修改邮箱")
    @RequestMapping(value = "/updateMail",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<ElectricalSealUser> updateMail(@RequestHeader(value = "Authorization") String token, @Validated @RequestBody ElectricalSealUser electricalSealUser){
        return userOperatingService.updateMail(token,electricalSealUser);
    }


    @ApiOperation(value = "修改头像")
    @RequestMapping(value = "/updateImage",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<ElectricalSealUser> updateImage(@RequestHeader(value = "Authorization") String token,
                                  @Validated @RequestBody ElectricalSealUser electricalSealUser) {
        return userOperatingService.updateImage(token, electricalSealUser);
    }

}
