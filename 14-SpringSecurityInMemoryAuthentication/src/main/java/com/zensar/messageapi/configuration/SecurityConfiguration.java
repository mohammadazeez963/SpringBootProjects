package com.zensar.messageapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean // This will declare the return Object as Spring bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
				.inMemoryAuthentication()
				.withUser("azeez")
				.password("$2a$10$rQFxAPEWr9mJ9vyman.rreaIsJ5e18nvGshYPAWZLq1PpZ80E0DRm") //password is in the plain text, spring security did't support this, we have to encode the password
				.roles("USER")// though  we are writing as USER, it is considered as ROLE_USER(ROLE_ added automatically)
				.and()
				.withUser("admin")
				.password("$2a$10$rQFxAPEWr9mJ9vyman.rreaIsJ5e18nvGshYPAWZLq1PpZ80E0DRm")
				.roles("ADMIN");
				
	}
	
	// Authorization  :- Specifying  access rights to a resource
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		       .csrf().disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/api/message").hasRole("ADMIN") // we are only allowing admin to 
				
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				
		
	}
}
