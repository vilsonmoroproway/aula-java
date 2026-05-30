package com.aula.seguro.config;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	 private final String SECRET = "12345678901234567890123456789012";

     private SecretKey getKey() {
	    return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
	 }
     
     public String gerarToken(String username) {

         return Jwts.builder()
                 .subject(username)
                 .issuedAt(new Date())
                 .expiration(new Date(System.currentTimeMillis()
                     + 1000 * 60 * 60))
                 .signWith(getKey())
                 .compact();
     }
     
     public String extrairUsuario(String token) {

         return Jwts.parser()
                 .verifyWith(getKey())
                 .build()
                 .parseSignedClaims(token)
                 .getPayload()
                 .getSubject();
     }
     
     public boolean tokenValido(String token) {

         try {
             Jwts.parser()
                     .verifyWith(getKey())
                     .build()
                     .parseSignedClaims(token);

             return true;

         } catch (Exception e) {
             return false;
         }
     }
}
