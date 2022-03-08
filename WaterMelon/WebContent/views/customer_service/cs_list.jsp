<%@page import="com.wm.mvc.common.util.PageInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wm.mvc.customerService.model.vo.CustomerService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/csList.css">
<% 
	List<CustomerService> list = (ArrayList)request.getAttribute("list");
	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
%>
<section id="cs-content">
	<h2 align="center">고객센터</h2>
	<div id="cs-container">
 		<%if(loginMember != null) {%>
			<button id="btn-write" type="button" onclick="location.href ='<%=request.getContextPath() %>/cs/write'">글쓰기</button>
			<br><br><br>
		<%}%> 
		<table id="cs-table" border="1" style="border-color: lightgray">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		<% if(list.isEmpty()) { %>
			<tr>
				<td colspan="5"> 조회된 게시글이 없습니다.</td>	
			</tr>
		<% } else { 
			  for(CustomerService cs : list) {
		%>
			<tr>
				<td width="70"><%= cs.getCsNo() %></td>
				<td align="left"> &nbsp;
					<a href="<%= request.getContextPath() %>/cs/view?csNo=<%= cs.getCsNo()%>">
						<%= cs.getCsTitle() %>
					</a>
				</td>
				<td width="100"><%= cs.getMemberId() %></td>
				<td width="100"><%= cs.getCsDate() %></td>
				<td width="70"><%= cs.getCsCount() %></td>
			</tr>
		<%
				} 
			}
		%>
	</table>
	<div id="pageBar">
		<button class="btn-page" onclick="location.href='<%= request.getContextPath()%>/cs/list?page='1'">&lt;&lt;</button>
		<button class="btn-page"  onclick="location.href='<%= request.getContextPath()%>/cs/list?page=<%= pageInfo.getPrvePage() %>'">&lt;</button>
		<% for(int p = pageInfo.getStartPage(); p <= pageInfo.getEndPage(); p++) { %>
			<% if(p == pageInfo.getCurrentPage()) { %>
				<button disabled><%= p %></button>
			<% } else { %>
				<button class="btn-page" onclick="location.href='<%= request.getContextPath() %>/cs/list?page=<%= p %>'"><%= p %></button>
			<% } %>
		<% } %>
		<button class="btn-page"  onclick="location.href='<%= request.getContextPath()%>/cs/list?page=<%= pageInfo.getNextPage() %>">&gt;</button>
		<button class="btn-page"  onclick="location.href='<%= request.getContextPath()%>/cs/list?page=<%= pageInfo.getMaxPage() %>'">&gt;&gt;</button>
	</div>
</div>
</section>
<%@ include file='/views/common/footer.jsp' %>