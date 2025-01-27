let checkId = false;
let password_check = false;
let name = false;
let searchEmail = false;
let checkEmail = false;
let checkphoneNumber = false

function enableSubmit() {
    if (checkId && password_check && name && searchEmail && checkEmail && checkphoneNumber) {
        $("#signup-submit").removeAttr("disabled").css({
                "cursor": "pointer",
                "background-color": "rgb(211,151,115)",
                "color": "rgb(154,110,110)"
            });
        $("#need-sign").hide();
        
    } else {
        $("#signup-submit").attr("disabled", "");
        $("#need-sign").show();
    }
}

//==============================아이디 유효성검사 ================================================
$("#input-id").blur(function (){
    let idCheck = /^(?=.*[a-zA-Z])[a-zA-Z0-9]{6,20}$/;

    if($("#input-id").val() == "") {
        $("#idcheck-blank").css("color", "red");
        $("#idcheck-blank").text("! 아이디는 필수 입력");
        id = false;
        enableSubmit();
    }else if(!idCheck.test($("#input-id").val())) {
        $("#idcheck-blank").css("color", "red");
        $("#idcheck-blank").text("! 영문 또는 영문 숫자 조합하여 6~20자만 가능");
        id = false;
        enableSubmit();
    }else {
        $("#idcheck-blank").css("color", "blue");
        $("#idcheck-blank").text("사용 가능한 아이디입니다. 중복확인을 해주세요.");
        id = true;
        enableSubmit();
    }
    if(id == true) {
        $("#id-Confirm").show();
    }else {
        $("#id-Confirm").hide();
    }
});

//==============================아이디 중복검사 ==============================================
$("#id-Confirm").click(function() {
    const member_id = $("#input-id").val();
    if (member_id == "") {
        alert("아이디를 입력해주세요.");
    } else {
        $.ajax(`/members/checkid/${member_id}`,{
			method: "get",
			contentType: "application/json",
            success: function(data) {
                if (data.available) {
                    $("#idcheck-blank").css("color", "blue");
                    $("#idcheck-blank").text("사용가능한 아이디입니다.");
                    checkId = true;
                } else {
                    $("#idcheck-blank").css("color", "red");
                    $("#idcheck-blank").text("! 중복된 아이디입니다.");
                    checkId = false;
                }
            },
            error: function() {
                alert("오류가 발생했습니다. 다시 시도해주세요.");
            }
            /*,complete: enableSubmit*/ /*<= validation 완성되면 해제*/
        });
    }
});

//==============================비밀번호 유효성검사 ==============================================
$("#input-password").blur(function() {
    let pwdCheck= /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;

    if ($("#input-password").val() == "") {
        $("#pwdcheck-blank1").css("color", "red");
        $("#pwdcheck-blank1").text("! 패스워드를 입력해주세요.");
        password = false;
    }
    else if (!pwdCheck.test($("#input-password").val())) {
        $("#pwdcheck-blank1").css("color", "red");
        $("#pwdcheck-blank1").text("! 비밀번호는 영문+숫자+특수문자 조합하여 8~20자리를 사용해야 합니다");
        password = false;
    }else {
        $("#pwdcheck-blank1").css("color", "blue");
        $("#pwdcheck-blank1").text("사용 가능한 비밀번호 입니다. 비밀번호를 확인해주세요");
        password = true;
    }


});

//==============================비밀번호 확인 ==============================================
$("#password-check").blur(function() {
    if($("#password-check").val() == "") {
        $("#pwdcheck-blank2").css("color", "red");
        $("#pwdcheck-blank2").text("! 패스워드를 입력해주세요.");
        password_check = false;
        enableSubmit();
    }
    else if(password == true && $("#input-password").val() == $("#password-check").val()) {
        $("#pwdcheck-blank2").css("color", "blue");
        $("#pwdcheck-blank2").text("비밀번호가 일치합니다.");
        password_check = true;
        enableSubmit();
    }else {
        $("#pwdcheck-blank2").css("color", "red");
        $("#pwdcheck-blank2").text("! 비밀번호를 다시 확인해주세요.");
        $("#password-check").val("");
        password_check = false;
        enableSubmit();
    }

});

