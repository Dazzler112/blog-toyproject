    $(document).ready(function() {
		
		const board_id = window.location.pathname.split("/").pop();
		
        $.ajax(`/post/${board_id}`, {
            method: "GET",
            contentType: "application/json",
            success: function(response) {
				// response는 서버에서 반환된 Board 객체
				console.log(response);
                const board = response;
                
                $("#board_get-id").val(board.board_id);
                $("#board_get-title").text(board.title);
                $("#board_get-writer").text(board.writer);
                
                const writeDate = new Date(board.write_date);
                $("#board_get-writedate").text(writeDate.toLocaleString());
                
                $("#board_get-body").text(board.body);
                
                const bucketUrl = "https://bucket0503-2345lhc5232.s3.ap-northeast-2.amazonaws.com/review_blog_project";
 				$("#board_get-img").attr("src", `${bucketUrl}/${board.board_id}/${board.photo_name}`);
 				
	            if (board.liked) {
	                $("#getboard_likeheart").text("🧡"); // 좋아요 상태
	            } else {
	                $("#getboard_likeheart").text("🤍"); // 좋아요 상태 아님
	            } 				
                
            },
            error: function(err) {
                console.error("Error fetching board data:", err);
            }
        });
    });
    
    
		$(document).on("click", "#modify-link", function (event) {
		    event.preventDefault(); // 기본 링크 동작 방지
		    const pathParts = window.location.pathname.split("/");
		    const board_id = pathParts.length > 2 ? pathParts[2] : null;// /main/{board_id}에서 추출
		    if (board_id) {
		    	const url = `/main/modify/${board_id}`; // 수정 페이지 URL 생성
		    	window.location.href = url; // 수정 페이지로 이동
		    } else {
		    	console.error("올바르지 않은 경로입니다. : board_id를 찾을 수 없음.")
		    }		    
		});    