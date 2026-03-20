package com.edutech.progressive.jwt;

<<<<<<< HEAD

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.repository.SupplierRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
=======
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
<<<<<<< HEAD

@Component
public class JwtUtil {

    private SupplierRepository supplierRepository;

    @Autowired
    public JwtUtil(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    private final String secret = "secretKey000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

    private final int expiration = 86400;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration * 1000);
        Supplier user = supplierRepository.findByUsername(username);

        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", username);

        // Assign role based on user type
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims extractAllClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expirationDate.before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
=======
import java.util.function.Function;

@Service
public class JwtUtil {

    @Value("8dEgksfJV0HXt7N-ulhGEGDuzgOLV3CjP-A7qCZbvx48cChTJvnLuub4g_GGXVJzBQn74Hyz2d4zShmf_9_SwQ")
    private String secret;

    // @Value("${app.jwt.expiration-ms}")
    private long expirationMs = 60* 60L;

    public String generateToken(UserDetails userDetails, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret) // jjwt 0.9.1 style
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) {
        Object role = extractAllClaims(token).get("role");
        return role != null ? role.toString() : null;
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username != null && username.equals(userDetails.getUsername()) && !isExpired(token);
    }

    private boolean isExpired(String token) {
        Date exp = extractExpiration(token);
        return exp != null && exp.before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(extractAllClaims(token));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
>>>>>>> b6b56768fe7eb7203f9202acf20e969d40768b6e
    }
}