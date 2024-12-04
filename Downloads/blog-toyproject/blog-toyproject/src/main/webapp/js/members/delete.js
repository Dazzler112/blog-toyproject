$("#delete-submit").click(function(){
	const password = $("#modify-password").val();
	const member_id = $("#delete-member_id").val();
	
	$.ajax(`/members/remove`, {
		method: "post",
		contentType: "application/json",
        data: JSON.stringify({
			member_id : member_id
        }),	
		success: function(result) { // 결과 성공 콜백함수
			/*console.log(result);*/
			console.log(result);
			
			window.location.href = "/about";
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
		},
	});
});