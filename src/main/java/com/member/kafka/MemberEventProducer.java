package com.member.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.member.entity.Member;

@Service
public class MemberEventProducer {
	private static final String TOPIC = "member.created";
	@Autowired
	private final KafkaTemplate<String, MemberCreatedEvent> kafkaTemplate;
	public MemberEventProducer(KafkaTemplate<String,MemberCreatedEvent> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void publishMemberCreated(Member member) {
		MemberCreatedEvent event=new MemberCreatedEvent(member.getId(), member.getName(), member.getEmail(), member.getMembershipType());
		kafkaTemplate.send(TOPIC,member.getId().toString(),event); 
	}
}
