package com.wm.mvc.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.community.model.service.CommunityService;
import com.wm.mvc.community.model.vo.Community;

@WebServlet("/community/update")
public class CommunityUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommunityUpdateServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		int age = Integer.parseInt(request.getParameter("age"));
		Community community = new CommunityService().getBoard(contentNo,true);
		
		request.setAttribute("age", age);
		request.setAttribute("community", community);				
		request.getRequestDispatcher("/views/community_board/community/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		String msg = "";
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String lotation = null;
		int age = 0;

		try {
			age = Integer.parseInt(request.getParameter("age"));
			} catch (NumberFormatException e) {
				age = 0;
			}
		
		Community community = new Community();
		
		community.setContentNo(contentNo);
		community.setBoardContent(content);
		community.setTitle(title);
		community.setAge(age);
		
		result = new CommunityService().saveBoard(community);
		
		if(result > 0) {
			msg = "성공적으로 수정되었습니다.";
		} else {
			msg = "게시판 수정에 실패하였습니다.";			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/community/view?contentNo=" + contentNo + "&&age=" + age);		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);	
	}

}
