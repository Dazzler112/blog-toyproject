<%@ tag language="java" pageEncoding="UTF-8"%>
<style>
nav{
	margin: 20px 0px;
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
		<a href="#">
		사진<img alt="#" src="#">
		</a>
	</div>
	<ul class="ul-nav-style">
		<li><a href="/post">Home</a></li>
		<li><a href="/about">About</a></li>
		<li><a href="#">Login/Logout</a></li>
	</ul>
</nav>