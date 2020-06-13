package com.challenge.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/acceleration/**").authenticated()
                .antMatchers(HttpMethod.GET, "/candidate/**").authenticated()
                .antMatchers(HttpMethod.GET, "/challenge/**").authenticated()
                .antMatchers(HttpMethod.GET, "/company/**").authenticated()
                .antMatchers(HttpMethod.GET, "/submission/**").authenticated()
                .antMatchers(HttpMethod.GET, "/user/**").permitAll();

    }
}
