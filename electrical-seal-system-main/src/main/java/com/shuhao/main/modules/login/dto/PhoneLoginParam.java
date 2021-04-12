package com.shuhao.main.modules.login.dto;

/**
 * @Description: 用户手机验证码登录参数
 * @author: XiaoShu
 * @date: 2020年11月25日 15:37
 */
public class PhoneLoginParam {

    private String account;

    private String code;

    private String autoLogin;

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

    public String getAutoLogin() {
        return autoLogin;
    }

    public void setAutoLogin(String autoLogin) {
        this.autoLogin = autoLogin;
    }
}
