package com.wm.mvc.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.community.model.service.CommunityService;

@WebServlet("/community/delreply")
public class CommunityDeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CommunityDeleteReplyServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int result = new CommunityService().deleteReply(contentNo, replyNo);
		int age = Integer.parseInt(request.getParameter("age"));
		
		if(result > 0) {
			msg = "정상적으로 삭제되었습니다.";
		} else {
			msg = "삭제 실패하였습니다.";			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/community/view?contentNo=" + contentNo + "&&age=" + age);		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
