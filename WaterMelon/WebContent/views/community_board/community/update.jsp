<%@page import="com.wm.mvc.community.model.vo.Community"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/views/community_board/community_header.jsp" %>
<%
	Community community = (Community) request.getAttribute("community");
	
%>
	<section>
            <div id="article_contents">
                <h2 id="cmt"><img src="<%= request.getContextPath()%>/images/iconfinder_Watermelon_2137822.png" id="img" align="top"> <%=request.getParameter("age") %>대 수박이</h2>
                <article id="article">
                    <form action='<%=request.getContextPath() %>/community/update?age=<%=request.getParameter("age") %>' method="post">
                    	<input type="hidden" name="contentNo" value = "<%= community.getContentNo() %>">
                        <table id='tbl-board-write'>
                            <tr>
                                <th style="width: 100px;">제목</th>
                                <td><input type="text" name="title" id="title" value="<%= community.getTitle() %>"></td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td><input type="text" name="writer" value="<%= loginMember.getNickName() %>" readonly></td>
                            </tr>
                            <tr>
                                <th>첨부파일</th>
                                <td><input type="file" name="upfile"></td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td><textarea name="content" cols="73" rows="18"><%= community.getBoardContent() %></textarea></td>
                            </tr>
                            <tr>
                                <th colspan="2">
                                    <input type="submit" class="btn" value="수정">
                                    <a href="<%= request.getContextPath()%>/community/list?age=<%=request.getParameter("age") %>"><input type="button" class="btn" value="목록으로"></a>
                                </th>
                            </tr>
                        </table>
                    </form>
                </article>
                
            </div>
            
        </section>
<%@ include file="/views/common/footer.jsp" %>