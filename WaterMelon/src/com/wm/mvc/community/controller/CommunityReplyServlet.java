package com.wm.mvc.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wm.mvc.community.model.service.CommunityService;
import com.wm.mvc.community.model.vo.CommunityReply;
import com.wm.mvc.member.model.vo.Member;

@WebServlet("/community/reply")
public class CommunityReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommunityReplyServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		HttpSession session = request.getSession(false);
		Member loginMember = session != null ? (Member)session.getAttribute("loginMember") : null;
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("replyContent");
		int age = Integer.parseInt(request.getParameter("age"));
		if (loginMember != null) {			
			if(loginMember.getNickName().equals(writer)) {
				CommunityReply reply = new CommunityReply();			
				
				reply.setBoardNO(contentNo);
				reply.setReplyWriterNo(loginMember.getMemberNo());
				reply.setReplyContent(content);
				reply.setAge(age);
				
				int result = new CommunityService().saveBoardReply(reply);
				
				if(result > 0) {
					msg = "댓글 등록 성공";
				} else {
					msg = "댓글 등록 실패";			
				}
			} else {
				msg = "잘못된 접근입니다.";
			}
		} else {
			msg = "로그인 진행 후 작성해주세요. ";
		}
			
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/community/view?contentNo=" + contentNo + "&&age=" + age);		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);	
	}

}
