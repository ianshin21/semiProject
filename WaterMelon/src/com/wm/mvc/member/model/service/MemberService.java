package com.wm.mvc.member.model.service;

import static com.wm.mvc.common.jdbc.JDBCTemplate.close;
import static com.wm.mvc.common.jdbc.JDBCTemplate.commit;
import static com.wm.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.wm.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import com.wm.mvc.member.model.dao.MemberDao;
import com.wm.mvc.member.model.vo.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();

	public int enrollMember(Member member) {
		Connection conn = getConnection();
		
		int result = dao.insertMember(conn, member);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public Member login(String id, String pwd) {
		Connection conn = getConnection();
		
		Member member = dao.findMemberByIdAndPwd(conn, id, pwd);

		System.out.println("Service : " + member);
		
		close(conn);
				
		return member;
			
	}

	public Member findMemberById(String memberId) {
		Connection conn = getConnection();

		Member member = dao.findMemberById(conn, memberId);
		
		System.out.println("Service : " + member);
		
		close(conn);

		return member;
	}
	
	public boolean validate(String memberId) {
		Connection conn = getConnection();

		Member member = dao.findMemberById(conn, memberId);
		
		close(conn);
		
		return member != null;
	}


	public int updatePassword(String memberId, String memberPwd) {
		Connection conn = getConnection();
		
		int result = dao.updatePassword(conn, memberId, memberPwd);
		

		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	public int deleteMember(String memberId) {

		Connection conn = getConnection();
		int result = dao.updateMemberStatus(conn, memberId, "N");
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);

		
		return result;
	}

	public int updateMember(Member member) {

		Connection conn = getConnection();

		int result = dao.updateMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}


}
