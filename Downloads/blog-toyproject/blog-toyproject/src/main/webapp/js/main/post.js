$("#add-writer-botton").click(function(){

	event.preventDefault();
	
	const now = new Date();
	const koreaTime = new Date(now.getTime() + (9* 60 * 60 * 1000)); // UTC+9
	const formattedDate = koreaTime.toISOString().slice(0, 16).replace("T", " "); // "YYYY-MM-DD HH:mm"
	
	const formData = new FormData();
	formData.append("title", $("#add-title").val());
	formData.append("body", $("#add-body").val());
	formData.append("category", $("#game-category").val());
	formData.append("write_date", formattedDate);
	
	const files = $("#add-file")[0].files;
	if(files.length > 0) { //파일이 존재하는 경우만 실행되게 하니면 해당 for문실행x
		for (let i = 0; i < files.length; i++) {
			formData.append("photoFile" ,files[i]);
		}
	}
	
	$.ajax(`/post/addpost`, {
		method: "post",
        data: formData,		
        processData: false, // FormData 처리 설정
        contentType: false, // FormData 처리 설정
		success: function(result) { // 결과 성공 콜백함수
			/*console.log(result);*/
			console.log(result + "성공");
			window.location.href = "/main";
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error + "잘못된 방식");
		},
	});
});