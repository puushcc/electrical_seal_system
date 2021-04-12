package com.shuhao.main.modules.Personal.service.impl;

import com.shuhao.main.dao.ElectricalSealUserRoleMapper;
import com.shuhao.main.dao.SealEnterpriseMapper;
import com.shuhao.main.entity.JsonResult;
import com.shuhao.main.modules.Personal.service.ICheckEnterpriseService;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.ResultTool;
import com.shuhao.main.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 企业认证实现层
 * @author:
 * @date:
 */
@Service
public class CheckEnterpriseServiceImpl implements ICheckEnterpriseService {

    @Autowired
    private IElectricalSealUserService electricalSealUserService;

    @Autowired
    private ElectricalSealUserRoleMapper electricalSealUserRoleMapper;

    @Autowired
    private SealEnterpriseMapper sealEnterpriseMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean checkEnterpriseByROleName(String account) {
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        Integer id = userByUsername.getId();
        ElectricalSealUserRoleExample example = new ElectricalSealUserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<ElectricalSealUserRole> electricalSealUserRoles = electricalSealUserRoleMapper.selectByExample(example);
        if (electricalSealUserRoles.get(0).getRoleId() == 4){
            return true;
        }
        return false;
    }

    @Override
    public SealEnterprise checkByEnterpriseName(String account) {
        ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
        Integer userid = userByUsername.getId();
        SealEnterpriseExample example = new SealEnterpriseExample();
        example.createCriteria().andUserIdEqualTo(userid);
        List<SealEnterprise> sealEnterprises = sealEnterpriseMapper.selectByExample(example);
        if (sealEnterprises.isEmpty()){
            return null;
        }
        return sealEnterprises.get(0);
    }

    @Override
    public JsonResult checkByEnterprise(SealEnterprise sealEnterprise, String token) {
        String account = jwtTokenUtil.getUserNameFromToken(token);
        if (checkEnterpriseByROleName(account)){
            return ResultTool.error();
        }{
            SealEnterprise byEnterpriseName = checkByEnterpriseName(account);
            if (byEnterpriseName == null){
                ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
                Integer userid = userByUsername.getId();
                sealEnterprise.setUserId(userid);
                sealEnterprise.setEnterpriseStats(0);
                int insert = sealEnterpriseMapper.insert(sealEnterprise);
            }else {
                ElectricalSealUser userByUsername = electricalSealUserService.getUserByUsername(account);
                Integer userid = userByUsername.getId();
                sealEnterprise.setUserId(userid);
                sealEnterprise.setEnterpriseStats(0);
                sealEnterprise.setEnterpriseId(byEnterpriseName.getEnterpriseId());
                int i = sealEnterpriseMapper.updateByPrimaryKey(sealEnterprise);
            }
            return ResultTool.success();
        }

    }


}
