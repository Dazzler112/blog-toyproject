<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<style>
body {
	margin: 0px 55px;
}
.about-title{
	display: flex;
	justify-content: center;
}
#about-body{
	display: flex;
	justify-content: center;
	padding: 0px 200px;
	margin: 0px 80px;
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
		<div class="about-title">
			<H1>About The Blog</H1>
		</div>
		<br>
		<div>
			<div style="display:none;"><span id="about-id_text"></span></div>
			<div id="about-body">
				<!-- <span id="about-body_text"></span> -->
			</div>
		</div>
		<div style="display:flex; justify-content: right;">
			<a href="/about/post"><button id="post-button" style="display:none; margin-right: 10px;">게시</button></a>
			<a href="/about/post/-1"><button>수정</button></a>
		</div>
	
   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		
		<script src="/js/about/aboutget.js"></script>
	</body>
</html>