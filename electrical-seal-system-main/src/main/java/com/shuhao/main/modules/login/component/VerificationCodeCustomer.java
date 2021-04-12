package com.shuhao.main.modules.login.component;

import com.shuhao.main.modules.login.service.ICodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
/**
 * @Description: 发送短信验证码的消费者
 * @author: XiaoShu
 * @date: 2021年01月14日 16:52
 */
@Component
public class VerificationCodeCustomer {

    @Autowired
    private ICodeService codeService;

    private static Logger LOGGER = LoggerFactory.getLogger(VerificationCodeCustomer.class);

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "VerificationCode",type = "direct"),
                    key = {"info"}
            )
    })
    public void receivel(String message){
        String[] split = message.split(",");
        String phoneNum = split[0];
        String code = split[1];
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
        codeService.send(phoneNum,map);
        LOGGER.info(phoneNum + code);
    }


}
