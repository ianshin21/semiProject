<%@page import="com.wm.mvc.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Member loginMember = (Member)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css">
<script src="<%= request.getContextPath()%>/js/jquery-3.5.1.js"></script>
</head>
<body>
<div class="wrap">
	<header>
	    <div id="header_contents">
	        <div id="header_1">
	            <a href="<%= request.getContextPath()%>/"><img src="<%= request.getContextPath()%>/images/logo.png" id="logo"></a>
	        </div>
	        <div id="header_2">
	            <div id="search_contents">
	                <input type="text" placeholder="검색창" id="search_input">
	                <button type="button" id="search_button"><img src="<%= request.getContextPath()%>/images/search.png" alt="" width="100%" height="100%"></button>
	            </div>
	        </div>
	        <div id="header_3">
	            <div id="icon_contents">
	            <% if (loginMember == null ) {%>
	                <button type="button" id="like_icon"><img src="<%= request.getContextPath()%>/images/heart.png" onclick="location.href='<%= request.getContextPath()%>/views/member/mypage.jsp'"></button>
	                <button type="button" id="community_icon"><img src="<%= request.getContextPath()%>/images/community.png" onclick="location.href='<%= request.getContextPath()%>/community/list?age=10'"></button>
	                <button type="button" id="mypage_icon"><img src="<%= request.getContextPath()%>/images/mypage.png" onclick="location.href='<%=request.getContextPath()%>'"></button>
	            
	                <div>
	                    <li id="list_1"><b>찜목록</b></li>
	                    <li id="list_2"><b>커뮤니티</b></li>
	                    <li id="list_3"><b>로그인</b></li>
	                </div>
	            <% } else { %>
	                <button type="button" id="like_icon"><img src="<%= request.getContextPath()%>/images/heart.png" onclick="location.href='<%= request.getContextPath()%>/views/member/mypage.jsp'"></button>
	                <button type="button" id="community_icon"><img src="<%= request.getContextPath()%>/images/community.png" onclick="location.href='<%= request.getContextPath()%>/community/list?age=10'"></button>
	                <button type="button" id="mypage_icon"><img src="<%= request.getContextPath()%>/images/mypage.png" onclick="location.href='<%=request.getContextPath()%>/views/member/mypage.jsp'"></button>
	            
	                <div>
	                    <li id="list_1"><b>찜목록</b></li>
	                    <li id="list_2"><b>커뮤니티</b></li>
	                    <li id="list_3"><b>마이페이지</b></li>
	                </div>
	            <% } %>
	            </div>
	        </div>
	    </div>
	    <nav>
	    <% if (loginMember != null && loginMember.getMemberId().equals("admin")) { %>
	        <div id="nav_1">
	            <ul id="nav_contents">
	                <li><a href="<%= request.getContextPath() %>/product/list">중고물품</a></li>
	                <li><a href="<%= request.getContextPath() %>">공지사항</a></li>
	                <li><a href="<%= request.getContextPath() %>/group/list">공동구매</a></li>
	                <li><a href="<%= request.getContextPath() %>/community/list?age=10">커뮤니티</a></li>
	                <li><a href="<%= request.getContextPath() %>/cs/list">고객센터</a></li>
	                <li><a href="<%= request.getContextPath() %>/member/admin">관리자페이지</a></li>
	            </ul>
	        </div>
        <% } else {%>
        	<% if (loginMember == null) { %>
   	        <div id="nav_1">
	            <ul id="nav_contents">
	                <li><a href="<%= request.getContextPath() %>/product/list">중고물품</a></li>
	                <li><a href="<%= request.getContextPath() %>">공지사항</a></li>
	                <li><a href="<%= request.getContextPath() %>/group/list">공동구매</a></li>
	                <li><a href="<%= request.getContextPath() %>/community/list?age=10">커뮤니티</a></li>
	                <li><a href="<%= request.getContextPath() %>/cs/list">고객센터</a></li>
	                <li><a onclick="location.href='<%=request.getContextPath()%>/views/member/login.jsp'">마이페이지</a></li>
	            </ul>
	        </div>
	        <% } else { %>
   	        <div id="nav_1">
	            <ul id="nav_contents">
	                <li><a href="<%= request.getContextPath() %>/product/list">중고물품</a></li>
	                <li><a href="<%= request.getContextPath() %>">공지사항</a></li>
	                <li><a href="<%= request.getContextPath() %>/group/list">공동구매</a></li>
	                <li><a href="<%= request.getContextPath() %>/community/list?age=10">커뮤니티</a></li>
	                <li><a href="<%= request.getContextPath() %>/cs/list">고객센터</a></li>
	                <li><a onclick="location.href='<%=request.getContextPath()%>/views/member/mypage.jsp'">마이페이지</a></li>
	            </ul>
	        </div>
        	<% } %>
        <% } %>
	    </nav>
	</header>	
