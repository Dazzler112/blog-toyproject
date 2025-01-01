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
		<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">	
		<title>Review Pages</title>
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	</head>
	<body>
	<my:navigation></my:navigation>
		<div style="display: flex; justify-content: center;">
			<form method="post">
      		<div>		
				<!--아이디-->
				 <div class="sign-column">
	              <div>
	              	<span style="margin-right: 50px;">아이디</span>
	              </div>
	              <input type="text" id="id-spc" name="username" maxlength="20">
	            </div>
	             <!--패스워드-->           
	            <div class="sign-column">
	              <div>
	              <span>비밀번호</span>
	              </div>
	              <input type="password" id="password-spc" name="password" maxlength="16">
	            </div>
         		<div id="sign-blank">
         			<c:if test="${not empty signUpMessage}">
         				<p>${signUpMessage}</p>
         				<% session.removeAttribute("signUpMessage"); %>
         			</c:if>
         		</div>
   
            </div> 
		</div>
		<br>
        <div class="member-sign-column">
        	<input type="submit" id="login-btn" value="로그인">
        </div>	
		</form>	
		<br>
        <div class="member-sign-column">
        	<a href="/0"><button id="signup-btn">회원가입</button></a>
        </div>

        <div class="member-sign-column">
        	<a href="/5" style="color: rgba(0,0,0,0.4);">ID 찾기</a>
        </div>	
	
        <div class="member-sign-column">
        	<a href="/6" style="color: rgba(0,0,0,0.4);">PW 찾기</a>
        </div>		
	
   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		
		<script src="/js/members/signup.js"></script>
		
		<my:bottom></my:bottom>	
	</body>
</html>