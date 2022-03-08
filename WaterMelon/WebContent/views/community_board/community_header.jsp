<%@page import="com.wm.mvc.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String saveId = null;
	Member loginMember = (Member)session.getAttribute("loginMember");
	Cookie[] cookies = request.getCookies();
	
	//쿠키값 받아오기	
	if (cookies != null) {
		for (Cookie c : cookies) {
			if(c.getName().equals("saveId")) {
				saveId = c.getValue();
				
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/community.css">
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
	                <button type="button" id="like_icon"><img src="<%= request.getContextPath()%>/images/heart.png" onclick="location.href='<%= request.getContextPath()%>'"></button>
	                <button type="button" id="community_icon"><img src="<%= request.getContextPath()%>/images/community.png" onclick="location.href='<%=request.getContextPath()%>'"></button>
	                <button type="button" id="mypage_icon"><img src="<%= request.getContextPath()%>/images/mypage.png" onclick="location.href='<%=request.getContextPath()%>'"></button>
	                <div>
	                    <li id="list_1"><b>찜목록</b></li>
	                    <li id="list_2"><b>커뮤니티</b></li>
	                    <li id="list_3" onclick="<%= request.getContextPath()%>/views/member/login.jsp"><b>로그인</b></li>
	                </div>
	            </div>
	        </div>
            </div>
            <nav>
                <div id="nav_1">
                    <ul id="nav_contents">
                        <li><button onclick="location.href='<%=request.getContextPath()%>'">&#60; 돌아가기</button></li>
                        <li><a onclick="location.href='<%= request.getContextPath()%>/community/list?age=10'">10대</a></li>
                        <li><a onclick="location.href='<%= request.getContextPath()%>/community/list?age=20'">20대</a></li>
                        <li><a onclick="location.href='<%= request.getContextPath()%>/community/list?age=30'">30대</a></li>
                        <li><a onclick="location.href='<%= request.getContextPath()%>/community/list?age=40'">40대</a></li>
                        <li><a onclick="location.href='<%= request.getContextPath()%>/community/list?age=50'">50대 이상</a></li>
                        <li><a href="<%= request.getContextPath()%>/views/community_board/groupshopping/groupshopping_list.jsp" style="color: yellow;">공구모여라</a></li>
                    </ul>
                </div>
            </nav>
        </header>