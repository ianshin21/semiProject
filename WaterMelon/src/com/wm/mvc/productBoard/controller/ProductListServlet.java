package com.wm.mvc.productBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.common.util.PageInfo;
import com.wm.mvc.productBoard.model.service.ProductBoardService;
import com.wm.mvc.productBoard.model.vo.ProductBoard;

@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<ProductBoard> plist = new ProductBoardService().getBoardList();
		
		int page = 0;
		int listCount = 0;
		PageInfo info = null;
		List<ProductBoard> list = null;

		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(NumberFormatException e) {
			page = 1;
		}		

		listCount = new ProductBoardService().getBoardCount();
		info = new PageInfo(page, 5, listCount, 3);		
		list = new ProductBoardService().getBoardList(info);

		request.setAttribute("list", list); 
		
		
		//request.setAttribute("plist", plist);
		request.setAttribute("pageInfo", info); // list.jsp에 info도 넘겨줘야
		request.getRequestDispatcher("/views/product_board/product_list.jsp").forward(request, response);
	}

}
