package com.toyblog.blog_toyproject.dto;

public class MemberAuthority {

	public MemberAuthority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberAuthority(String member_id) {
		super();
		this.member_id = member_id;
	}

	private String member_id;

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "MemberAuthority [member_id=" + member_id + "]";
	}
	
}
