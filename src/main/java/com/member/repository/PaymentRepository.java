package com.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.member.entity.Payment;


public interface PaymentRepository extends JpaRepository<Payment,Long>{

}
