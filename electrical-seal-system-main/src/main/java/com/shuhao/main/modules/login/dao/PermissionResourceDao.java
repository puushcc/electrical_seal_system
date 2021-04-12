package com.shuhao.main.modules.login.dao;

import com.shuhao.main.vo.ElectricalSealPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionResourceDao {

    /**
     * 获取用户所有可访问资源
     */
    List<ElectricalSealPermission> getResourceList(@Param("userId") Integer userId);
}
