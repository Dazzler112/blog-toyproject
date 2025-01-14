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
	
	<div class="view_about-container">
	  <div class="view_main-about-img-container">
	    <div class="main-about-img">
	      <img src="/img/signature.jpg" alt="Image 1" class="full-width-img">
	      <div class="view_about-text">
	        <h1>Soo's Best</h1>
	        <span>The Best Game I've Ever Had</span>
	      </div>
	    </div>
	  </div>
	</div>

	<my:search></my:search>	
		<div class="main-container">
			
		<c:forEach items="${boardList}" var="board">
			<div id="board-container" class="center-container">
			<c:forEach items="${board.photo_name}" var="photo">
				<div>
					<a class="get-view" href="/main/${board.board_id}"  data-board-id="${board.board_id}">
						<img id="photo_img-id" src="${bucketUrl}/${board.board_id}/${photo}" />
					</a>
				</div>
			</c:forEach>	
				<div>
					<div>
						<input id="board_id-value" type="text" name="board_id" value="${board.board_id}"  hidden readonly />
					</div>
					<div class=""><a><span>⋮</span></a></div>
					<a class="get-view" href="/main/${board.board_id}" onclick="getBoard(${board.board_id})" data-board-id="${board.board_id}" >
						<div class="">
						<h3 id="board-title">${board.title}</h3>
						<span id="board-body">${board.body}</span>
						</div>
					</a>
					<div class="active_container" data-board-id="${board.board_id}">
						<div>
						<span>${board.views}</span><span>views</span>
						<span>comment ${board.reply_count}</span>
						</div>
						<div>
				            <span class="board_likeheart">
				            	<c:if test="${board.liked}"> 
				            		🧡
				            	</c:if>
				            	<c:if test="${not board.liked}"> 
				            		🤍
				            	</c:if>			            	
				            </span>
	            			<span class="like-number">${board.like_count}</span> 						
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
	<script src="/js/main/countview.js"></script>
	
	<my:bottom></my:bottom>	
	</body>
</html>