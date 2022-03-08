package com.wm.mvc.productBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wm.mvc.productBoard.model.service.ProductBoardService;

import com.wm.mvc.member.model.vo.Member;

@WebServlet("/product/delete")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ProductDeleteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String memberId = request.getParameter("MEMBER_ID");
		

		
				int result = new ProductBoardService().deleteProduct(productNo);
				System.out.println("RESULT +" + result);
				
				
				if(result > 0) {
					msg = "정상적으로 삭제되었습니다.";
				} else {
					msg = "삭제에 실패하였습니다.";
				}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/product/list");
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
}
