package com.shuhao.main.modules.login.service;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.login.dto.PhoneLoginParam;
import com.shuhao.main.modules.login.dto.UserLoginParam;

import java.util.Map;

/**
 * @Description: 登录控制器接口层
 * @author: XiaoShu
 * @date: 2020年11月25日 17:27
 */
public interface ILoginService {

    /**
     * 账号密码登录
     * @param userLoginParam
     * @return
     */
    JsonResult<Map<String, String>> login(UserLoginParam userLoginParam);

    /**
     * 管理员登录
     * @param userLoginParam
     * @return
     */
    JsonResult<Map<String, String>> loginAdmin(UserLoginParam userLoginParam);

    /**
     * 验证码登录
     * @param phoneLoginParam
     * @return
     */
    JsonResult<Map<String, String>> phoneLogin(PhoneLoginParam phoneLoginParam);

}
