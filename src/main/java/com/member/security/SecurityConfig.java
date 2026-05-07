package com.member.security;

import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	private final String SECRET="MySuperSecretKeyForJwtWhichIsVerySecure12345";
	
	///This filter chain implemented after API GATEWAY
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) {
		http
		  .formLogin(form->form.disable())
		  .httpBasic(basic->basic.disable())
		  .csrf(csrf->csrf.disable())
		  .sessionManagement(session->
		  session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				  )
		  .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
		  .oauth2ResourceServer(oauth->oauth.jwt(jwt->{}));
		  return http.build();
		  
		  
	}
	
	@Bean
	JwtDecoder jwtDecoder() {
		SecretKey key=new SecretKeySpec(SECRET.getBytes(), "HmacSHA256");
		return NimbusJwtDecoder.withSecretKey(key).build();
		
	}
	

	//@Autowired
//private JwtAuthFilter jwtAuthFilter;	

	/*
	 * @Bean SecurityFilterChain filterChain(HttpSecurity http) {
	 * http.csrf(csrf->csrf.disable())
	 * .cors(cors->cors.configurationSource(corsConfigurationSource()))
	 * .authorizeHttpRequests(auth-> auth
	 * .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
	 * .requestMatchers(HttpMethod.POST,"/members/**") .hasRole("ADMIN")
	 * .requestMatchers(HttpMethod.GET,"/members/**") .hasAnyRole("ADMIN","TRAINER")
	 * .anyRequest().authenticated() ) .sessionManagement(sess->
	 * sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	 * .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
	 * 
	 * return http.build(); }
	 */

/*
 * @Bean public CorsConfigurationSource corsConfigurationSource() {
 * CorsConfiguration config=new CorsConfiguration();
 * config.setAllowedOrigins(List.of("http://localhost:4200"));
 * config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
 * config.setAllowedHeaders(List.of("*")); config.setAllowCredentials(true);
 * UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
 * source.registerCorsConfiguration("/**", config); return source;
 * 
 * }
 */
}
