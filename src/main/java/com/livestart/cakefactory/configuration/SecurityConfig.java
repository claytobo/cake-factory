package com.livestart.cakefactory.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.livestart.cakefactory.services.SignupService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private SignupService service;
	
	private static final String[] PUBLIC_MATCHERS = {
		"/", "/css/**", "/images/**", "/vendor/**", "/register/**", "/login/**", "/actuator/**"
	};
	
	public SecurityConfig(SignupService injected) {
		this.service = injected;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/basket/").hasRole("CUSTOMER")
				.antMatchers(HttpMethod.GET, "/basket/add/**").permitAll()
				.antMatchers(HttpMethod.GET, "/basket/subtract/**").permitAll()
				.antMatchers(HttpMethod.GET, "/basket/item/**").permitAll()
				.antMatchers("/account/").hasRole("CUSTOMER")
				.antMatchers(PUBLIC_MATCHERS).permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/basket")
					.failureUrl("/error")
			.and()
				.exceptionHandling()
					.accessDeniedPage("/error")
			.and()
				.logout()
					.deleteCookies("JSESSIONID")
					.logoutSuccessUrl("/")
			.and()
				.addFilterAfter(new CustomerFilterBean(), BasicAuthenticationFilter.class);
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return service;
	}

}
