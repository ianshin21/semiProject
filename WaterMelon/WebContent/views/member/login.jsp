<%@page import="com.wm.mvc.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/login.css">

<%
	String saveId = null;

	Cookie[] cookies = request.getCookies();
	
	// 쿠키값 받아오기 
	if(cookies != null){
		for (Cookie c : cookies){
			if(c.getName().equals("saveId")){
				saveId = c. getValue();
				
				break;
			}
		}
	}
 %>
   <section>
      <div class="login_wrap">
          <form action="<%= request.getContextPath() %>/login" id="login_form" method="POST">
              <a href="<%= request.getContextPath()%>"></a><img src="<%= request.getContextPath()%>/images/logo.png" id="login_logo"><br>
              <input type="text" placeholder="아이디" id="loginId" name="loginId" value="<%= saveId == null ? "" : saveId %>" required><br>
              <input type="password" placeholder="비밀번호" id="loginPwd" name="loginPwd" required><br>
              <input type="submit" value="로그인" id="login_button""><br>
              &nbsp;<label><input type="checkbox" name="saveId" <%= saveId == null ? "" : "checked" %>>아이디 저장</label>
              <label>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="<%= request.getContextPath()%>/views/member/agree.jsp">회원가입</a></label>
          </form>
      </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>
<!-- 관리자 로그인 시 관리자 페이지로 이동 -->