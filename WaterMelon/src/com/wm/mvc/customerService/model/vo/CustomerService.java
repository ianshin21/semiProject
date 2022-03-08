package com.wm.mvc.customerService.model.vo;

import java.sql.Date;

public class CustomerService {
	private int csNo; 			// 게시글 번호
	private int rowNum;
	private int csWriterNo;		// 작성자
	private String memberId;
	private String csTitle;		// 제목
	private String csContent;	// 내용
	private int csCount;		// 조회수
	private Date csDate;		// 작성일
	
	public CustomerService() {
	}
	

	public CustomerService(int csNo, int rowNum, int csWriterNo, String memberId, String csTitle, String csContent,
			int csCount, Date csDate) {
		this.csNo = csNo;
		this.rowNum = rowNum;
		this.csWriterNo = csWriterNo;
		this.memberId = memberId;
		this.csTitle = csTitle;
		this.csContent = csContent;
		this.csCount = csCount;
		this.csDate = csDate;
	}


	public int getCsNo() {
		return csNo;
	}


	public void setCsNo(int csNo) {
		this.csNo = csNo;
	}


	public int getRowNum() {
		return rowNum;
	}


	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}


	public int getCsWriterNo() {
		return csWriterNo;
	}


	public void setCsWriterNo(int csWriterNo) {
		this.csWriterNo = csWriterNo;
	}

	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getCsTitle() {
		return csTitle;
	}


	public void setCsTitle(String csTitle) {
		this.csTitle = csTitle;
	}


	public String getCsContent() {
		return csContent;
	}


	public void setCsContent(String csContent) {
		this.csContent = csContent;
	}


	public int getCsCount() {
		return csCount;
	}


	public void setCsCount(int csCount) {
		this.csCount = csCount;
	}


	public Date getCsDate() {
		return csDate;
	}


	public void setCsDate(Date csDate) {
		this.csDate = csDate;
	}

}