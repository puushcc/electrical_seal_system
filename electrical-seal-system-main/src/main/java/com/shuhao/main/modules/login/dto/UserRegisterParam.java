package com.shuhao.main.modules.login.dto;

/**
 * @Description: 用户注册参数
 * @author: XiaoShu
 * @date: 2020年11月26日 9:29
 */
public class UserRegisterParam {

    private String username;

    private String account;

    private String password;

    private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
