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
			
			showAlert("계정 삭제 완료.", "success");
			// 페이지 이동을 잠시 딜레이하여 메시지를 확인할 시간 제공
            setTimeout(() => {
                window.location.href = "/0/0";
            }, 1000); // 1초 후 이동
			
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
			showAlert("삭제중 이상이 발생하였습니다.", "error");
		},
	});
});