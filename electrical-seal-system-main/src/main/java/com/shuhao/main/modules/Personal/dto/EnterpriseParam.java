package com.shuhao.main.modules.Personal.dto;
/**
 *企业认证时验证所需参数
 */
public class EnterpriseParam {

    private Integer userId;
    private String EnterpriseName;
    private String EnterpriseIndustry;
    private String EnterpriseLocal;
    private String EnterpriseCity;
    private String EnterpriseBusiness;
    private String EnterpriseCode;
    private String EnterpriseUser;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEnterpriseName() {
        return EnterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        EnterpriseName = enterpriseName;
    }

    public String getEnterpriseIndustry() {
        return EnterpriseIndustry;
    }

    public void setEnterpriseIndustry(String enterpriseIndustry) {
        EnterpriseIndustry = enterpriseIndustry;
    }

    public String getEnterpriseLocal() {
        return EnterpriseLocal;
    }

    public void setEnterpriseLocal(String enterpriseLocal) {
        EnterpriseLocal = enterpriseLocal;
    }

    public String getEnterpriseCity() {
        return EnterpriseCity;
    }

    public void setEnterpriseCity(String enterpriseCity) {
        EnterpriseCity = enterpriseCity;
    }

    public String getEnterpriseBusiness() {
        return EnterpriseBusiness;
    }

    public void setEnterpriseBusiness(String enterpriseBusiness) {
        EnterpriseBusiness = enterpriseBusiness;
    }

    public String getEnterpriseCode() {
        return EnterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        EnterpriseCode = enterpriseCode;
    }

    public String getEnterpriseUser() {
        return EnterpriseUser;
    }

    public void setEnterpriseUser(String enterpriseUser) {
        EnterpriseUser = enterpriseUser;
    }
}
