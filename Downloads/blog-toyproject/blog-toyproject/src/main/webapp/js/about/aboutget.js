let aboutValue = "all";

listAbout(aboutValue);

function listAbout() {
	const memberId = "dummy";
	const aboutId = 1;

	$.ajax(`/about/${memberId}/post/${aboutId}`, {
		method: "get",
		contentType: "application/json",
		success: function(result) { // 결과 성공 콜백함수
			console.log(result.body);
			$("#about-body").html(`<p>${result.body}</p>`);

				// 해당 게시물ID가 있으면 버튼 숨기기
				if(result.about_id == 1){
					$("#post-button").hide();
				} else if(result.about_id != null || result.about_id == undefined) { // 해당 게시물ID가 없으면 버튼 보이게
					$("#post-button").show();
				}
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error)
		}
	});

}
