package com.toyblog.blog_toyproject.dto;

public class BoardLike {

	public BoardLike(Integer board_id, String member_id) {
		super();
		this.board_id = board_id;
		this.member_id = member_id;
	}
	
	private Integer board_id;
	private String member_id;
	
	
	public Integer getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	@Override
	public String toString() {
		return "BoardLike [board_id=" + board_id + ", member_id=" + member_id + "]";
	}
	
}
