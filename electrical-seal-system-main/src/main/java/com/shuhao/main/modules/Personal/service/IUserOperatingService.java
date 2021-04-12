package com.shuhao.main.modules.Personal.service;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.vo.ElectricalSealUser;

public interface IUserOperatingService {


    /**
     * 获取个人信息
     * @param token
     * @return
     */
    JsonResult<ElectricalSealUser> getUserInformation(String token);


    /**
     * 修改用户名
     * @param token
     * @return
     */
    JsonResult<ElectricalSealUser> updateUserName(String token,ElectricalSealUser electricalSealUser);

    /**
     * 修改邮箱
     * @param token
     * @return
     */
    JsonResult<ElectricalSealUser> updateMail(String token,ElectricalSealUser electricalSealUser);

    /**
     * 修改头像
     * @param token
     * @return
     */
    JsonResult<ElectricalSealUser> updateImage(String token,ElectricalSealUser electricalSealUser);


}
