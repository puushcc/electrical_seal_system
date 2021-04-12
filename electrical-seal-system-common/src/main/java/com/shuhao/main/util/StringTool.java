package com.shuhao.main.util;

import java.util.Random;

/**
 * @Description: String工具类
 * @author: XiaoShu
 * @date:
 */
public class StringTool {

    /**
     * 生成数字验证码
     * @return
     */
    public static String UUIDGenrateUtil(){

        String str="0123456789";
        String uuid=new String();
        for(int i=0;i<6;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            uuid+=ch;
        }
        return uuid;
    }

}
