package com.wm.mvc.community.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wm.mvc.common.jdbc.JDBCTemplate.close;

import com.wm.mvc.common.util.PageInfo;
import com.wm.mvc.community.model.vo.Community;
import com.wm.mvc.community.model.vo.CommunityReply;

public class CommunityDAO {

	public List<Community> findAll(Connection conn, PageInfo info, int age) {
		List<Community> list = new ArrayList<Community>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * "
				+ "FROM ("
				+ "SELECT ROWNUM AS RNUM, CONTENT_NO, WRITER_NO, TITLE, NICKNAME, BOARD_CONTENT, FILENAME, STATUS, MAKE_DATE, VISIT_COUNT, RENAME_FILENAME, AGE "
				+ "FROM ("
				+ "SELECT  C.CONTENT_NO, C.WRITER_NO, C.TITLE, M.NICKNAME, C.BOARD_CONTENT, C.FILENAME, C.STATUS, C.MAKE_DATE, C.VISIT_COUNT, C.RENAME_FILENAME, C.AGE "
				+ "FROM COMMUNITY_BOARD C JOIN MEMBER M ON(C.WRITER_NO = M.MEMBER_NO) WHERE AGE = ? AND C.STATUS = 'Y' ORDER BY CONTENT_NO DESC"
				+ ")"
				+ ") WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, age);
			pstmt.setInt(2, info.getStartList());
			pstmt.setInt(3, info.getEndList());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Community community = new Community();
				
				community.setContentNo(rs.getInt("CONTENT_NO"));
				community.setWriterNo(rs.getInt("WRITER_NO"));
				community.setRowNum(rs.getInt("RNUM"));
				community.setTitle(rs.getString("TITLE"));
				community.setNickName(rs.getString("NICKNAME"));
				community.setStatus(rs.getString("STATUS"));
				community.setMakeDate(rs.getDate("MAKE_DATE"));
				community.setVisitCount(rs.getInt("VISIT_COUNT"));
				community.setAge(rs.getInt("AGE"));
				
				list.add(community);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	public Community findBoardByNo(Connection conn, int contentNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Community community = null;
		String query = "SELECT C.CONTENT_NO, C.WRITER_NO, C.TITLE, "
				+ 			  "M.NICKNAME, C.BOARD_CONTENT, C.FILENAME, C.RENAME_FILENAME, C.MAKE_DATE, C.VISIT_COUNT, C.AGE "
				+ "FROM COMMUNITY_BOARD C JOIN MEMBER M ON(C.WRITER_NO = M.MEMBER_NO) "
				+ "WHERE CONTENT_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, contentNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				community = new Community();
				
				community.setContentNo(rs.getInt("CONTENT_NO"));
				community.setWriterNo(rs.getInt("WRITER_NO"));
				community.setTitle(rs.getString("TITLE"));
				community.setNickName(rs.getString("NICKNAME"));
				community.setBoardContent(rs.getString("BOARD_CONTENT"));
				community.setFileName(rs.getString("FILENAME"));
				community.setFileName(rs.getString("RENAME_FILENAME"));
				community.setMakeDate(rs.getDate("MAKE_DATE"));
				community.setVisitCount(rs.getInt("VISIT_COUNT"));
				community.setAge(rs.getInt("AGE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return community;
	}

	public int getCommunityCount(Connection conn, int age) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = "SELECT COUNT(*) FROM COMMUNITY_BOARD WHERE STATUS = 'Y' AND AGE = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, age);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	public int insertBoard(Connection conn, Community community) {
		PreparedStatement pstmt = null;
		int result = 0;		
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO COMMUNITY_BOARD VALUES(SEQ_BNO.NEXTVAL,?,?,?,?,DEFAULT,DEFAULT,DEFAULT,?,?,DEFAULT)");
			
			pstmt.setInt(1, community.getWriterNo());
			pstmt.setString(2, community.getTitle());
			pstmt.setString(3, community.getBoardContent());
			pstmt.setString(4, community.getFileName());
			pstmt.setString(5, community.getRenameFileName());
			pstmt.setInt(6, community.getAge());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateBoard(Connection conn, Community community) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE COMMUNITY_BOARD SET TITLE=?,BOARD_CONTENT=? WHERE CONTENT_NO=?");
			
			pstmt.setString(1, community.getTitle());
			pstmt.setString(2, community.getBoardContent());
			pstmt.setInt(3, community.getContentNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}

	public int updateBoardStatus(Connection conn, int contentNo, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE COMMUNITY_BOARD SET STATUS=? WHERE CONTENT_NO=?");
			
			pstmt.setString(1, status);
			pstmt.setInt(2, contentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}

	public int updateReadCount(Connection conn, Community community) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement("UPDATE COMMUNITY_BOARD SET VISIT_COUNT=? WHERE CONTENT_NO=?");
			
			community.setVisitCount(community.getVisitCount() + 1);
			
			pstmt.setInt(1, community.getVisitCount());
			pstmt.setInt(2, community.getContentNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}

	public int insertCommunityReply(Connection conn, CommunityReply reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO REPLY VALUES(SEQ_REPLY_NO.NEXTVAL, ?, ?, ?, DEFAULT, SYSDATE, SYSDATE, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, reply.getBoardNO());
			pstmt.setInt(2, reply.getReplyWriterNo());
			pstmt.setString(3, reply.getReplyContent());
			pstmt.setInt(4, reply.getAge());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<CommunityReply> getReplies(Connection conn, int contentNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CommunityReply> list = new ArrayList();
		String query = 
				  "SELECT REPLY_NO, "
				+ 	   "BOARD_NO, "
				+ 	   "NICKNAME, "
				+ 	   "REPLY_CONTENT, "
				+      "R.REPLY_CREATE_DATE, "
				+      "R.REPLY_MODIFY_DATE, "
				+      "R.STATUS "
				+ "FROM REPLY R "
				+ "JOIN MEMBER M ON(R.REPLY_WRITER_NO = M.MEMBER_NO) "
				+ "WHERE R.STATUS='Y' AND BOARD_NO = ?"
				+ "ORDER BY REPLY_CREATE_DATE DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, contentNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommunityReply reply = new CommunityReply();
				
				reply.setReplyNO(rs.getInt("REPLY_NO"));
				reply.setBoardNO(rs.getInt("BOARD_NO"));
				reply.setUserNickname(rs.getString("NICKNAME"));
				reply.setReplyContent(rs.getString("REPLY_CONTENT"));
				reply.setReplyCreateDate(rs.getDate("REPLY_CREATE_DATE"));
				reply.setReplyModifyDate(rs.getDate("REPLY_MODIFY_DATE"));
				
				list.add(reply);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("list : " + list);
		return list;
	}

	public int reportBoard(Connection conn, int contentNo, String report) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE COMMUNITY_BOARD SET REPORT=? WHERE CONTENT_NO=?");
			
			pstmt.setString(1, report);
			pstmt.setInt(2, contentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReplyStatus(Connection conn, int contentNo, int replyNo, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("UPDATE REPLY SET STATUS=? WHERE BOARD_NO=? AND REPLY_NO=?");
			
			pstmt.setString(1, status);
			pstmt.setInt(2, contentNo);
			pstmt.setInt(3, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}

	


}
