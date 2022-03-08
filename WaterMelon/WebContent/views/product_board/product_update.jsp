<%@page import="com.wm.mvc.productBoard.model.vo.ProductBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ProductBoard board  = (ProductBoard)request.getAttribute("board");
    		
    %>
    
    <%@ include file="/views/common/header.jsp" %>
    <%--  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/productEnroll.css">                                     --%>
    

	<section id = "page">
            <h2>상품 수정</h2>
            <div class=middle>
          <form action='<%=request.getContextPath() %>/product/update' method="post" enctype="multipart/form-data">

   			 <fieldset>
               <div id="image" class="display-inline-block">
       
       		  <label><input type="file"  name="uploadFile"> </label>
     
                
              <button type = "button" id="imagebutton"><b>등록하기</b> </button><br> -->

                   
                    </div> <!-- 사진 영역 끝 -->
       
                    <div id="info" class="display-inline-block">
        
                        <input type="text" id="title" name="name" value="<%=board.getProductName() %>"> <br><br>
                        <input type="number" id="price" name="price" value="<%=board.getProductPrice() %>"><br><br>
                       
                       <%--loginmember 에러뜸 --%>
                        <%--<input type="text" name="writer" value="<%=loginMember.getMemberId() %>" readonly>   --%>
                    
                         <input type="text" id="tradearea" name="tradearea" value="<%=board.getTradeArea() %>"><br>
           

           
                    <br><br>
                  <label><b>상태</b> 
                    <input type="radio" id= "state1" name="state" value="<%=board.getProductState() %>" checked>개봉
                    <input type="radio" id= "state2" name="state" value="<%=board.getProductState() %>">미개봉</label> <br>
                  
                  <label><b>거래 방식</b>
                     <input type="radio" id= "trade1" name="trade" value="<%=board.getProductMethod()%>" checked>직거래
                     <input type="radio" id= "trade2"  name="trade"  value="<%=board.getProductMethod()%>">택배</label></span><br>

                </div>
                 </fieldset>
             <fieldset>
             
                    <div id ="text">
                        <textarea  id="textarea" cols ="70" rows ="10"  value="<%=board.getProductText()%>" ></textarea>
                    </div>
        
                    <div id ="save">
        
                      <input type="submit" value="수정">
						<button type="button" onclick="location.replace('<%=request.getContextPath() %>/product/list')">목록으로</button>

                    </div>
                </div>
         </fieldset>
           
            </form>
        
        
    </section>
    
    
    
    <%@ include file="/views/common/footer.jsp" %>