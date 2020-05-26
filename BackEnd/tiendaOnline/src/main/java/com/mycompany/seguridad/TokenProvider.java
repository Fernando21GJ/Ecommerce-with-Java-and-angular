/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seguridad;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 *
 * @author Enrique
 */
public class TokenProvider {

    final String issuer = "https://www.tiendaonline.com/";
    final String secret = "{{tiendita}}";

    public String issueToken(String userEmail) {
        try {
            String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(issuer)
                    .setSubject(userEmail)
                    .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                    //                    .setExpiration(new Date(System.currentTimeMillis() + 9000000))
                    .signWith(SignatureAlgorithm.HS512, secret).compact();
            return token;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean decode(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject() != "";
        } catch (ExpiredJwtException e) {
            return false;
        }
    }
}
