package com.shuhao.main.domain;

import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;

import java.awt.*;
import java.io.IOException;

/**
 * @Description: 验证码生产类
 * @author: XiaoShu
 * @date:
 */
public class CodeProperties {

    /**
     * 获取验证码生产类
     *
     */
    public Captcha getCaptcha() throws Exception {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置内置字体
        specCaptcha.setFont(Captcha.FONT_1);
        return specCaptcha;
    }

}
