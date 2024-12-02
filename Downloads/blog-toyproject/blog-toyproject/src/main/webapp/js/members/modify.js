let password_check = true;
let password = true;

//===============================유효성 모두 완료되면 수정 가능=======================================
function modiEnableSubmit() {
    if (password) {
        $("#modify-submit").removeAttr("disabled").css("cursor", "pointer");
    } else {
        $("#modify-submit").attr("disabled", "");
    }
}

//==============================비밀번호 유효성검사 ==============================================
$("#modify-password").keyup(function() {
    let pwdCheck= /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
    password_check = false;

    if ($("#modify-password").val() == "") {
        $("#mpwdcheck-blank1").css("color", "red");
        $("#mpwdcheck-blank1").text("패스워드를 입력해주세요.");
        password = false;
        modiEnableSubmit();
    }
    else if (!pwdCheck.test($("#modify-password").val())) {
        $("#mpwdcheck-blank1").css("color", "red");
        $("#mpwdcheck-blank1").text("비밀번호는 영문+숫자+특수문자 조합하여 8~16자리를 사용해야 합니다");
        password = false;
        modiEnableSubmit();
    }else {
        $("#mpwdcheck-blank1").css("color", "blue");
        $("#mpwdcheck-blank1").text("사용 가능한 비밀번호 입니다. 비밀번호를 확인해주세요");
        password = true;
        modiEnableSubmit();
    }


});


$("#modify-submit").click(function(){
	const password = $("#modify-password").val();
	const member_id = $("#search-id").val();
	const oldMember = $("#search-id").val();
	
	$.ajax(`/members/modify`, {
		method: "post",
		contentType: "application/json",
        data: JSON.stringify({
			member_id : member_id,
            password : password 
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