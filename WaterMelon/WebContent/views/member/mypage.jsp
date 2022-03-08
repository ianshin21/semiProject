<%@page import="com.wm.mvc.member.model.vo.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/mypage.css">

   <section class="mypage">
        <div class="my_content">
            <table>
                <tr>
                    <td><a href="*"><img src="<%= request.getContextPath() %>/images/user.png" style="width: 50px; height:50px"></td>
                    <td rowspan="2">&nbsp;&nbsp;&nbsp;&nbsp;<%= loginMember.getNickName() %>님 환영합니다!
                        <br></p><span>&nbsp;&nbsp;&nbsp;&nbsp;판매등급 : 수박 반쪽</span><br><br>
                    </td>
                </tr>
                <tr>
                 <td style="text-align: center;"><%= loginMember.getNickName() %></td>
                </tr>
            </table>

            <div class="my_menu">
                <ul onclick="location.href ='<%= request.getContextPath() %>/member/view?memberId=<%=loginMember.getMemberId() %>';">
                    <li><img src="<%= request.getContextPath() %>/images/modify.png"></li>
                    <li>정보확인 및 수정</li>
                </ul>
                <ul>
                    <li><a href="*"><img src="<%= request.getContextPath() %>/images/list.png"></a></li>
                    <li><a href="*">거래내역</a></li>
                </ul>
                <ul>
                    <li><a href="*"><img src="<%= request.getContextPath() %>/images/heart.png"></a></li>
                    <li><a href="*">찜목록</a></li>
                </ul>
                <br>
                <ul> 
                    <li><a href="*"><img src="<%= request.getContextPath() %>/images/iconfinder_FAQ_Discussion_Ask_Question_4075919.png"></a></li>
                    <li><a href="*">문의내역</a></li>
                </ul>
                <ul>
                    <li><a href="*"><img src="<%= request.getContextPath() %>/images/community.png"></a></li>
                    <li><a href="*">커뮤니티 관리</a></li>
                </ul>
            </div>
        </div>

    </section>
<%@ include file="/views/common/footer.jsp" %>