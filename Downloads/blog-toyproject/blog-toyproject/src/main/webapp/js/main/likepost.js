$("#getboard_list-likecount").click(function(){
	
	const board_id = $("#board_get-id").val();
	const data = {board_id};
		
	$.ajax(`/post/like`, {
		method: "post",
		contentType: "application/json",
	      	data: JSON.stringify(data),
			success: function(data) { // 결과 성공 콜백함수
			console.log(data);
			if(data.boardLike) {
				$("#getboard_likeheart").text("🧡");
			}else{
				$("#getboard_likeheart").text("🤍");
			}
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			alert("로그인을 해주세요!");
			console.log(error + "잘못된 방식");
		},
	});
});


$(".active_container").on("click", ".board_likeheart", function(){
	
	const boardItem = $(this).closest(".active_container");
	const board_id = boardItem.data("board-id");
		
	const data = {board_id};
		
	$.ajax(`/post/like`, {
		method: "post",
		contentType: "application/json",
	      	data: JSON.stringify(data),
			success: function(data) { // 결과 성공 콜백함수
			console.log(board_id);
			location.reload();
			if(data.boardLike) {
				$("#board_likeheart").text("🧡");
			}else{
				$("#board_likeheart").text("🤍");
			}
			boardItem.find(".like-number").text(data.like_count);//<= 이부분 동적으로 바뀌게 해야함
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			alert("로그인을 해주세요!");
			console.log(error + "잘못된 방식");
		},
	});
});


$(document).on("click", ".list_view-likeheart", function () {
    // 클릭된 게시물 컨테이너에서 board_id 가져오기
    const boardItem = $(this).closest(".list_view-container");
    const board_id = boardItem.find(".list_view-id").val(); // input 값을 가져옴
    console.log("Clicked board_id:", board_id);

    // board_id가 없으면 에러 처리
    if (!board_id) {
        alert("board_id를 가져오지 못했습니다. HTML 데이터를 확인하세요.");
        return;
    }

    // Ajax 요청
    $.ajax(`/post/like`, {
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({ board_id }),
        success: function (response) {
            console.log("Response from server:", response);

            // 좋아요 상태 변경
            if (response.boardLike) {
                boardItem.find(".list_view-likeheart").text("🧡");
            } else {
                boardItem.find(".list_view-likeheart").text("🤍");
            }
        },
        error: function (request, status, error) {
            alert("로그인을 해주세요!");
            console.error("Error:", error);
        },
    });
});
