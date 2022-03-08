package com.wm.mvc.productBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wm.mvc.member.model.vo.Member;
import com.wm.mvc.productBoard.model.service.ProductBoardService;
import com.wm.mvc.productBoard.model.vo.BoardReply;


@WebServlet("/product/reply")
public class ProductBoardReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ProductBoardReplyServlet() {
  
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		HttpSession session = request.getSession(false);
		Member loginMember = session != null ? (Member)session.getAttribute("loginMember") : null;
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		if (loginMember != null) {			
			if(loginMember.getMemberId().equals(writer)) {
				BoardReply reply = new BoardReply();			

				reply.setProductNo(productNo);
				reply.setCommentWriterNo(loginMember.getMemberNo());
				reply.setContent(content);

				int result = new ProductBoardService().saveBoardReply(reply);

				if(result > 0) {
					msg = "댓글 등록 성공";			

				} else {
					msg = "댓글 등록 실패";			
				}
			} else {
				msg = "잘못된 접근입니다.";
			}
		} else {
			msg = "로그인 진행 후 작성해주세요. ";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("location", "/product/product_info?productNo=" + productNo);		
//		request.setAttribute("location", "/product_board/product_info?productNo=" + productNo);		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);		
//		request.getRequestDispatcher("/product/list").forward(request, response);		
	}

}
