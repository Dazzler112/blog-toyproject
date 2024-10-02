package com.toyblog.blog_toyproject.dto;

import java.time.*;

public class BoardReply {

	public BoardReply(Integer reply_id, Integer board_id, String comment_body, String member_id, LocalDate comment_date,
			Integer depth, Integer parentID, Boolean editable) {
		super();
		this.reply_id = reply_id;
		this.board_id = board_id;
		this.comment_body = comment_body;
		this.member_id = member_id;
		this.comment_date = comment_date;
		this.depth = depth;
		this.parentID = parentID;
		this.editable = editable;
	}

	private Integer reply_id;
	private Integer board_id;
	private String comment_body;
	private String member_id;
	private LocalDate comment_date;
	private Integer depth;
	private Integer parentID;
	
	private Boolean editable;

	
	public Integer getReply_id() {
		return reply_id;
	}

	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}

	public Integer getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	public String getComment_body() {
		return comment_body;
	}

	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public LocalDate getComment_date() {
		return comment_date;
	}

	public void setComment_date(LocalDate comment_date) {
		this.comment_date = comment_date;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "BoardReply [reply_id=" + reply_id + ", board_id=" + board_id + ", comment_body=" + comment_body
				+ ", member_id=" + member_id + ", comment_date=" + comment_date + ", depth=" + depth + ", parentID="
				+ parentID + ", editable=" + editable + "]";
	}
	
}
