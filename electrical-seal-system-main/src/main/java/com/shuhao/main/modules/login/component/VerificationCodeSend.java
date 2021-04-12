package com.shuhao.main.modules.login.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: 发送短信验证码的生产者
 * @author: XiaoShu
 * @date: 2021年01月14日 16:43
 */
@Component
public class VerificationCodeSend {

    private static Logger LOGGER = LoggerFactory.getLogger(VerificationCodeSend.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String phoneNum, Map<String, Object> code){
        rabbitTemplate.convertAndSend("VerificationCode","info",phoneNum +","+ code.get("code"));
        LOGGER.info(phoneNum +","+ code.get("code"));
    }

}
