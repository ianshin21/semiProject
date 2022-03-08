<%@page import="com.wm.mvc.community.model.vo.CommunityReply"%>
<%@page import="java.util.List"%>
<%@page import="com.wm.mvc.community.model.vo.Community"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.File"%>
<%@page import="javax.imageio.ImageIO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/views/community_board/community_header.jsp" %>
<%
	Community community = (Community) request.getAttribute("community");
	List<CommunityReply> replies = (List) request.getAttribute("replies");
	
	System.out.println(community);
%>
	<section>
            <div id="article_contents">
                <h2 id="cmt"><img src="<%= request.getContextPath()%>/images/iconfinder_Watermelon_2137822.png" id="img" align="top"> <%=request.getParameter("age") %>대 수박이</h2>
                <article id="article">
                    <table id="tbl-board-view" border="1px">
                        <tr>
                            <th colspan="2"><%= community.getTitle() %></th>
                        </tr>
                        <tr>
                            <th style="width: 80px;">작성자</th>
                            <td><%= community.getNickName() %></td>
                        </tr>
                        <tr>
                            <th>조회수</th>
                            <td><%= community.getVisitCount() %></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="height: 150px; text-align: center">
	                            <% if(community.getFileName() != null) { %>
	                            	<img src="<%= request.getContextPath()%>/views/community_board/upload/<%=community.getFileName()%>" width=600px><br>
	                            	<%= community.getBoardContent() %>
	                            <% } else { %>
	                            	<%= community.getBoardContent() %>
								<% } %>
							</td>
                        </tr>
                        <tr>
                            <th colspan="2">
                                <!-- 본인작성글만 수정삭제 가능 -->
                                <% if(loginMember != null && (loginMember.getMemberNo() == community.getWriterNo()
									|| loginMember.getMemberRole().equals("ROLE_ADMIN"))) { %>
									<button class="btn" type="button" onclick="updateBoard()">수정</button>
									<button class="btn" type="button" onclick="deleteBoard()">삭제</button>
								<% }  %>
                                <button class="btn" type="button" onclick="location.replace('<%=request.getContextPath() %>/community/list?age=<%=request.getParameter("age") %>')">목록으로</button>
                                <% if(loginMember != null) { %>
                                <button type="button" onclick="reportBoard()" style="background-color: white; border: none"><img src="<%= request.getContextPath()%>/images/iconfinder_7_5243655.png" style="width: 40px; height: 35px;"><br><b>신고하기</b></button>
                                <% }  %>
                            </th>
                        </tr>
                    </table>
                    <div id="comment-container">
                        <div class="comment-editor">
                            <form action="<%= request.getContextPath()%>/community/reply" method="post">
                                <input type="hidden" name="contentNo" value="<%= community.getContentNo() %>">
                                <input type="hidden" name="age" value="<%= community.getAge() %>">
                                <input type="hidden" name="writer" value="<%= loginMember != null ? loginMember.getNickName() : "" %>">
                                <textarea name="replyContent" cols="100" rows="3" onfocus="checkLogin()"></textarea>
                                <button class="btn" type="submit" id="btn-insert">등록</button>	    			
                            </form>
                        </div>
                    </div>
                    <table id="tbl-comment">
				    	<% for(CommunityReply reply : replies) { %>
					    	<tr class="level1">
					    		<td>
					    			<sub class="comment-writer"><%= reply.getUserNickname() %></sub>
					    			<sub class="comment-date"><%= reply.getReplyCreateDate() %></sub>
					    			<br>
					    			<%= reply.getReplyContent() %>
					    		</td>
					    		<td>			    		
				    			<% if(loginMember != null && (loginMember.getNickName().equals(reply.getUserNickname()) 
				    					|| loginMember.getMemberRole().equals("ROLE_ADMIN"))) { %>
				    				<input type="hidden" name="replyNo" value="<%= reply.getReplyNO() %>"></input>
				    				<button class="btn-delete" onclick="location.href='<%=request.getContextPath()%>/community/delreply?contentNo=<%=community.getContentNo()%>&&replyNo=<%=reply.getReplyNO()%>&&age=<%=request.getParameter("age") %>'">삭제</button>
				    			<%} %>
				    			</td>
					    	</tr>
				    	<%} %>
				    </table>
                </article>
                
            </div>
            
        </section>
        <script>
			function updateBoard(){
					location.href = '<%=request.getContextPath()%>/community/update?contentNo=<%=community.getContentNo()%>&&age=<%=request.getParameter("age") %>';
			}
				
			function deleteBoard(){		
				if(confirm("정말로 게시글을 삭제 하시겠습니까?")){
					location.replace('<%=request.getContextPath()%>/community/delete?contentNo=<%=community.getContentNo()%>&&age=<%=request.getParameter("age") %>');
				}
			}
			
			function reportBoard(){	
				if(confirm("정말로 신고 하시겠습니까?")){
					location.replace('<%=request.getContextPath()%>/community/report?contentNo=<%=community.getContentNo()%>&&age=<%=request.getParameter("age") %>');
				}
			}
			
			function checkLogin() {
				if(<%= loginMember == null %>){
					alert("로그인 후 이용해주세요!");
				}
			}
			
			function deleteReply(){		
				if(confirm("정말로 댓글을 삭제 하시겠습니까?")){
					location.replace('<%=request.getContextPath()%>/community/delreply?contentNo=<%=community.getContentNo()%>&&replyNo=<%=request.getParameter("replyNo")%>');
				}
			}
			
		</script>
<%@ include file="/views/common/footer.jsp" %>