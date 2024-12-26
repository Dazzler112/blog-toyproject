$(document).ready(function(){
	
	// 현재 URL에서 board_id 가져오기
    const board_id = window.location.pathname.split("/").pop();
    
	$.ajax(`/post/${board_id}`, {
		method: "get",
		success: function(response) { 
			console.log(response);
			
			const fileListContainer = $("#file-list-container"); // 서버에서 전달된 기존 파일 이름 배열
			fileListContainer.empty(); // 기존 리스트 초기화
            
            // photoName이 null이 아니고, 배열 형태라면 처리
            if (response.photo_name  && Array.isArray(response.photo_name)) {
                response.photo_name.forEach((photo) => {
                    const fileItem = `
                        <div class="file-item">
                            <span>${photo}</span>
                            <button type="button" class="delete-file-btn" data-filename="${photo}">삭제</button>
                        </div>
                    `;
                    fileListContainer.append(fileItem);
                });
            }           
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
			alert("조회가 잘못되었습니다.");
		},
	});
	
	// 삭제 버튼 클릭 이벤트
    let removeFiles = [];
    $(document).on("click", ".delete-file-btn", function () {
        const fileToDelete = $(this).data("filename");
        removeFiles.push(fileToDelete);

        // UI에서 해당 파일 항목 제거
        $(this).closest(".file-item").remove();
    });
    
    // DOM에 board_id를 삽입 (필요 시)
    $("#get_post-board_id").val(board_id);
	
	$("#modify-writer-button").click(function(){

		$("#get_post-board_id").val(board_id);
		
		const now = new Date();
		const koreaTime = new Date(now.getTime() + (9* 60 * 60 * 1000)); // UTC+9
		const formattedDate = koreaTime.toISOString().slice(0, 16).replace("T", " "); // "YYYY-MM-DD HH:mm"
		
		const formData = new FormData();
//		formData.append("board_id", board_id); //board_id 추가
		formData.append("title", $("#modify-title").val());
		formData.append("body", $("#modify-body").val());
		formData.append("category", $("#modi_game-category").val());
		formData.append("write_date", formattedDate);		
		
        // 삭제할 파일 이름 추가
        if (removeFiles.length > 0) {
            removeFiles.forEach((fileName) => {
                formData.append("deletePhotoFile", fileName);
            });
        }
        
		const files = $("#modify-file")[0].files;		
		for (let i = 0; i < files.length; i++) {
			formData.append("photoFile" ,files[i]);
		}
		
		$.ajax(`/post/modify/${board_id}`, {
			method: "post",
	        data: formData,		
	        processData: false, // FormData 처리 설정
	        contentType: false, // FormData 처리 설정
			success: function(result) { // 결과 성공 콜백함수
				/*console.log(result);*/
				console.log(result + "성공");
				alert("수정이 완료되었습니다.");
				window.location.href = `/main/${board_id}`;
			},
			error: function(request, status, error) { // 결과 에러 콜백함수
				console.log(error + "잘못된 방식");
				alert("수정 중 이상이 발생하였습니다.");
			},
		});
	});
});



//취소버튼
$("#modify_cancle").click(function(){
	history.go(-1);
});