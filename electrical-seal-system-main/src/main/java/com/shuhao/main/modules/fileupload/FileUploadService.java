package com.shuhao.main.modules.fileupload;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Farewell is well
 * @date
 */
public interface FileUploadService {
    /**
     * 处理浏览器文件上传请求
     * @param multipartFile
     * @return
     */
    String upload(MultipartFile multipartFile);

    /**
     * 处理普通文件上传
     * @param file
     * @return
     */
    String upload(File file);

    /**
     * 下载远程文件并保存到本地
     *
     * @param remoteFilePath-远程文件路径
     * @param localFilePath-本地文件路径（带文件名）
     *
     */
    void downloadFile(String remoteFilePath, String localFilePath);
}
