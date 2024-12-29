$("#getboard_list-likecount").click(function(){
	
	const board_id = $("#board_get-id").val();
	const data = {board_id};
		
	$.ajax(`/post/like`, {
		method: "post",
		contentType: "application/json",
	      	data: JSON.stringify(data),
			success: function(data) { // 결과 성공 콜백함수
			console.log(data);
			if(data.boardLike) {
				$("#getboard_likeheart").text("🧡");
			}else{
				$("#getboard_likeheart").text("🤍");
			}
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			alert("로그인을 해주세요!");
			console.log(error + "잘못된 방식");
		},
	});
});


$("#board_likeheart").click(function(){
	
	const board_id = $("#board_id-value").val();
	const data = {board_id};
		
	$.ajax(`/post/like`, {
		method: "post",
		contentType: "application/json",
	      	data: JSON.stringify(data),
			success: function(data) { // 결과 성공 콜백함수
			console.log(data);
			location.reload();
/*			if(data.boardLike) {
				$("#board_likeheart").text("🧡");
			}else{
				$("#board_likeheart").text("🤍");
			}
			$("#like-number").text(data.like_count); //<= 이부분 동적으로 바뀌게 해야함*/
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			alert("로그인을 해주세요!");
			console.log(error + "잘못된 방식");
		},
	});
});
