<%@page import="com.wm.mvc.member.model.vo.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/info.css">

<% 
	Member member = (Member)request.getAttribute("member"); 
	System.out.println("userinfo : " + member);

%>

	<section>
            <div id="article_contents">
                <h2>회원정보수정</h2>
                <article id="article">
                    <form id="memberFrm" action="<%=request.getContextPath()%>/member/update" method="post">
                        <table>
                            <tr>
                                <th>아이디 : </th>
                                <td>
                                    <input type="text" name="memberId" id="newId" 
                                        value="<%= member.getMemberId()%>" readonly required>
                                </td> 	
                            </tr>
                            <tr>
                                <th>닉네임 : </th>
                                <td>
                                    <input type="text" name="nickName" id="userName" 
                                        value="<%= member.getNickName()%>" required>				
                                </td> 	
                            </tr>
                              <tr>
                                <th>휴대폰 : </th>
                                <td>
                                    <input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" 
                                        maxlength="11" value="<%= member.getPhone()%>">
                                </td>
                            </tr>
                            <tr>
                                <th>이메일 : </th>
                                <td>
                                    <input type="email" placeholder="abc@abc.com" name="email" id="email"
                                         value="<%= member.getEmail()%>">												
                                </td> 	
                            </tr>
                            <tr>
                                <th>주소 :</th>
                                    <td>
                                        <input type="text" name="address" id="address" 
                                            value="<%= member.getAddress()%>">
                                    </td> 	
                            </tr>
                        </table>
                        <div id="btn">
                        <button class="btn" type="button" onclick="updatePwd();">비밀번호변경</button>
                        <input class="btn" type="submit" value="정보수정">
                        <input class="btn" type="button" onclick="deleteMember();" style="background-color: rgb(231, 76, 60);" value="탈퇴">
                        </div>
                     </form>
                </article>
            </div>
            <script>
 				function updatePwd(){
 				//1 비밀번호 변경창을 열고
 				//2. 비밀번호수정하기
 			
 				const url="<%=request.getContextPath()%>/member/updatePwd?memberId=" + $("#newId").val();
 				const status="left=500px,top=200px,width=400px,height=210px";
 			
 				open(url,"",status);
 				
 				}
 		
 				function deleteMember(){
 					//id서버에 전송해서 그 id랑 일치하는 회원을 삭제
 			
 					if(confirm("정말로 탈퇴하시겠습니까?")){
 					location.replace('<%=request.getContextPath()%>/member/delete?memberId=<%=member.getMemberId()%>');
 				
 					}
 				}	
 			</script>
      </section>
<%@ include file="/views/common/footer.jsp" %>