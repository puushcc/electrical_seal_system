package com.shuhao.main.modules.login.dto;

/**
 * @Description: 找回密码时验证所需参数
 * @author: XiaoShu
 * @date: 2020年11月26日 11:15
 */
public class RecoverParam {

    private String account;

    private String code;

    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