//==============================이름 확인 ==============================================
$("#input-name").blur(function() {
    let nameCheck = /^[a-zA-Z가-힣]{2,20}$/;

    if ($("#input-name").val() == "") {
        $("#namecheck-blank").css("color", "red");
        $("#namecheck-blank").text("! 이름은 필수 입력입니다.");
        name = false;
        enableSubmit();
    } else if (!nameCheck.test($("#input-name").val())) {
        $("#namecheck-blank").css("color", "red");
        $("#namecheck-blank").text("! 이름은 한글 또는 영어로 이루어져야 하며, 2자에서 20자 사이여야 합니다.");
        name = false;
        enableSubmit();
    } else {
        $("#namecheck-blank").css("color", "blue");
        $("#namecheck-blank").text("유효한 이름입니다.");
        name = true;
        enableSubmit();
    }
});

//================================연락처=========================================
function maxLengthCheck(object){
    if (object.value.length > object.maxLength) {
        object.value = object.value.slice(0, object.maxLength);
    }
}

$("#phone-num").blur(function() {

    if ($("#phone-num").val() == "") {
        	$("#phonecheck-blank").css("color", "red");
        	$("#phonecheck-blank").text("번호를 입력해 주세요.");		
        	phone_number = false;
        	enableSubmit();
    } 
});

$("#checkPhoneNumBtn").click(function() {
    const phone_number = $("#phone-num").val();
    // 입력한 ID와 ajax 요청 보내서
    $.ajax(`/members/checkphone/${phone_number}`, {
		method: "get",
		contentType: "application/json",
        success: function(data) {

            if (data.available) {
                // 사용 가능하다는 메세지 출력
                $("#phonecheck-blank").css("color", "blue");
                $("#phonecheck-blank").text("사용 가능한 번호입니다.");
                checkphoneNumber = true;
            } else {
                // 사용 가능하지 않다는 메세지 출력
                $("#phonecheck-blank").css("color", "red");
                $("#phonecheck-blank").text("이미 가입된 번호입니다.");
                checkphoneNumber = false;
            }
        },
        /*complete: enableSubmit*/ /*<= 이 부분도 완료되면 해제*/
    })
});

//================================ 이메일 중복 확인 =====================================

$("#checkmailBtn").click(function() {
    const email = $("#mail-sign").val();

    // 이메일이 비어있는 경우에는 중복 확인 버튼 동작하지 않도록 처리
    if (email == "") {
        alert("이메일 주소를 입력해주세요.");
        return;
    }

    // 입력한 ID와 ajax 요청 보내서
    $.ajax(`/searchmail/${email}`, {
        method: "get",
/*        data: {
            email: email
        },*/
        success: function(data) {

            if (data.available) {
                // 사용 가능하다는 메세지 출력
                $("#mailcheck-blank").css("color", "blue");
                $("#mailcheck-blank").text("사용 가능한 메일입니다.");
                $("#mail-sign").prop("disabled", true);
                $("#checkmailBtn").hide();
                $("#checkEmailBtn").show();
                searchEmail = true;
            } else {
                // 사용 가능하지 않다는 메세지 출력
                $("#mailcheck-blank").css("color", "red");
                $("#mailcheck-blank").text("이미 사용중인 메일입니다.");
                searchEmail = false;
            }
        },
        error: function(request, status, error) {
                // 에러 처리 로직 추가
                console.log(error + email);
                showAlert("메일 인증 중 이상이 발생하였습니다.", "error");
        }
    })
});

//================================ 이메일 인증 =========================================
// 이메일 인증 버튼 클릭 이벤트 처리
$("#checkEmailBtn").click(function() {
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
                $("#verifyEmailBtn").show();
            },
            error: function(request, status, error) {
                // 에러 처리 로직 추가
                console.log(error + email);
                showAlert("메일 인증 중 이상이 발생하였습니다.", "error");
            }
        });
    }
});


// 확인 버튼 클릭 이벤트 처리
$("#verifyEmailBtn").click(function() {
    var enteredCode = $("#verificationCode").val();
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
                    $("#verificationCode").prop("disabled", true);
                    $("#verifyEmailBtn").prop("disabled", true);
                    enableSubmit();

                    alert("인증이 완료되었습니다. 회원 가입을 진행합니다.");
                } else {
                    alert("인증번호가 일치하지 않습니다. 다시 확인해 주세요.");
                    $("#validEmailMessage").css("color" , "red");
                    $("#validEmailMessage").text("코드가 일치하지 않습니다");
                }
            },
            error: function(request, status, error) {
                // 에러 처리 로직 추가
                console.log(error + email);
                showAlert("메일 인증 중 이상이 발생하였습니다.", "error");
            }

        });
    }
});