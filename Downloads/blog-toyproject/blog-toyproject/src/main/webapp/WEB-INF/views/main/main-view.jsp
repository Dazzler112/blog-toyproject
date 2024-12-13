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
		</div>
	</body>
</html>