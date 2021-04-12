package com.shuhao.main.modules.admin.service.impl;

import com.shuhao.main.dao.ElectricalSealUserMapper;
import com.shuhao.main.dao.ElectricalSealUserRoleMapper;
import com.shuhao.main.dao.SealEnterpriseMapper;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.entity.ResultCode;
import com.shuhao.main.modules.admin.dto.EntriInformation;
import com.shuhao.main.modules.admin.dto.UserInformation;
import com.shuhao.main.modules.admin.service.IAdminUserService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserService implements IAdminUserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Autowired
    private ElectricalSealUserRoleMapper electricalSealUserRoleMapper;

    @Autowired
    private ElectricalSealUserMapper electricalSealUserMapper;

    @Autowired
    private SealEnterpriseMapper sealEnterpriseMapper;

    @Override
    public JsonResult<List<UserInformation>> getuser(String token) {

        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        //用户是否为管理员
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        ElectricalSealUserRoleExample example = new ElectricalSealUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userByUsername.getId());
        List<ElectricalSealUserRole> electricalSealUserRoles = electricalSealUserRoleMapper.selectByExample(example);
        if (electricalSealUserRoles.get(0).getRoleId() != 1) {
            return ResultTool.error();
        }
        List<ElectricalSealUser> electricalSealUsers = electricalSealUserMapper.selectByExample(new ElectricalSealUserExample());
        List<UserInformation> list = new ArrayList<>();
        for (ElectricalSealUser electricalSealUser : electricalSealUsers) {
            UserInformation userInformation = new UserInformation();
            userInformation.setAccount(electricalSealUser.getAccount());
            userInformation.setUsername(electricalSealUser.getUserName());
            if (electricalSealUser.getMail() == null ){
                userInformation.setMail("未设置");
            }else {
                userInformation.setMail(electricalSealUser.getMail());
            }
            if (electricalSealUser.getIdCard() == null){
                userInformation.setIdcard("未实名");
            }else {
                userInformation.setIdcard(electricalSealUser.getIdCard());
            }
            if (electricalSealUser.getRealName() == null){
                userInformation.setRealname("未实名");
            }else {
                userInformation.setRealname(electricalSealUser.getRealName());
            }

            userInformation.setCreattime(electricalSealUser.getCreateTime());
            if (!electricalSealUser.getLocked()){
                userInformation.setStatus("禁用中");
            }else {
                userInformation.setStatus("正常");
            }
            ElectricalSealUserRoleExample example1 = new ElectricalSealUserRoleExample();
            example1.createCriteria().andUserIdEqualTo(electricalSealUser.getId());
            List<ElectricalSealUserRole> electricalSealUserRoles1 = electricalSealUserRoleMapper.selectByExample(example1);
            if (electricalSealUserRoles1.get(0).getRoleId() == 1) {
                userInformation.setRole("管理员");
            }
            if (electricalSealUserRoles1.get(0).getRoleId() == 3) {
                userInformation.setRole("访客");
            }
            if (electricalSealUserRoles1.get(0).getRoleId() == 2) {
                userInformation.setRole("普通用户");
            }
            if (electricalSealUserRoles1.get(0).getRoleId() == 4) {
                userInformation.setRole("企业用户");
            }
            list.add(userInformation);
        }
        return ResultTool.success(list);
    }

    @Override
    public JsonResult upStates(String token, UserInformation userInformation) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        //用户是否为管理员
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        ElectricalSealUserRoleExample example = new ElectricalSealUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userByUsername.getId());
        List<ElectricalSealUserRole> electricalSealUserRoles = electricalSealUserRoleMapper.selectByExample(example);
        if (electricalSealUserRoles.get(0).getRoleId() != 1) {
            return ResultTool.error();
        }
        String account1 = userInformation.getAccount();
        String status = userInformation.getStatus();
        ElectricalSealUser electricalSealUser = new ElectricalSealUser();

        if (status.equals("正常")){
            electricalSealUser.setLocked(false);
        }
        if (status.equals("禁用中")){
            electricalSealUser.setLocked(true);
        }
        ElectricalSealUserExample example1= new ElectricalSealUserExample();
        example1.createCriteria().andAccountEqualTo(account1);
        int i = electricalSealUserMapper.updateByExampleSelective(electricalSealUser, example1);
        return ResultTool.success();


    }

    @Override
    public JsonResult<List<EntriInformation>> getentri(String token) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        //用户是否为管理员
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        ElectricalSealUserRoleExample example = new ElectricalSealUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userByUsername.getId());
        List<ElectricalSealUserRole> electricalSealUserRoles = electricalSealUserRoleMapper.selectByExample(example);
        if (electricalSealUserRoles.get(0).getRoleId() != 1) {
            return ResultTool.error();
        }
        List<SealEnterprise> sealEnterprises = sealEnterpriseMapper.selectByExample(new SealEnterpriseExample());
        List<EntriInformation> list = new ArrayList<>();
        for (SealEnterprise sealEnterpris : sealEnterprises) {
            EntriInformation entriInformation = new EntriInformation();
            ElectricalSealUser electricalSealUser = electricalSealUserMapper.selectByPrimaryKey(sealEnterpris.getUserId());
            entriInformation.setAccount(electricalSealUser.getAccount());
            entriInformation.setEname(sealEnterpris.getEnterpriseName());
            entriInformation.setEindustry(sealEnterpris.getEnterpriseIndustry());
            entriInformation.setEcity(sealEnterpris.getEnterpriseCity());
            entriInformation.setEbusiness(sealEnterpris.getEnterpriseBusiness());
            entriInformation.setEcode(sealEnterpris.getEnterpriseCode());
            entriInformation.setElocal(sealEnterpris.getEnterpriseLocal());
            entriInformation.setEuser(sealEnterpris.getEnterpriseUser());
            entriInformation.setEstats(String.valueOf(sealEnterpris.getEnterpriseStats()));
            list.add(entriInformation);
        }
        return ResultTool.success(list);
    }

    @Override
    public JsonResult review(String token, EntriInformation entriInformation) {
        //获取用户账号
        String account = jwtTokenUtil.getUserNameFromToken(token);
        //用户是否为管理员
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        ElectricalSealUserRoleExample example = new ElectricalSealUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userByUsername.getId());
        List<ElectricalSealUserRole> electricalSealUserRoles = electricalSealUserRoleMapper.selectByExample(example);
        if (electricalSealUserRoles.get(0).getRoleId() != 1) {
            return ResultTool.error();
        }
        String account1 = entriInformation.getAccount();
        String review = entriInformation.getReview();
        ElectricalSealUser userByUsername1 = electricalSealUserService.getUserByUsername(account1);
        Integer userid = userByUsername1.getId();
        SealEnterpriseExample example1 = new SealEnterpriseExample();
        example1.createCriteria().andUserIdEqualTo(userid);
        if (review.equals("true")){
            SealEnterprise sealEnterprise = new SealEnterprise();
            sealEnterprise.setEnterpriseStats(1);
            sealEnterpriseMapper.updateByExampleSelective(sealEnterprise,example1);
            ElectricalSealUserRoleExample example2 = new ElectricalSealUserRoleExample();
            example2.createCriteria().andUserIdEqualTo(userid);
            ElectricalSealUserRole electricalSealUserRole = new ElectricalSealUserRole();
            electricalSealUserRole.setRoleId(4);
            electricalSealUserRoleMapper.updateByExampleSelective(electricalSealUserRole,example2);
            return ResultTool.success();
        }else {
            SealEnterprise sealEnterprise = new SealEnterprise();
            sealEnterprise.setEnterpriseStats(2);
            sealEnterpriseMapper.updateByExampleSelective(sealEnterprise,example1);
            return ResultTool.success();
        }

    }
}
