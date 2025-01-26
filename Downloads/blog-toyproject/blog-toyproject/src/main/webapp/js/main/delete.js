$(document).ready(function() {
    let selectBoardId = null;

    $("#remove_post-btn").click(function() {
        selectBoardId = $("#board_get-id").val(); // 삭제할 게시글 ID 가져오기
        $("#deleteModal").show(); // 모달 보이기
        $("#remove_post-btn").hide();

        // "예" 버튼 클릭 이벤트
        $("#confirmDelete").off("click").on("click", function() {
            if (selectBoardId) {
                $.ajax("/post/remove", {
                    method: "post",
                    contentType: "application/json",
                    data: JSON.stringify(selectBoardId),
                    success: function(result) {
                        console.log(result + "성공");
                        
                        showAlert("삭제가 성공적으로 완료되었습니다.", "success");
						// 페이지 이동을 잠시 딜레이하여 메시지를 확인할 시간 제공
			            setTimeout(() => {
			                window.location.href = "/main";
			            }, 2000); // 2초 후 이동                        
                    },
                    error: function(request, status, error) {
                        console.log(error + "잘못된 방식");
                        showAlert("삭제에 실패하였습니다.", "error");
                    },
                });
            }
            $("#deleteModal").hide(); // 모달 닫기
            $("#remove_post-btn").show();
        });

        // "아니오" 버튼 클릭 이벤트
        $("#cancelDelete").off("click").on("click", function() {
            $("#deleteModal").hide(); // 모달 닫기
            $("#remove_post-btn").show();
        });
    });
});