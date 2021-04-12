package com.shuhao.main.modules.Personal.controller;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.Personal.dto.CheckParam;
import com.shuhao.main.modules.Personal.service.ICheckpersonalUserService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.ElectricalSealUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 实名认证控制层
 * @author: XiaoShu
 * @date:
 */


@RestController
@Api(tags = "实名认证")
@RequestMapping("/check")
public class CheckPersonalUserController {

    @Autowired
    private ICheckpersonalUserService checkpersonalUser;

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation(value = "判断是否实名认证")
    @RequestMapping(value = "/checkByUser",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<CheckParam> checkPersonalByUser(@RequestHeader(value = "Authorization") String token){
        String account = jwtTokenUtil.getUserNameFromToken(token);
        if (checkpersonalUser.checkPersonal(account) == -1){
            ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
            CheckParam checkParam = new CheckParam();
            checkParam.setIdCard(userByUsername.getIdCard());
            checkParam.setRealName(userByUsername.getRealName());
            checkParam.setImage(userByUsername.getImage());
            checkParam.setAccount(account);
            return ResultTool.success(checkParam);
        }
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        CheckParam checkParam = new CheckParam();
        checkParam.setAccount(account);
        checkParam.setImage(userByUsername.getImage());
        return ResultTool.error(checkParam);
    }

    @ApiOperation(value = "身份证姓名二要素实名认证")
    @RequestMapping(value = "/Personal",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkPersonalUser(@Validated @RequestBody CheckParam checkParam,@RequestHeader(value = "Authorization") String token){
        return checkpersonalUser.checkPersonalUser(checkParam,token);
    }




}
