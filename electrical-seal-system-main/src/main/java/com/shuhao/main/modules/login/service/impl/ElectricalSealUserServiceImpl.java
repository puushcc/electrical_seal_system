package com.shuhao.main.modules.login.service.impl;

import com.shuhao.main.dao.ElectricalSealUserMapper;
import com.shuhao.main.dao.ElectricalSealUserRoleMapper;
import com.shuhao.main.modules.login.bo.MyUserDetails;
import com.shuhao.main.modules.login.dao.PermissionResourceDao;
import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.modules.login.service.IRoleService;
import com.shuhao.main.service.RedisService;
import com.shuhao.main.util.JwtTokenUtil;
import com.shuhao.main.util.StringTool;
import com.shuhao.main.vo.ElectricalSealPermission;
import com.shuhao.main.vo.ElectricalSealUser;
import com.shuhao.main.vo.ElectricalSealUserExample;
import com.shuhao.main.vo.ElectricalSealUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: IElectricalSealUserService的实现类
 * @author: XiaoShu
 * @date: 2020年11月21日 20:55
 */
@Service
public class ElectricalSealUserServiceImpl implements IElectricalSealUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElectricalSealUserServiceImpl.class);
    @Autowired
    private ElectricalSealUserMapper electricalSealUserMapper;

    @Autowired
    private PermissionResourceDao permissionResourceDao;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RedisService redisService;

    @Override
    public String login(String account, String password ,String autoLogin) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(account);
            if( null != password && !passwordEncoder.matches(password,userDetails.getPassword())){
                return token;
            }
//            if(!userDetails.isEnabled()){
//               throw new RuntimeException("账号被锁定");
//            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.createToken(userDetails);
            //自动登录则将token存入Cookie中

            //更新登录时间
            updateLoginTimeByUsername(account);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public boolean register(String account, String password, String username) {
        ElectricalSealUser electricalSealUser = new ElectricalSealUser();
        //设置账号
        if (StringUtils.isEmpty(account)){
            return false;
        }else {
            electricalSealUser.setAccount(account);
        }
        //设置昵称
        if (StringUtils.isEmpty(username)) {
            electricalSealUser.setUserName(account);
        } else {
            electricalSealUser.setUserName(username);
        }
        //设置密码
        if (StringUtils.isEmpty(password)){
            String s = "123456";
            electricalSealUser.setPassword( new BCryptPasswordEncoder().encode(s) );
        }else {
            electricalSealUser.setPassword( new BCryptPasswordEncoder().encode(password) );
        }
        electricalSealUser.setCreateTime(new Date());
        int i = electricalSealUserMapper.insertSelective(electricalSealUser);
        if (i>0){
            //设置用户默认角色位普通用户
            ElectricalSealUser userByUsername = getUserByUsername(account);
            if (userByUsername != null){
                ElectricalSealUserRole electricalSealUserRole = new ElectricalSealUserRole();
                electricalSealUserRole.setUserId(userByUsername.getId());
                electricalSealUserRole.setRoleId(3);
                roleService.insertUserRole(electricalSealUserRole);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public ElectricalSealUser getUserByUsername(String account) {
        String key = "userInformation: redis_user_" + account;
        ElectricalSealUser electricalSealUser = (ElectricalSealUser) redisService.get(key);
        if (electricalSealUser != null ){
            return electricalSealUser;
        }
        //从数据库获取用户信息并且写入缓存
        return getUserByUsernameDB(account);
    }

    @Override
    public ElectricalSealUser getUserByUsernameDB(String account){
        String key = "userInformation: redis_user_" + account;
        ElectricalSealUser electricalSealUser = new ElectricalSealUser();
        ElectricalSealUserExample example = new ElectricalSealUserExample();
        example.createCriteria().andAccountEqualTo(account);
        List<ElectricalSealUser> electricalSealUsers = electricalSealUserMapper.selectByExample(example);
        if (electricalSealUsers != null && electricalSealUsers.size() > 0) {
            electricalSealUser = electricalSealUsers.get(0);
            redisService.set(key,electricalSealUser,24, TimeUnit.HOURS);
            return electricalSealUser;
        }
        return null;
    }


    @Override
    public String getStatusByUsername(String account) {
        ElectricalSealUser electricalSealUser = getUserByUsername(account);
        if (electricalSealUser != null ){
            Boolean locked = electricalSealUser.getLocked();
            if (!locked){
                return "IsLocked";
            }else{
                return "Ok";
            }
        }
        return "NoUser";
    }


    @Override
    public UserDetails loadUserByUsername(String account) {
        //获取用户信息
        ElectricalSealUser userByUsername = getUserByUsername(account);
        if (userByUsername != null){
            List<ElectricalSealPermission> resourceList = getResourceList(userByUsername.getId());
            return new MyUserDetails(userByUsername,resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public List<ElectricalSealPermission> getResourceList(Integer userId) {
        String key = "userInformation: redis_resource_" + userId;
        List<ElectricalSealPermission> electricalSealPermissions = (List<ElectricalSealPermission>) redisService.get(key);
        if (electricalSealPermissions != null){
            return electricalSealPermissions;
        }
        electricalSealPermissions = permissionResourceDao.getResourceList(userId);
        redisService.set(key,electricalSealPermissions,24,TimeUnit.HOURS);
        return electricalSealPermissions;
    }

    @Override
    public void updateLoginTimeByUsername(String account) {
        ElectricalSealUser electricalSealUser = new ElectricalSealUser();
        electricalSealUser.setUpdateTime(new Date());
        ElectricalSealUserExample example = new ElectricalSealUserExample();
        example.createCriteria().andAccountEqualTo(account);
        electricalSealUserMapper.updateByExampleSelective(electricalSealUser,example);
    }

    @Override
    public void updatePasswordByUsername(String account,String password) {
        ElectricalSealUser electricalSealUser = new ElectricalSealUser();
        electricalSealUser.setPassword(password);
        ElectricalSealUserExample example = new ElectricalSealUserExample();
        example.createCriteria().andAccountEqualTo(account);
        electricalSealUserMapper.updateByExampleSelective(electricalSealUser,example);
    }
}
