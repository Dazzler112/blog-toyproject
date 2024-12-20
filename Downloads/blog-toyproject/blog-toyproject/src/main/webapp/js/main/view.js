    $(document).on("click", ".get-view", function(event) {
		
		event.preventDefault();
		const board_id = $(this).data("board-id");
		
        $.ajax(`/post/${board_id}`, {
            method: "GET",
            success: function(response) {
				// response는 서버에서 반환된 Board 객체
				console.log(response);
                
                $("#board-title").text(response.title);
                $("#board_writer").text(response.writer);
                
                const writeDate = new Date(response.write_date);
                $("#board_writedate").text(writeDate.toLocaleString());
                
                $("#board-body").text(board.body);
                
 				$("#board-img").attr("src", `${bucketUrl}/${response.board_id}/${response.photo_name}`);
                
            },
            error: function(err) {
                console.error("Error fetching board data:", err);
            }
        });
    });