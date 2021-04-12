package com.shuhao.main.dao;

import com.shuhao.main.vo.SealUserSign;
import com.shuhao.main.vo.SealUserSignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SealUserSignMapper {
    long countByExample(SealUserSignExample example);

    int deleteByExample(SealUserSignExample example);

    int deleteByPrimaryKey(Integer signId);

    int insert(SealUserSign record);

    int insertSelective(SealUserSign record);

    List<SealUserSign> selectByExample(SealUserSignExample example);

    SealUserSign selectByPrimaryKey(Integer signId);

    int updateByExampleSelective(@Param("record") SealUserSign record, @Param("example") SealUserSignExample example);

    int updateByExample(@Param("record") SealUserSign record, @Param("example") SealUserSignExample example);

    int updateByPrimaryKeySelective(SealUserSign record);

    int updateByPrimaryKey(SealUserSign record);
}