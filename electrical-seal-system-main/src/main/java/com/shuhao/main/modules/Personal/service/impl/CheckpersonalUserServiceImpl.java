package com.shuhao.main.modules.Personal.service.impl;

import com.shuhao.main.dao.ElectricalSealUserMapper;
import com.shuhao.main.dao.ElectricalSealUserRoleMapper;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.entity.ResultCode;
import com.shuhao.main.modules.Personal.dto.CheckParam;
import com.shuhao.main.modules.Personal.service.ICheckpersonalUserService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.ElectricalSealUser;
import com.shuhao.main.vo.ElectricalSealUserExample;
import com.shuhao.main.vo.ElectricalSealUserRole;
import com.shuhao.main.vo.ElectricalSealUserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 实名认证实现层
 * @author:
 * @date:
 */

@Service
public class CheckpersonalUserServiceImpl implements ICheckpersonalUserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ElectricalSealUserMapper electricalSealUserMapper;

    @Autowired
    private ElectricalSealUserRoleMapper electricalSealUserRoleMapper;

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Override
    public JsonResult checkPersonalUser(CheckParam checkParam,String token) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        //判断该账号是否已经实名认证
        Integer integer = checkPersonal(account);
        if (integer == -1){
            return ResultTool.error(ResultCode.COMMON_FAIL);
        }
        //进行实名认证
        if (checkPersonalById(checkParam)){
            //实名认证成功，添加数据到数据库中
            ElectricalSealUser electricalSealUser = new ElectricalSealUser();
            electricalSealUser.setIdCard(checkParam.getIdCard());
            electricalSealUser.setRealName(checkParam.getRealName());
            electricalSealUser.setId(integer);
            int i = electricalSealUserMapper.updateByPrimaryKeySelective(electricalSealUser);
            //修改用户访客角色为普通用户
            ElectricalSealUserRoleExample example = new ElectricalSealUserRoleExample();
            example.createCriteria().andUserIdEqualTo(integer);
            ElectricalSealUserRole electricalSealUserRole = new ElectricalSealUserRole();
            electricalSealUserRole.setRoleId(2);
            electricalSealUserRoleMapper.updateByExampleSelective(electricalSealUserRole,example);
            //更新用户信息缓存
            electricalSealUserService.getUserByUsernameDB(account);
            if (i>0){
                return ResultTool.error(ResultCode.COMMON_SUCCESS);
            }else {
                return ResultTool.error(ResultCode.COMMON_FAIL);
            }

        }
        return ResultTool.error(ResultCode.COMMON_FAIL);

    }

    @Override
    public Integer checkPersonal(String account) {
        ElectricalSealUserExample example = new ElectricalSealUserExample();
        example.createCriteria().andAccountEqualTo(account);
        List<ElectricalSealUser> electricalSealUsers = electricalSealUserMapper.selectByExample(example);
        if ( electricalSealUsers.get(0).getIdCard() == null && electricalSealUsers.get(0).getRealName() == null ){
            return electricalSealUsers.get(0).getId();
        }else {
            return -1;
        }
    }

    @Override
    public boolean checkPersonalById(CheckParam checkParam) {
        //调用身份证二要素认证接口进行认证

        return true;
    }


}
