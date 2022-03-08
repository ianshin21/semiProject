package com.wm.mvc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wm.mvc.member.model.service.MemberService;
import com.wm.mvc.member.model.vo.Member;


@WebServlet(name = "login", urlPatterns = "/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberLoginServlet() {
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		String saveId = request.getParameter("saveId");  // 체크박스에 벨류값을 지정하지 않았을 때 체크시 on, 미체크시 null
		
		Member member = null;
		
		member = new MemberService().login(loginId, loginPwd);

		System.out.println("Servlet : " + member);
		
		// 아이디 저장 로직 구현 -> Cookie  이용		
		if(saveId != null) {
			// 현재 전달된 아이디 쿠키에 저장
			Cookie cookie = new Cookie("saveId", loginId);
			
			// 쿠키 유지 시간 지정 후 response 객체에 추가
			cookie.setMaxAge(60 * 60 * 24 * 3); // 3일 동안 유지 * 시간계산기 사용 			
			response.addCookie(cookie);
		}else {
			// 기존 쿠키값 삭제 
			// 동일한 키값을 가지는 쿠키 객체를 생성 -> 유지시간을 0으로 설정 
			Cookie cookie = new Cookie("saveId", "");
			
			cookie.setMaxAge(0); 		
			response.addCookie(cookie);
		}
		
		if(member != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("loginMember", member);
			System.out.println("Session ID : " + session.getId());
			
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다.");
			request.setAttribute("location", "/");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/common/msg.jsp");	
			dispatcher.forward(request, response);
		}
	}
}
