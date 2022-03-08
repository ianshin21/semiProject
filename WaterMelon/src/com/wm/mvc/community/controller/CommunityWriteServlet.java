package com.wm.mvc.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.wm.mvc.common.util.FileRename;
import com.wm.mvc.community.model.service.CommunityService;
import com.wm.mvc.community.model.vo.Community;
import com.wm.mvc.member.model.vo.Member;

@WebServlet("/community/write")
public class CommunityWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommunityWriteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int age = Integer.parseInt(request.getParameter("age"));
		
		request.setAttribute("age", age);
		request.getRequestDispatcher("/views/community_board/community/community_write.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "관리자에게 문의하세요.");			
			request.setAttribute("location", "/community/list");		
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
			return;			
		}
		
		String msg = null;
		
		int age = Integer.parseInt(request.getParameter("age"));
		
		request.setAttribute("age", age);
		
		// 파일 저장경로
		String path = getServletContext().getRealPath("/views/community_board/upload");
		
		String encoding = "UTF-8";
		// 파일 사이즈
		int maxSize = 1024 * 1024 * 10;
		
		// 파일 rename 처리
		MultipartRequest mr = new MultipartRequest(request, path, maxSize, encoding, new FileRename());
		
		String title = mr.getParameter("title");
		String writer = mr.getParameter("writer");
		String content = mr.getParameter("content");
		
		// 파일 정보 가져오기
		String fileName = mr.getFilesystemName("upfile");
		String upfileName = mr.getOriginalFileName("upfile");
		
		// 로그인 체크
		HttpSession session = request.getSession(false);
		Member loginMember = session != null ? (Member)session.getAttribute("loginMember") : null;
		
//		System.out.println(loginMember);
		
		if(loginMember != null) {
			if(loginMember.getNickName().equals(writer)) {
				Community community = new Community();
				
				community.setTitle(title);
				community.setWriterNo(loginMember.getMemberNo());
				community.setNickName(loginMember.getNickName());
				community.setBoardContent(content);
				community.setFileName(upfileName);
				community.setRenameFileName(fileName);
				community.setAge(age);
				
				int result = new CommunityService().saveBoard(community);
				
				if(result > 0) {
					msg = "게시글 등록 성공";			
					
				} else {
					msg = "게시글 등록 실패";			
				}
			} else {
				msg = "잘못된 접근입니다.";
			}
		} else {
			msg = "로그인 진행 후 작성해주세요. ";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("location", "/community/list?age=" + age);		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
