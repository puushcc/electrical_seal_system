package com.shuhao.main.modules.Personal.service;


import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.Personal.dto.CheckParam;

/**
 * @Description: 实名认证接口
 * @author: XiaoShu
 * @date:
 */

public interface ICheckpersonalUserService {

    /**
     * 个人实名认证
     * @return
     */
    JsonResult checkPersonalUser(CheckParam checkParam, String token);

    /**
     * 判断是否已经实名认证
     * @return -1 : 已经认证  其它 ： 未认证
     */
    Integer checkPersonal(String account);

    /**
     * 实名认证
     * @return true : 认证成功  false ： 认证失败
     */
    boolean checkPersonalById(CheckParam checkParam);




}
