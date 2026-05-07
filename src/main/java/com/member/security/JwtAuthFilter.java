package com.member.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.member.util.JwtUtil;

//import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter { //extends OncePerRequestFilter

//@Autowired
//private JwtUtil jwtUtil;	
	/*
	 * @Override protected void doFilterInternal(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain filterChain) throws
	 * ServletException, IOException { String header
	 * =request.getHeader("Authorization"); System.out.println("header   "+header);
	 * if(header != null && header.startsWith("Bearer ")) { String
	 * token=header.substring(7); Claims claims=jwtUtil.extractClaims(token); String
	 * role=claims.get("role",String.class); List<GrantedAuthority>
	 * authorities=List.of(new SimpleGrantedAuthority("ROLE_"+role));
	 * 
	 * UsernamePasswordAuthenticationToken auth=new
	 * UsernamePasswordAuthenticationToken(claims.getSubject(),null,authorities);
	 * SecurityContextHolder.getContext().setAuthentication(auth); }
	 * filterChain.doFilter(request, response);
	 * 
	 * }
	 */
}
