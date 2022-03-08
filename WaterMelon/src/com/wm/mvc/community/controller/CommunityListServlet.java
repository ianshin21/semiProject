package com.wm.mvc.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wm.mvc.common.util.PageInfo;
import com.wm.mvc.community.model.service.CommunityService;
import com.wm.mvc.community.model.vo.Community;

@WebServlet("/community/list")
public class CommunityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommunityListServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 페이징처리
		int age = 0;
		int page = 0;
		int listCount = 0;
		PageInfo info = null;
		List<Community> list = null;
		
		try {
			age = Integer.parseInt(request.getParameter("age"));
			} catch (NumberFormatException e) {
				age = 0;
			}
		
		try {
		page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
		
		listCount = new CommunityService().getBoardCount(age);
		info = new PageInfo(page, 10, listCount, 10);
		
		list = new CommunityService().getBoardList(info, age);
		request.setAttribute("age", age);
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", info);
		request.getRequestDispatcher("/views/community_board/community/community_list.jsp").forward(request, response);
	}

}
