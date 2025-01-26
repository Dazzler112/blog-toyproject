<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
body {
	margin: 0px 0px;
}
nav{
	padding: 30px 70px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	text-align: center;
	text-decoration: none;
	background-color: black;
}

nav a {
	text-decoration: none;
}
.nav-li-a_style{
	color: white;
}
.ul-nav-style{
	display: flex;
	list-style: none;
}

.ul-nav-style li a{
	margin: 0px 10px;
	text-decoration: none;
	color: black;
}
.nav_li-mypage {
	padding: 7px;
	background-color: #a0a09f;
	border-radius: 50%;
	color: #cccccc;
}
</style>
<body>
	<nav>
		<div>
			<a href="/main">
				<img src="/img/signature.jpg" style="width: 60px;  height: 60px; ">
			</a>
		</div>
		<ul class="ul-nav-style">
			<li><a href="/main"><span class="nav-li-a_style">Home</span></a></li>
			<li><a href="/about"><span class="nav-li-a_style">About</span></a></li>
			<sec:authorize access="isAnonymous()">
				<li><a href="/1"><span class="nav-li-a_style">Log in / Sign up</span></a></li>
			</sec:authorize>	
			<sec:authorize access="isAuthenticated()">
	        	<li><a href="/0/0"><span class="nav-li-a_style">Logout</span></a></li>
	        </sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li><a href="/2"><span class="nav-li-a_style nav_li-mypage">👤</span></a></li>
			</sec:authorize>			
		</ul>
	</nav>
</body>