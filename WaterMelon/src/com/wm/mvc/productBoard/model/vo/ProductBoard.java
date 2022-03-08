package com.wm.mvc.productBoard.model.vo;

import java.sql.Date;

public class ProductBoard{
	private int productNo;
	
	private int rowNum;	
	
	private String productName;	
	
	private String memberId;
	
	private String phone;
	
	private String ProductWriter;
	
	private int productPrice;
	
	private String productMethod ;
	
	private String productState ;
	
	private String productPictureUrl;
	
	private String productText;
	
	private int visitCount;
	
	private Date uploadDate;
	
	private String tradeArea;
	
	private int likeCount;
	
	private String status;
	
	public ProductBoard(){
	
	}

	public ProductBoard(int productNo, int rowNum, String productName, String memberId, String phone,
			String productWriter, int productPrice, String productMethod, String productState, String productPictureUrl,
			String productText, int visitCount, Date uploadDate, String tradeArea, int likeCount, String status) {
		super();
		this.productNo = productNo;
		this.rowNum = rowNum;
		this.productName = productName;
		this.memberId = memberId;
		this.phone = phone;
		ProductWriter = productWriter;
		this.productPrice = productPrice;
		this.productMethod = productMethod;
		this.productState = productState;
		this.productPictureUrl = productPictureUrl;
		this.productText = productText;
		this.visitCount = visitCount;
		this.uploadDate = uploadDate;
		this.tradeArea = tradeArea;
		this.likeCount = likeCount;
		this.status = status;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProductWriter() {
		return ProductWriter;
	}

	public void setProductWriter(String productWriter) {
		ProductWriter = productWriter;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductMethod() {
		return productMethod;
	}

	public void setProductMethod(String productMethod) {
		this.productMethod = productMethod;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getProductPictureUrl() {
		return productPictureUrl;
	}

	public void setProductPictureUrl(String productPictureUrl) {
		this.productPictureUrl = productPictureUrl;
	}

	public String getProductText() {
		return productText;
	}

	public void setProductText(String productText) {
		this.productText = productText;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getTradeArea() {
		return tradeArea;
	}

	public void setTradeArea(String tradeArea) {
		this.tradeArea = tradeArea;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductBoard [productNo=" + productNo + ", rowNum=" + rowNum + ", productName=" + productName
				+ ", memberId=" + memberId + ", phone=" + phone + ", ProductWriter=" + ProductWriter + ", productPrice="
				+ productPrice + ", productMethod=" + productMethod + ", productState=" + productState
				+ ", productPictureUrl=" + productPictureUrl + ", productText=" + productText + ", visitCount="
				+ visitCount + ", uploadDate=" + uploadDate + ", tradeArea=" + tradeArea + ", likeCount=" + likeCount
				+ ", status=" + status + "]";
	}

	
	
	
	
}