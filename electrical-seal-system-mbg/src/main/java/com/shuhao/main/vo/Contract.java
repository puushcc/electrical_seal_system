package com.shuhao.main.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable {
    @ApiModelProperty(value = "合同主键")
    private Integer contractId;

    @ApiModelProperty(value = "合同主题")
    private String contractName;

    @ApiModelProperty(value = "合同文件地址")
    private String contractFile;

    @ApiModelProperty(value = "合同发起人")
    private String contractSponsor;

    @ApiModelProperty(value = "合同接收入")
    private String contractReceiver;

    @ApiModelProperty(value = "合同签署日期限制")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date contractDate;

    @ApiModelProperty(value = "合同状态：1-接收人签署；2-发起人签署；3-失效；4-完成")
    private String contractStatus;

    @ApiModelProperty(value = "创建时间戳")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date contractCreatetime;

    @ApiModelProperty(value = "完成时间戳")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date contractCompletetime;

    private static final long serialVersionUID = 1L;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractFile() {
        return contractFile;
    }

    public void setContractFile(String contractFile) {
        this.contractFile = contractFile;
    }

    public String getContractSponsor() {
        return contractSponsor;
    }

    public void setContractSponsor(String contractSponsor) {
        this.contractSponsor = contractSponsor;
    }

    public String getContractReceiver() {
        return contractReceiver;
    }

    public void setContractReceiver(String contractReceiver) {
        this.contractReceiver = contractReceiver;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Date getContractCreatetime() {
        return contractCreatetime;
    }

    public void setContractCreatetime(Date contractCreatetime) {
        this.contractCreatetime = contractCreatetime;
    }

    public Date getContractCompletetime() {
        return contractCompletetime;
    }

    public void setContractCompletetime(Date contractCompletetime) {
        this.contractCompletetime = contractCompletetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contractId=").append(contractId);
        sb.append(", contractName=").append(contractName);
        sb.append(", contractFile=").append(contractFile);
        sb.append(", contractSponsor=").append(contractSponsor);
        sb.append(", contractReceiver=").append(contractReceiver);
        sb.append(", contractDate=").append(contractDate);
        sb.append(", contractStatus=").append(contractStatus);
        sb.append(", contractCreatetime=").append(contractCreatetime);
        sb.append(", contractCompletetime=").append(contractCompletetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}