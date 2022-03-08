package com.wm.mvc.productBoard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.wm.mvc.productBoard.model.service.ProductBoardService;
import com.wm.mvc.productBoard.model.vo.ProductBoard;



@WebServlet("/product/product_enroll")
public class ProductEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProductEnrollServlet() {
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/product_board/product_enroll.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파일에 대한 전송이 맞는지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			// enctype이  multitpart/form-data가 아닌경우 메세지 전송
			request.setAttribute("msg", "[enctype 에러] 관리자에게 문의하세요");
			request.getRequestDispatcher("/views/common/msg.jsp");
			
			return ;
			
		}
		// 파일 저장할 경로 upload/board
		String path=getServletContext().getRealPath("/upload/board");
		// 파일의 사이즈 지정
		int maxSize = 1024 * 1024 * 10;
		
		// 문자에 대한 인코딩 값 설정
			String encoding = "UTF-8";
		
			// DefaultFileRenamePolicy
			//  - 업로드된 파일에 대한 rename 처리
			//  - 중복되는 이름 뒤에 0 ~ 9999
		MultipartRequest mr =
					new MultipartRequest(request, path, maxSize,encoding,new DefaultFileRenamePolicy());
 
				String name = mr.getParameter("name");
				int price =Integer.parseInt( mr.getParameter("price"));
				String writer = mr.getParameter("writer");
				String tradearea = mr.getParameter("tradearea");
				String textcontent = mr.getParameter("textcontent"); // Null 나옴......
				String state = mr.getParameter("state"); 
				String method= mr.getParameter("method");		
				String url= mr.getParameter("productPictureUrl");		
				System.out.println("name : "+name+ "price "+price+" ,textcontent "+textcontent+" ,state "+state+" , "
						+ "method "+method+"tradearea"+tradearea+"state"+state);
		
				String fileName = mr.getFilesystemName("uploadFile");
				String upfileName = mr.getOriginalFileName("uploadFile");		
				File file = mr.getFile("uploadFile"); 
				System.out.println("fileName   "+fileName+"   ,upfileName  "+upfileName);
				System.out.println(file.getPath()+ " " + file.getName());
				
				ProductBoard product = new ProductBoard();
				product.setProductName(name);
				product.setProductWriter(writer);
				product.setProductPrice(price);
				product.setTradeArea(tradearea);
			
				
				product.setProductText(textcontent);
			
				product.setProductState(state);
				product.setProductMethod(method);
				product.setProductPictureUrl(url);
				
				
				System.out.println("getpn "+product.getProductName());
				
				int result = new ProductBoardService().saveBoard(product);
				String msg= null;
				
				if(result>0) {
					
					msg="게시글 등록 성공";}
					else {
						
						msg="실패";
					}
				request.setAttribute("msg", msg);
				request.setAttribute("location", "/product/list");		
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
								
		
	}


		
	
}

