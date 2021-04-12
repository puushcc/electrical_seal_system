package com.shuhao.main.modules.fileupload.impl;


import com.shuhao.main.modules.fileupload.FileUploadService;
import com.shuhao.main.util.QCloudCosUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private QCloudCosUtils qCloudCosUtils;
    @Override
    public String upload(MultipartFile multipartFile) {
        return qCloudCosUtils.upload(multipartFile);
    }

    @Override
    public String upload(File file) {
        return qCloudCosUtils.upload(file);
    }


    @Override
    public void downloadFile(String remoteFilePath, String localFilePath) {
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(localFilePath);
        try {
            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection) urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
