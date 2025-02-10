$(document).ready(function () {
    // 현재 URL에서 board_id 가져오기
    const aphoto_id = window.location.pathname.split("/").pop();

    // 파일 삭제 이벤트 처리
    let removeFiles = [];
    $(document).on("click", ".delete-file-btn", function () {
        const fileToDelete = $(this).data("filename");
        if (!removeFiles.includes(fileToDelete)) {
            removeFiles.push(fileToDelete); // 중복 방지
        }
        $(this).closest(".file-item").remove(); // UI에서 제거
    });
    
    // DOM에 board_id를 삽입 (필요 시)
    $("#get_post-board_id").val(board_id);
	
  // 수정 버튼 클릭 이벤트
    $("#modify-writer-button").click(function () {
        // 입력 값 검증
        const title = $("#modify-title").val().trim();
        const body = $("#modify-body").val().trim();

        if (!title || !body) {
            alert("제목과 내용을 모두 입력해주세요.");
            return;
        }

        // 현재 시간 계산
        const now = new Date();
        const koreaTime = new Date(now.getTime() + 9 * 60 * 60 * 1000); // UTC+9
        const formattedDate = koreaTime.toISOString().slice(0, 16).replace("T", " ");

        // FormData 생성
        const formData = new FormData();
        formData.append("title", title);
        formData.append("body", body);
        formData.append("category", $("#modi_game-category").val());
        formData.append("write_date", formattedDate);

        // 삭제 파일 추가
        if (removeFiles.length > 0) {
            removeFiles.forEach((fileName) => {
                formData.append("deletePhotoFile", fileName);
            });
        }

        // 추가 파일 처리
        const files = $("#modify-file")[0].files;
        if(files.length > 0) { 
	        for (let i = 0; i < files.length; i++) {
	            formData.append("photoFile", files[i]);
	        }
		}
        // 수정 데이터 전송
        $.ajax(`/post/modify/${board_id}`, {
            method: "post",
            data: formData,
            processData: false, // FormData 처리
            contentType: false, // FormData 처리
            success: function (result) {
                console.log(result + " 성공");
                showAlert("게시물 수정이 성공적으로 되었습니다.", "success");
                setTimeout(() => {
                window.location.href = `/main/${board_id}`;
            }, 2000); // 2초 후 이동
               
            },
            error: function (request, status, error) {
                console.error(error, "수정 실패");
                showAlert("수정 중 문제가 발생하였습니다.", "error");
            },
        });
    });
});



//취소버튼
$("#modify_cancle").click(function(){
	history.go(-1);
});