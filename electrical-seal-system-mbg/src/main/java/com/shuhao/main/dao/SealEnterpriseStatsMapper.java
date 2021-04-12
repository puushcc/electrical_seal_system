package com.shuhao.main.dao;

import com.shuhao.main.vo.SealEnterpriseStats;
import com.shuhao.main.vo.SealEnterpriseStatsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SealEnterpriseStatsMapper {
    long countByExample(SealEnterpriseStatsExample example);

    int deleteByExample(SealEnterpriseStatsExample example);

    int deleteByPrimaryKey(Integer enterpriseStats);

    int insert(SealEnterpriseStats record);

    int insertSelective(SealEnterpriseStats record);

    List<SealEnterpriseStats> selectByExample(SealEnterpriseStatsExample example);

    SealEnterpriseStats selectByPrimaryKey(Integer enterpriseStats);

    int updateByExampleSelective(@Param("record") SealEnterpriseStats record, @Param("example") SealEnterpriseStatsExample example);

    int updateByExample(@Param("record") SealEnterpriseStats record, @Param("example") SealEnterpriseStatsExample example);

    int updateByPrimaryKeySelective(SealEnterpriseStats record);

    int updateByPrimaryKey(SealEnterpriseStats record);
}