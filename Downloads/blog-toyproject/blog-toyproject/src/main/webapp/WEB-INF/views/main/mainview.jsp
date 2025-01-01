<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<style>
body {
	margin: 0px 55px;
}
.main-container {
	margin: 0px 250px 90px 250px;
}

.center-container {
	border: 0.5px solid rgba(0,0,0,0.3);
	display: flex;
	justify-content: space-between;
	text-align: center;
}

/* 글쓰기버튼 css */
.writer_link-color {
   color: rgba(0, 0, 0, 0.5);
   font-size: 18px;
   text-decoration: none;
   color: white;
}

.board_writer-icon {
   display: flex;
   justify-content: center;
   align-items: center;
   background-color: black;
   padding: 16px;
   border-radius: 50%;
}

.div_writer {
   margin-bottom: 50px;
   margin-right: 30px;
   position: fixed;
   bottom: 40;
   right: 0;
   margin: 0px, 30px, 30px, 0px;
   z-index: 1;
}
/*===================*/
.get-view{
	text-decoration: none;
	color: black;
	z-index: -1;
}
#board_likeheart {
	cursor: pointer;
}

#photo_img-id {
	width: 100%;  /* 너비를 부모에 맞춤 */
    height: 100%; /* 높이를 부모에 맞춤 */
    object-fit: cover;
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
	<my:search></my:search>
		<div class="main-container">
			
		<c:forEach items="${boardList}" var="board">
			<div id="board-container" class="center-container">
			<c:forEach items="${board.photo_name}" var="photo">
				<div>
					<a class="get-view" href="/main/${board.board_id}" data-board-id="${board.board_id}">
					<img id="photo_img-id" src="${bucketUrl}/${board.board_id}/${photo}" />
					</a>
				</div>
			</c:forEach>	
				<div>
					<div><input id="board_id-value" type="text" name="board_id" value="${board.board_id}" style="display:none; " readonly /></div>
					<div class=""><a><span>⋮</span></a></div>
					<a class="get-view" href="/main/${board.board_id}" onclick="getBoard(${board.board_id})">
						<div class="">
						<h3 id="board-title">${board.title}</h3>
						<span id="board-body">${board.body}</span>
						</div>
					</a>
					<div class="">
						<div>
						<span>views</span>
						<span>comment</span>
						</div>
						<div>
			            <span id="board_likeheart">
			            	<c:if test="${board.liked}"> 
			            		🧡
			            	</c:if>
			            	<c:if test="${not board.liked}"> 
			            		🤍
			            	</c:if>			            	
			            </span>
            			<span id="like-number">${board.like_count}</span> 						
						</div>
					</div>
				</div>
			</div>
			<br>
		   </c:forEach>	
			
						
   <div class="div_writer">
      <a href="/main/post" class="writer_link-color">
         <div class="board_writer-icon">
            <span>🖍</span>
         </div>
      </a>
   </div>
   			
		</div>
		
		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/main/likepost.js"></script>	
	
	<my:bottom></my:bottom>	
	</body>
</html>