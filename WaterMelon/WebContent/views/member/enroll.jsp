<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/enroll.css">
<section>
	<div id="div1">
		<h4>회원가입</h4>
		<div id="div2">
			<!-- required 속성은 폼 데이터(form data)가 서버로 제출되기 전 반드시 채워져 있어야 하는 입력 필드를 명시 -->
			<form name="memberEnrollFrm" action="<%=request.getContextPath()%>/member/enroll" method="POST" id="enroll_form"><br> 
				<label>아이디<br> 
					<input type="text" id="memberId" name="memberId" placeholder="최소 3글자 이상 / 첫글자는 영소문자" size="30" required>
				</label> 
					<input type="button" value="중복확인" id="id_Duplicate"><br>
				<label>비밀번호<br> 
					<input type="password" id="password1" name="memberPwd" placeholder="비밀번호를 입력해주세요." size="30" required></label><br> 
				<label>비밀번호 확인<br> 
					<input type="password" id="password2" placeholder="비밀번호를 입력해주세요." size="30"></label><br> 
				<label>이름<br> 
					<input type="text" id="memberName" name="memberName" placeholder="이름" size="30" required></label><br> 
				<label>닉네임<br></label> 
					<input type="text" id="nickName" name="nickName" placeholder="닉네임" size="30" required><br>
				<label>휴대폰번호</label><br> 
					<input type="tel" id="phone" name="phone" placeholder="010" size="30" maxlength="11"><br>
				<label>이메일</label><br> 
					<input type="email" id="email"name="email" placeholder="test@test.com" size="30"><br>
				<label>주소</label><br> <input type="text" id="address" name="address" size="30"><br> 
					<input type="submit" value="회원가입" id="enroll_button" onclick="validate();"> 
					<input type="reset" value="취소" id="enroll_exit" onclick="location.href='<%=request.getContextPath()%>/views/member/login.jsp'">
			</form>
			<form name="checkIdForm">
	 			<input type="hidden" name="memberId">
	 		</form>
		</div>
	</div>
</section>
<script>
	// 유효성검사
	function validate() {
		let memberId = document.querySelector("#memberId");
		let memberPwd = document.querySelector("#password1");

		if (!check(/^[a-zA-Z0-9]{3,11}$/, memberId.value, "3~11자리 숫자와 영문자 포함해주세요!")) {
			return false;
		}
	}

	function check(regExp, checkValue, msg) {
		// 아이디
		if (regExp.test(checkValue)) {
			return true;
		} else {
			alert(msg);
			document.querySelector("#memberId").value = "";
			return false;
		}
	}

	// 비밀번호, 비밀번화 확인 일치여부
	$(document).ready(function() {
		$("#password2").blur(function(e) {
			let password1 = $("#password1").val();
			let password2 = $(e.target).val();

			if (password1.trim() != password2.trim()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#password1").val("");
				$(e.target).val("");
				$("#password1").focus();
			}
		});
	});

	// 아이디 중복검사
	$("#id_Duplicate").on("click", function() {
		let id = $("#memberId").val().trim();

		if (id.length < 4) {
			alert("아이디는 최소 3글자 이상 입력하세요.");
			return;
		}
		
		//중복 확인할 새창 띄우기
		const url = "<%= request.getContextPath()%>/member/checkId";
		const title = "duplicate";
		const status = "left=500px, top=100px, width=300px, height=200px";
		
		open("", title, status);
					
		// form에 데이터들를 채우고 open된 윈도우에서 결과를 받는 로직 구성한다. 
		// 자바스크립트에서 form은 name 속성으로 요소를 가져올 수 있다. 
		checkIdForm.target = title;	// form 전송하는 윈도우 설정한다. 
		checkIdForm.action = url;
		checkIdForm.method = "post";
		checkIdForm.memberId.value = id;
		
		// (hidden?)form 전송하기 
		checkIdForm.submit();	
		
	});
</script>
<%@ include file="/views/common/footer.jsp"%>