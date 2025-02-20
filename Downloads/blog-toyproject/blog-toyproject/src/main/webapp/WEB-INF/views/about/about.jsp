<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	
	</body>
	<body>
	<my:navigation></my:navigation>
		<div class="about-container">
			<div class="about-title">
				<H1>About The Blog</H1>
			</div>
			<br>
			<div class="about_body-container">
				<div style="display:none;"><span id="about-id_text"></span></div>
				<div id="about-body">
					<!-- <span id="about-body_text"></span> -->
				</div>
			</div>
			<sec:authorize access="hasAuthority('admin')">
				<div style="display:flex; justify-content: right;">
					<a href="/about/post"><button id="post-button" style="display:none; margin-right: 10px;">게시</button></a>
					<a href="/about/post/-1"><button>수정</button></a>
				</div>
			</sec:authorize>
			
			
	    <div class="carousel_container"> <!-- 페이지 전체를 중앙 정렬하는 컨테이너 -->
	        <div class="carousel">
	                <input name="aphoto_id" value="${aboutImg.aphoto_id}" hidden readonly>
	            <div class="carousel-track">
	                <img src="${bucketUrl}/About/${aboutImg.aphoto_id}/${aboutImg.photo_name[0]}" alt="Image 1">
	                <img src="${bucketUrl}/About/${aboutImg.aphoto_id}/${aboutImg.photo_name[1]}" alt="Image 2">
	                <img src="${bucketUrl}/About/${aboutImg.aphoto_id}/${aboutImg.photo_name[2]}" alt="Image 3">
	                <img src="${bucketUrl}/About/${aboutImg.aphoto_id}/${aboutImg.photo_name[3]}" alt="Image 4">
	                <img src="${bucketUrl}/About/${aboutImg.aphoto_id}/${aboutImg.photo_name[4]}" alt="Image 5">
	            </div>
	        </div>
	    </div>	
		<c:if test="${not empty aboutImg}">	
			<style>
				#about_create_img-btn-div {display: none;}	
			</style>
		</c:if>	
		
		<sec:authorize access="hasAuthority('admin')">
			<div class="about_img-create-div" id="about_create_img-btn-div"><a class="about_img-create-btn" href="/about/img">게시</a></div>	
			<div class="about_img-update-div" id="about_update_img-btn-div"><a class="about_img-update-btn" href="/about/updateimg/${aboutImg.aphoto_id}">수정</a></div>	
		</sec:authorize>
		
		</div>
	
   		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>		
		<script src="/js/about/aboutget.js"></script>
		
		<my:bottom></my:bottom>	
	</body>
</html>