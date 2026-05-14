package com.common.events;

public class MemberCreatedEvent {
	private Long memberId;
	private String name;
	private String email;
	private String membershipType;

	public MemberCreatedEvent(Long memberId, String name, String email,String membershipType) {
		this.memberId=memberId;
		this.name=name;
		this.email=email;
		this.membershipType=membershipType;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
}
