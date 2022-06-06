package com.zensar.messageapi.security.jwt.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
@Component
public class JWTUtil {
		// This method is used to generate token for username
		// To generate token we will be using library java-jwt
		public String generateToken(String username) {
			String jwtToken = JWT.create()
											// payload consist of username
											.withClaim("name", username)
											//payload consist of expiaration time
											.withExpiresAt(new Date(System.currentTimeMillis()+60000))
											.sign(Algorithm.HMAC512("zensarsecret"));//Header + signature
		
			return jwtToken; 
			
		}
		public void validateToken(String token) {
			JWT.require(Algorithm.HMAC512("zensarsecret")).build().verify(token);
		}
}
