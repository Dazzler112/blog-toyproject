//링크 복사 로직 mainlist	
$(document).ready(function() {
    // 🔗 버튼 클릭 시 링크 컨테이너 표시
    $(".triple_link-share").click(function(e) {
        const link = window.location.href; // 현재 페이지 링크 가져오기
        const board_id = $("#board_id-value").val();
        
        $("#link-input").val(link + "/" + board_id); // 링크를 input에 설정

        // 클릭된 버튼 위치 계산
        const buttonOffset = $(this).offset();
        const buttonHeight = $(this).outerHeight();

        // 링크 컨테이너 위치 조정
        $("#link-container").css({
            top: buttonOffset.top + buttonHeight + 70 + "px", // 버튼 바로 아래
            left: buttonOffset.left + "px", // 버튼 왼쪽 정렬
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