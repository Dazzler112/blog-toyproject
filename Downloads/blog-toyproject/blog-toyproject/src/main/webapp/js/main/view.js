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
		

//링크 복사 로직 1	

$(document).ready(function() {
    // 🔗 버튼 클릭 시 링크 컨테이너 표시
    $(".triple_link-share").click(function(e) {
        const link = window.location.href; // 현재 페이지 링크 가져오기
        $("#link-input").val(link); // 링크를 input에 설정

        // 클릭된 버튼 위치 계산
        const buttonOffset = $(this).offset();
        const buttonHeight = $(this).outerHeight();

        // 링크 컨테이너 위치 조정
        $("#link-container").css({
            top: buttonOffset.top + buttonHeight + 70 + "px", // 버튼 바로 아래
            left: buttonOffset.left +170 +"px", // 버튼 왼쪽 정렬
            position: "absolute"
        }).fadeIn(); // 컨테이너 표시
    });

    // 복사 버튼 클릭 시 클립보드로 복사
    $("#copy-button").click(function() {
        const linkInput = $("#link-input");
        linkInput.select(); // 텍스트 선택
        document.execCommand("copy"); // 복사
        alert("링크가 복사되었습니다!"); // 알림 메시지
    });

    // 닫기 버튼 클릭 시 컨테이너 숨기기
    $("#close-button").click(function() {
        $("#link-container").fadeOut(); // 컨테이너 숨기기
    });

    // 외부 클릭 시 컨테이너 닫기
    $(document).mouseup(function(e) {
        const container = $("#link-container");
        if (!container.is(e.target) && container.has(e.target).length === 0) {
            container.fadeOut(); // 외부 클릭 시 컨테이너 닫기
        }
    });
});
		
		
//링크 복사 로직 2	

$(document).ready(function() {
    // 🔗 버튼 클릭 시 링크 컨테이너 표시
    $(".get_page-link").click(function(e) {
        const link = window.location.href; // 현재 페이지 링크 가져오기
        $("#link-input").val(link); // 링크를 input에 설정

        // 클릭된 버튼 위치 계산
        const buttonOffset = $(this).offset();
        const buttonHeight = $(this).outerHeight();

        // 링크 컨테이너 위치 조정
        $("#link-container").css({
            top: buttonOffset.top + buttonHeight + 70 + "px", // 버튼 바로 아래
            left: buttonOffset.left +170 +"px", // 버튼 왼쪽 정렬
            position: "absolute"
        }).fadeIn(); // 컨테이너 표시
    });

    // 복사 버튼 클릭 시 클립보드로 복사
    $("#copy-button").click(function() {
        const linkInput = $("#link-input");
        linkInput.select(); // 텍스트 선택
        document.execCommand("copy"); // 복사
        alert("링크가 복사되었습니다!"); // 알림 메시지
    });

    // 닫기 버튼 클릭 시 컨테이너 숨기기
    $("#close-button").click(function() {
        $("#link-container").fadeOut(); // 컨테이너 숨기기
    });

    // 외부 클릭 시 컨테이너 닫기
    $(document).mouseup(function(e) {
        const container = $("#link-container");
        if (!container.is(e.target) && container.has(e.target).length === 0) {
            container.fadeOut(); // 외부 클릭 시 컨테이너 닫기
        }
    });
});