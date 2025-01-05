$(".get-view").click(function() {
	const boardItem = $(this).closest(".get-view");
	const board_id = boardItem.data("board-id");
	console.log(board_id);
	$.ajax(`/post/views/${board_id}`, {
		method: "post",
		contentType: "application/json",
		success: function(data) {
			console.log(data);
		},
		error: function(err) {
			console.error("Error fetching board data:", err);
		}
	});
}); 