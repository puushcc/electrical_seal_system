package com.shuhao.main.dao;

import com.shuhao.main.vo.Seal;
import com.shuhao.main.vo.SealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SealMapper {
    long countByExample(SealExample example);

    int deleteByExample(SealExample example);

    int deleteByPrimaryKey(Integer sealId);

    int insert(Seal record);

    int insertSelective(Seal record);

    List<Seal> selectByExample(SealExample example);

    Seal selectByPrimaryKey(Integer sealId);

    int updateByExampleSelective(@Param("record") Seal record, @Param("example") SealExample example);

    int updateByExample(@Param("record") Seal record, @Param("example") SealExample example);

    int updateByPrimaryKeySelective(Seal record);

    int updateByPrimaryKey(Seal record);
}