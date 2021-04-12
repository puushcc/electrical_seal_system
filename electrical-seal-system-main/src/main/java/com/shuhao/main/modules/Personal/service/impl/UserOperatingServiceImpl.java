package com.shuhao.main.modules.Personal.service.impl;

import com.shuhao.main.dao.ElectricalSealUserMapper;
import com.shuhao.main.dao.ElectricalSealUserRoleMapper;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.Personal.service.ICheckpersonalUserService;
import com.shuhao.main.modules.Personal.service.IUserOperatingService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.ElectricalSealUser;
import com.shuhao.main.vo.ElectricalSealUserRole;
import com.shuhao.main.vo.ElectricalSealUserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用户个人信息操作实现层
 * @author: scott
 * @date:
 */
@Service
public class UserOperatingServiceImpl implements IUserOperatingService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ICheckpersonalUserService checkpersonalUserService;

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Autowired
    private ElectricalSealUserRoleMapper electricalSealUserRoleMapper;

    @Autowired
    private ElectricalSealUserMapper electricalSealUserMapper;

    @Override
    public JsonResult<ElectricalSealUser> getUserInformation(String token) {
        String account = jwtTokenUtil.getUserNameFromToken(token);
        Integer integer = checkpersonalUserService.checkPersonal(account);
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        ElectricalSealUserRoleExample example = new ElectricalSealUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userByUsername.getId());
        List<ElectricalSealUserRole> electricalSealUserRoles = electricalSealUserRoleMapper.selectByExample(example);
        Integer roleId = electricalSealUserRoles.get(0).getRoleId();
        if (roleId == 1){
            userByUsername.setPassword("管理员");
        }else if (roleId == 2 || roleId == 3){
            userByUsername.setPassword("个体用户");
        }else if (roleId == 4){
            userByUsername.setPassword("企业用户");
        }
        if (integer == -1){
            return ResultTool.error(userByUsername);
        }
        return ResultTool.success(userByUsername);
    }

    @Override
    public JsonResult<ElectricalSealUser> updateUserName(String token, ElectricalSealUser electricalSealUser) {
        String account = jwtTokenUtil.getUserNameFromToken(token);
        Integer integer = electricalSealUserService.getUserByUsernameDB(account).getId();
        electricalSealUser.setId(integer);
        int i = electricalSealUserMapper.updateByPrimaryKeySelective(electricalSealUser);
        if (i>0){
            electricalSealUserService.getUserByUsernameDB(account);
            return ResultTool.success(electricalSealUser);
        }else {
            return ResultTool.error();
        }
    }

    @Override
    public JsonResult<ElectricalSealUser> updateMail(String token, ElectricalSealUser electricalSealUser) {
        String account = jwtTokenUtil.getUserNameFromToken(token);
        Integer integer = electricalSealUserService.getUserByUsernameDB(account).getId();
        electricalSealUser.setId(integer);
        int i = electricalSealUserMapper.updateByPrimaryKeySelective(electricalSealUser);
        if (i>0){
            electricalSealUserService.getUserByUsernameDB(account);
            return ResultTool.success(electricalSealUser);
        }else {
            return ResultTool.error();
        }
    }

    @Override
    public JsonResult<ElectricalSealUser> updateImage(String token, ElectricalSealUser electricalSealUser) {
        String account = jwtTokenUtil.getUserNameFromToken(token);
        Integer integer = electricalSealUserService.getUserByUsernameDB(account).getId();
        electricalSealUser.setId(integer);
        int i = electricalSealUserMapper.updateByPrimaryKeySelective(electricalSealUser);
        if (i>0){
            electricalSealUserService.getUserByUsernameDB(account);
            return ResultTool.success(electricalSealUser);
        }else {
            return ResultTool.error();
        }
    }


}
