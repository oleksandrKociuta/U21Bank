package edu.cursor.u21.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by vk on 3/20/17.
 */
@Configuration
public class ContextConfig {
    @Bean
    public DataSource dataSource() {
        return null;
    }
}
