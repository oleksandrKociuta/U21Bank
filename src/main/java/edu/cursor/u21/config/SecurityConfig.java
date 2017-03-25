package edu.cursor.u21.config;

import edu.cursor.u21.handler.LogoutSuccessHandlerForLoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by vk on 3/22/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void globalConfig(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER");
        authentication.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/views/admin/**")
                .access("hasRole('ROLE_ADMIN')");
        httpSecurity.formLogin()
                .loginPage("login")
                .loginProcessingUrl("/views/login")
                .usernameParameter("")
                .passwordParameter("")
                .defaultSuccessUrl("/views/bankClient/home");
        httpSecurity.logout()
                .logoutUrl("/")
                .logoutSuccessHandler(new LogoutSuccessHandlerForLoginPage());
    }
}
