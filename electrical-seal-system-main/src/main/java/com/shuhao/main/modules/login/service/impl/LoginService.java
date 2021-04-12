package com.shuhao.main.modules.login.service.impl;

import com.shuhao.main.dao.ElectricalSealUserRoleMapper;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.entity.ResultCode;
import com.shuhao.main.modules.login.dto.PhoneLoginParam;
import com.shuhao.main.modules.login.dto.UserLoginParam;
import com.shuhao.main.modules.login.service.ICodeService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.modules.login.service.ILoginService;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.ElectricalSealUser;
import com.shuhao.main.vo.ElectricalSealUserRole;
import com.shuhao.main.vo.ElectricalSealUserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 登录控制器实现类
 * @author: XiaoShu
 * @date: 2020年11月25日 17:30
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Autowired
    private ICodeService codeService;

    @Autowired
    private ElectricalSealUserRoleMapper electricalSealUserRoleMapper;

    @Override
    public JsonResult<Map<String, String>> login(UserLoginParam userLoginParam) {
        //验证码是否正确
        boolean b = codeService.checkCode(userLoginParam.getCodeId(), userLoginParam.getCode());
        if (!b){
            return ResultTool.error(ResultCode.CODE_FAIL);
        }
        //清除验证码缓存
        codeService.clearCode(userLoginParam.getCodeId());
        //用户是否存在
        String status = electricalSealUserService.getStatusByUsername(userLoginParam.getAccount());
        if (status.equals("NoUser") ){
            return ResultTool.error(ResultCode.USER_MISS_FAIL);
        }
        //用户是否锁定
        if (status.equals("IsLocked")){
            return ResultTool.error(ResultCode.USER_LOCKED_FAIL);
        }
        //登录鉴权，获取token
        String token = electricalSealUserService.login(userLoginParam.getAccount(), userLoginParam.getPassword(),userLoginParam.getAutoLogin());
        if(token == null){
            return ResultTool.error(ResultCode.USER_PASSWORD_FAIL);
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return ResultTool.success(tokenMap);
    }

    @Override
    public JsonResult<Map<String, String>> loginAdmin(UserLoginParam userLoginParam) {
        //验证码是否正确
        boolean b = codeService.checkCode(userLoginParam.getCodeId(), userLoginParam.getCode());
        if (!b){
            return ResultTool.error(ResultCode.CODE_FAIL);
        }
        //清除验证码缓存
        codeService.clearCode(userLoginParam.getCodeId());
        //用户是否存在
        String status = electricalSealUserService.getStatusByUsername(userLoginParam.getAccount());
        if (status.equals("NoUser") ){
            return ResultTool.error(ResultCode.USER_MISS_FAIL);
        }
        //用户是否锁定
        if (status.equals("IsLocked")){
            return ResultTool.error(ResultCode.USER_LOCKED_FAIL);
        }
        //用户是否为管理员
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(userLoginParam.getAccount());
        ElectricalSealUserRoleExample example = new ElectricalSealUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userByUsername.getId());
        List<ElectricalSealUserRole> electricalSealUserRoles = electricalSealUserRoleMapper.selectByExample(example);
        if (electricalSealUserRoles.get(0).getRoleId() != 1) {
            return ResultTool.error(ResultCode.FORBIDDEN);
        }
        //登录鉴权，获取token
        String token = electricalSealUserService.login(userLoginParam.getAccount(), userLoginParam.getPassword(),userLoginParam.getAutoLogin());
        if(token == null){
            return ResultTool.error(ResultCode.USER_PASSWORD_FAIL);
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return ResultTool.success(tokenMap);
    }

    @Override
    public JsonResult<Map<String, String>> phoneLogin(PhoneLoginParam phoneLoginParam) {
        //验证码是否正确
        boolean b = codeService.checkCode(phoneLoginParam.getAccount(),phoneLoginParam.getCode());
        if (!b){
            return ResultTool.error(ResultCode.CODE_FAIL);
        }
        //清除验证码缓存
        codeService.clearCode(phoneLoginParam.getAccount());
        String status = electricalSealUserService.getStatusByUsername(phoneLoginParam.getAccount());
        //用户是否锁定
        if (status.equals("IsLocked")){
            return ResultTool.error(ResultCode.USER_LOCKED_FAIL);
        }
        if (status.equals("NoUser")){
            //不存在该用户则自动注册（登录时需要在前台验证密码长度，小于8位密码无法请求后端），下次登录时无法使用密码登录，需要重新修改密码
            electricalSealUserService.register(phoneLoginParam.getAccount(),null,null);
        }
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(phoneLoginParam.getAccount());
        System.out.println(userByUsername);
        //登录鉴权，获取token
        String token = electricalSealUserService.login(userByUsername.getAccount(), null,phoneLoginParam.getAutoLogin());
        if(token == null){
            return ResultTool.error(ResultCode.CODE_LOGIN_FAIL);
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return ResultTool.success(tokenMap);
    }
}
