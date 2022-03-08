package com.wm.mvc.productBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.member.model.service.MemberService;
import com.wm.mvc.member.model.vo.Member;
import com.wm.mvc.productBoard.model.service.ProductBoardService;
import com.wm.mvc.productBoard.model.vo.BoardReply;
import com.wm.mvc.productBoard.model.vo.ProductBoard;


@WebServlet("/product/product_info")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductInfoServlet() {
    
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		ProductBoard product = new ProductBoardService().getBoard(productNo, true);
		List<BoardReply> replies = null; // 여러개의 댓글로 읽어올 수잇어서 list로 받음
		
		//Member member = new MemberService().findMemberByPhone();
		System.out.println("product11111 : "+ product);
		request.setAttribute("product", product);
		//request.setAttribute("member", member);
	//	productno = new ProductBoardService().getBoard(productno, hasRead);
		

		replies = new ProductBoardService().getReplyList(productNo); // 댓글 읽어오기
		
		
		request.setAttribute("replies", replies); //service에서 받아온거 view.jsp에 포워드
		System.out.println("set replies11111 : "+ replies);
		request.getRequestDispatcher("/views/product_board/product_info.jsp").forward(request, response);
	}

}
