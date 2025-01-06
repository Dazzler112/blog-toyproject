<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	<div class="main-container">
		<input type="text" id="delete-member_id" name="member_id" value="${member.member_id}" style="display: none;" readonly>
		<input type="text" id="delete-authmember_id" name="member_id" value="${memberAuth.member_id}" style="display: none;" readonly>
        <div style="display: flex; justify-content: center;">
        	<span id="need-sign" style="color: rgba(252, 168, 149, 0.7); font-size: 9px; margin-bottom: 8px;">* 항목은 필수 사항입니다.</span>
        </div>		
        <br>
        <div class="member-sign-column">
        	<input type="submit" id="delete-submit" value="계정삭제">
        </div>
	</div>
	
		<my:bottom></my:bottom>	
		
   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		
		<script src="/js/members/delete.js"></script>
	</body>
</html>