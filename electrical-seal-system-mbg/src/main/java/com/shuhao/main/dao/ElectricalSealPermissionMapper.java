package com.shuhao.main.dao;

import com.shuhao.main.vo.ElectricalSealPermission;
import com.shuhao.main.vo.ElectricalSealPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectricalSealPermissionMapper {
    long countByExample(ElectricalSealPermissionExample example);

    int deleteByExample(ElectricalSealPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ElectricalSealPermission record);

    int insertSelective(ElectricalSealPermission record);

    List<ElectricalSealPermission> selectByExample(ElectricalSealPermissionExample example);

    ElectricalSealPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ElectricalSealPermission record, @Param("example") ElectricalSealPermissionExample example);

    int updateByExample(@Param("record") ElectricalSealPermission record, @Param("example") ElectricalSealPermissionExample example);

    int updateByPrimaryKeySelective(ElectricalSealPermission record);

    int updateByPrimaryKey(ElectricalSealPermission record);
}