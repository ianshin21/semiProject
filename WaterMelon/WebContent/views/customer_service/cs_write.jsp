<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/csWrite.css">
<section id="cs-content">
	<div id="cs-container">
		<h2 align="center">고객센터</h2>
		<form action='<%=request.getContextPath()%>/cs/write' method="POST">
			<table id="cs-table">
				<tr>
					<th id="tbl-th">제목</th>
					<td><input type="text" name="title" id="title"></td>
				</tr>
				<tr>
					<th id="tbl-th">작성자</th>
					<td><input type="text" id="writer" name="writer" value="<%=loginMember.getMemberId() %>" readonly></td>
				</tr>
				<tr>
					<th id="tbl-th">문의내용</th>
					<td><textarea name="content" id="content" cols="100" rows="200"></textarea></td>
				</tr>
				<tr>
					<th id="tbl-btn" colspan="2">
						<button type="submit">등록</button>
						<button type="button" onclick="history.go(-1);">목록으로</button>
					</th>
				</tr>
			</table>
		</form>
	</div>
</section>
<%@ include file='/views/common/footer.jsp' %>