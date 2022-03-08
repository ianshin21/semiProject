<%@page import="com.wm.mvc.productBoard.model.vo.BoardReply"%>
<%@page import="java.util.List"%>
<%@page import="com.wm.mvc.productBoard.model.vo.ProductBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/productInfo.css">
 <%
	ProductBoard product  = (ProductBoard)request.getAttribute("product");
 	Member member =(Member)request.getAttribute("member");
 	System.out.println("product : " + product);
 	List<BoardReply> replies = (List)request.getAttribute("replies");
	System.out.println("gets replies : " + replies);
 %>      
        <!--섹션의 핑크 틀을 위한 id=page-->
        <section id = "page">
            <h2>상품정보</h2>
	
				
                  <div class=middle>
                
                 <fieldset>
                   	
                  	<div id="image" class="display-inline-block">
       
       		  		<!-- 	<div id="imagespace"></div> -->
       		  			

       		  	 		</div><!-- 사진 영역 끝 -->
                    	
                    	<div id="info" class="display-inline-block">
                    
                        <table id="info" >
                            <tr id="top">
                            <th  class="sector">상품명</th>

                            <th  class="alignmid" id="product_name"><b> <%=product.getProductName()%></b></th>

                            </tr>
                            <tr>
                                <td class="sector" id="td_0">상태 </td>
                               
                                <td class="alignmid" id="state"><%=product.getProductState()%></td>
                            </tr>
                            <tr>
                                <td class="sector" id="td_0">연락처</td>
                             	 <td class="alignmid"><%=product.getPhone()%></td> 
                            </tr>
                            <tr>
                                <td class="sector" id="td_0">거래방식</td>
                                <td  class="alignmid" id=trade ><%=product.getProductMethod()%></td>
                            </tr>
                            <tr>
                                <td class="sector" id="td_0">거래지역</td>

                                <td class="alignmid" id="tradearea"><%=product.getTradeArea()%></td>
                            </tr>
                            <tr>
                               <td class="sector" id="td_0">가격</td>
                                <td  class="alignmid" id="price"> <%=product.getProductPrice()%></td>

                            </tr>
                            <tr>
				<th colspan="2">
				<% if(loginMember != null && (loginMember.getMemberId().equals(product.getMemberId()) 
					|| loginMember.getMemberRole().equals("admin"))) { %>
				
					<!-- 	<button type="submit" onclick="updateProduct()">수정</button> -->
					<button id="infochangebutton" type="submit" onclick="deleteProduct()">삭제</button>
				<% }  %>
					<button id="infochangebutton"  type="submit" onclick="location.replace('<%=request.getContextPath() %>/product/list')">목록으로</button>
				</th>
			</tr>
                        </table>
                       
                       <!--   <button type = "submit" id="imagebutton"><b>찜</b> </button><br> -->
                      
                    
                      
                    </div><!--info div 영역 끝-->
                            </fieldset>
                    
                    <hr style="border: 1px solid silver;" width="85%">

                    <div class="tab_content">

                        <input type="radio" name="tabmenu"id="tab01" checked>
                        <label for="tab01">상품 설명 </label>  <!--인풋과 라벨이 아이디 값으로 연결되어 라벨 클릭시 인풋고 쳌크 됨 -->
                
                        <input type="radio" name="tabmenu"  id="tab02">
                        <label for="tab02">상품 문의 </label>
                  
                
                    <div class="conbox con1">
                              <%=product.getProductText()%>
                
                            </div> <!-- con /div -->
                      

               
                <div class="conbox con2">
	    	<div class="comment-editor">
	    		<form action="<%=request.getContextPath() %>/product/reply" method="post">
	    			<input type="hidden" name="productNo" value="<%=product.getProductNo() %>">
	    			<input type="hidden" name="writer" value="<%=loginMember != null ? loginMember.getMemberId() : "" %>">
					<textarea name="content" cols="70" rows="3" onfocus="checkLogin()"></textarea>
					<button type="submit" id="btn-insert">등록</button>	    			
	    		</form>
	    		</div><!-- comment-editor -->
	    
	    <table id="tbl-comment">
	    	<% for(BoardReply reply : replies) { %>
		    	<tr class="level1">
		    		<td>
		    			<sub class="comment-writer"><%= reply.getMemberId() %></sub>
		    			<sub class="comment-date"><%= reply.getWritetime() %></sub>
		    			<br>
		    			<%= reply.getContent() %>
		    		</td>
		    		<td>
	    			<% if(loginMember != null && (loginMember.getMemberId().equals(reply.getMemberId()) 
	    					|| loginMember.getMemberRole().equals("admin"))) { %>
	    				
	    			<%} %>
		    		</td>
		    	</tr>
	    	<%} %>
	    </table>

	
    </div><!-- con2 /div -->
            
               
                </div><!-- middle -->
 
    </section>
<script>
	function updateProduct(){
			location.href = "<%=request.getContextPath()%>/product/update?productNo=<%=product.getProductNo()%>";
	}
		
	function deleteProduct(){		
		if(confirm("정말로 게시글을 삭제 하시겠습니까?")){
			location.replace('<%=request.getContextPath()%>/product/delete?productNo=<%=product.getProductNo()%>');
			// 뒤로가기 못하게 replace로 처리
			// location을 get요청해주는 서블릿 하나 필요
			// get 형태의 쿼리스트링으로 날리니까 getPAra로 BoardDelete에 날림
			
		}
	}
	
	function checkLogin() {
		if(<%= loginMember == null %>){
			alert("로그인 후 이용해주세요!");
			$("#memberId").focus();
		}
	}
</script>


<%@ include file="/views/common/footer.jsp" %>