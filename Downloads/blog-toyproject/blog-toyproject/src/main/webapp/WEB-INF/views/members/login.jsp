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
	<div class="main-container">
		<div style="display: flex; justify-content: center;">
			<div>
				<a style="text-decoration: none; " href="/main">X</a>
			</div>
			<form method="post">
				<div class="log_in-title">
					<h1>Log In</h1>
				</div>
				<div class="member_sign-column-link">
					<p>New to this site? </p><a href="/0"><span id="signup-btn"> Sign Up</span></a>
				</div>
				<div>
					<!--아이디-->
					<div class="sign-column">
						<div>
							<span style="margin-right: 50px;">ID</span>
						</div>
						<input type="text" id="id-spc" name="username" maxlength="20">
					</div>
					<!--패스워드-->
					<div class="sign-column">
						<div>
							<span>Password</span>
						</div>
						<input type="password" id="password-spc" name="password" maxlength="16">
					</div>
					<div id="sign-blank">
						<c:if test="${not empty signUpMessage}">
							<p>${signUpMessage}</p>
							<%
							session.removeAttribute("signUpMessage");
							%>
						</c:if>
					</div>

				</div>
				
		<div class="member-sign-column-id">
			<a href="/5" style="color: rgba(0, 0, 0, 0.4);">Forgot ID?</a>
		</div>

		<div class="member-sign-column-password">
			<a href="/6" style="color: rgba(0, 0, 0, 0.4);">Forgot password?</a>
		</div>
		<br>
		<div class="member-sign-column">
			<input type="submit" id="login-btn" value="Log In">
		</div>
				
		</div>
		</form>

	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/members/signup.js"></script>
</body>
</html>