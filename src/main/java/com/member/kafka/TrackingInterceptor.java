package com.member.kafka;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.common.events.ApiTrackingEvent;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TrackingInterceptor{
	 //implements HandlerInterceptor
		/*
		 * @Autowired private KafkaTemplate<String, Object> kafkaTemplate; private
		 * static final Logger
		 * logger=LoggerFactory.getLogger(TrackingInterceptor.class);
		 * 
		 * @Override public boolean preHandle(HttpServletRequest request,
		 * HttpServletResponse response, Object handler) throws Exception {
		 * logger.info("Tracking API: {}", request.getRequestURI());
		 * System.out.println(request.getRequestURI()); ApiTrackingEvent event = new
		 * ApiTrackingEvent(); event.setServiceName(request.getMethod());
		 * event.setUsername(null); event.setEndpoint(request.getRequestURI());
		 * event.setMethod(request.getMethod());
		 * event.setTimestamp(LocalDateTime.now().toString());
		 * 
		 * try { kafkaTemplate.send("api-tracking", event); } catch (Exception e) {
		 * logger.error("Kafka error", e); }
		 * 
		 * return true; }
		 */
}
