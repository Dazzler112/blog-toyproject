$(".get-view").click(function() {
	const boardItem = $(this).closest(".get-view");
	const board_id = boardItem.data("board-id");
		
	const data = {board_id};
	console.log(data);
	$.ajax(`/post/views/${data}`, {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		success: function(data) {
			console.log(data);
		},
		error: function(err) {
			console.error("Error fetching board data:", err);
		}
	});
}); 