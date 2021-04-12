package com.shuhao.main.entity;

/**
 * @Author: XiaoShu
 * @Description: 返回码定义
 * @Date
 */
public enum ResultCode implements IResultCode{
    /**
     * 默认成功
     */
    COMMON_SUCCESS(200, "成功"),
    CODE_SEND_SUCCESS(2008,"验证码发送成功"),
    CODE_REGISTER_SUCCESS(2001,"注册成功"),
    CODE_CHECK_SUCCESS(201,"验证成功"),
    CODE_PASSWORD_SUCCESS(202,"密码修改成功"),
    /**
     *默认失败
     */
    COMMON_FAIL(999, "失败"),
    CODE_REGISTER_FAIL(500,"注册失败"),
    USER_MISS_FAIL(2002,"用户未注册"),
    USER_EXIT_FAIL(2004,"用户已经被注册"),
    USER_LOCKED_FAIL(2007,"账号被锁定"),
    USER_PASSWORD_FAIL(2003,"密码不正确"),
    CODE_FAIL(2005,"验证码错误"),
    CODE_SEND_FAIL(2009,"验证码发送失败"),
    CODE_LOGIN_FAIL(2006,"登录失败"),


    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private long code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
