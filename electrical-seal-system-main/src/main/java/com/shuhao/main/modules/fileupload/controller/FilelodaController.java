package com.shuhao.main.modules.fileupload.controller;

import com.rabbitmq.client.AMQP;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.fileupload.FileUploadService;
import com.shuhao.main.util.FileToBase64;
import com.shuhao.main.util.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "用户个人信息操作类")
@RequestMapping("/fileLoad")
public class FilelodaController {

    @Autowired
    private FileUploadService fileUploadService;

    @ApiOperation(value = "上传文件")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult upload(@RequestParam("file") MultipartFile file,
                             HttpServletRequest request){
        String upload = fileUploadService.upload(file);
        return ResultTool.success(upload);
    }


    @ApiOperation(value = "文件")
    @RequestMapping(value = "/base",method = RequestMethod.GET)
    @ResponseBody
    public String upload() throws Exception {
        //String head = "data:application/pdf;base64,";
        String s = FileToBase64.netSourceToBase64("https://demo-1304423007.cos.ap-guangzhou.myqcloud.com/electric/%E4%B8%AA%E4%BA%BA%E7%AE%80%E5%8E%86s.pdf","GET");
        return s;
    }
}
