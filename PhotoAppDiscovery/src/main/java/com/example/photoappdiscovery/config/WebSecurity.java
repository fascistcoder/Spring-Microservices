package com.example.photoappdiscovery.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/08/22
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	@Override protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
	}
}
