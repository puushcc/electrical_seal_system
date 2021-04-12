package com.shuhao.main.modules.login.service.impl;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.entity.ResultCode;
import com.shuhao.main.modules.login.dto.RecoverParam;
import com.shuhao.main.modules.login.dto.UserRegisterParam;
import com.shuhao.main.modules.login.service.ICodeService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.modules.login.service.IRegisterService;
import com.shuhao.main.util.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description: 注册控制器实现类
 * @author: XiaoShu
 * @date: 2020年11月26日 9:39
 */

@Service
public class RegisterService implements IRegisterService {

    @Autowired
    private ICodeService codeService;

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Override
    public JsonResult register(UserRegisterParam userRegisterParam) {
        String account = userRegisterParam.getAccount();
        String code = userRegisterParam.getCode();
        String password = userRegisterParam.getPassword();
        String username = userRegisterParam.getUsername();
        //验证手机验证码
        boolean b =codeService.checkCode(account,code);
        if (!b){
            return ResultTool.error(ResultCode.CODE_FAIL);
        }
        //清除验证码缓存
        codeService.clearCode(account);
        //校验该用户是否被注册
        if (electricalSealUserService.getUserByUsername(account) != null){
            return ResultTool.error(ResultCode.USER_EXIT_FAIL);
        }
        //添加用户信息到数据库中
        boolean register = electricalSealUserService.register(account, password, username);
        if (register){
            return  ResultTool.success(ResultCode.CODE_REGISTER_SUCCESS);
        }
        return ResultTool.error(ResultCode.CODE_REGISTER_FAIL);
    }

    @Override
    public JsonResult checkRecover(RecoverParam recoverParam) {
        if (null == electricalSealUserService.getUserByUsername(recoverParam.getAccount())){
            return ResultTool.error(ResultCode.USER_MISS_FAIL);
        }
        boolean b = codeService.checkCode(recoverParam.getAccount(), recoverParam.getCode());
        if (!b){
            return ResultTool.error(ResultCode.CODE_FAIL);
        }
        //清除验证码缓存
        codeService.clearCode(recoverParam.getAccount());
        return ResultTool.success(ResultCode.CODE_CHECK_SUCCESS);
    }

    @Override
    public JsonResult recoverPassword(RecoverParam recoverParam) {
        if (null != electricalSealUserService.getUserByUsername(recoverParam.getAccount())){
            electricalSealUserService.updatePasswordByUsername(recoverParam.getAccount(),new BCryptPasswordEncoder().encode(recoverParam.getPassword()));
            electricalSealUserService.getUserByUsernameDB(recoverParam.getAccount());
            return ResultTool.success(ResultCode.CODE_PASSWORD_SUCCESS);
        }
        return ResultTool.error();
    }


}
