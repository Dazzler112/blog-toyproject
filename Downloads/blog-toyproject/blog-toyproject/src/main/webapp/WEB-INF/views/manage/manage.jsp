<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
</style>
<sec:authorize access="hasAuthority('admin')">	
<html>
	<head>
	    <meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Review Pages</title>
		
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	</head>
	<body>	
	<my:message></my:message>	
	<div class="manage_main-container">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Member Type</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${memberList}" var="member">
							<tr>
								<!--어드민은 안보이게 설정-->
								<c:if test="${member.member_type ne 'admin'}">
								
									<td class="manage_user-list">${member.member_id}</td>
									<td class="manage_user-type">${member.member_type}</td>
									<c:if test="${member.member_type eq 'user'}">
										<td><button class="user_block-button">block</button></td>
									</c:if>
									<c:if test="${member.member_type eq 'user0' }">
										<td><button class="user_remove-button">remove</button></td>
									</c:if>
									
								</c:if>
							</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>	
		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/manage/block.js"></script>
	<script src="/js/manage/remove.js"></script>	
	
	</body>
</html>
</sec:authorize>
<c:if test="${member == null or member.member_type ne 'admin'}">
	<h1>잘못된 경로입니다.</h1>
</c:if>