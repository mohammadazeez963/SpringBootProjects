package com.zensar.messageapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.zensar.messageapi.security.service.impl.ZensarUserServiceImpl;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	ZensarUserServiceImpl userDetailsService;
	@Bean // This will declare the return Object as Spring bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/* auth
				.inMemoryAuthentication()
				.withUser("azeez")
				.password("$2a$10$rQFxAPEWr9mJ9vyman.rreaIsJ5e18nvGshYPAWZLq1PpZ80E0DRm") //password is in the plain text, spring security did't support this, we have to encode the password
				.roles("USER")// though  we are writing as USER, it is considered as ROLE_USER(ROLE_ added automatically)
				.and()
				.withUser("admin")
				.password("$2a$10$rQFxAPEWr9mJ9vyman.rreaIsJ5e18nvGshYPAWZLq1PpZ80E0DRm")
				.roles("ADMIN");
				*/
		auth
		         .userDetailsService(userDetailsService)
				.passwordEncoder(getBCryptPasswordEncoder());
				
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
