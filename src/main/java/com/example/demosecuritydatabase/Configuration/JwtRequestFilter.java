package com.example.demosecuritydatabase.Configuration;

import com.example.demosecuritydatabase.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtRequestFilter extends OncePerRequestFilter {

    final private JwtUtil jwtUtil;

    public JwtRequestFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader("Authorization");

        String jwkToken = null;
        String userName = null;
        if (header != null && header.startsWith("Bearer ")) {
            jwkToken = header.substring(7);

            try{
                userName = jwtUtil.getUsernameFromToken(jwkToken);
            }catch (IllegalAccessError e){
                System.out.println("Unable to get jwt token");
            }catch (ExpiredJwtException e){
                System.out.println("JWT token is expired");
            }
        }else {
            System.out.println("JWT token does not start with Bearer");

        }
    }
}
