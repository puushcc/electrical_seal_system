package com.shuhao.main.modules.login.service;

import com.shuhao.main.vo.ElectricalSealPermission;
import com.shuhao.main.vo.ElectricalSealUser;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @Description: 用户操作Service接口层
 * @author: XiaoShu
 * @date: 2020年11月21日 20:55
 */
public interface IElectricalSealUserService {

    /**
     * 登录功能
     * @param account 用户账号
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String account,String password,String autoLogin);

    /**
     * 注册功能
     * @param account 用户账号
     * @param password 密码
     * @param username 用于昵称
     * @return
     */
    boolean register(String account,String password,String username);

    /**
     * 根据用户名获取用户
     *  @param account 用户账号
     *  @return 用户信息
     */
    ElectricalSealUser getUserByUsername(String account);

    /**
     * 从数据库获取用户信息并且写入缓存
     *  @param account 用户账号
     *  @return 用户信息
     */
    ElectricalSealUser getUserByUsernameDB(String account);

    /**
     * 账号是否可用
     *  @param account 用户账号
     *  @return 用户状态
     */
    String getStatusByUsername(String account);

    /**
     * 获取用户信息
     * @param account 用户账号
     * @return 用户信息，包括角色可权限
     */
     UserDetails loadUserByUsername(String account);



    /**
     * 获取指定用户的可访问资源
     */
    List<ElectricalSealPermission> getResourceList(Integer userId);

    /**
     * 更新用户的最后一次登录时间
     */
    void updateLoginTimeByUsername(String account);

    /**
     * 修改用户密码
     */
    void updatePasswordByUsername(String account,String password);



}
