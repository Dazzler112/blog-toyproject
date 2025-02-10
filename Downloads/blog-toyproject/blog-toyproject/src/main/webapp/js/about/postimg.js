$("#add_about-Img-button").click(function(){

	event.preventDefault();
	
	// 버튼 여러 번 클릭 방지
    const $button = $(this);
    if ($button.prop("disabled")) return; // 이미 비활성화된 경우 중복 실행 방지
    $button.prop("disabled", true); // 버튼 비활성화
	
	const formData = new FormData();
	
	// 여러 개의 파일 input 필드 ID 리스트
	const fileInputs = ["#add_about-file1", "#add_about-file2", "#add_about-file3", "#add_about-file4", "#add_about-file5"];
	
	fileInputs.forEach(selector => {
	    const inputElement = $(selector)[0]; // input 요소 가져오기
	    if (inputElement && inputElement.files.length > 0) { // 파일이 존재하는 경우
	        for (let i = 0; i < inputElement.files.length; i++) {
	            formData.append("aphotoFile", inputElement.files[i]); // FormData에 추가
	        }
	    }
	});
	
	$.ajax(`/about/imgpost`, {
		method: "post",
        data: formData,		
        processData: false, // FormData 처리 설정
        contentType: false, // FormData 처리 설정
		success: function(result) { // 결과 성공 콜백함수
			/*console.log(result);*/
			showAlert("게시물이 성공적으로 등록되었습니다.", "success");
			// 페이지 이동을 잠시 딜레이하여 메시지를 확인할 시간 제공
            setTimeout(() => {
                window.location.href = "/about";
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