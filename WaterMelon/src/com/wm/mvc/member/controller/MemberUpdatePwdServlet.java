package com.wm.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.member.model.service.MemberService;


@WebServlet("/member/updatePwd")
public class MemberUpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberUpdatePwdServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/member/updatePwd.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String msg = "";
		String loc = "/";
		String script = null;
		
		System.out.println("memberId : " + memberId + ", memberPwd : " + memberPwd );
		
		int result = new MemberService().updatePassword(memberId, memberPwd);
		
		if(result > 0) {
			msg = "비밀번호가 정상적으로 변경되었습니다.";
			script = "self.close()";
		}else { 
			msg = "비밀번호 변경이 실패했습니다.";
			loc = "/member/updatePwd?memberId=" + memberId;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("script", script);
		request.setAttribute("location", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	
	}

}
