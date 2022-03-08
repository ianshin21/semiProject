package com.wm.mvc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.member.model.service.MemberService;
import com.wm.mvc.member.model.vo.Member;

@WebServlet(name = "enroll", urlPatterns = "/member/enroll")
public class MemberEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberEnrollServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/member/enroll.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		String msg = "";
		String location = "";
		Member member = new Member();
		
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPwd(request.getParameter("memberPwd"));
		member.setMemberName(request.getParameter("memberName"));
		member.setNickName(request.getParameter("nickName"));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setAddress(request.getParameter("address"));
		
		System.out.println(member);
		
		result = new MemberService().enrollMember(member);
		
		System.out.println("Servlet : " + result);
		
		if (result > 0) {
			msg = "회원가입이 되었습니다.";
			location = "/";
		} else {
			msg = "회원가입을 실패하였습니다.";
			location = "/member/login";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("location", location);

		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
