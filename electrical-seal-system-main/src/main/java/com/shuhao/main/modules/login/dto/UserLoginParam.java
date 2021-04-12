package com.shuhao.main.modules.login.dto;

/**
 * @Description: 用户登录参数
 * @author: XiaoShu
 * @date: 2020年11月21日 20:39
 */
public class UserLoginParam {

    private String account;

    private String password;

    private String code;

    private String codeId;

    private String autoLogin;

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

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getAutoLogin() {
        return autoLogin;
    }

    public void setAutoLogin(String autoLogin) {
        this.autoLogin = autoLogin;
    }
}
