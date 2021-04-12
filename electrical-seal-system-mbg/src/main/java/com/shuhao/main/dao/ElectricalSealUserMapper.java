package com.shuhao.main.dao;

import com.shuhao.main.vo.ElectricalSealUser;
import com.shuhao.main.vo.ElectricalSealUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectricalSealUserMapper {
    long countByExample(ElectricalSealUserExample example);

    int deleteByExample(ElectricalSealUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ElectricalSealUser record);

    int insertSelective(ElectricalSealUser record);

    List<ElectricalSealUser> selectByExample(ElectricalSealUserExample example);

    ElectricalSealUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ElectricalSealUser record, @Param("example") ElectricalSealUserExample example);

    int updateByExample(@Param("record") ElectricalSealUser record, @Param("example") ElectricalSealUserExample example);

    int updateByPrimaryKeySelective(ElectricalSealUser record);

    int updateByPrimaryKey(ElectricalSealUser record);
}