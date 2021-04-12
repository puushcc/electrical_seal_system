package com.shuhao.main.security;

import cn.hutool.json.JSONUtil;
import com.shuhao.main.entity.ResultCode;
import com.shuhao.main.util.ResultTool;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 自定义返回结果：未登录或登录过期
 * @author: XiaoShu
 * @date: 2020年11月22日 12:15
 */
public class ResultAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Cache-Control","no-cache");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(ResultTool.error(e.getMessage(), ResultCode.UNAUTHORIZED)));
        httpServletResponse.getWriter().flush();
    }
}
