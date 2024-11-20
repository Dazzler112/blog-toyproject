<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
		<title>Review Pages</title>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	</head>
	<body>
	<my:navigation></my:navigation>
		<div style="display: flex; justify-content: center;">
      		<div>		
				<input id="authority-space" type="text" name="authority" value="user" style="display: none;">
				<input id="membertype-space" type="text" name="member_type" value="user" style="display: none;">
				<!--아이디-->
				 <div class="sign-column">
	              <div>
	              <span style="margin-right: 50px;">아이디 *</span>
	              </div>
	              <input type="text" class="sign-input" id="input-id" name="member_id" maxlength="20" placeholder="영문 또는 영문 숫자 조합으로 6~20자">
	              <input class="check-button" type="button" id="id-Confirm" value="중복확인">
	              <div id="idcheck-blank" style="margin-left: 10px;"></div>
	            </div>
	            <!--패스워드-->
	            <div class="sign-column">
	              <div>
	              <span style="margin-right: 35px;">비밀번호 * </span>
	              </div>
	              <input type="password" class="sign-input" id="input-password" name="password" placeholder="영문,숫자,특수문자 조합하여 8~20자리" maxlength="20">
	              <div style="margin-left: 10px;" id="pwdcheck-blank1"></div>
	            </div>
	             <!--패스워드 확인-->           
	            <div class="sign-column">
	              <div>
	              <span>비밀번호 확인 * </span>
	              </div>
	              <input type="password" class="sign-input" id="password-check" name="password-check" placeholder="위와 동일하게 입력해주세요" maxlength="20">
	              <div style="margin-left: 10px;" id="pwdcheck-blank2"></div>
	            </div>
	            <!--이름-->
	            <div class="sign-column">
	              <div>
	              <span style="margin-right: 65px;">이 름 * </span>
	              </div>
	              <input type="text" class="sign-input" id="input-name" name="name" placeholder="한글 또는 영어로 입력해주세요" maxlength="20">
	              <div style="margin-left: 10px;" id="namecheck-blank"></div>
	            </div>
	 			<!--폰번호-->
	            <div class="sign-column">
	              <div>
	              <span style="margin-right: 35px;">휴대폰번호</span>
	              </div>
	              <input type="number" id="phone-num" name="phone_number">
	              <button class="check-button" type="button" id="checkPhoneNumBtn">중복확인</button>
	              <div style="margin-left: 10px;" id="phonecheck-blank"></div>
	            </div>            
	 			<!--이메일-->            
	            <div class="sign-column">
	              <div>
	              <span style="margin-right: 35px;">이메일</span>
	              </div>
	              <input type="text" id="mail-sign" name="email">
	              <button class="check-button" type="button" id="checkmailBtn">중복확인</button>
	              <div style="margin-left: 10px;" id="mailcheck-blank"></div>
	            </div>     
	            <!--이메일 인증--> 
	            <div class="sign-column">
	              <input type="hidden" id="totalemail" name="email" value="${members.email}">
	              <input type="button" class="check-button" id="search-email" style="margin-left: -10px;" value="중복확인">
	              <input style="display: none;" type="button" class="check-button" id="checkEmailBtn" value="인증하기">
	              <div class="d-none form-text text-primary" id="validEmailId"></div>	
                </div>  
              <!-- 인증번호 입력 칸 -->
	            <div  style="display: none;" id="inputVerificationCode">
		            <div class="input-group">
			            <input type="text" class="form-control" id="verificationCode" name="verificationCode" placeholder="인증번호를 입력하세요" />
			            <button type="button" id="verifyEmailBtn" style="display: none;">확인</button>
			            <div style="display: none;  color: #4C84F3" id="validEmailMessage"></div>
		            </div>
	            </div>                
                
                       
            </div> 
		</div>
		<br>
        <div class="member-sign-column">
        	<input type="submit" id="signup-submit" value="회원가입">
        </div>
	
   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		
		<script src="/js/members/signup.js"></script>
		<script src="/js/members/signupvalidation.js"></script>
	</body>
</html>