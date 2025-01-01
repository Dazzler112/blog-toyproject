<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<style>
body {
	margin: 0px 55px;
}

.sign-column{
    margin: 0px 0px 15px 0px;
}

.member-sign-column{
    display: flex;
    justify-content: center;
}
</style>
<html>
	<head>
		<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>Review Pages</title>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	</head>
	<body>
	<my:navigation></my:navigation>
		<div style="display: flex; justify-content: center;">
      		<div>		
				<input id="authority-space" type="text" name="authority" value="user" style="display: none;" readonly>
				<input id="membertype-space" type="text" name="member_type" value="user" style="display: none;" readonly>
				<input type="text" id="search-id" name="member_id" value="${member.member_id}" style="display: none;" readonly>
	            <!--패스워드-->
	            <div class="sign-column">
	              <div>
	              <span style="margin-right: 35px;">비밀번호 * </span>
	              </div>
	              <input type="password" class="sign-input" id="modify-password" name="password" placeholder="영문,숫자,특수문자 조합하여 8~20자리" maxlength="20">
	              <div style="margin-left: 10px;" id="mpwdcheck-blank1"></div>
	            </div>                       
                       
            </div> 
		</div>
		<br>
        <div style="display: flex; justify-content: center;">
        	<span id="need-sign" style="color: rgba(252, 168, 149, 0.7); font-size: 9px; margin-bottom: 8px;">* 항목은 필수 사항입니다.</span>
        </div>		
        <div class="member-sign-column">
        	<input disabled type="submit" id="modify-submit" value="수정">
        </div>
	
   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		
		<script src="/js/members/modify.js"></script>
		
		<my:bottom></my:bottom>	
	</body>
</html>