
$("#about-post_submit").click(function(){
	const memberId = "dummy";
	// const body = $("#about-post_body").val();
	const getbody = document.querySelector("#about-body");
	const bodyContent = $("#about-post_body").val();
	
	$.ajax(`/about/${memberId}/post`, {
		method: "post",
		contentType: "application/json",
        data: JSON.stringify({
            body: bodyContent,
            writer: memberId, // 필요한 다른 필드들도 추가 가능
        }),		
		success: function(result) { // 결과 성공 콜백함수
			console.log(result);
			showAlert("게시물이 성공적으로 등록되었습니다.", "success");
			setTimeout(() => {
                window.location.href = "/about";
            }, 2000); // 2초 후 이동
			
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			showAlert("게시물 등록중 이상이 발생하였습니다.", "error");
			console.log(error + "잘못된 방식");
		},
	});
});