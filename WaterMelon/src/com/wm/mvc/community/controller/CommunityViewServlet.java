package com.wm.mvc.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.community.model.service.CommunityService;
import com.wm.mvc.community.model.vo.Community;
import com.wm.mvc.community.model.vo.CommunityReply;

@WebServlet("/community/view")
public class CommunityViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommunityViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contentNo = Integer.parseInt(request.getParameter("contentNo"));
		int age = Integer.parseInt(request.getParameter("age"));
		Community community = null;
		List<CommunityReply> replies = null;
		
		// 새로고침시 조회수가 증가하는 것을 방지하는 로직 
		// 쿠키에 조회한 내용을 기록하여 한 번 조회하면 그 뒤에는 조회수가 올라가지 않게 설정
		// 1. 쿠키에 조회한 이력이 있는 지 확인
		Cookie[] cookies = request.getCookies();
		String boardHistory = ""; //이력 저장
		boolean hasRead = false; //읽은 글 true, 안 읽은 글 false
				
		if(cookies != null) {
			String name = null;
			String value = null;
					
			for(Cookie cookie : cookies) {
				name = cookie.getName();
				value = cookie.getValue();
						
				//boardHistory인 쿠키값을 찾기
				if("boardHistory".equals(name)) {
					boardHistory = value;//현재저장된 값 대입
					if(value.contains("|" + contentNo + "|")) {
						//읽은 게시글
						hasRead = true;
								 
						break;
					}
				}
			}
		}
				
		// 2. 읽지않은 게시글이면 cookie에 기록
		if(!hasRead) {
			Cookie cookie = new Cookie("boardHistory", boardHistory + "|" + contentNo + "|");
			
			cookie.setMaxAge(-1);//브라우저 종료시 삭제
			response.addCookie(cookie);
		}
		community = new CommunityService().getBoard(contentNo, hasRead);
		replies = new CommunityService().getReplyList(contentNo);
		
		request.setAttribute("replies", replies);
		request.setAttribute("age", age);	
		request.setAttribute("community", community);
		request.getRequestDispatcher("/views/community_board/community/community_view.jsp").forward(request, response);
	}

}
