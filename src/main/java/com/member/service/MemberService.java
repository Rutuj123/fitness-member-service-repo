package com.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.member.dto.MemberRequest;
import com.member.entity.Member;
import com.member.repository.MemberRepository;

@Service
public class MemberService {

@Autowired	
private MemberRepository memberRepository;	

public Member createMember(MemberRequest request) {
	Member m=new Member();
	m.setName(request.name);
    m.setEmail(request.email);
    m.setPhone(request.phone);
    m.setMembershipType(request.membershipType);
    return memberRepository.save(m);
}

public List<Member> getAllMembers(){
	return memberRepository.findAll();
}

public Member getById(Long id) {
	return memberRepository.findById(id).orElseThrow(()->new RuntimeException("Member not found"));
			               
}
} 
