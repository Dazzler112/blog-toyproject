
$("#findid-btn").click(function(){
	const member_id = $("#find-id").val();
	
	$.ajax(`/members/modify`, {
		method: "post",
		contentType: "application/json",
        data: JSON.stringify({
			member_id : member_id
        }),		
		success: function(result) { // 결과 성공 콜백함수
			/*console.log(result);*/
			console.log(result);
			if(MEMBERS.getMeber_Id == member_id) {
				$("#sign-blank").html(<p>로그인 생성이 완료되었습니다.</p>);
			}
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
		},
	});
});