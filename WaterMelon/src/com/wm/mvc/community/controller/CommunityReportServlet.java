package com.wm.mvc.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.community.model.service.CommunityService;

@WebServlet("/community/report")
public class CommunityReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CommunityReportServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		int result = new CommunityService().reportBoard(contentNo);
		int age = Integer.parseInt(request.getParameter("age"));
		
		if(result > 0) {
			msg = "정상적으로 신고되었습니다.";
		} else {
			msg = "신고에 실패하였습니다.";			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/community/list?age=" + age);		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
