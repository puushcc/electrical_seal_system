package com.shuhao.main.modules.login.bo;


import com.shuhao.main.vo.ElectricalSealPermission;
import com.shuhao.main.vo.ElectricalSealUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: SpringSecurity需要的用户详情
 * @author: XiaoShu
 * @date: 2020年11月21日 22:52
 */
public class MyUserDetails implements UserDetails {
    private ElectricalSealUser electricalSealUser;
    private List<ElectricalSealPermission> permissions;

    public MyUserDetails(ElectricalSealUser electricalSealUser, List<ElectricalSealPermission> permissions) {
        this.electricalSealUser = electricalSealUser;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissions.stream()
                .map(role -> new SimpleGrantedAuthority(role.getId()+":"+role.getPermissionName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return electricalSealUser.getPassword();
    }

    @Override
    public String getUsername() {
        return electricalSealUser.getAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return electricalSealUser.getLocked().equals(1);
    }
}
