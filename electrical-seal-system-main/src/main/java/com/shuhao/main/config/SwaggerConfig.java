package com.shuhao.main.config;

import com.shuhao.main.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: Swagger API文档相关配置
 * @author: github-mall
 * @date:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig{
    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.shuhao.main.modules.admin.controller,com.shuhao.main.modules.*.controller")
                .title("印控中台系统")
                .description("印控中台系统相关接口文档")
                .contactName("shuhao")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
