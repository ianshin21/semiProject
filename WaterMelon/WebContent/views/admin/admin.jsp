<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
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
                        <button type="button" id="like_icon"><img src="<%= request.getContextPath()%>/images/heart.png" onclick="location.href='<%=request.getContextPath()%>'"></button>
                        <button type="button" id="community_icon"><img src="<%= request.getContextPath()%>/images/community.png" onclick="location.href='<%=request.getContextPath()%>'"></button>
                        <button type="button" id="mypage_icon"><img src="<%= request.getContextPath()%>/images/mypage.png" onclick="location.href='<%=request.getContextPath()%>'"></button>
                        <div>
                            <li id="list_1"><b>찜목록</b></li>
                            <li id="list_2"><b>커뮤니티</b></li>
                            <li id="list_3"><b>로그인</b></li>
                        </div>
                    </div>
                </div>
            </div>
            <nav>
                <div id="nav_1">
                    <ul id="nav_contents">
                        <li><a href="#">관리자</a></li>
                        <li><a href="#">기본설정</a></li>
                        <li><a href="#">회원관리</a></li>
                        <li><a href="#">게시판관리</a></li>
                        <li><a href="#">상품관리</a></li>
                        <li><a href="#">공구관리</a></li>
                    </ul>
                </div>
            </nav>
        </header>    


        <!-- admin section -->
   		<section>
        <div class="admin_form">
            <article>
                <ul id="dashboard"><a href="#">Dashboard</a></ul>
                <ul class="admin_list" id="adminList1"><a href="#">회원관리</a></ul>
                <ul id="member_admin_list" class="member_admin_list">
                    <li><a href="#">회원조회</a></li>
                    <li><a href="#">신고관리</a></li>
                    <li><a href="#">블랙리스트</a></li>
                </ul>
                <ul class="admin_list" id="adminList2"><a href="#">게시판관리</a></ul>
                <ul id="board_admin_list">
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">게시물관리</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">1:1문의</a></li>
                </ul>
                <ul class="admin_list" id="adminList3"><a href="#">상품관리</a></ul>
                <ul id="product_admin_list">
                    <li><a href="#">상품조회</a></li>
                    <li><a href="#">상품삭제</a></li>
                </ul>
                <ul class="admin_list" id="adminList4"><a href="#">공구관리</a></ul>
                <ul id="group_admin_list">
                    <li><a href="#">공구조회</a></li>
                    <li><a href="#">공구추가</a></li>
                    <li><a href="#">공구삭제</a></li>
                </ul>
            </article>
            <article id="dashboard_background">
                <p href="#">Dashboard</p>
                <div id="dashboard_contents"></div>
            </article>
        </div>
        </section>
        <!-- 각 페이지마다 삭제/추가/수정 기능 넣어야함 -->
<script>
/*$(document).ready(function() {
	$(".admin_list").on("click", function() {
	    if($(this).next().css('display') === 'none') {
	        $(this).next().slideDown();
	    } else {
	        $(this).next().slideUp();
	    }
});*/
$(document).ready(function() {
    $("#adminList1").mouseover(function (e) {
        e.preventDefault();
        $("#member_admin_list").slideDown(500);
        $("#board_admin_list").slideUp(500);
        $("#product_admin_list").slideUp(500);
        $("#group_admin_list").slideUp(500);
        if ($("#adminList1").click(function () {
            $("#member_admin_list").slideUp(500);
        }));
    });
    $("#adminList2").mouseover(function (e) {
        e.preventDefault();
        $("#member_admin_list").slideUp(500);
        $("#board_admin_list").slideDown(500);
        $("#product_admin_list").slideUp(500);
        $("#group_admin_list").slideUp(500);
        if ($("#adminList2").click(function () {
            $("#board_admin_list").slideUp(500);
        }));
    });
    $("#adminList3").mouseover(function (e) {
        e.preventDefault();
        $("#member_admin_list").slideUp(500);
        $("#board_admin_list").slideUp(500);
        $("#product_admin_list").slideDown(500);
        $("#group_admin_list").slideUp(500);
        if ($("#adminList3").click(function () {
            $("#product_admin_list").slideUp(500);
        }));
    });
    $("#adminList4").mouseover(function (e) {
        e.preventDefault();
        $("#member_admin_list").slideUp(500);
        $("#board_admin_list").slideUp(500);
        $("#product_admin_list").slideUp(500);
        $("#group_admin_list").slideDown(500);
        if ($("#adminList4").click(function () {
            $("#group_admin_list").slideUp(500);
        }));
    });
});
</script>
<%@ include file="/views/common/footer.jsp" %>
