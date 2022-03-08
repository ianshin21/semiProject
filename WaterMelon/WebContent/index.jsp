<%@page import="com.wm.mvc.member.model.vo.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css">

<section>
    <div id="article_contents_1">
        <article id="article_1">
            <div class="slideshow-container">
                <div class="mySlides fade">
                  <div class="numbertext">1 / 3</div>
                  <img src="<%= request.getContextPath() %>/images/joongonara.png" style="width:100%; height: 250px;" onclick="location.href='https://cafe.naver.com/joonggonara'">
                </div>
                
                <div class="mySlides fade">
                  <div class="numbertext">2 / 3</div>
                  <img src="<%= request.getContextPath() %>/images/dangun.png" style="width:100%; height: 250px;" onclick="location.href='https://www.daangn.com/'">
                </div>
                
                <div class="mySlides fade">
                  <div class="numbertext">3 / 3</div>
                  <img src="<%= request.getContextPath() %>/images/bungae.png" style="width:100%; height: 250px;" onclick="location.href='https://m.bunjang.co.kr/'">
                </div>
                <br>
                </div>
        </article>
        
        <article id="article_2" style="text-align: center; line-height: 180px; background-color: lightgray;">
            <img style= "cursor: pointer; border: 1px solid  rgba(255, 255, 255, 0.219);" src="<%= request.getContextPath() %>/images/group.png" width="100%" height="100%" onclick="location.href='<%= request.getContextPath() %>';">
        </article>
        <article id="article_3">
            <div id="button_background">
			<% if (loginMember == null) {%>
            <form action="<%= request.getContextPath() %>/login" id="login_form" method="POST">
			    <table width="100%" height="135px">
			        <tr>
			            <td>
			                <p  style="text-align: center; font-size:small;"><b>로그인화면으로 넘어갑니다.</b></p>
			            </td>
			        </tr>
			        <tr>
			        	<td rowspan="2";>&nbsp;</td>
			        </tr>
			        <tr></tr>
			        <tr>
			            <td><input id="main_login" type="button" value="로그인" onclick="location.replace('<%= request.getContextPath() %>/views/member/login.jsp')";></td>
			        </tr>
	   		        <tr><td>&nbsp;</td></tr>
			    </table>
	            </div>
            </form>
            <% } else { %>
            <form action="<%= request.getContextPath() %>/logout" id="login_form" method="POST">
			    <table width="100%" height="135px">
			        <tr>
			            <td>
			                <p style="text-align: center; font-size:small;"><b>[<%= loginMember.getNickName() %>]님 반갑습니다.</b></p>
			            </td>
			        </tr>
			        <tr>
			        	<td rowspan="2";>&nbsp;</td>
			        </tr>
			        <tr></tr>
			        <tr>
			            <td>
			            	<input id="main_logout" type="button" value="로그아웃" onclick="location.replace('<%= request.getContextPath() %>/logout')">
		            	</td>
			            <!-- 문제 해결되면 내정보 폼 만들기 -->
			        </tr>
	   		        <tr><td>&nbsp;</td></tr>
			    </table>
	            </div>
            </form>
            <%} %>
            <div id="side_background">
                <aside id="side_contends">
                    <p>최근 본 상품</p>
                    <img src="" alt="" id="product_1">
                    <img src="" alt="" id="product_2">
                    <button id="product_next">NEXT</button>
                </aside>
            </div>
        </article>
    </div>
    <div id="article_contents_2">
        <article id="article_product">
            <div id="product_text">중고 상품</div>
            <div id="product_list">
                <p><a href="<%= request.getContextPath() %>">더보기</a>></p>
                <div class="product_group">
                    <img src="" alt="">
                    <img src="" alt="">
                    <img src="" alt="">
                </div>
            </div>
        </article>
    </div>
</section>
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    slides[slideIndex-1].style.display = "block";  
    setTimeout(showSlides, 2000);
}
</script>
<%@ include file="/views/common/footer.jsp" %>