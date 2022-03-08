package com.wm.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.member.model.service.MemberService;


@WebServlet("/member/checkId")
public class MemberCheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberCheckIdServlet() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 브라우저가 보내주는 Id 값을 가져와서 DB에 있는 값인지 확인하고 결과를 페이지에 전달하는 기능
		
		String memberId = request.getParameter("memberId");
		System.out.println("memberId : " + memberId);
		
		boolean valid = new MemberService().validate(memberId);
		
		request.setAttribute("valid", valid);
		
		request.getRequestDispatcher("/views/member/checkId.jsp").forward(request, response);		
	}

}
