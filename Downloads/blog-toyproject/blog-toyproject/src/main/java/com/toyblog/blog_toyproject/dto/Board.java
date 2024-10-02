package com.toyblog.blog_toyproject.dto;

import java.time.*;
import java.util.*;

public class Board {

	public Board(Integer board_id, String title, String body, String writer, LocalDate write_date,
			List<String> photoName, Boolean liked, Integer like_count, Integer file_count, Integer reply_count) {
		super();
		this.board_id = board_id;
		this.title = title;
		this.body = body;
		this.writer = writer;
		this.write_date = write_date;
		this.photoName = photoName;
		this.liked = liked;
		this.like_count = like_count;
		this.file_count = file_count;
		this.reply_count = reply_count;
	}
	
	//
	
	private Integer board_id;
	private String title;
	private String body;
	private String writer; 
	private LocalDate write_date;
	
//	private String category; <=보류
	
	private List<String> photoName;
	
	private Boolean liked;
	private Integer like_count;
	
	private Integer file_count;
	private Integer reply_count;
	
	//
	
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDate getWrite_date() {
		return write_date;
	}
	public void setWrite_date(LocalDate write_date) {
		this.write_date = write_date;
	}
	public List<String> getPhotoName() {
		return photoName;
	}
	public void setPhotoName(List<String> photoName) {
		this.photoName = photoName;
	}
	public Boolean getLiked() {
		return liked;
	}
	public void setLiked(Boolean liked) {
		this.liked = liked;
	}
	public Integer getLike_count() {
		return like_count;
	}
	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}
	public Integer getFile_count() {
		return file_count;
	}
	public void setFile_count(Integer file_count) {
		this.file_count = file_count;
	}
	public Integer getReply_count() {
		return reply_count;
	}
	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}
	
	//
	
	@Override
	public String toString() {
		return "Board [board_id=" + board_id + ", title=" + title + ", body=" + body + ", writer=" + writer
				+ ", write_date=" + write_date + ", photoName=" + photoName + ", liked=" + liked + ", like_count="
				+ like_count + ", file_count=" + file_count + ", reply_count=" + reply_count + "]";
	}
	
}
