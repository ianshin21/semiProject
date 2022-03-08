package com.wm.mvc.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wm.mvc.member.model.vo.Member;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	public AdminFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 관리자 페이지 권한처리
		// - 관리자가 아닌 경우에는 페이지를 못보게 처리하기
		// - 일반적인 형태로 못가져오므로 형변환
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		Member loginMember = (Member) (session.getAttribute("loginMember"));

//		// 로그인 되어있고 관리자계정이면 통과!
//		if (loginMember == null || !loginMember.getMemberRole.equals("ROLE_ADMIN")) {
//			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
//			request.setAttribute("location", "/");
//			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
//
//			// 개발자가 직접 에러로 보낼 수도 있어요^^
//			// sendError : 잘못된 요청을 했을 경우 아래와 같은 방법으로 에러코드 작성 가능
//			// ((HttpServletResponse)response).sendError(HttpServletResponse.SC_BAD_REQUEST);
//
//			// 다음 필터로 넘어갈 필요가 없기때문에 return;
//			return;
//		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
