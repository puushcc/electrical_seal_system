package com.shuhao.main.modules.login.service.impl;

import com.shuhao.main.dao.ElectricalSealPermissionMapper;
import com.shuhao.main.modules.login.service.IResourceService;
import com.shuhao.main.vo.ElectricalSealPermission;
import com.shuhao.main.vo.ElectricalSealPermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 权限管理Service实现类
 * @author: XiaoShu
 * @date: 2020年11月25日 9:43
 */
@Service
public class ResourceService implements IResourceService {

    @Autowired
    ElectricalSealPermissionMapper electricalSealPermissionMapper;

    @Override
    public List<ElectricalSealPermission> listAll() {
        return electricalSealPermissionMapper.selectByExample(new ElectricalSealPermissionExample());
    }

}
