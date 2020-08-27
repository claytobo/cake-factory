package com.livestart.cakefactory.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.livestart.cakefactory.services.SignupService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private SignupService service;
	private BCryptPasswordEncoder encoder;
	
	private static final String[] PUBLIC_MATCHERS = {
		"/", "/css/**", "/images/**", "/vendor/**", "/register/**", "/login/**", "/actuator/**"
	};
	
	public SecurityConfig(SignupService injected, BCryptPasswordEncoder encoder) {
		this.service = injected;
		this.encoder = encoder;
	}
	
	/*
	 * .csrf().disable()
          .authorizeRequests()
          .antMatchers("/admin/**").hasRole("ADMIN")
          .antMatchers("/anonymous*").anonymous()
          .antMatchers("/login*").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login.html")
          .loginProcessingUrl("/perform_login")
          .defaultSuccessUrl("/homepage.html", true)
          //.failureUrl("/login.html?error=true")
          .failureHandler(authenticationFailureHandler())
          .and()
          .logout()
          .logoutUrl("/perform_logout")
          .deleteCookies("JSESSIONID")
          .logoutSuccessHandler(logoutSuccessHandler());

	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//			.httpBasic()
//			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/basket/").hasRole("CUSTOMER")
				.antMatchers(HttpMethod.GET, "/basket/add/**").permitAll()
				.antMatchers(HttpMethod.GET, "/basket/subtract/**").permitAll()
				.antMatchers(HttpMethod.GET, "/basket/item/**").permitAll()
				.antMatchers(PUBLIC_MATCHERS).permitAll()
				.anyRequest().authenticated()
//			.and()
//			.authorizeRequests()
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
					.logoutSuccessUrl("/");
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return service;
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(service).passwordEncoder(encoder);
//	}
}
