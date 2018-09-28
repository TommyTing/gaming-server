package com.ooqiu.gaming.server.web.admin.config.thymeleaf;

import com.ooqiu.gaming.server.web.admin.config.thymeleaf.dialect.ThSysDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Thymeleaf 配置
 */
@Configuration
public class ThymeleafConfiguration {

    @Bean
    public ThSysDialect thSysDialect() {
        return new ThSysDialect();
    }

}
