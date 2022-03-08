package com.wm.mvc.community.model.vo;

import java.sql.Date;

public class CommunityReply {
	private int replyNO;
	
	private int boardNO;
	
	private int replyWriterNo;
	
	private String userNickname;
	
	private String replyContent;	
	
	private Date replyCreateDate;
	
	private Date replyModifyDate;

	private int age;

	public CommunityReply() {
	}
	public CommunityReply(int replyNO, int boardNO, int replyWriterNo, String userNickname, String replyContent,
			Date replyCreateDate, Date replyModifyDate, int age) {
		super();
		this.replyNO = replyNO;
		this.boardNO = boardNO;
		this.replyWriterNo = replyWriterNo;
		this.userNickname = userNickname;
		this.replyContent = replyContent;
		this.replyCreateDate = replyCreateDate;
		this.replyModifyDate = replyModifyDate;
		this.age = age;
	}

	public int getReplyNO() {
		return replyNO;
	}

	public void setReplyNO(int replyNO) {
		this.replyNO = replyNO;
	}

	public int getBoardNO() {
		return boardNO;
	}

	public void setBoardNO(int boardNO) {
		this.boardNO = boardNO;
	}

	public int getReplyWriterNo() {
		return replyWriterNo;
	}

	public void setReplyWriterNo(int replyWriterNo) {
		this.replyWriterNo = replyWriterNo;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyCreateDate() {
		return replyCreateDate;
	}

	public void setReplyCreateDate(Date replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}

	public Date getReplyModifyDate() {
		return replyModifyDate;
	}

	public void setReplyModifyDate(Date replyModifyDate) {
		this.replyModifyDate = replyModifyDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "CommunityReply [replyNO=" + replyNO + ", boardNO=" + boardNO + ", replyWriterNo=" + replyWriterNo
				+ ", userNickname=" + userNickname + ", replyContent=" + replyContent + ", replyCreateDate="
				+ replyCreateDate + ", replyModifyDate=" + replyModifyDate + ", age=" + age + "]";
	}
	
	
}
