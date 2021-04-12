package com.shuhao.main.modules.Personal.service;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.vo.SealEnterprise;

public interface ICheckEnterpriseService {

    /**
     * 判断用户是否为企业用户
     * @return
     */
    boolean checkEnterpriseByROleName(String account);

    /**
     * 返回用户企业信息
     * @return
     */
    SealEnterprise checkByEnterpriseName(String account);

    /**
     * 用户申请企业认证
     * @return
     */
    JsonResult checkByEnterprise(SealEnterprise sealEnterprise, String token);


}
