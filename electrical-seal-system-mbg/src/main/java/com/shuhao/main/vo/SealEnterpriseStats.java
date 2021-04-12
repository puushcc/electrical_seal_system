package com.shuhao.main.vo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SealEnterpriseStats implements Serializable {
    @ApiModelProperty(value = "审核状态id")
    private Integer enterpriseStats;

    @ApiModelProperty(value = "0-审核中  1-审核通过 2-审核失败")
    private String enterpriseStatsName;

    private static final long serialVersionUID = 1L;

    public Integer getEnterpriseStats() {
        return enterpriseStats;
    }

    public void setEnterpriseStats(Integer enterpriseStats) {
        this.enterpriseStats = enterpriseStats;
    }

    public String getEnterpriseStatsName() {
        return enterpriseStatsName;
    }

    public void setEnterpriseStatsName(String enterpriseStatsName) {
        this.enterpriseStatsName = enterpriseStatsName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", enterpriseStats=").append(enterpriseStats);
        sb.append(", enterpriseStatsName=").append(enterpriseStatsName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}