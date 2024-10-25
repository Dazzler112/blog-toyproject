
$("#about-post_submit").click(function(){
	const memberId = "dummy";
	// const body = $("#about-post_body").val();
	const getbody = document.querySelector("#about-body");
	
	$.ajax(`/about/${memberId}/post`, {
		method: "post",
		contentType: "application/json",
		success: function(result) { // 결과 성공 콜백함수
			console.log(result.body);
			getbody.html(`<p>${result.body}</p>`);
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error)
		}
	});
});