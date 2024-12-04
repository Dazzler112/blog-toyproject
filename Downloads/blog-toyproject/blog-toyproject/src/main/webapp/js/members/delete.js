$("#delete-submit").click(function(){
	const member_id = $("#delete-member_id").val();
	const authorityId = $("#delete-authmember_id")
	
	$.ajax(`/members/remove`, {
		method: "post",
		contentType: "application/json",
        data: JSON.stringify({
			"MEMBERS.member_id" : member_id,
			"MEMBERAUTHORITY.member_id" : authorityId
        }),	
		success: function(result) { // 결과 성공 콜백함수
			/*console.log(result);*/
			console.log(result);
			
			window.location.href = "/0/0";
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
		},
	});
});