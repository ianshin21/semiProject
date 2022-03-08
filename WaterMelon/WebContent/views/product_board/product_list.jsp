<%@page import="com.wm.mvc.common.util.PageInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wm.mvc.productBoard.model.vo.ProductBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/item.css">

<%
	List<ProductBoard> list = (ArrayList)request.getAttribute("list");
	System.out.println(list);
	
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
%>
<section id="content_box">
    <div class="box">
        <h1>중고물품</h1> 
        
         
    <% if(loginMember != null) {    %>
        	<p><input type="submit" value="상품등록" id="item" onclick="location.href='<%=request.getContextPath() %>/product/product_enroll'"></p>
              <% }  %>
         
     
     <table id="tbl-board">

	
 		<% if(list.isEmpty()) { %>
			<h2>을 작성해주세요.</h2>
		<% } else {
				for(ProductBoard pboard : list) {	
		%>	
				<tr>
					<td id="picarea"></td> 	
					<td id="blank"></td>
				
				<td>
					<a href="<%=request.getContextPath() %>/product/product_info?productNo=<%= pboard.getProductNo() %>">
						<%= pboard.getProductName() %>
					</a>
				</td>
				<td id="blank"></td>
				<td>
					
						<%= pboard.getProductPrice() %>원
					
				</td>
				<br>
				</tr>
				<tr id="heightblank"></tr>
				
			
	        
		<%    }
		   } %>
		   </table>
		 	</div>

    
  
    <div id="pageBar">
			<!-- 맨 처음으로 -->
			<button id="Abutton" onclick="location.href='<%= request.getContextPath() %>/product/list?page=1'">&lt;&lt;</button>
			<!-- 이전 페이지로 -->
				<button id="Abutton" onclick="location.href='<%= request.getContextPath() %>/product/list?page=<%= pageInfo.getPrvePage() %>'">&lt;</button>
			<!--  10개 페이지 목록 -->
			<% for(int p = pageInfo.getStartPage(); p <= pageInfo.getEndPage(); p++){ %>
				<% if(p == pageInfo.getCurrentPage()){ %> <%--내가 선택한 페이지 5번이 반복 돌다 동일하면 그 페이지번호 버튼 disable --%>
					<button id="Abutton" disabled><%= p %></button>		<%-- 즉 내가 2번 클릭하면 2번 버튼 disable 개발자 도구봐도 디스에입르되있음 --%>
				<% } else { %>
					<button id="Abutton"onclick="location.href='<%= request.getContextPath() %>/product/list?page=<%= p %>'"><%= p %></button>
				<% } %>
			<% } %>
			<!-- 다음 페이지로 -->
			<button id="Abutton" onclick="location.href='<%= request.getContextPath() %>/product/list?page=<%= pageInfo.getNextPage() %>'">&gt;</button>
			<!-- 맨 끝으로 -->
					<button id="Abutton"  onclick="location.href='<%= request.getContextPath() %>/product/list?page=<%= pageInfo.getMaxPage() %>'">&gt;&gt;</button>
		</div>

</section>
<%@ include file="/views/common/footer.jsp" %>