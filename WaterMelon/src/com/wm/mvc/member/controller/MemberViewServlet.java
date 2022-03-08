package com.wm.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.member.model.service.MemberService;
import com.wm.mvc.member.model.vo.Member;


@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberViewServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		
		Member member = new MemberService().findMemberById(memberId);
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("/views/member/userinfo.jsp").forward(request, response);
	}

}
