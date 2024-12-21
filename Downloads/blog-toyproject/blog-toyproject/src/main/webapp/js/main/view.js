    $(document).ready(function() {
		
		const board_id = window.location.pathname.split("/").pop();
		
        $.ajax(`/post/${board_id}`, {
            method: "GET",
            contentType: "application/json",
            success: function(response) {
				// response는 서버에서 반환된 Board 객체
				console.log(response);
                const board = response[0];
                
                $("#board_get-title").text(board.title);
                $("#board_get-writer").text(board.writer);
                
                const writeDate = new Date(board.write_date);
                $("#board_get-writedate").text(writeDate.toLocaleString());
                
                $("#board_get-body").text(board.body);
                
                const bucketUrl = "https://bucket0503-2345lhc5232.s3.ap-northeast-2.amazonaws.com/review_blog_project";
 				$("#board_get-img").attr("src", `${bucketUrl}/${board.board_id}/${board.photo_name}`);
                
            },
            error: function(err) {
                console.error("Error fetching board data:", err);
            }
        });
    });