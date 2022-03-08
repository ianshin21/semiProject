package com.wm.mvc.community.model.service;

import java.sql.Connection;
import java.util.List;

import static com.wm.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.wm.mvc.common.jdbc.JDBCTemplate.close;
import static com.wm.mvc.common.jdbc.JDBCTemplate.commit;
import static com.wm.mvc.common.jdbc.JDBCTemplate.rollback;
import com.wm.mvc.common.util.PageInfo;
import com.wm.mvc.community.model.dao.CommunityDAO;
import com.wm.mvc.community.model.vo.Community;
import com.wm.mvc.community.model.vo.CommunityReply;

public class CommunityService {

	public List<Community> getBoardList(PageInfo info, int age) {
		Connection conn = getConnection();
		
		List<Community> list = new CommunityDAO().findAll(conn, info, age);
		
		close(conn);
		
		return list;
	}

	public Community getBoard(int contentNo, boolean hasRead) {
		int result = 0;
		Connection conn = getConnection();
		Community community = new CommunityDAO().findBoardByNo(conn, contentNo);
		// 게시글 조회수 증가 로직
				if(community != null && !hasRead) {
					result = new CommunityDAO().updateReadCount(conn, community);
					
					if (result > 0) {
						commit(conn);
					} else {
						rollback(conn);
					}
				}		
				
				close(conn);	
				
		return community;
	}

	public int getBoardCount(int age) {
		Connection conn = getConnection();
		
		int result = new CommunityDAO().getCommunityCount(conn, age);
		
		close(conn);
		
		return result;
	}

	public int saveBoard(Community community) {
		int result = 0;
		Connection conn = getConnection();
		
		if(community.getContentNo() != 0) {
			result = new CommunityDAO().updateBoard(conn, community);	
		} else {
			result = new CommunityDAO().insertBoard(conn, community);			
		}
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteBoard(int contentNo) {
		Connection conn = getConnection();
		int result = new CommunityDAO().updateBoardStatus(conn, contentNo, "N");
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;
	}

	public List<CommunityReply> getReplyList(int contentNo) {
		Connection conn = getConnection();
		
		List<CommunityReply> replies = new CommunityDAO().getReplies(conn, contentNo);
		
		close(conn);		
		
		return replies;
	}
	
	public int saveBoardReply(CommunityReply reply) {
		int result = 0;
		Connection conn = getConnection();

		result = new CommunityDAO().insertCommunityReply(conn, reply);			

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;	
	}

	public int reportBoard(int contentNo) {
		Connection conn = getConnection();
		int result = new CommunityDAO().reportBoard(conn, contentNo, "Y");
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;
	}

	public int deleteReply(int contentNo, int replyNo) {
		Connection conn = getConnection();
		int result = new CommunityDAO().updateReplyStatus(conn, contentNo, replyNo, "N");
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);
		
		return result;
	}

}
