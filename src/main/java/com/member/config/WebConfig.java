package com.member.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.member.kafka.TrackingInterceptor;

@Configuration
public class WebConfig {
	//implements WebMvcConfigurer
	/*
	 * @Autowired private TrackingInterceptor trackingInterceptor;
	 * 
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * 
	 * registry.addInterceptor(trackingInterceptor) .addPathPatterns("/**"); }
	 */
}
