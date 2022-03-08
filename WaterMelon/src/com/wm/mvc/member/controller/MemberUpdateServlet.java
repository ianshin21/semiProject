package com.wm.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.member.model.service.MemberService;
import com.wm.mvc.member.model.vo.Member;


@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberUpdateServlet() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		int result = 0;
		Member member = new Member();
		
		member.setMemberId(request.getParameter("memberId"));
		member.setNickName(request.getParameter("nickName"));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));
		member.setAddress(request.getParameter("address"));
		
		System.out.println(member);
		
		result = new MemberService().updateMember(member);
		
		if(result > 0) {
			msg = "성공적으로 수정되었습니다.";
		}else { 
			msg = "회원정보 수정에 실패했습니다";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	
	}

}
