package com.shuhao.main.modules.sign.service;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.vo.SealUserSign;

import java.util.List;

public interface UserSignService {

    /**
     *用户添加个人签名
     * @param token
     * @param signBase64
     * @return
     */
    JsonResult addUserSign(String token,String signBase64);

    /**
     * 用户获取个人签名
     * @param token
     * @return
     */
    JsonResult<List<SealUserSign>> selectUserSign(String token);

    /**
     *用户删除个人签名
     * @param token
     * @param url
     * @return
     */
    JsonResult delUserSign(String token,String url);


}
