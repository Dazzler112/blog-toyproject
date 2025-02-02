$("#add-writer-button").click(function(){

	event.preventDefault();
	
	// 버튼 여러 번 클릭 방지
    const $button = $(this);
    if ($button.prop("disabled")) return; // 이미 비활성화된 경우 중복 실행 방지
    $button.prop("disabled", true); // 버튼 비활성화
	
	const now = new Date();
	const koreaTime = new Date(now.getTime() + (9* 60 * 60 * 1000)); // UTC+9
	const formattedDate = koreaTime.toISOString().slice(0, 16).replace("T", " "); // "YYYY-MM-DD HH:mm"
	
	const formData = new FormData();
	formData.append("title", $("#add-title").val());
	formData.append("body", $("#add-body").val());
	formData.append("category", $("#game-category").val());
	formData.append("write_date", formattedDate);
	
	const files = $("#add-file")[0].files;
	if(files.length > 0) { //파일이 존재하는 경우만 실행되게 하니면 해당 for문실행x
		for (let i = 0; i < files.length; i++) {
			formData.append("photoFile" ,files[i]);
		}
	}
	
	$.ajax(`/post/addpost`, {
		method: "post",
        data: formData,		
        processData: false, // FormData 처리 설정
        contentType: false, // FormData 처리 설정
		success: function(result) { // 결과 성공 콜백함수
			/*console.log(result);*/
			showAlert("게시물이 성공적으로 등록되었습니다.", "success");
			// 페이지 이동을 잠시 딜레이하여 메시지를 확인할 시간 제공
            setTimeout(() => {
                window.location.href = "/main";
            }, 2000); // 2초 후 이동
            
			console.log(result + "성공");
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			showAlert("게시물 등록에 실패했습니다.", "error");
			console.log(error + "잘못된 방식");
			
			$button.prop("disabled", false);
		},
	});
});