package com.wm.mvc.customerService.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wm.mvc.customerService.model.service.CSBoardService;
import com.wm.mvc.customerService.model.vo.CustomerService;
import com.wm.mvc.member.model.vo.Member;

@WebServlet("/cs/write")
public class CSWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CSWriteServlet() {
    }
    
    // get으료 요청 시 해당하는 글 작성할 수 있는 view로 보내주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/customer_service/cs_write.jsp").forward(request, response);
	}

	// post으료 요청 시 form에 작성한 데이터를 db에 저장해주기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String msg = null;
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		HttpSession session = request.getSession(false);
		Member loginMember = session != null ? (Member)session.getAttribute("loginMember") : null;

		if(loginMember != null) {
			if(loginMember.getMemberId().equals(writer)) {
				CustomerService cs = new CustomerService();
				
				cs.setCsTitle(title);
				cs.setCsWriterNo(loginMember.getMemberNo());
				cs.setCsContent(content);
				
				int result = new CSBoardService().saveBoard(cs);
				
				if(result > 0) {
					msg = "게시글 작성이 성공적으로 완료되었습니다.";
				} else {
					msg = "게시글 작성에 실패하였습니다.";
				}
			} else {
				msg = "잘못된 접근입니다.";
			}
		} else {
			msg =" 로그인 후 작성해주세요.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/cs/list");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
