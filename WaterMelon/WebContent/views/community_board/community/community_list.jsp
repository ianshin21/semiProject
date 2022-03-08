<%@page import="com.wm.mvc.common.util.PageInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wm.mvc.community.model.vo.Community"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/community_board/community_header.jsp" %>
<%
	List<Community> list = (ArrayList<Community>)request.getAttribute("list");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
%>
        <section>
            <div id="article_contents">
                <h2 id="cmt">
                    <img src="<%= request.getContextPath()%>/images/iconfinder_Watermelon_2137822.png" id="img" align="top"> <%=request.getParameter("age") %>대 수박이
                    <%if(loginMember != null) {%>
                    <button type="button" class="btn" id="btn-add" onclick="location.href='<%=request.getContextPath()%>/community/write?age=<%=request.getParameter("age") %>'">글쓰기</button>
					<%}%>
                </h2>
                <article id="article">
                    <div id="board-container">
                        <table id="tbl-board-list" border="1">
                            <tr>
                                <th style="width: 40px;">번호</th>
                                <th>제목</th>
                                <th style="width: 80px;">작성자</th>
                                <th style="width: 100px;">작성일</th>
                                <th style="width: 60px;">조회수</th>
                            </tr>
                        <% if(list.isEmpty()) { %>		
							<tr>
								<td colspan="6">
									조회된 게시글이 없습니다.
								</td>
							</tr>	
						<% } else {
							  for(Community community : list) {
						%>
                            <tr>
                                <td><%= community.getRowNum() %></td>
                                <td>
                                    <a href="<%= request.getContextPath()%>/community/view?contentNo=<%= community.getContentNo()%>&&age=<%=request.getParameter("age") %>">
                                        <%= community.getTitle() %>
                                    </a>
                                </td>
                                <td><%= community.getNickName() %></td>
                                <td><%= community.getMakeDate() %></td>
                                
                                <td><%= community.getVisitCount() %></td>
                            </tr>
                        <%    }
		   					} %>
                        </table>
                        <div id="pageBar">
							<!-- 맨 처음으로 -->
							<button onclick="location.href='<%= request.getContextPath() %>/community/list?page=1&&age=<%=request.getParameter("age") %>'">&lt;&lt;</button>
							
							<!-- 이전 페이지로 -->
							<button onclick="location.href='<%= request.getContextPath() %>/community/list?page=<%= pageInfo.getPrvePage() %>&&age=<%=request.getParameter("age") %>'">&lt;</button>
				
							<!--  10개 페이지 목록 -->
							<% for(int p = pageInfo.getStartPage(); p <= pageInfo.getEndPage(); p++){ %>
								<% if(p == pageInfo.getCurrentPage()){ %>
									<button disabled><%= p %></button>
								<% } else { %>
									<button onclick="location.href='<%= request.getContextPath() %>/community/list?page=<%= p %>&&age=<%=request.getParameter("age") %>'"><%= p %></button>
								<% } %>
							<% } %>
							
							<!-- 다음 페이지로 -->
							<button onclick="location.href='<%= request.getContextPath() %>/community/list?page=<%= pageInfo.getNextPage() %>&&age=<%=request.getParameter("age") %>'">&gt;</button>
							
							<!-- 맨 끝으로 -->
							<button onclick="location.href='<%= request.getContextPath() %>/community/list?page=<%= pageInfo.getMaxPage() %>&&age=<%=request.getParameter("age") %>'">&gt;&gt;</button>
						</div>
                    </div>
                </article>
            </div>
        </section>
<%@ include file="/views/common/footer.jsp" %>