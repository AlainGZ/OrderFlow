package com.orderflow.orderflow_user_service.application.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.security.Key;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration-ms}")
	private long expirationMs;

	private Key getKey(){
		return Keys.hmacShaKeyFor(secret.getBytes());
	}

	public String generateToken(String subject, String email){
		return Jwts.builder()
				.setSubject(subject)
				.claim("email", email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expirationMs))
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();
	}
}
