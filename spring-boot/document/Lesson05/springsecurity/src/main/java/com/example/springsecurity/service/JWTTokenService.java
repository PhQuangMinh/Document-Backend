package com.example.springsecurity.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;


public interface JWTTokenService {
    String generateToken(UserDetails userDetails);

    String extractUsername(String token);

    Boolean validateToken(String token, UserDetails userDetails);

    Boolean isTokenExpired(String token);
}
