<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/community_board/group_header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/groupWrite.css">
<section>
    <div id="article_contents">
        <form action="<%=request.getContextPath()%>/group/write" method="post" enctype="multipart/form-data">
        <h2 id="cmt" style="color: yellow;">
            <img src="<%= request.getContextPath() %>/images/iconfinder_Watermelon_2137822.png" id="img" align="top"> 공구모여라
            <button type="submit" class="btn" id="btn-add">글쓰기
        </h2>
        <article id="article">
            <div id="board-container">
                <div id="group_write">
                    <div id="headContainer"><br>
                        <!-- 게시판 선택 -->
                        <select name="boardSelect" id="boardSelect" >
                            <option value="" id="chooseOption">게시판을 선택해주세요.</option>
                            <option value="" id="chooseOption">10대</option>
                            <option value="" id="chooseOption">20대</option>
                            <option value="" id="chooseOption">30대</option>
                            <option value="" id="chooseOption">40대</option>
                            <option value="" id="chooseOption">50대 이상</option>
                            <option value="" id="chooseOption">공구모여라</option>
                        </select>
                        <input name="writer" id="writer" value="<%= loginMember.getNickName() %>" readonly required><br><br>
                        <!-- 제목 입력 -->
                        <input name="title" id="boardTitle" type="text" placeholder="제목을 입력해 주세요." required><br><br>
                        <div class="writeWrap">
                            <div id="fileUpload">
                                <input type="file" name="upfile" id="fileSelect" onchange="javascript:document.getElementById('onChanged').value = this.value.replace(/c:\\fakepath\\/i, '')" required multiple>
                                <input type="text" name="onChanged" id="onChanged" required readonly>
                                <img alt="" src="<%= request.getContextPath() %>/images/iconfinder_icon-4-file-png_315641.png">
                            </div>
                            <div id="writeContent"><br>
                                <textarea name="content" id="wc_Content" cols="70" rows="20" placeholder="# 내용을 입력해주세요." style="resize: none;" required></textarea>
                            </div>
                        </div><br>
                    </div>
                </div>
            </div>
        </article>
        </form>
    </div>
</section>
<script>
	
</script>

<%@ include file="/views/common/footer.jsp" %>