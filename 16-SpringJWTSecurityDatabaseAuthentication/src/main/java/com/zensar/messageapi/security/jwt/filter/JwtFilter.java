package com.zensar.messageapi.security.jwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.zensar.messageapi.security.jwt.util.JWTUtil;

public class JwtFilter extends BasicAuthenticationFilter {

	// This class is used to fetch token  and check if it is valid
	public JwtFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//Bearer Token
		//  1. Fetch the token from user request
		
		String authorizationHeaderValue = request.getHeader("Authorization");
		if(authorizationHeaderValue != null) {
		String token = authorizationHeaderValue.substring(7);
		
		// 2. Validate the token
		
		JWTUtil util = new JWTUtil();
		try {
			util.validateToken(token);
			// if it is valid allow user to access resource
			UsernamePasswordAuthenticationToken authenticationToken;
				authenticationToken = new UsernamePasswordAuthenticationToken("azeez",null,AuthorityUtils.createAuthorityList("ROLE_USER"));
				
				// Following line authenticates user
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
						
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
		// Calling Do filter method is must so that next filter in chain will execute
		chain.doFilter(request, response);
	}

	
}
