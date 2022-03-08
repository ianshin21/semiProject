<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<link rel="stylesheet"
	href="<%= request.getContextPath() %>/css/productEnroll.css">
<section id="page">
	<div id="page-background">
		<div id="page-container">
			<h2>상품등록</h2>
			<div class=middle>
				<form action='<%=request.getContextPath() %>/product/product_enroll'
					method="post" enctype="multipart/form-data">
					<div id="fieldset-container">
						<fieldset style="border: 0px; height: 300px;">
							<div id="flex-direction">
								<div id="image" class="display-inline-block">

									<div id="image_container"></div>
								</div>
								<label><input type="file" name="uploadFile"
									id="uploadFile" onchange="setThumbnail(event);"></label>
							</div>
							<div id="info-container">
								<div id="info-detail">
									<input type="text" id="title" name="name" placeholder="제목">
									<br>
									<br> <input type="text" id="writer" name="writer"
										value="<%=loginMember.getMemberId() %>" placeholder="작성자">
									<br>
									<br> <input type="number" id="price" name="price"
										placeholder="가격"><br>
									<br> <input type="text" id="tradearea" name="tradearea"
										placeholder="거래지역"><br>
									<br> <label><b>상태</b> <input type="radio"
										id="state1" name="state" value="개봉" checked>개봉 <input
										type="radio" id="state2" name="state" value="미개봉">미개봉</label>
									<br> <label><b>거래 방식</b> <input type="radio"
										id="trade1" name="method" value="직거래" checked>직거래 <input
										type="radio" id="trade2" name="method" value="택배">택배</label></span><br>
								</div>
							</div>
						</fieldset>
						<fieldset style="border: 1px solid white;">
							<div id="text">
								<textarea id="textcontent" name="textcontent" cols="40"
									rows="13" placeholder="내용을 입력해주세요~"></textarea>
							</div>
							<div id="save">
								<button type="submit" id="savebutton" background-color="pink"
									onclick="location.replace('<%=request.getContextPath() %>/product/list')">
									<b>등록하기</b>
								</button>
								<br>
							</div>
						</fieldset>
					</div>
			</form>
		</div>
	</div>
	</div>
</section>
<footer>
	<div id="footer">
		<span><b>(주)나눌수박애</b><span> &nbsp; &nbsp; <a href="">회사
					소개</a> | <a href="">이용 약관</a> | <a href="">고객 센터</a> | <a href="">개인정보처리방침</a>
	</div>
	<p>
		&lt;Copyright 2021. <strong>NANUL_SUBAK_AE</strong>.All rights
		reserved.&gt;
	</p>
</footer>
</body>
</html>
</div>
<script>
    	function setThumbnail(event) {
    		var reader = new FileReader();
    		
    		reader.onload = function(event) {
    			var img = document.createElement("img");
    			img.setAttribute("src", event.target.result);
    			document.querySelector("div#image_container").appendChild(img);
    		};
    		
    		reader.readAsDataURL(event.target.files[0]);
    	}
    </script>
