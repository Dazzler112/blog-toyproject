
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
			window.location.href = "/1";
			$("#sign-blank").html(`<p>로그인 생성이 완료되었습니다.</p>`);
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
		},
	});
});