package com.shuhao.main.dao;

import com.shuhao.main.vo.SealEnterprise;
import com.shuhao.main.vo.SealEnterpriseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SealEnterpriseMapper {
    long countByExample(SealEnterpriseExample example);

    int deleteByExample(SealEnterpriseExample example);

    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(SealEnterprise record);

    int insertSelective(SealEnterprise record);

    List<SealEnterprise> selectByExample(SealEnterpriseExample example);

    SealEnterprise selectByPrimaryKey(Integer enterpriseId);

    int updateByExampleSelective(@Param("record") SealEnterprise record, @Param("example") SealEnterpriseExample example);

    int updateByExample(@Param("record") SealEnterprise record, @Param("example") SealEnterpriseExample example);

    int updateByPrimaryKeySelective(SealEnterprise record);

    int updateByPrimaryKey(SealEnterprise record);
}