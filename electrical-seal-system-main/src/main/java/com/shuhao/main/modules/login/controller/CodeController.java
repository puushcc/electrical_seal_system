package com.shuhao.main.modules.login.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.entity.ResultCode;
import com.shuhao.main.modules.login.dto.PhoneLoginParam;
import com.shuhao.main.modules.login.service.ICodeService;
import com.shuhao.main.util.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


/**
 * @Description: 获取验证码控制器
 * @author: XiaoShu
 * @date: 2020年11月23日 16:15
 */
@RestController
@Api(tags = "验证码")
@RequestMapping("/code")
public class CodeController {

    @Autowired
    private ICodeService codeService;

    @ResponseBody
    @ApiOperation("获取图片验证码")
    @GetMapping(value = "/image")
    public JsonResult<Map<String, Object>> getImageCode() {
        Map<String, Object> stringObjectMap = codeService.imageCode();
        if (stringObjectMap == null){
            return ResultTool.error();
        }
        return ResultTool.success(stringObjectMap);
    }

    @ResponseBody
    @ApiOperation("获取短信验证码")
    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public JsonResult getLoginPhoneCode(@Validated @RequestBody PhoneLoginParam phoneLoginParam) {
        if (codeService.LoginPhoneCode(phoneLoginParam.getAccount())){
            return ResultTool.success(ResultCode.CODE_SEND_SUCCESS);
        }
        return ResultTool.error(ResultCode.CODE_SEND_FAIL);
    }



}
