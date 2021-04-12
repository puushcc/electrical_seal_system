package com.shuhao.main.config;

import com.shuhao.main.util.QCloudCosUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Farewell is well
 * @date
 */
@Configuration
public class QCloudCosUtilsConfig {
    @ConfigurationProperties(prefix = "qcloud")
    @Bean
    public QCloudCosUtils qcloudCosUtils() {
        return new QCloudCosUtils();
    }
}
