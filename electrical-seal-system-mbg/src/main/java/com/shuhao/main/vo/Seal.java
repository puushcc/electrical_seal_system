package com.shuhao.main.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Seal implements Serializable {
    @ApiModelProperty(value = "印章id")
    private Integer sealId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "印章存放地址")
    private String sealUrl;

    @ApiModelProperty(value = "印章名称")
    private String sealName;

    @ApiModelProperty(value = "印章的编号")
    private String sealNum;

    @ApiModelProperty(value = "创建时间戳")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimestamp;

    @ApiModelProperty(value = "印章状态")
    private String state;

    private static final long serialVersionUID = 1L;

    public Integer getSealId() {
        return sealId;
    }

    public void setSealId(Integer sealId) {
        this.sealId = sealId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSealUrl() {
        return sealUrl;
    }

    public void setSealUrl(String sealUrl) {
        this.sealUrl = sealUrl;
    }

    public String getSealName() {
        return sealName;
    }

    public void setSealName(String sealName) {
        this.sealName = sealName;
    }

    public String getSealNum() {
        return sealNum;
    }

    public void setSealNum(String sealNum) {
        this.sealNum = sealNum;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sealId=").append(sealId);
        sb.append(", userId=").append(userId);
        sb.append(", sealUrl=").append(sealUrl);
        sb.append(", sealName=").append(sealName);
        sb.append(", sealNum=").append(sealNum);
        sb.append(", createTimestamp=").append(createTimestamp);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}