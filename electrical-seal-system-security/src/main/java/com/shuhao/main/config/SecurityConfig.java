package com.shuhao.main.config;

import com.shuhao.main.security.*;
import com.shuhao.main.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description: SpringSecurity的配置
 * @author: XiaoShu
 * @date: 2020年11月21日 18:51
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ResultAccessDeniedHandler resultAccessDeniedHandler;

    @Autowired
    ResultAuthenticationEntryPoint resultAuthenticationEntryPoint;

    @Autowired
    IgnoreUrlsConfig ignoreUrlsConfig;

    @Autowired
    private IDataSecurityService dataSecurityService;

    @Bean
    public ResultAccessDeniedHandler resultAccessDeniedHandler(){
        return new ResultAccessDeniedHandler();
    }

    @Bean
    public ResultAuthenticationEntryPoint resultAuthenticationEntryPoint(){
        return new ResultAuthenticationEntryPoint();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
        .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        //不需要保护的资源路径允许访问
        for (String url : ignoreUrlsConfig.getUrls()) {
            registry.antMatchers(url).permitAll();
        }
        //允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS)
                .permitAll();
        // 任何请求需要身份认证
        registry.and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(resultAccessDeniedHandler())
                .authenticationEntryPoint(resultAuthenticationEntryPoint())
                // 自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //有动态权限配置时添加动态权限校验过滤器
        if(dataSecurityService != null){
            registry.and().addFilterBefore(permissionSecurityFilter(), FilterSecurityInterceptor.class);
        }

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @ConditionalOnBean(name = "dataSecurityService")
    public PermissionAccessDecisionManager permissionAccessDecisionManager(){
        return new PermissionAccessDecisionManager();
    }

    @Bean
    @ConditionalOnBean(name = "dataSecurityService")
    public PermissionSecurityFilter permissionSecurityFilter(){
        return new PermissionSecurityFilter();
    }

    @Bean
    @ConditionalOnBean(name = "dataSecurityService")
    public PermissionFilterInvocationSecurityMetadataSource permissionFilterInvocationSecurityMetadataSource(){
        return new PermissionFilterInvocationSecurityMetadataSource();
    }

}
