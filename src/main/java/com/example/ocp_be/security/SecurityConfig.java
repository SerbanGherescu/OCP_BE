package com.example.ocp_be.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/users/**/")
                .authenticated()
                .antMatchers("/hi")
                .permitAll()
                .antMatchers(HttpMethod.PUT,"/api/orders")
                .authenticated()
                .antMatchers("/adminDashboard").hasRole("ADMIN")
                .antMatchers("/managerDashboard").hasAnyRole("ADMIN","MANAGER")
                .antMatchers("/products").hasAnyAuthority("ROLE_ADMIN","ROLE_MANAGER")
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .headers().frameOptions().disable()
                .and()
                .logout()
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user1").password("$2a$12$o1kpRn72KvL1fkoHQMpd5OeR21fVXunyaW1AyyGWPQ/N.mumfL6Eq").roles("ADMIN")
                .and()
                .withUser("user2").password("$2a$12$o1kpRn72KvL1fkoHQMpd5OeR21fVXunyaW1AyyGWPQ/N.mumfL6Eq").roles("MANAGER");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}