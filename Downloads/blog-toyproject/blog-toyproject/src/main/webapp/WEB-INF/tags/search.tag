<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
body {
	margin: 0px 0px;
}
.mcontainer {
	margin: 150px 250px 0px 250px;
	padding: 0 20px; /* 좌우 패딩 추가 */
}
.top-container {
    display: flex;
    justify-content: space-between;
    margin: 0px 0px 45px 0px;
    align-items: center;
    flex-wrap: wrap;
    gap: 10px; /* 요소 간 간격 추가 */    
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

.search_bar {
	border: none;
	outline: none;
	border-bottom: 2px solid rgba(0,0,0,0.2);
	transition: 0.2s border-bottom ease-in-out;
}

.search_bar:focus {
	border-bottom: 2px solid rgb(223,173,105);
}

/* 수정된 부분 */
form {
    display: flex; /* 폼 내용을 flexbox로 표시 */
    align-items: center; /* 수직 가운데 정렬 */
    margin-left: auto; /* 폼을 오른쪽으로 밀어냄 */
}

form > div {
    display: flex;
    justify-content: center; /* 자식 요소들을 가운데 정렬 */
    flex-grow: 1; /* 남은 공간을 모두 차지하도록 설정 */
}

/* 미디어 쿼리: 화면 너비에 따른 조정 */
@media (max-width: 768px) {
    .mcontainer {
        margin: 150px 20px 0px 20px;
    }
    .top-container {
        flex-direction: column;
        align-items: center; /* 가운데 정렬 추가 */
    }
    .search_select {
        margin-bottom: 10px;
    }
    form {
        margin-left: 0;
        width: 100%; /* form의 너비를 100%로 설정 */
        justify-content: center; /* form 내부 요소를 가운데 정렬 */
    }
    form > div {
        display: flex;
        width: 100%;
        justify-content: center;
    }
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