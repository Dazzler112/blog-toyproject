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
	<my:navigation></my:navigation>
	<div class="find_password-main-container">
		<div style="display: flex; justify-content: center;">
			<div>
				<input id="authority-space" type="text" name="authority" value="user" style="display: none;"> <input id="membertype-space" type="text" name="member_type" value="user" style="display: none;">
				<div id="memid" hidden></div>
				<!--이메일-->
				<div class="sign-column">
					<div style="margin-bottom: 10px;">
						<span style="margin-right: 35px;">이메일</span>
					</div>
					<input type="text" id="mail-sign" name="email"> <input type="button" class="check-button" id="pw-checkEmailBtn" value="인증하기">
					<div style="margin-left: 10px;" id="pw-mailcheck-blank"></div>
				</div>
				<!-- 인증번호 입력 칸 -->
				<div style="display: none;" class="sign-column" id="inputVerificationCode">
					<div class="input-group">
						<input type="text" class="form-control" id="verifycode" placeholder="인증번호를 입력하세요" />
						<button type="button" id="codeemail_Btn" style="display: none;">확인</button>
						<div id="validEmailMessage"></div>
					</div>
				</div>

				<!--패스워드-->
				<div style="display: none;" id="pwmodify-div">
					<div class="sign-column">
						<div style="margin-bottom: 10px;">
							<span style="margin-right: 35px;">비밀번호 * </span>
						</div>
						<input type="password" class="sign-input" id="input-password" name="password" placeholder="영문,숫자,특수문자 조합하여 8~20자리" maxlength="20">
						<div style="margin-left: 10px;" id="pwdfindcheck-blank1"></div>
					</div>
					<!--패스워드 확인-->
					<div class="sign-column">
						<div style="margin-bottom: 10px;">
							<span>비밀번호 확인 * </span>
						</div>
						<input type="password" class="sign-input" id="passwordfind-check" name="password-check" placeholder="위와 동일하게 입력해주세요" maxlength="20">
						<div style="margin-left: 10px;" id="pwdfindcheck-blank2"></div>
					</div>
				</div>

			</div>
		</div>
		<br>
		<div class="member-sign-column">
			<input disabled type="submit" id="pwfind-submit" value="변경">
		</div>
	</div>


	<my:bottom></my:bottom>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/members/findpassword.js"></script>
</body>
</html>