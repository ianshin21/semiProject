package com.wm.mvc.productBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.productBoard.model.service.ProductBoardService;
import com.wm.mvc.productBoard.model.vo.ProductBoard;


@WebServlet("/product/update")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProductUpdateServlet() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		ProductBoard board= new ProductBoardService().getBoard(productNo, true);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/product/update").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int result = 0;
		String msg = "";
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String name = request.getParameter("name");
		String textcontent = request.getParameter("textcontent");
		int price = Integer.parseInt(request.getParameter("price"));
		String tradearea = request.getParameter("tradearea");
		String state = request.getParameter("state");
		String method = request.getParameter("method");
	
		
		ProductBoard product = new ProductBoard();
		
		product.setProductName(name);
		
		product.setProductPrice(price);
		product.setTradeArea(tradearea);
		
		product.setProductText(textcontent);
		
		product.setProductState(state);
		product.setProductMethod(method);
		
		result = new ProductBoardService().saveBoard(product); 
		
		if(result > 0) {
			msg = "성공적으로 수정되었습니다.";
		} else {
			msg = "게시판 수정에 실패하였습니다.";			
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/product/product_info?productNo=" + productNo );		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);	
		
		
	}

}
