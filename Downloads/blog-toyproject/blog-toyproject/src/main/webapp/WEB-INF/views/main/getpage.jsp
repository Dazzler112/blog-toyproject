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
   bottom: 0;
   right: 0;
   margin: 0px, 30px, 30px, 0px;
}
/*===================*/
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
				<div><input id="board_id" type="text" name="board_id" style="display:none; " readonly /></div>
				<div class="top-info">
					<div>
						<span id="board_writer">writer</span>
						<span id="board_writedate">date</span>					
					</div>
						<a><span>⋮</span></a>
					<div>
					</div>					
				</div>
				<div class="title-info">
					<h3 id="board-title">title</h3>
				</div>
				<br>
				<div class="body-info">
					<div>
						<img  id="board-img" src="" />
					</div>
					<div>
						<span id="board-body">body</span>
					</div>
				</div>
	
				<div>
					<div class="">
					
					
					</div>
					<div class="">

					</div>
				</div>
			</div>

			
						
		   <div class="div_writer">
		      <a href="/main/post" class="writer_link-color">
		         <div class="board_writer-icon">
		            <span>🖍</span>
		         </div>
		      </a>
		   </div>
   			
		</div>
		
		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/main/view.js"></script>
	<script>
		const boardId = "${board_id}";
	</script>
	</body>
</html>