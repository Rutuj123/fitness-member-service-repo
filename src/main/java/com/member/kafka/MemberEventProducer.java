package com.member.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.common.events.MemberCreatedEvent;
import com.member.entity.Member;

@Service
public class MemberEventProducer {
	/*
	 * private static final Logger
	 * LOGGER=LoggerFactory.getLogger(MemberEventProducer.class); private static
	 * final String TOPIC = "member.created";
	 * 
	 * @Autowired private final KafkaTemplate<String, MemberCreatedEvent>
	 * kafkaTemplate; public
	 * MemberEventProducer(KafkaTemplate<String,MemberCreatedEvent> kafkaTemplate) {
	 * this.kafkaTemplate=kafkaTemplate; }
	 * 
	 * public void publishMemberCreated(Member member) {
	 * LOGGER.info(String.format("Message sent -> %s", member.toString()));
	 * MemberCreatedEvent event=new MemberCreatedEvent(member.getId(),
	 * member.getName(), member.getEmail(), member.getMembershipType());
	 * kafkaTemplate.send(TOPIC,member.getId().toString(),event); }
	 */
}
