package com.toyblog.blog_toyproject.dto;

import java.util.*;

public class AboutImg {

	public AboutImg() {
		super();
	}
	
	public AboutImg(Integer aphoto_id, String member_id, List<String> photo_name, Integer file_count) {
		super();
		this.aphoto_id = aphoto_id;
		this.member_id = member_id;
		this.photo_name = photo_name;
		this.file_count = file_count;
	}
	
	private Integer aphoto_id;
	private String member_id;
	
	private List<String> photo_name;
	private Integer file_count;
	
	public Integer getAphoto_id() {
		return aphoto_id;
	}
	public void setAphoto_id(Integer aphoto_id) {
		this.aphoto_id = aphoto_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public List<String> getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(List<String> photo_name) {
		this.photo_name = photo_name;
	}
	public Integer getFile_count() {
		return file_count;
	}
	public void setFile_count(Integer file_count) {
		this.file_count = file_count;
	}
	
}
