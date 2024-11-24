<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
nav{
	margin: 30px 0px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	text-align: center;
	text-decoration: none;
}

nav a {
	text-decoration: none;
	color: black;
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
</style>

<nav>
	<div>
		<a href="/post">
			<img src="/img/signature.jpg" style="width: 60px;  height: 60px; ">
		</a>
	</div>
	<ul class="ul-nav-style">
		<li><a href="/post">Home</a></li>
		<li><a href="/about">About</a></li>
		<sec:authorize access="isAnonymous()">
		<li><a href="/1">Login/Logout</a></li>
		</sec:authorize>	
		<sec:authorize access="isAuthenticated()">
		<li><a href="/2?id=<sec:authentication property="name" />">Member Modify</a></li>
		</sec:authorize>
	</ul>
</nav>