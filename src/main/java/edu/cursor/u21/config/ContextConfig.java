package edu.cursor.u21.config;

import edu.cursor.u21.users.bankClient.Accounts.AccountFactory;
import edu.cursor.u21.users.bankClient.BankClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by vk on 3/20/17.
 */
@Configuration
@ComponentScan("edu.cursor.u21.service")
public class ContextConfig {

    @Bean
    @Scope("prototype")
    public AccountFactory accountFactoryBean() {
        return new AccountFactory();
    }

    @Bean
    @Scope("prototype")
    public BankClient bankClientBean() {
        return new BankClient();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
