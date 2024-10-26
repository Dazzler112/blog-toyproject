package com.toyblog.blog_toyproject.dto;

public class About {

	public About(Integer about_id, String member_id, String body) {
		super();
		this.about_id = about_id;
		this.member_id = member_id;
		this.body = body;
	}
	
	
	private Integer about_id;
	private String member_id;
	private String body;
	
	
	public Integer getAbout_id() {
		return about_id;
	}
	public void setAbout_id(Integer about_id) {
		this.about_id = about_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "About [about_id=" + about_id + ", member_id=" + member_id + ", body=" + body + "]";
	}
	
}
