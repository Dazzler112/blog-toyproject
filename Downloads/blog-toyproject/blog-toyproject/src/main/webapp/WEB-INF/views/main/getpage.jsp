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
	<my:search></my:search>
	<my:message></my:message>
		<div class="main-container">
			
			<div id="board_get-container" class="getpage_center-container">
				<div><input id="board_get-id" type="text" name="board_id" style="display:none; " readonly /></div>
				<div class="top-info">
					<div class="writer_container">
						<span id="board_get-writer">writer</span>
						<span style="margin: 0px 10px;">•</span>
						<span id="board_get-writedate">date</span>					
					</div>
					<div>
						<a><span>⋮</span></a>
					</div>					
				</div>
				<div class="title-info">
					<h3 id="board_get-title">title</h3>
				</div>
				<br>
				<div class="body-info">
					<div class="board_get-img-container">
						<img id="board_get-img" src="" />
					</div>
					<div class="board_get-body-container">
						<span id="board_get-body">body</span>
					</div>
				</div>
				
			<div class="share_link-container">
				<span class="get_page-link">🔗</span>
			</div>
				
				<div class="count_container">
					<div class="">
						<span id="get_count-views"></span><span>views</span>
						<span id="get_count-comment"></span><span>comment</span>
					</div>
					<div class="">
						<span id="getboard_likeheart">🤍</span>
					</div>
				</div>
				
			</div>

			
		   <div style="display: flex; margin: 20px 0px;">			
			   <div class="div_modify">
			      <button class="button-style" id="modify-link">수정</button>
			   </div>

				<div class="div_removee">
				  <button class="button-style" id="remove_post-btn">삭제</button>
			   </div>
   		   </div>
   		   
   		   		<div id="deleteModal" class="modal" style="display:none;">
				    <div class="modal-content">
				        <p>정말 해당 게시글을 삭제하시겠습니까?</p>
				        <button id="confirmDelete" class="confirm-btn">예</button>
				        <button id="cancelDelete" class="cancel-btn">아니오</button>
				    </div>
			   </div>
   		   	
			<div class="view_list-container">
				<div >
				
					<div class="view-list-all">
						<div>
							<span>Recent Post</span>
						</div>
						<div>
							<a href="/main" class="see_all-button"><span>See All</span></a>
						</div>
					</div>
					
				<div style="display: flex; justify-content: space-between;">		
						<div class="list_view-container list_view-container-f" data-board-id="${board.board_id}">
							<input type="text" class="list_view-id" hidden>
							<div class="extra_img-list-container">
			   				<a class="list-view_get" href=""><img class="list_view-img" src="#"></a>
			   				</div>
			   				<div style="padding: 0px 25px;">
				   				<div class="extra_title-list-container">
				   					<a class="list-view_get" href=""><h2 class="list_view-title">title</h2></a>
				   				</div>
			   				</div>
			   				<div class="list_view-status">
			   					<div style="color: rgba(0,0,0,0.6); font-size: 14px;"><span class="list_view-count">👁</span><span class="list_view-comment">🗨</span></div>
			   					<div><span class="list_view-likeheart">🤍</span></div>
			   				</div>
			   			</div>
			   							
						<div class="list_view-container list_view-container-b" data-board-id="${board.board_id}">
							<input type="text" class="list_view-id" hidden>
							<div class="extra_img-list-container">
			   				<a class="list-view_get" href=""><img class="list_view-img" src="#"></a>
			   				</div>
			   				<div style="padding: 0px 25px;">
				   				<div class="extra_title-list-container">
				   					<a class="list-view_get" href=""><h2 class="list_view-title">title</h2></a>
				   				</div>
			   				</div>
			   				<div class="list_view-status">
			   					<div style="color: rgba(0,0,0,0.6); font-size: 14px;"><span class="list_view-count">👁</span><span class="list_view-comment">🗨</span></div>
								<div><span class="list_view-likeheart">🤍</span></div>
			   				</div>
			   			</div>
			   			
						<!-- Previous Extra 첫 번째 게시물 -->
						<div class="list_view-container list_view-container-extra-1" data-board-id="${board.board_id}">
						    <input type="text" class="list_view-id" hidden>
						    <div class="extra_img-list-container">
						        <a class="list-view_get" href=""><img class="list_view-img" src="#"></a>
						    </div>
						    <div style="padding: 0px 25px;">
							    <div class="extra_title-list-container">
							        <a class="list-view_get" href=""><h2 class="list_view-title">title</h2></a>
							    </div>
						    </div>
						    <div class="list_view-status">
						        <div style="color: rgba(0,0,0,0.6); font-size: 14px;"><span class="list_view-count">👁</span><span class="list_view-comment">🗨</span></div>
						        <div><span class="list_view-likeheart">🤍</span></div>
						    </div>
						</div>
						
						<!-- Previous Extra 두 번째 게시물 -->
						<div class="list_view-container list_view-container-extra-2" data-board-id="${board.board_id}">
						    <input type="text" class="list_view-id" hidden>
						    <div class="extra_img-list-container">
						        <a class="list-view_get" href=""><img class="list_view-img" src="#"></a>
						    </div>
						    <div style="padding: 0px 25px;">
							    <div class="extra_title-list-container">
							        <a class="list-view_get" href=""><h2 class="list_view-title">title</h2></a>
							    </div>
						    </div>
						    <div class="list_view-status">
						        <div style="color: rgba(0,0,0,0.6); font-size: 14px;"><span class="list_view-count">👁</span><span class="list_view-comment">🗨</span></div>
						        <div><span class="list_view-likeheart">🤍</span></div>
						    </div>
						</div>			   			
		   			
		   			</div>
   					
   				</div>	
   							
			</div>	
   			
   			<div class="comment-container">
   				<div style="padding: 20px 100px;">
   				<div class="comment_count-container">
	   				<div class="comment_count-container-sub">
	   					<span id="comment_count-id"></span> <span>Comment</span>
	   				</div>
   				</div>
   				</div>
   				<div class="comment_write-container">
   					<textarea placeholder="Write a comment..." rows="6" cols="120" id="comment_write-box"></textarea>
   				</div>
   				<div class="comment_write-container-btn">
   				</div>
   				<div id="comment_reply-container"></div>
   				<div class="update_comment-container">

				</div>
   			</div>
   			
		</div>
		
		
		
		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/main/view.js"></script>
	<script src="/js/main/delete.js"></script>
	<script src="/js/main/likepost.js"></script>
	<script src="/js/main/comment.js"></script>
	<script src="/js/main/viewcontainer.js"></script>
	
	<my:bottom></my:bottom>	
	</body>
</html>