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
	<div class="find_id-main-container">
		<div style="display: flex; justify-content: center;">
      		<div>		
				<!--메일-->
				 <div class="sign-column">
	              <div style="margin-bottom: 10px;">
	              	<span>email</span>
	              </div>
	              <input type="text" id="find-email" name="email" maxlength="20">
	            </div>
   
            </div> 
		</div>
		<br>
        <div class="member-sign-column">
        	<input type="submit" id="email-btn" value="ID찾기">
        </div>	

        <div id="findid_div"></div>
	</div>
		<my:bottom></my:bottom>	
		
   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		
		<script src="/js/members/findid.js"></script>
	</body>
</html>