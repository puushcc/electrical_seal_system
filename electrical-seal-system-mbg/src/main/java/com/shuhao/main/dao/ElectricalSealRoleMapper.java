package com.shuhao.main.dao;

import com.shuhao.main.vo.ElectricalSealRole;
import com.shuhao.main.vo.ElectricalSealRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectricalSealRoleMapper {
    long countByExample(ElectricalSealRoleExample example);

    int deleteByExample(ElectricalSealRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ElectricalSealRole record);

    int insertSelective(ElectricalSealRole record);

    List<ElectricalSealRole> selectByExample(ElectricalSealRoleExample example);

    ElectricalSealRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ElectricalSealRole record, @Param("example") ElectricalSealRoleExample example);

    int updateByExample(@Param("record") ElectricalSealRole record, @Param("example") ElectricalSealRoleExample example);

    int updateByPrimaryKeySelective(ElectricalSealRole record);

    int updateByPrimaryKey(ElectricalSealRole record);
}