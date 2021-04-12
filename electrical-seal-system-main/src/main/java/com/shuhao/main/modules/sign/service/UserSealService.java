package com.shuhao.main.modules.sign.service;

import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.vo.Seal;

import java.util.List;

public interface UserSealService {

    JsonResult addEnterpriseSeal(String token, Seal seal);

    JsonResult<List<Seal>> selectEnterpriseSeal(String token);

    JsonResult delEnterpriseSeal(String token, String url);
}
