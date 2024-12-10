<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
				
				 <div class="sign-column">
					<sec:authorize access="isAuthenticated()">
						<li><a href="/3?member_id=<sec:authentication property="name" />">Member Modify</a></li>
					</sec:authorize>					
	            </div>
   
   				 <div class="sign-column">
					<sec:authorize access="isAuthenticated()">
						<li><a href="/4?member_id=<sec:authentication property="name" />">Member Delete</a></li>
					</sec:authorize>					
	            </div>
   
            </div> 
		</div>

   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		
		<script src="/js/members/findid.js"></script>
	</body>
</html>