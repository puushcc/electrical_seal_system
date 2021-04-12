package com.shuhao.main.modules.login.service;

import java.util.Map;

/**
 * @Description: 验证码业务层接口
 * @author: XiaoShu
 * @date: 2020年11月23日 18:00
 */
public interface ICodeService {

    /**
     * 生成图片验证码
     * @return
     * @throws Exception
     */
    Map<String, Object> imageCode();

    /**
     * 校验验证码
     * @param codeId
     * @param code
     * @return
     */
    boolean checkCode(String codeId,String code);

    /**
     * 清除验证码缓存
     * @param codeId
     * @return
     */
    boolean clearCode(String codeId);

    /**
     * 发送短信验证码
     * @param phoneNum
     * @param code
     * @return
     */
    boolean send(String phoneNum,Map<String, Object> code);

    /**
     * 获取手机短信验证码
     * @return
     */
    boolean LoginPhoneCode(String phoneNum);


}
