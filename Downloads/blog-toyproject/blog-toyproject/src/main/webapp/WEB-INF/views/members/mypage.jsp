<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
	<div class="user_main-container">
		<div style="display: flex; justify-content: center;">
			<div>

				<div class="user-column">
					<sec:authorize access="isAuthenticated()">
						<li><a href="/3?member_id=<sec:authentication property="name" />" class="user_href">Member Modify</a></li>
					</sec:authorize>
				</div>

				<div class="user-column">
					<sec:authorize access="isAuthenticated()">
						<li><a href="/4?member_id=<sec:authentication property="name" />" class="user_href">Member Delete</a></li>
					</sec:authorize>
				</div>
				
				<div class="user-column">
					<sec:authorize access="hasAuthority('admin')">	
						<li><a href="/manage" class="user_href">User Manage</a></li>
					</sec:authorize>
				</div>

			</div>
		</div>
	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/members/findid.js"></script>
	
<my:bottom></my:bottom>
</body>

</html>