$(".user_block-button").click(function(){
	
	const row = $(this).closest("tr");
    // 해당 행에서 값 가져오기
    const member_id = row.find(".manage_user-list").text().trim();  
    const member_type = "user0"; 
    
    console.log("🚀 선택된 member_id:", member_id);
    console.log("🚀 member_type을 강제로 'user0'으로 설정"); 
	
	$.ajax(`/manage/block/${member_id}`, {
		method: "post",
		contentType: "application/json",
        data: JSON.stringify({
			member_id : member_id,
            member_type: member_type
        }),		
		success: function(result) { // 결과 성공 콜백함수  
		
			showAlert("변경 완료.", "success");
			setTimeout(() => {
                window.location.href = "/manage";
            }, 0)			
			console.log(result + "성공");
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			showAlert("게시물 등록에 실패했습니다.", "error");
			console.log(error + "잘못된 방식");
			
			$button.prop("disabled", false);
		},
	});
});