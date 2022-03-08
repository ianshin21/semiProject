package com.wm.mvc.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/main")
public class CommunityMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommunityMainServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/community_board/community/community_main.jsp").forward(request, response);
	}

}
