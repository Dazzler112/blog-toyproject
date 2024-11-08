package com.toyblog.blog_toyproject.dto;

public class Members {
		

	public Members() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Members(String member_id, String password, String name, String phone_number, String email,
			String member_type, String authority) {
		super();
		this.member_id = member_id;
		this.password = password;
		this.name = name;
		this.phone_number = phone_number;
		this.email = email;
		this.member_type = member_type;
		this.authority = authority;
	}
	
	private String member_id;
	private String password;
	private String name;
	private String phone_number;
	private String email;
	private String member_type;
	private String authority;
	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "Members [member_id=" + member_id + ", password=" + password + ", name=" + name + ", phone_number="
				+ phone_number + ", email=" + email + ", member_type=" + member_type + ", authority=" + authority + "]";
	}
	
	
}
