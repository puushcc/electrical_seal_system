package com.shuhao.main.vo;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class SealEnterprise implements Serializable {
    @ApiModelProperty(value = "企业id")
    private Integer enterpriseId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "服务行业")
    private String enterpriseIndustry;

    @ApiModelProperty(value = "企业注册地")
    private String enterpriseLocal;

    @ApiModelProperty(value = "所在地区")
    private String enterpriseCity;

    @ApiModelProperty(value = "营业执照")
    private String enterpriseBusiness;

    @ApiModelProperty(value = "统一社会信用代码")
    private String enterpriseCode;

    @ApiModelProperty(value = "法定代表人")
    private String enterpriseUser;

    @ApiModelProperty(value = "审核状态：0-审核中 1-审核通过 2-审核未通过")
    private Integer enterpriseStats;

    private static final long serialVersionUID = 1L;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseIndustry() {
        return enterpriseIndustry;
    }

    public void setEnterpriseIndustry(String enterpriseIndustry) {
        this.enterpriseIndustry = enterpriseIndustry;
    }

    public String getEnterpriseLocal() {
        return enterpriseLocal;
    }

    public void setEnterpriseLocal(String enterpriseLocal) {
        this.enterpriseLocal = enterpriseLocal;
    }

    public String getEnterpriseCity() {
        return enterpriseCity;
    }

    public void setEnterpriseCity(String enterpriseCity) {
        this.enterpriseCity = enterpriseCity;
    }

    public String getEnterpriseBusiness() {
        return enterpriseBusiness;
    }

    public void setEnterpriseBusiness(String enterpriseBusiness) {
        this.enterpriseBusiness = enterpriseBusiness;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getEnterpriseUser() {
        return enterpriseUser;
    }

    public void setEnterpriseUser(String enterpriseUser) {
        this.enterpriseUser = enterpriseUser;
    }

    public Integer getEnterpriseStats() {
        return enterpriseStats;
    }

    public void setEnterpriseStats(Integer enterpriseStats) {
        this.enterpriseStats = enterpriseStats;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", userId=").append(userId);
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", enterpriseIndustry=").append(enterpriseIndustry);
        sb.append(", enterpriseLocal=").append(enterpriseLocal);
        sb.append(", enterpriseCity=").append(enterpriseCity);
        sb.append(", enterpriseBusiness=").append(enterpriseBusiness);
        sb.append(", enterpriseCode=").append(enterpriseCode);
        sb.append(", enterpriseUser=").append(enterpriseUser);
        sb.append(", enterpriseStats=").append(enterpriseStats);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}