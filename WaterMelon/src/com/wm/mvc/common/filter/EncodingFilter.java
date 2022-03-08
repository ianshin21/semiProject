package com.wm.mvc.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    public EncodingFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

    // 컨테이너가 요청에 필터를 적용해야겠다고 판단하면 호출
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// doPost방식으로 한글을 보내게되면 깨지게된다. 이를 방지하기위해 처리해준다. 
		// doGet 방식은 톰켓에서 기본적으로 UTF-8로 설정되어있어서 하지 않아도된다.
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 다음 필터를 호출하거나, 마지막이면 servlet, JSP를 호출한다.
		chain.doFilter(request, response); 
	}


	public void destroy() {
	}
}
