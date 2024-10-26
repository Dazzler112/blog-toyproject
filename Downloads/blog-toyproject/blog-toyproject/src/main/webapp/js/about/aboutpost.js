
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
			window.location.href = "/about";
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
		},
	});
});