package com.wm.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.member.model.service.MemberService;


@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberDeleteServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		
		int result = new MemberService().deleteMember(memberId);
		
		String msg = "";
		String loc = "";
		
		// 회원이 삭제되었다면 로그아웃 서블릿을 호출하도록 만들어준다.
		if(result > 0) {
			msg = "정상적으로 탈퇴되었습니다";
			loc = "/logout";
		}else {
			msg = "탈퇴 실패하였습니다.";
			loc = "/member/view?memberId=" + memberId;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
