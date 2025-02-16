$(document).ready(function () {
    // 현재 URL에서 board_id 가져오기
    const aphoto_id = 1;
	

    // 파일 삭제 이벤트 처리
    let removeFiles = [];
    
    // 파일 삭제 이벤트 처리 (버튼 클릭 시)
    $(document).on("click", ".delete-file-btn", function () {
        const fileToDelete = $(this).data("filename");
        if (!removeFiles.includes(fileToDelete)) {
            removeFiles.push(fileToDelete); // 중복 방지
        }
        $(this).closest(".file-item").remove(); // UI에서 제거
    });

    // 수정 버튼 클릭 이벤트
    $("#modify_about-Img-button").click(function (e) {
        e.preventDefault(); // 기본 이벤트 방지 (페이지 새로고침 방지)

        const formData = new FormData();

        // 📌 삭제할 파일 리스트 추가 (올바른 key로 추가!)
        if (removeFiles.length > 0) {
            removeFiles.forEach((fileName) => {
                formData.append("deleteAboutPhoto", fileName);
            });
        }

        // 📌 추가할 파일 처리 (JSP input별 개별 처리)
        const fileInputs = [
            "#modify_about-file1",
            "#modify_about-file2",
            "#modify_about-file3",
            "#modify_about-file4",
            "#modify_about-file5"
        ];

        fileInputs.forEach(selector => {
            const inputElement = $(selector)[0]; // input 요소 가져오기
            if (inputElement && inputElement.files.length > 0) { // 파일이 존재하는 경우
                for (let i = 0; i < inputElement.files.length; i++) {
                    formData.append("AboutPhoto", inputElement.files[i]); // 서버에서 받는 key에 맞춤!
                }
            }
        });

        // Ajax 요청 보내기
        $.ajax({
            url: `/about/imgpost/${aphoto_id}`,
            method: "POST",
            data: formData,
            processData: false, // FormData 자동 변환 방지
            contentType: false, // FormData 자동 변환 방지
            success: function (result) {
                console.log("수정 성공", result);
                showAlert("게시물 수정이 성공적으로 완료되었습니다.", "success");
                setTimeout(() => {
                    window.location.href = `/about`;
                }, 2000);
            },
            error: function (request, status, error) {
                console.error("수정 실패", error);
                showAlert("수정 중 문제가 발생했습니다.", "error");
            },
        });
    });
});
