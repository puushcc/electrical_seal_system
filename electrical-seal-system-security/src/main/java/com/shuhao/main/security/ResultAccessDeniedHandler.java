package com.shuhao.main.security;

import cn.hutool.json.JSONUtil;
import com.shuhao.main.entity.ResultCode;
import com.shuhao.main.util.ResultTool;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 自定义返回结果：没有权限访问时
 * @author: XiaoShu
 * @date: 2020年11月21日 23:01
 */
public class ResultAccessDeniedHandler implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Cache-Control","no-cache");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().println(JSONUtil.parse(ResultTool.error(e.getMessage(), ResultCode.FORBIDDEN)));
        httpServletResponse.getWriter().flush();
    }
}
