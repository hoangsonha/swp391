package com.group6.swp391.jwt;

import com.group6.swp391.security.CustomUserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
public class JWTToken {

    private SecretKey SCRET_KEY;
    private int JWT_EXPIRATION = 864000000;  // 10 ngay

    public JWTToken() {
        String sceretString = "753474857438754387594385743975348574893759843753498776576576575765634545435365346534645645364565465347657547465";
        byte[] keyBytes = Base64.getDecoder().decode(sceretString.getBytes(StandardCharsets.UTF_8));
        this.SCRET_KEY = new SecretKeySpec(keyBytes,"HmacSHA256" );
    }

    public String generatedToken(CustomUserDetail customUserDetail) {
        Date date = new Date(System.currentTimeMillis());

        Date exp = new Date(System.currentTimeMillis() + JWT_EXPIRATION);

        return Jwts.builder()
                .subject(customUserDetail.getUsername())
                .issuedAt(date)
                .expiration(exp)
                .claim("firstName", customUserDetail.getFirstName())
                .claim("lastName", customUserDetail.getLastName())
                .signWith(SCRET_KEY)
                .compact();
    }

    public String getNameFromJwt(String token) {
        return getClaims(token, Claims::getSubject);
    }

    private <T> T getClaims(String token, Function<Claims, T> claimsTFunction) {
        return claimsTFunction.apply(
                Jwts.parser().verifyWith(SCRET_KEY).build().parseSignedClaims(token).getPayload());
    }
    public boolean validate(String token) {
        if(getNameFromJwt(token) != null && !isExpired(token)) {
            return true;
        }
        return false;
    }

    public boolean isExpired(String token) {
        return getClaims(token, Claims::getExpiration).before(new Date(System.currentTimeMillis()));
    }


}