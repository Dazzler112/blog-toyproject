/*    $(document).ready(function() {
		
		const board_id = $("#board_id-value").data("board-id");
		
        $.ajax(`main/${board_id}`, {
            method: "GET",
            success: function(board) {
                // REST API에서 받은 데이터로 h2 태그 업데이트
                $("#board-title").text(board.title);
                $("#board-body").text(board.body);
                
                const imgContainer = $("#board-imgs");
                if(board.photoName && board.photoName.length > 0) {
					board.photoName.forEach(photo =>{
						const imgTag = `<img src="/path/to/images/${photo}" alt="Board Image">`;
						imgContainer.append(imgTag);
					}); 
				}else {
					imgContainer.text("No images available.");
				}
                
            },
            error: function(err) {
                console.error("Error fetching board data:", err);
            }
        });
    });*/