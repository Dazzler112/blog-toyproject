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
	            
	            $("#get_count-views").text(board.views);
	            $("#get_count-comment").text(board.reply_count);	
	            	
	            $("#comment_count-id").text(board.reply_count);
                
            },
            error: function(err) {
                console.error("Error fetching board data:", err);
            }
        });
   
    });