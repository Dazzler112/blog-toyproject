package com.toyblog.blog_toyproject.dto;

import java.time.*;

public class About {

	public About(Integer about_id, String title, String member_id, String writer, String body, LocalDate about_date) {
		super();
		this.about_id = about_id;
		this.title = title;
		this.member_id = member_id;
		this.writer = writer;
		this.body = body;
		this.about_date = about_date;
	}
	
	private Integer about_id;
	private String title;
	private String member_id;
	private String writer;
	private String body;
	private LocalDate about_date;
	
	public Integer getAbout_id() {
		return about_id;
	}
	public void setAbout_id(Integer about_id) {
		this.about_id = about_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public LocalDate getAbout_date() {
		return about_date;
	}
	public void setAbout_date(LocalDate about_date) {
		this.about_date = about_date;
	}
	
	@Override
	public String toString() {
		return "About [about_id=" + about_id + ", title=" + title + ", member_id=" + member_id + ", writer=" + writer
				+ ", body=" + body + ", about_date=" + about_date + "]";
	}	
	
}
