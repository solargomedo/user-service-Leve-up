package com.ecomarket.user_service.util;

import com.ecomarket.user_service.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {

    // Clave secreta segura (mínimo 256 bits para HS256)
    private static final String SECRET = "mi_secreto_super_seguro_muy_largo_para_hmac_sha256";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    // Generar token
    public static String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getCorreo())
                .claim("id", usuario.getId())
                .claim("roles", usuario.getRoles())
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // Validar token
    public static Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
