package com.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.member.dto.PaymentRequest;
import com.member.service.PaymentService;



@RestController
@RequestMapping("/payments")
public class PaymentController {

@Autowired
private  PaymentService service;

@PostMapping("/pay")
public ResponseEntity<Map<String,String>> makePayment(@RequestBody PaymentRequest req){
	 System.out.println("🔥 PaymentController HIT");
	 try {
	service.processPayment(req);
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	return ResponseEntity.ok(Map.of("message","Payment successful"));
}

}
