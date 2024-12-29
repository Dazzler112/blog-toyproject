<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
body {
	margin: 0px 0px;
}
.mcontainer {
	margin: 150px 250px 30px 250px;
}
.top-container {
    display: flex;
    justify-content: space-between;
    margin: 0px 0px 45px 0px;
}
</style>
<body>
	<div class="mcontainer">
		<div class="top-container">
			<div><a href="#">All Posts</a></div>
				<div>
					<input type="search">
					<input type="button" value="🔍">
				</div>
		</div>
	</div>
</body>