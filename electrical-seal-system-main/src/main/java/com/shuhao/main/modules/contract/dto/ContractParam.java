package com.shuhao.main.modules.contract.dto;

/**
 *
 */
public class ContractParam {

    private Integer contractId;
    private String sealWidth;
    private String sealHeight;
    private String signWidth;
    private String signHeight;
    private String signUrl;
    private String sealUrl;
    private int pageNum;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getSealWidth() {
        return sealWidth;
    }

    public void setSealWidth(String sealWidth) {
        this.sealWidth = sealWidth;
    }

    public String getSealHeight() {
        return sealHeight;
    }

    public void setSealHeight(String sealHeight) {
        this.sealHeight = sealHeight;
    }

    public String getSignWidth() {
        return signWidth;
    }

    public void setSignWidth(String signWidth) {
        this.signWidth = signWidth;
    }

    public String getSignHeight() {
        return signHeight;
    }

    public void setSignHeight(String signHeight) {
        this.signHeight = signHeight;
    }

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }

    public String getSealUrl() {
        return sealUrl;
    }

    public void setSealUrl(String sealUrl) {
        this.sealUrl = sealUrl;
    }
}
