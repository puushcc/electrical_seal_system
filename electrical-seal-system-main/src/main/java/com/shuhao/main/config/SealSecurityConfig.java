package com.shuhao.main.config;

import com.shuhao.main.modules.login.service.IElectricalSealUserService;
import com.shuhao.main.modules.login.service.IResourceService;
import com.shuhao.main.security.IDataSecurityService;
import com.shuhao.main.vo.ElectricalSealPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: Security配置类
 * @author: XiaoShu
 * @date:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SealSecurityConfig extends SecurityConfig{

    @Autowired
    private IElectricalSealUserService userService;

    @Autowired
    private IResourceService resourceService;

    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        //获取登录用户信息
        return account -> userService.loadUserByUsername(account);
    }

    @Bean
    public IDataSecurityService dataSecurityService() {
        return new IDataSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<ElectricalSealPermission> resourceList = resourceService.listAll();
                for (ElectricalSealPermission resource : resourceList) {
                    map.put(resource.getPermissionCode(),
                            new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getPermissionName()));
                }
                return map;
            }
        };
    }

}
