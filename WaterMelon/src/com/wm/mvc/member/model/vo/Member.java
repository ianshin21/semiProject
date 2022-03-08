package com.wm.mvc.member.model.vo;

public class Member {

	private int memberNo;			// 회원번호
	private String memberId;		// 회원아이디
	private String memberPwd;		// 회원비밀번호
	private String memberRole;		// 회원타입
	private String memberName;		// 회원이름
	private String nickName;		// 회원닉네임
	private String phone;			// 전화번호
	private String email;			// 이메일
	private String address;			// 주소
	private int trustGrade; 		// 회원신뢰도
	private int memberGrade; 	// 회원등급
	private String memberProfile;	// ex) 이달의 판매왕?
	private String status;
	
	public Member() {
	}

	public Member(int memberNo, String memberId, String memberPwd, String memberRole, String memberName,
			String nickName, String phone, String email, String address, int trustGrade, int memberGrade,
			String memberProfile, String status) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberRole = memberRole;
		this.memberName = memberName;
		this.nickName = nickName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.trustGrade = trustGrade;
		this.memberGrade = memberGrade;
		this.memberProfile = memberProfile;
		this.status = status;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTrustGrade() {
		return trustGrade;
	}

	public void setTrustGrade(int trustGrade) {
		this.trustGrade = trustGrade;
	}

	public int getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(int memberGrade) {
		this.memberGrade = memberGrade;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberRole="
				+ memberRole + ", memberName=" + memberName + ", nickName=" + nickName + ", phone=" + phone + ", email="
				+ email + ", address=" + address + ", trustGrade=" + trustGrade + ", memberGrade=" + memberGrade
				+ ", memberProfile=" + memberProfile + ", status=" + status + "]";
	}

}
