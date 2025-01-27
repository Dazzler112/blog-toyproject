
$("#email-btn").click(function(){
	const email = $("#find-email").val();
	
		$.ajax(`/members/findid`, {
			method: "post",
			contentType: "application/json",
	        data: JSON.stringify({
            	email: email
        	}),	
			success: function(data) { // 결과 성공 콜백함수
				/*console.log(result);*/
				console.log(data);
				console.log(email);
				if(data == 0) {
					$("#findid_div").css("color", "red");
					$("#findid_div").text("!해당된 메일이 없습니다.");
				} else {
					$("#findid_div").css("color", "blue");
					$("#findid_div").html("ID는 " + data + "입니다.");
				}
			},
			error: function(request, status, error) { // 결과 에러 콜백함수
				console.log(error + "잘못된 방식");
				showAlert("실행 중 이상이 발생하였습니다.", "error");
			},
		});

});