package com.shuhao.main.dao;

import com.shuhao.main.vo.ElectricalSealUserRole;
import com.shuhao.main.vo.ElectricalSealUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectricalSealUserRoleMapper {
    long countByExample(ElectricalSealUserRoleExample example);

    int deleteByExample(ElectricalSealUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ElectricalSealUserRole record);

    int insertSelective(ElectricalSealUserRole record);

    List<ElectricalSealUserRole> selectByExample(ElectricalSealUserRoleExample example);

    ElectricalSealUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ElectricalSealUserRole record, @Param("example") ElectricalSealUserRoleExample example);

    int updateByExample(@Param("record") ElectricalSealUserRole record, @Param("example") ElectricalSealUserRoleExample example);

    int updateByPrimaryKeySelective(ElectricalSealUserRole record);

    int updateByPrimaryKey(ElectricalSealUserRole record);
}