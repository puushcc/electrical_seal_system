package com.shuhao.main.modules.login.service;


import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.login.dto.RecoverParam;
import com.shuhao.main.modules.login.dto.UserRegisterParam;

/**
 * @Description: 注册控制器接口层
 * @author: XiaoShu
 * @date: 2020年11月26日 9：38
 */
public interface IRegisterService {
    /**
     * 注册新用户
     * @param userRegisterParam
     * @return
     */
    JsonResult register(UserRegisterParam userRegisterParam);

    /**
     * 校验手机号码和验证码
     * @param recoverParam
     * @return
     */
    JsonResult checkRecover(RecoverParam recoverParam);

    /**
     * 修改密码
     * @param recoverParam
     * @return
     */
    JsonResult recoverPassword(RecoverParam recoverParam);

}
