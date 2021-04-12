package com.shuhao.main.modules.login.service;

import com.shuhao.main.vo.ElectricalSealUserRole;

/**
 * @Description: 用户角色Service接口层
 * @author: XiaoShu
 * @date: 2020年11月26日 10:42
 */
public interface IRoleService {

    /**
     * 给用户添加角色
     * @param electricalSealUserRole
     * @return
     */
    int insertUserRole(ElectricalSealUserRole electricalSealUserRole);
}
