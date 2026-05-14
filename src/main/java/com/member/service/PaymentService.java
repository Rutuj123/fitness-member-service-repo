package com.member.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.member.dto.PaymentRequest;
import com.member.entity.Payment;
import com.member.repository.PaymentRepository;


@Service
public class PaymentService {

@Autowired
private PaymentRepository repo;	

public void processPayment(PaymentRequest request) {
	Payment payment = new Payment();
    payment.setMemberId(request.getMemberId());
    payment.setAmount(request.getAmount());
    payment.setPaymentMethod(request.getPaymentMethod());
    payment.setPaymentDate(LocalDateTime.now());

    repo.save(payment);
    
 // Activate membership
  //  memberClient.activateMember(request.getMemberId());
}
	
}
