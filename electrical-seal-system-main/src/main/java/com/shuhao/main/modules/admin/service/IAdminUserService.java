package com.shuhao.main.modules.admin.service;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.admin.dto.EntriInformation;
import com.shuhao.main.modules.admin.dto.UserInformation;

import java.util.List;

public interface IAdminUserService {

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    JsonResult<List<UserInformation>> getuser(String token);

    /**
     * 禁用或启用用户
     * @param token
     * @param userInformation
     * @return
     */
    JsonResult upStates(String token,UserInformation userInformation);

    /**
     * 获取企业信息
     * @param token
     * @return
     */
    JsonResult<List<EntriInformation>> getentri(String token);

    /**
     * 企业审核
     * @param token
     * @return
     */
    JsonResult review(String token,EntriInformation entriInformation);

}
