package com.shuhao.main.dao;

import com.shuhao.main.vo.ElectricalSealRolePermission;
import com.shuhao.main.vo.ElectricalSealRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectricalSealRolePermissionMapper {
    long countByExample(ElectricalSealRolePermissionExample example);

    int deleteByExample(ElectricalSealRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ElectricalSealRolePermission record);

    int insertSelective(ElectricalSealRolePermission record);

    List<ElectricalSealRolePermission> selectByExample(ElectricalSealRolePermissionExample example);

    ElectricalSealRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ElectricalSealRolePermission record, @Param("example") ElectricalSealRolePermissionExample example);

    int updateByExample(@Param("record") ElectricalSealRolePermission record, @Param("example") ElectricalSealRolePermissionExample example);

    int updateByPrimaryKeySelective(ElectricalSealRolePermission record);

    int updateByPrimaryKey(ElectricalSealRolePermission record);
}