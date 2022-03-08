<%@page import="com.wm.mvc.groupshopping.model.vo.GroupReply"%>
<%@page import="com.wm.mvc.groupshopping.model.vo.Group"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/community_board/group_header.jsp"%>
<%
	Group g = (Group)request.getAttribute("group");
	List<GroupReply> replies = (ArrayList)request.getAttribute("replies");
%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/groupView.css">
<section>
	<div id="article_contents">
			<h2 id="cmt" style="color: yellow;">
				<img
					src="<%=request.getContextPath()%>/images/iconfinder_Watermelon_2137822.png"
					id="img" align="top"> 공구모여라
				<%
					if (loginMember != null && (loginMember.getMemberId().equals("admin"))) {
				%>

				<% if(loginMember != null && (loginMember.getMemberNo() == g.getWriterNo()) 
				|| loginMember.getMemberRole().equals("ROLE_ADMIN")) { %>
				<button id="btn-option" type="button" onclick="updateBoard()">수정</button>
				<button id="btn-option" type="button" onclick="deleteBoard()">삭제</button>
				<% }  %>
				<button id="btn-option" type="button" onclick="location.replace('<%=request.getContextPath() %>/group/list')">목록으로</button>
				<%
					}
				%>
			</h2>
			<article id="article">
				<div id="board-container">
					<div id="viewHead">
						<div id="viewTitle">
							<br>
							<%
								if (g != null) {
							%>
							<div>
								<h1>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=g.getTitle()%></h1>
							</div>
							<div id="headEtc">
								<br>
								<div id="titleIcon">
									<img style="width: 40px; height: 40px;"
										src="<%=request.getContextPath()%>/images/iconfinder_watermelon_2003313.png"
										alt="">
								</div>
								<div id="writerInfo">
									<div id="writerInfo_style">
										<h4><%=g.getNickName()%></h4>
										<h5><%=g.getMakeDate()%></h5>
										<h5><%=g.getVisitCount()%></h5>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br> <br>
					<hr style="border: 1px solid #ff9c8a69; width: 80%;">
					<div id="viewContainer">
						<textarea name="viewContent" id="viewContent" cols="100" rows="50" style="resize: none; height: 100%;" readonly><%=g.getBoardContent()%></textarea>
               	 	<div id="comment-container">
                  		<div class="comment-editor">
                       		<form id="comment-form" action="<%=request.getContextPath()%>/group/reply" method="post">
                          		<input type="hidden" name="contentNo" value="<%= g.getContentNo() %>">
                        		<input type="hidden" name="writer" value="<%= loginMember != null ? loginMember.getNickName() : "" %>">
                          		<textarea id="replyContent" name="replyContent" cols="73" rows="3" onfocus="checkLogin()"></textarea>
                          		<button class="btn" type="submit" id="btn-insert">등록</button>	    			
                      		</form>
                  		</div>
              		</div>
              		<table id="tbl-comment">
              		<% for (GroupReply r : replies) { %>
                  		<tr class="level1">
                      		<td>
                          		<sub class="comment-writer"><%= r.getUserNickname() %></sub>
                          		<sub class="comment-date"><%= r.getReplyCreateDate() %></sub>
                          		<br>
                          		<%= r.getReplyContent() %>
                      		</td>
                   			<td>
			    			<% if(loginMember != null && (loginMember.getNickName().equals(r.getUserNickname()) 
			    					|| loginMember.getMemberRole().equals("ROLE_ADMIN"))) { %>
			    				<input type="hidden" name="replyNo" value="<%= r.getReplyNo() %>"></input>
			    				<button class="btn-delete" onclick="location.href='<%=request.getContextPath()%>/group/deleteReply?contentNo=<%=g.getContentNo()%>&&replyNo=<%=r.getReplyNo()%>'" && deleteReply();>삭제</button>
			    			<%} %>
			    			</td>
                  		</tr>
               		<% } %>
              		</table>
					</div>
				</div>
				<%
					}
				%>
			</article>
	</div>
</section>
<script>
	function updateBoard(){
			location.href = "<%=request.getContextPath()%>/group/update?contentNo=<%=g.getContentNo()%>";
	}
		
	function deleteBoard(){		
		if(confirm("정말로 게시글을 삭제 하시겠습니까?")){
			location.replace('<%=request.getContextPath()%>/group/delete?contentNo=<%=g.getContentNo()%>');
		}
	}
	
	function checkLogin() {
		if(<%= loginMember == null %>){
			alert("로그인 후 이용해주세요!");
			$("#userId").focus();
		}
	}
	
	function deleteReply(){		
		if(confirm("정말로 댓글을 삭제 하시겠습니까?")){
			location.replace('<%=request.getContextPath()%>/group/deleteReply?contentNo=<%=g.getContentNo()%>&&replyNo=<%=request.getParameter("replyNo")%>');
		}
	}
</script>
<%@ include file="/views/common/footer.jsp"%>