package com.shuhao.main.modules.sign.service.impl;

import com.shuhao.main.dao.SealUserSignMapper;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.fileupload.FileUploadService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.modules.sign.service.UserSignService;
import com.shuhao.main.util.BASE64DecodedMultipartFile;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.ElectricalSealUser;
import com.shuhao.main.vo.SealUserSign;
import com.shuhao.main.vo.SealUserSignExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 个人签名操作业务操作层
 */
@Service
public class UserSignServiceImpl implements UserSignService {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private SealUserSignMapper sealUserSignMapper;

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Override
    public JsonResult addUserSign(String token, String signBase64) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);

        if (!signBase64.isEmpty()){
            //将图片base64转为MultipartFile
            MultipartFile File = BASE64DecodedMultipartFile.base64ToMultipart(signBase64);
            if (File.isEmpty()) {
                return ResultTool.error();
            }else {
                //上传图片File到COS
                String upload = fileUploadService.upload(File);
                if (upload.isEmpty()){
                    return ResultTool.error();
                }else {
                    //添加到数据库
                    SealUserSign sealUserSign = new SealUserSign();
                    sealUserSign.setUserId(userByUsername.getId());
                    sealUserSign.setSignUrl(upload);
                    int i = sealUserSignMapper.insertSelective(sealUserSign);
                    if (i > 0 ){
                        return ResultTool.success();
                    }else {
                        return ResultTool.error();
                    }
                }

            }

        }else {
            return ResultTool.error();
        }



    }

    @Override
    public JsonResult<List<SealUserSign>> selectUserSign(String token) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        Integer userId = userByUsername.getId();
        SealUserSignExample example = new SealUserSignExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<SealUserSign> sealUserSigns = sealUserSignMapper.selectByExample(example);
        return ResultTool.success(sealUserSigns);
    }

    @Override
    public JsonResult delUserSign(String token, String url) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        Integer userId = userByUsername.getId();
        SealUserSignExample example = new SealUserSignExample();
        example.createCriteria().andUserIdEqualTo(userId).andSignUrlEqualTo(url);
        int i = sealUserSignMapper.deleteByExample(example);
        if (i > 0){
            return ResultTool.success();
        }else {
            return ResultTool.error();
        }
    }
}
