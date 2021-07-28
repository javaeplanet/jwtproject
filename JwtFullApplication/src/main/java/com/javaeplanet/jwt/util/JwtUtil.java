package com.javaeplanet.jwt.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${app.secret}")
	private String secret;

	public boolean ValidateToken(String token, String username) {
		String tokenUsername = getUsername(token);
		return (username.equals(tokenUsername) && !isTokenExp(token));
	}

	public boolean isTokenExp(String token) {
		Date expDate = expDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}

	public Date expDate(String token) {
		return getClaims(token).getExpiration();
	}

	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}

	public String generateToken(String subject) {
		return Jwts.builder().setSubject(subject).setIssuer("ByJavaeplanet")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS256, secret.getBytes()).compact();
	}
}
