package com.shuhao.main.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: MyBatis配置
 * @author: XiaoShu
 * @date:
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.shuhao.main.dao","com.shuhao.main.modules.login.dao","com.shuhao.main.modules.contract.dao"})
public class MyBatisConfig {
}
