package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.member.dto.MemberRequest;
import com.member.entity.Member;
import com.member.kafka.MemberEventProducer;
import com.member.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

@Autowired
private MemberService service;

@Autowired
private MemberEventProducer memberEventProducer;

@PostMapping("/addMember")
public ResponseEntity<Member> createMember(@RequestBody MemberRequest request) {
	Member m=service.createMember(request);
	//memberEventProducer.publishMemberCreated(m);
	return ResponseEntity.ok(m);
}

@GetMapping("/getAll")
public ResponseEntity<List<Member>> getAllMember(){
	List<Member> list=service.getAllMembers();
	return ResponseEntity.ok(list);
}

@GetMapping("/{id}")
public ResponseEntity<Member> getById(@PathVariable Long id) {
	Member m=service.getById(id);
	return ResponseEntity.ok(m);
}
}
