
$("#about-update_submit").click(function(){
	const memberId = "dummy";
	const boardId = 1;
	// const body = $("#about-post_body").val();
	const bodyContent = $("#about-update_body").val();
	
	$.ajax(`/about/${memberId}/post/${boardId}`, {
		method: "put",
		contentType: "application/json",
        data: JSON.stringify({
            body: bodyContent,
            member_id : memberId, // 필요한 다른 필드들도 추가 가능
            about_id : boardId
        }),		
		success: function(result) { // 결과 성공 콜백함수
			console.log(result);
			showAlert("게시물이 성공적으로 수정되었습니다.", "success");
			setTimeout(() => {
                window.location.href = "/about";
            }, 2000); // 2초 후 이동
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
			showAlert("게시물 수정중 이상이 발생하였습니다.", "error");
		},
	});
});