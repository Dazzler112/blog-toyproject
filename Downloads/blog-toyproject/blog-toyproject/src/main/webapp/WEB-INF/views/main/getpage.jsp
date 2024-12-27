<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<style>
body {
	margin: 0px 55px;
}
.main-container {
	margin: 150px 250px 30px 250px;
}
.top-container {
    display: flex;
    justify-content: space-between;
    margin: 0px 0px 45px 0px;
}
.center-container {
	border: 0.5px solid rgba(0,0,0,0.3);
	text-align: center;
	justify-content: center;
	align-items: center;
}
.top-info {
	display: flex;
	justify-content: space-between;
}
.body-info {
	text-align: center;
	align-items: center;
}

/* 여기부터 삭제모달 */
.modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal-content {
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    text-align: center;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

.button-style {
    margin: 5px;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.confirm-btn {
    background-color: #4CAF50;
    color: white;
}

.cancel-btn {
    background-color: #f44336;
    color: white;
}
/* 여기까지 삭제 모달 */

.view_list-all {
    display: flex;
    justify-content: space-between;
    margin: 0px 0px 20px 0px;
}

.list_view-container{
	margin-bottom: 20px;
	border: 0.5px solid rgba(0,0,0,0.3);
	text-align: center;
	justify-content: center;
	align-items: center;
}
.comment-container {
	margin-top: 10px;
	border: 0.5px solid rgba(0,0,0,0.3);
	text-align: center;
	justify-content: center;
	align-items: center;
}
.comment_count-container {
	display: flex;
	margin-bottom: 20px;
	padding: 0px 20px;
}
.comment_count-container-sub {
	border-bottom: 0.5px solid rgba(0,0,0,0.3);
}

.comment_write-container {
	margin-bottom: 20px;
}
.comment_write-container-btn {
	display: flex;
}
.count_container {
	display: flex;
	justify-content: space-between;
	margin: 20px;
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
	
		<div class="main-container">
		
			<div class="top-container">
				<div><a href="#">All Posts</a></div>
				<div>
					<input type="search">
					<input type="button" value="🔍">
				</div>
			</div>
			
			<div id="board-container" class="center-container">
				<div><input id="board_get-id" type="text" name="board_id" style="display:none; " readonly /></div>
				<div class="top-info">
					<div>
						<span id="board_get-writer">writer</span>
						<span id="board_get-writedate">date</span>					
					</div>
						<a><span>⋮</span></a>
					<div>
					</div>					
				</div>
				<div class="title-info">
					<h3 id="board_get-title">title</h3>
				</div>
				<br>
				<div class="body-info">
					<div>
						<img id="board_get-img" src="" />
					</div>
					<div>
						<span id="board_get-body">body</span>
					</div>
				</div>
				
			<div>
				<div>
					<div class="">
					
					
					</div>
					<div class="">

					</div>
				</div>
			</div>
				
				<div class="count_container">
					<div class="">
						<span>views</span>
						<span>comment</span>
					</div>
					<div class="">
						<button id="getboard_list-likecount"><span id="getboard_likeheart">🤍</span></button>
					</div>
				</div>
				
			</div>

			
		   <div style="display: flex; margin: 20px 0px;">			
			   <div class="div_modify">
			      <button class="button-style" id="modify-link">수정</button>
			   </div>
			   
			   <div id="deleteModal" class="modal" style="display:none;">
				    <div class="modal-content">
				        <p>정말 해당 게시글을 삭제하시겠습니까?</p>
				        <button id="confirmDelete" class="confirm-btn">예</button>
				        <button id="cancelDelete" class="cancel-btn">아니오</button>
				    </div>
			   </div>
				<div class="div_removee">
				  <button class="button-style" id="remove_post-btn">삭제</button>
			   </div>
   		   </div>
   		   	
			<div class="view_list-all">
				<div class="view_list-elem"><span>Recent Post</span></div>
				<div class="view_list-elem"><span>See All</span></div>
			</div>	
   			
   			<div class="list_view-container">
   				<img src="#">
   			</div>
   			
   			<div class="comment-container">
   				<div class="comment_count-container">
	   				<div class="comment_count-container-sub">
	   				<span>Comment</span>
	   				</div>
   				</div>
   				<div class="comment_write-container"><input type="text"/></div>
   				<div class="comment_write-container-btn">
   					<button id="comment_cancle-btn">Cancel</button>
   					<button id="comment_publish-btn">Publish</button>
   				</div>
   				<div class="comment_reply-container"></div>
   			</div>
   			
		</div>
		
		
		
		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/main/view.js"></script>
	<script src="/js/main/delete.js"></script>
	<script src="/js/main/likepost.js"></script>
	</body>
</html>