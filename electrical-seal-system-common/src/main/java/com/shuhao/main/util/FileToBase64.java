package com.shuhao.main.util;


import com.google.common.base.Strings;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileToBase64 {


    /**
     * 根据文件url获取文件并转换为base64编码
     *
     * @param srcUrl 文件地址
     * @param requestMethod 请求方式（"GET","POST"）
     * @return 文件base64编码
     */
    public static String netSourceToBase64(String srcUrl,String requestMethod) {
        ByteArrayOutputStream outPut = new ByteArrayOutputStream();
        byte[] data = new byte[1024 * 8];
        try {
            // 创建URL
            URL url = new URL(srcUrl);
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setConnectTimeout(10 * 1000);

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                //连接失败/链接失效/文件不存在
                return null;
            }
            InputStream inStream = conn.getInputStream();
            int len = -1;
            while (-1 != (len = inStream.read(data))) {
                outPut.write(data, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(outPut.toByteArray());
    }
}
