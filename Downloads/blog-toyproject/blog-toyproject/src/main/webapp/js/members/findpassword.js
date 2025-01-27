let password_check = false;
let checkEmail = false;

function enableSubmit() {
    if (password_check && checkEmail) {
        $("#pwfind-submit").removeAttr("disabled").css("cursor", "pointer");
        $("#need-sign").hide();
    } else {
        $("#pwfind-submit").attr("disabled", "");
        $("#need-sign").show();
    }
}


//================================ 이메일 인증 =========================================
// 이메일 인증 버튼 클릭 이벤트 처리
$("#pw-checkEmailBtn").click(function() {
    // 인증하기 버튼을 클릭하면 인증번호 입력 칸과 확인 버튼을 나타내고, 인증하기 버튼은 숨김
/*    $("#inputVerificationCode").removeAttr("style");
    $("#verifyEmailBtn").show();
    $("#checkEmailBtn").hide();*/

    var email = $("#mail-sign").val();
    if (email) {
        // 이메일 전송 요청
        $.ajax(`/mail/code`, {
            method: "POST",
            data: {
                email: email
            },
            success: function(data) {
				console.log(email);
                // 이메일 전송 성공 시 처리
                $("#mail-sign").prop("disabled", true);
                $("#checkEmailBtn").hide();
                $("#inputVerificationCode").removeAttr("style");
                $("#codeemail_Btn").show();
            },
            error: function(request, status, error) {
                // 에러 처리 로직 추가
                console.log(error);
                showAlert("실행 중 이상이 발생하였습니다.", "error");
            }
        });
    }
});


// 확인 버튼 클릭 이벤트 처리
$("#codeemail_Btn").click(function() {
    var enteredCode = $("#verifycode").val();
    if (enteredCode) {
        // 이메일 전송 요청
        $.ajax(`/mailcheck` ,{
            method: "POST",
            data: {
                enteredCode: enteredCode
            },
            success: function(response) {
                var authentication = response.authentication;
                console.log("authentication => " + authentication);

                if (authentication) {
                    // 인증번호 일치 시 회원 가입 진행
                    checkEmail = true;
                    $("#validEmailMessage").css("color" , "blue");
                    $("#validEmailMessage").text("코드가 일치합니다");
                    $("#verifycode").prop("disabled", true);
                    $("#codeemail_Btn").prop("disabled", true);
                    $("#pwmodify-div").show();
                    $("#memid").html(
                	`<input id="memberId" name="memberId" value="${response.memberId}">`
            		);
                    enableSubmit();

                    alert("인증이 완료되었습니다. 회원 가입을 진행합니다.");
                } else {
                    alert("인증번호가 일치하지 않습니다. 다시 확인해 주세요.");
                    $("#validEmailMessage").css("color" , "red");
                    $("#validEmailMessage").text("코드가 일치하지 않습니다");
                }
            }

        });
    }
});

//==============================비밀번호 유효성검사 ==============================================
$("#input-password").blur(function() {
    let pwdCheck= /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;

    if ($("#input-password").val() == "") {
        $("#pwdfindcheck-blank1").css("color", "red");
        $("#pwdfindcheck-blank1").text("! 패스워드를 입력해주세요.");
        password = false;
    }
    else if (!pwdCheck.test($("#input-password").val())) {
        $("#pwdfindcheck-blank1").css("color", "red");
        $("#pwdfindcheck-blank1").text("! 비밀번호는 영문+숫자+특수문자 조합하여 8~20자리를 사용해야 합니다");
        password = false;
    }else {
        $("#pwdfindcheck-blank1").css("color", "blue");
        $("#pwdfindcheck-blank1").text("사용 가능한 비밀번호 입니다. 비밀번호를 확인해주세요");
        password = true;
    }


});

//==============================비밀번호 확인 ==============================================
$("#passwordfind-check").blur(function() {
    if($("#passwordfind-check").val() == "") {
        $("#pwdfindcheck-blank2").css("color", "red");
        $("#pwdfindcheck-blank2").text("! 패스워드를 입력해주세요.");
        password_check = false;
        enableSubmit();
    }
    else if(password == true && $("#input-password").val() == $("#passwordfind-check").val()) {
        $("#pwdfindcheck-blank2").css("color", "blue");
        $("#pwdfindcheck-blank2").text("비밀번호가 일치합니다.");
        password_check = true;
        enableSubmit();
    }else {
        $("#pwdfindcheck-blank2").css("color", "red");
        $("#pwdfindcheck-blank2").text("! 비밀번호를 다시 확인해주세요.");
        $("#passwordfind-check").val("");
        password_check = false;
        enableSubmit();
    }

});

//================================ 비밀번호 변경 =========================================
$("#pwfind-submit").click(function(){
	const password = $("#input-password").val();
	const member_id = $("#memberId").val();
	$.ajax(`/members/findpw`, {
		method: "post",
		contentType: "application/json",
        data: JSON.stringify({
            password : password,
            member_id : member_id
        }),		
		success: function(result) { // 결과 성공 콜백함수
			/*console.log(result);*/
			console.log(result);
			showAlert("변경 완료.", "success");
			// 페이지 이동을 잠시 딜레이하여 메시지를 확인할 시간 제공
            setTimeout(() => {
                window.location.href = "/about";
            }, 2000); // 2초 후 이동
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
			showAlert("변경 중 이상이 발생하였습니다.", "error");
		},
	});
});