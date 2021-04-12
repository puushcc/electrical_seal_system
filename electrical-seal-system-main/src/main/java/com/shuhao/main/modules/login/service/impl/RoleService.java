package com.shuhao.main.modules.login.service.impl;

import com.shuhao.main.dao.ElectricalSealUserRoleMapper;
import com.shuhao.main.modules.login.service.IRoleService;
import com.shuhao.main.vo.ElectricalSealUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户角色业务层实现类
 * @author: XiaoShu
 * @date: 2020年11月26日 10:44
 */
@Service
public class RoleService implements IRoleService {


    @Autowired
    private ElectricalSealUserRoleMapper electricalSealUserRoleMapper;

    @Override
    public int insertUserRole(ElectricalSealUserRole electricalSealUserRole) {
        return electricalSealUserRoleMapper.insertSelective(electricalSealUserRole);
    }
}
