<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
body {
	margin: 0px 0px;
}
.mcontainer {
	margin: 150px 250px 0px 250px;
}
.top-container {
    display: flex;
    justify-content: space-between;
    margin: 0px 0px 45px 0px;
}
.search_all-post {
	font-size: 13px;
	color: rgba(0,0,0,0.5);
	text-decoration: none;
	transition: 0.1s color ease-in-out;
}

.search_all-post:hover {
	color: rgb(223,173,105);
} 

.search_select {
	border: none;
}
.search_button {
	background-color: transparent;
	border: none;
	cursor: pointer;
}
</style>
<body>
	<div class="mcontainer">
		<div class="top-container">
			<div><a href="/main" class="search_all-post">All Posts</a></div>
			
			<form action="main" class="" role="search">
				<div>
					<select name="type" class="search_select">
						<option value="all">All</option>
						<option value="title" ${param.type eq 'title' ? 'selected' : '' }>title</option>
					</select>
					<input class="search_bar" type="search" value="${param.search}" name="search">
					<button class="search_button" type="submit">
					🔍
					</button>
				</div>
			</form>	
		</div>
	</div>
</body>