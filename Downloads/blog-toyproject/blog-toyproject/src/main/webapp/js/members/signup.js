
$("#signup-submit").click(function(){
	const memberId = $("#input-id").val();
	const password = $("#input-password").val();
	const name = $("#input-name").val();
	const phoneNum = $("#phone-num").val();
	const mail = $("#mail-sign").val();
	const authority = $("#authority-space").val();
	const memberType = $("#membertype-space").val();
	
	$.ajax(`/members/signup`, {
		method: "post",
		contentType: "application/json",
        data: JSON.stringify({
            member_id : memberId,
            password : password,
            name : name,
            phone_number : phoneNum,
            email : mail,
            authority : authority,
            member_type : memberType
        }),		
		success: function(result) { // 결과 성공 콜백함수
			/*console.log(result);*/
			console.log(authority);
			
			showAlert("회원가입 완료.", "success");
			// 페이지 이동을 잠시 딜레이하여 메시지를 확인할 시간 제공
            setTimeout(() => {
                window.location.href = result;
            }, 2000); // 2초 후 이동			
			
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
			showAlert("가입 중 이상이 발생하였습니다.", "error");
		},
	});
});