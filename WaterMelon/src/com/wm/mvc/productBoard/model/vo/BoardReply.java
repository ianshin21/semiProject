package com.wm.mvc.productBoard.model.vo;

import java.sql.Date;

public class BoardReply {
	
	private int commentNo;

	private int productNo;

	private int commentWriterNo;

	private String memberId;

	private String content;	
	
	private String status;

	private Date writetime;
	
	public BoardReply() {
		
	}

	public BoardReply(int commentNo, int productNo, int commentWriterNo, String memberId, String content, String status,
			Date writetime) {
		super();
		this.commentNo = commentNo;
		this.productNo = productNo;
		this.commentWriterNo = commentWriterNo;
		this.memberId = memberId;
		this.content = content;
		this.status = status;
		this.writetime = writetime;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getCommentWriterNo() {
		return commentWriterNo;
	}

	public void setCommentWriterNo(int commentWriterNo) {
		this.commentWriterNo = commentWriterNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getWritetime() {
		return writetime;
	}

	public void setWritetime(Date writetime) {
		this.writetime = writetime;
	}

	@Override
	public String toString() {
		return "BoardReply [commentNo=" + commentNo + ", productNo=" + productNo + ", commentWriterNo="
				+ commentWriterNo + ", memberId=" + memberId + ", content=" + content + ", status=" + status
				+ ", writetime=" + writetime + "]";
	}

	
	
	
}
