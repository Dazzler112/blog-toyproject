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
			
			<div class="center-container">
				<div>
					<img src="#">
				</div>
				
				<div>
					<div class=""><a><span>⋮</span></a></div>
					<div class="">
					<h3>title</h3>
					<span>text</span>
					</div>
					<div class="">
						<div>
						<span>views</span>
						<span>comment</span>
						</div>
						<div>
						🤍						
						</div>
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
	</body>
</html>