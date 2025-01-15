<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<style>
</style>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Review Pages</title>

<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="signup_main-container">
			<div class="member_signup-cancel">
				<a style="text-decoration: none; " href="/main">⨉</a>
			</div>
			<div class="sign_up-title">
				<h1>Sign Up</h1>
			</div>
		<div style="display: flex; justify-content: center;">
			<div>
				<input id="authority-space" type="text" name="authority" value="user" style="display: none;"> <input id="membertype-space" type="text" name="member_type" value="user" style="display: none;">
				<!--아이디-->
				<div class="sign-column">
					<div>
						<span style="margin-right: 50px;">ID</span>
					</div>
					<input type="text" class="sign-input" id="input-id" name="member_id" maxlength="20" placeholder="영문 또는 영문 숫자 조합으로 6~20자"> 
					<input class="check-button" type="button" id="id-Confirm" value="check">
					<div id="idcheck-blank" style="margin-left: 10px;"></div>
				</div>
				<!--패스워드-->
				<div class="sign-column">
					<div>
						<span style="margin-right: 35px;">Password</span>
					</div>
					<input type="password" class="sign-input" id="input-password" name="password" placeholder="영문,숫자,특수문자 조합하여 8~20자리" maxlength="20">
					<div style="margin-left: 10px;" id="pwdcheck-blank1"></div>
				</div>
				<!--패스워드 확인-->
				<div class="sign-column">
					<div>
						<span>Password Check</span>
					</div>
					<input type="password" class="sign-input" id="password-check" name="password-check" placeholder="위와 동일하게 입력해주세요" maxlength="20">
					<div style="margin-left: 10px;" id="pwdcheck-blank2"></div>
				</div>
				<!--이름-->
				<div class="sign-column">
					<div>
						<span style="margin-right: 65px;">Name</span>
					</div>
					<input type="text" class="sign-input" id="input-name" name="name" placeholder="한글 또는 영어로 입력해주세요" maxlength="20">
					<div style="margin-left: 10px;" id="namecheck-blank"></div>
				</div>
				<!--폰번호-->
				<div class="sign-column">
					<div>
						<span style="margin-right: 35px;">Phone Number</span>
					</div>
					<input type="number" id="phone-num" name="phone_number">
					<button class="check-button" type="button" id="checkPhoneNumBtn">check</button>
					<div style="margin-left: 10px;" id="phonecheck-blank"></div>
				</div>
				<!--이메일-->
				<div class="sign-column">
					<div>
						<span style="margin-right: 35px;">Email</span>
					</div>
					<input type="text" id="mail-sign" name="email">
					<button class="check-button" type="button" id="checkmailBtn">check</button>
					<input style="display: none;" type="button" class="check-button" id="checkEmailBtn" value="인증하기">
					<div style="margin-left: 10px;" id="mailcheck-blank"></div>
				</div>
				<!--이메일 인증-->
				<!-- 	            <div class="sign-column">
	              <input type="hidden" id="totalemail" name="email">
	              <div class="d-none form-text text-primary" id="validEmailId"></div>	
                </div>   -->
				<!-- 인증번호 입력 칸 -->
				<div style="display: none;" id="inputVerificationCode">
					<div class="input-group">
						<input type="text" class="form-control" id="verificationCode" name="verificationCode" placeholder="인증번호를 입력하세요" />
						<button type="button" id="verifyEmailBtn" style="display: none;">확인</button>
						<div id="validEmailMessage"></div>
					</div>
				</div>


			</div>
		</div>
		<br>
		<div style="display: flex; justify-content: center;">
			<span id="need-sign" style="color: rgba(252, 168, 149, 0.7); font-size: 9px; margin-bottom: 8px;">* 항목은 필수 사항입니다.</span>
		</div>
		<div class="member-sign-column">
			<input disabled type="submit" id="signup-submit" value="Sign Up">
		</div>
	</div>


	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/members/signup.js"></script>
	<script src="/js/members/signupvalidation.js"></script>
</body>
</html>