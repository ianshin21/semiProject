<%@page import="com.wm.mvc.groupshopping.model.vo.Group"%>
<%@page import="com.wm.mvc.common.util.PageInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/community_board/group_header.jsp" %>
<%
	List<Group> list = (ArrayList<Group>)request.getAttribute("list");
	System.out.println("list : " + list);
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/groupList.css">
            <section>
                <div id="article_contents">
                    <h2 id="cmt" style="color: yellow;">
                        <img src="<%=request.getContextPath()%>/images/iconfinder_Watermelon_2137822.png" id="img" align="top"> 공구모여라
                        <!-- 로그인 처리 구문 -->
                        <% if(loginMember != null) { %>
                        <button type="button" class="btn" id="btn-add" onclick="location.href='<%=request.getContextPath()%>/views/community_board/groupshopping/groupshopping_write.jsp'">글쓰기</button>
                        <% } %>
                    </h2>
                    <article id="article">
                        <div id="board-container">
                                <div class="tableList1">
         	                           <table>
                                        <tr style="height: 140px;">
                                            <td colspan="2" rowspan="3"><img src="" alt="none image"></td>
                                        </tr>
                                        <tr></tr>
                                        <tr></tr>
                                        <tr>
                                            <th colspan="2"><a> 첫 게시글 </a></th>
                                        </tr>
                                        <tr>
                                            <td> 작성자 </td>
                                            <td> 게시판번호 </td>
                                        </tr>
                                        <tr>
                                            <td> 등록날짜 </td>
                                            <td> 조회수 </td>
                                        </tr>
                               		<% if(list.isEmpty()) { %>
                                        <tr style="height: 140px;">
                                            <td colspan="2" rowspan="3"><img src="" alt="none image"></td>
                                        </tr>
                                        <tr></tr>
                                        <tr></tr>
                                        <tr>
                                            <th colspan="2"><a> - </a></th>
                                        </tr>
                                        <tr>
                                            <td> - </td>
                                            <td> - </td>
                                        </tr>
                                        <tr>
                                            <td> - </td>
                                            <td> - </td>
                                        </tr>
                               		<% } else { 
                               			for (Group g : list) {	
                          			%>
	                                    <table style="border: 1px solid #ff9c8a69;">
	                                        <tr style="height: 140px;">
	                                            <td colspan="2" rowspan="3"><img src="<%=request.getContextPath()%>/images/file.png" alt="none image" onclick="location.href='<%= request.getContextPath() %>/group/view?contentNo=<%= g.getContentNo() %>'"></td>
	                                        </tr>
	                                        <tr></tr>
	                                        <tr></tr>
	                                        <tr>
	                                            <th colspan="2"><a href="<%= request.getContextPath()%>/group/view?contentNo=<%= g.getContentNo()%>"><%= g.getTitle() %></a></th>
	                                        </tr>
	                                        <tr>
	                                            <td><%= g.getNickName() %></td>
	                                            <td><%= g.getContentNo() %></td>
	                                        </tr>
	                                        <tr>
	                                            <td><%= g.getMakeDate() %></td>
	                                            <td><%= g.getVisitCount() %></td>
	                                        </tr>
	                                        <% } %>
	                                    <% } %>
	                                    </table>
                                </div>
	                        <div id="pageBar">
								<!-- 맨 처음으로 -->
								<button onclick="location.href='<%= request.getContextPath() %>/group/list?page=1'">&lt;&lt;</button>
								
								<!-- 이전 페이지로 -->
								<button onclick="location.href='<%= request.getContextPath() %>/group/list?page=<%= pageInfo.getPrvePage() %>'">&lt;</button>
					
								<!--  10개 페이지 목록 -->
								<% for(int p = pageInfo.getStartPage(); p <= pageInfo.getEndPage(); p++){ %>
									<% if(p == pageInfo.getCurrentPage()){ %>
										<button disabled><%= p %></button>
									<% } else { %>
										<button onclick="location.href='<%= request.getContextPath() %>/group/list?page=<%= p %>'"><%= p %></button>
									<% } %>
								<% } %>
								
								<!-- 다음 페이지로 -->
								<button onclick="location.href='<%= request.getContextPath() %>/group/list?page=<%= pageInfo.getNextPage() %>'">&gt;</button>
								
								<!-- 맨 끝으로 -->
								<button onclick="location.href='<%= request.getContextPath() %>/group/list?page=<%= pageInfo.getMaxPage() %>'">&gt;&gt;</button>
							</div>
                        </div>
                    </article>
                </div>
            </section>
<%@ include file="/views/common/footer.jsp" %>