package edu.cursor.u21.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Kocyta on 24.03.17.
 */
@Configuration
public class PropertyConfigurator {

    @Bean
    public static PropertySourcesPlaceholderConfigurer testPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("db-props.properties"));
        return configurer;
    }
}
