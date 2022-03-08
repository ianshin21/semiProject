package com.wm.mvc.community.model.vo;

import java.util.Date;

public class Community {
	private int contentNo;
	
	private int rowNum;
	
	private int writerNo;
	
	private String nickName;
	
	private String title;
	
	private String boardContent;
	
	private String fileName;
	
	private String renameFileName;
	
	private Date makeDate;
	
	private int visitCount;
	
	private String status;
	
	private int age;

	public Community() {
	}
	
	public Community(int contentNo, int rowNum, int writerNo, String nickName, String title, String boardContent,
			String fileName, String renameFileName, Date makeDate, int visitCount, String status, int age) {
		super();
		this.contentNo = contentNo;
		this.rowNum = rowNum;
		this.writerNo = writerNo;
		this.nickName = nickName;
		this.title = title;
		this.boardContent = boardContent;
		this.fileName = fileName;
		this.renameFileName = renameFileName;
		this.makeDate = makeDate;
		this.visitCount = visitCount;
		this.status = status;
		this.age = age;
	}
	
	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRenameFileName() {
		return renameFileName;
	}

	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}

	public Date getMakeDate() {
		return makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Community [contentNo=" + contentNo + ", rowNum=" + rowNum + ", writerNo=" + writerNo + ", nickName="
				+ nickName + ", title=" + title + ", boardContent=" + boardContent + ", fileName=" + fileName
				+ ", renameFileName=" + renameFileName + ", makeDate=" + makeDate + ", visitCount=" + visitCount
				+ ", status=" + status + ", age=" + age + "]";
	}
	
}