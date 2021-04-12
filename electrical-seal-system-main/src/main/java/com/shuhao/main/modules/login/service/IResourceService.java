package com.shuhao.main.modules.login.service;

import com.shuhao.main.vo.ElectricalSealPermission;

import java.util.List;

/**
 * @Description: 权限管理Service接口层
 * @author: XiaoShu
 * @date: 2020年11月25日 9:40
 */
public interface IResourceService {

    /**
     * 查询全部权限
     * @return
     */
    List<ElectricalSealPermission> listAll();

}
