package com.shuhao.main.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Rides Cache 配置类
 * @author: XiaoShu
 * @date:
 */

@Configuration
@EnableCaching
public class CacheConfig extends BaseCacheConfig{
}
