package com.wm.mvc.member.model.dao;

import static com.wm.mvc.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wm.mvc.common.jdbc.JDBCTemplate;
import com.wm.mvc.member.model.vo.Member;

public class MemberDao {

	public MemberDao() {
	}
	
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO MEMBER VALUES(SEQ_UNO.NEXTVAL, ?, ?, DEFAULT, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, DEFAULT)");
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getNickName());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getAddress());
			
			result = pstmt.executeUpdate();			// return 6
			System.out.println("Dao : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt); 
		}
		return result;
	}

	public Member findMemberByIdAndPwd(Connection conn, String id, String pwd) {
		Member member = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ? AND STATUS = 'Y'");
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println(rset.getString("MEMBER_ID") + ", " + rset.getString("MEMBER_PWD"));
				member = new Member(
						rset.getInt("MEMBER_NO"),
						rset.getString("MEMBER_ID"),
						rset.getString("MEMBER_PWD"),
						rset.getString("MEMBER_ROLE"),
						rset.getString("MEMBER_NAME"),
						rset.getString("NICKNAME"),
						rset.getString("PHONE"),
						rset.getString("EMAIL"),
						rset.getString("ADDRESS"),
						rset.getInt("TRUTH_GRADE"),
						rset.getInt("MEMBER_GRADE"),
						rset.getString("MEMBER_PROFILE"),
						rset.getString("STATUS")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return member;
	}

	public Member findMemberById(Connection conn, String memberId) {
		Member member = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		try {			
				pstmt = conn.prepareStatement("SELECT * FROM MEMBER WHERE MEMBER_ID = ?");
				
				pstmt.setString(1, memberId);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					System.out.println(rset.getString("MEMBER_ID") + ", " + rset.getString("MEMBER_PWD"));
					member = new Member(
							rset.getInt("MEMBER_NO"),
							rset.getString("MEMBER_ID"),
							rset.getString("MEMBER_PWD"),
							rset.getString("MEMBER_ROLE"),
							rset.getString("MEMBER_NAME"),
							rset.getString("NICKNAME"),
							rset.getString("PHONE"),
							rset.getString("EMAIL"),
							rset.getString("ADDRESS"),
							rset.getInt("TRUTH_GRADE"),
							rset.getInt("MEMBER_GRADE"),
							rset.getString("MEMBER_PROFILE"),
							rset.getString("STATUS")	
						);
				}			
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}		

		return member;
	}

	public int updatePassword(Connection conn, String memberId, String memberPwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET MEMBER_PWD=? WHERE MEMBER_ID=?");
			
			pstmt.setString(1, memberPwd);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int updateMemberStatus(Connection conn, String memberId, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET STATUS=? WHERE MEMBER_ID=?");
			
			pstmt.setString(1, status);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println("22222 : " + member);
		try {
			pstmt = conn.prepareStatement("UPDATE MEMBER SET NICKNAME=?, PHONE=?, EMAIL=?, ADDRESS=? WHERE MEMBER_ID=?");
			
			pstmt.setString(1, member.getNickName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}