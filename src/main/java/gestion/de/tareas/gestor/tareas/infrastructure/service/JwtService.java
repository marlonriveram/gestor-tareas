package gestion.de.tareas.gestor.tareas.infrastructure.service;

import gestion.de.tareas.gestor.tareas.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken (User user){

        Map<String, Object> claims = new HashMap<>();

        //Informacion adicional para el paylod de jwt
        claims.put("userId",user.getId());
        claims.put("role",user.getUserRole().name());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getSignInKey (){
     byte[] keyBytes = Decoders.BASE64.decode(secret); // pasar secret a base 64 y optemos los bytes
     return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername (String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Claims extractAllClaims (String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Long extractUserId(String token) {
        Claims claims = extractAllClaims(token);
        // Obtener el userId del payload del token
        Object userId = claims.get("userId");

        if (userId == null) {
            // validar controllers
            throw new IllegalStateException("Invalid JWT: missing userId");
        }

        return Long.valueOf(userId.toString());
    }


    public String extractRole(String token) {
        Claims claims = extractAllClaims(token);
        Object role = claims.get("role");
        return role != null ? role.toString() : null;
    }

    public boolean isTokenValid(String token) {
        try {
            extractAllClaims(token); // si no lanza excepción es válido
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                // Validar si fecha de expiracion esta antes de la fecha actual
                .getExpiration()
                .before(new Date());
    }
}
