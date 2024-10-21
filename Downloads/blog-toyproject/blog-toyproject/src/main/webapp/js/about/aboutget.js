let aboutValue = "all";

listAbout(aboutValue);

function listAbout() {
	const memberId = "dummy";
	const aboutId = 1;

	/*const requestMemberId = {
		member_id : "dummy"
	};
	
	const requestAboutId = {
		about_id : 1
	};
	
	
	const param1 = new URLSearchParams(requestMemberId).toString();
	const param2 = new URLSearchParams(requestAboutId).toString();
	*/
	$.ajax(`/about/${memberId}/post/${aboutId}`, {
		method: "get",
		contentType: "application/json",
		success: function(result) { // 결과 성공 콜백함수
			console.log(result.body);
			$("#about-body").html(`<p>${result.body}</p>`);
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error)
		}
	});

}