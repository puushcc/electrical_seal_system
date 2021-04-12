package com.shuhao.main.modules.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.utils.StringUtils;
import com.shuhao.main.domain.CodeProperties;
import com.shuhao.main.modules.login.component.VerificationCodeSend;
import com.shuhao.main.modules.login.service.ICodeService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.service.RedisService;
import com.shuhao.main.util.StringTool;
import com.wf.captcha.base.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 验证码业务层实现类
 * @author: XiaoShu
 * @date: 2020年11月23日 18:03
 */
@Service
public class CodeService implements ICodeService {

    CodeProperties codeProperties = new CodeProperties();

    @Autowired
    private RedisService redisService;

    @Autowired
    private VerificationCodeSend verificationCodeSend;

    @Override
    public Map<String, Object> imageCode() {
        Captcha captcha = null;
        try {
            captcha = codeProperties.getCaptcha();
            String verCode = captcha.text().toLowerCase();
            String key = UUID.randomUUID().toString();
            String base64 = captcha.toBase64();
            // 保存到Redis中设置过期时间为5分钟
            redisService.set(key,verCode,5, TimeUnit.MINUTES);
            // 将key和base64返回给前端
            Map<String, Object> imgResult = new HashMap<String, Object>(2) {{
                put("img", base64);
                put("codeId", key);
            }};
            return imgResult;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean checkCode(String codeId, String code) {
        String o = (String) redisService.get(codeId);
        if ( o == null || o == ""){
            return false;
        }
        return code.equals(o) ? true : false;
    }

    @Override
    public boolean clearCode(String codeId) {
        return redisService.del(codeId);
    }

    @Override
    public boolean send(String phoneNum, Map<String, Object> code) {
        // 连接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "", "");
        IAcsClient client = new DefaultAcsClient(profile);
        // 构建请求
        CommonRequest request = new CommonRequest();
        // 基本信息
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        // 自定义的参数（手机号，验证码，签名，模板）
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "");
        request.putQueryParameter("TemplateCode", "SMS_205816085");
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            //返回是否成功
            return response.getHttpResponse().isSuccess();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean LoginPhoneCode(String phoneNum) {
        //生成4位验证码并存储到 redis 中
        String code = StringTool.UUIDGenrateUtil();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
        verificationCodeSend.sendMessage(phoneNum, map);
        System.out.println("获取一条通信");
        //将验证码存入redis，并设置5分钟过期时间
        redisService.set(phoneNum,code,60, TimeUnit.MINUTES);
        return true;
    }


}
