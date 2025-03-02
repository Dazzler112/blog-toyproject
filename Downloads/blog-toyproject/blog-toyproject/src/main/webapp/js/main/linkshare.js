//mainview의 링크 복사
$(document).ready(function () {
    // 🔗 버튼 클릭 시 링크 컨테이너 표시
    $(".triple_link-share").off("click").on("click", function (e) {
        e.stopPropagation(); // 이벤트 버블링 방지

        const link = window.location.href; // 현재 페이지 링크 가져오기
        let board_id = $("#board_id-value").val(); // 게시글 ID 가져오기

        // 🔥 board_id가 undefined 또는 빈 값일 경우 제거
        if (!board_id) {
            board_id = ""; // 빈 값으로 설정하여 `/undefined` 방지
        }

        const fullLink = board_id ? link + "/" + board_id : link; // 게시글 ID가 있으면 추가

        $("#link-input").val(fullLink); // 링크를 input에 설정

        // 클릭된 버튼 위치 계산
        const buttonOffset = $(this).offset();
        const buttonHeight = $(this).outerHeight();

        // 링크 컨테이너 위치 조정
        $("#link-container").css({
            top: buttonOffset.top + buttonHeight + 10 + "px", // 버튼 아래 위치
            left: buttonOffset.left + "px", // 버튼 왼쪽 정렬
            position: "absolute"
        }).fadeIn(); // 컨테이너 표시
    });

    // 🔥 복사 버튼 클릭 시 이벤트 중복 방지
    $("#copy-button").off("click").on("click", function () {
        const linkInput = $("#link-input");
        const linkText = linkInput.val();

        if (navigator.clipboard) {
            navigator.clipboard.writeText(linkText).then(() => {
                alert("링크가 복사되었습니다!"); // 알림 메시지 (중복 방지됨)
            }).catch(err => {
                console.error("복사 실패:", err);
            });
        } else {
            linkInput.select(); // 텍스트 선택
            document.execCommand("copy"); // 복사 (구형 브라우저용)
            alert("링크가 복사되었습니다!"); // 알림 메시지 (중복 방지됨)
        }
    });

    // 닫기 버튼 클릭 시 컨테이너 숨기기
    $("#close-button").off("click").on("click", function () {
        $("#link-container").fadeOut(); // 컨테이너 숨기기
    });

    // 외부 클릭 시 컨테이너 닫기
    $(document).off("mouseup").on("mouseup", function (e) {
        const container = $("#link-container");
        if (!container.is(e.target) && container.has(e.target).length === 0) {
            container.fadeOut(); // 외부 클릭 시 컨테이너 닫기
        }
    });
});


//getpage 🔗링크 복사
$(document).ready(function () {
    // 🔗 버튼 클릭 시 링크 컨테이너 표시
    $(".get_page-link").off("click").on("click", function (e) {
        e.stopPropagation(); // 이벤트 버블링 방지

        const link = window.location.href; // 현재 페이지 링크 가져오기
        let board_id = $("#board_id-value").val(); // 게시글 ID 가져오기

        // 🔥 board_id가 undefined 또는 빈 값일 경우 제거
        if (!board_id) {
            board_id = ""; // 빈 값으로 설정하여 `/undefined` 방지
        }

        const fullLink = board_id ? link + "/" + board_id : link; // 게시글 ID가 있으면 추가

        $("#link-input").val(fullLink); // 링크를 input에 설정

        // 클릭된 버튼 위치 계산
        const buttonOffset = $(this).offset();
        const buttonHeight = $(this).outerHeight();

        // 링크 컨테이너 위치 조정
        $("#link-container").css({
            top: buttonOffset.top + buttonHeight + 10 + "px", // 버튼 아래 위치
            left: buttonOffset.left + "px", // 버튼 왼쪽 정렬
            position: "absolute"
        }).fadeIn(); // 컨테이너 표시
    });

    // 🔥 복사 버튼 클릭 시 이벤트 중복 방지
    $("#copy-button").off("click").on("click", function () {
        const linkInput = $("#link-input");
        const linkText = linkInput.val();

        if (navigator.clipboard) {
            navigator.clipboard.writeText(linkText).then(() => {
                alert("링크가 복사되었습니다!"); // 알림 메시지 (중복 방지됨)
            }).catch(err => {
                console.error("복사 실패:", err);
            });
        } else {
            linkInput.select(); // 텍스트 선택
            document.execCommand("copy"); // 복사 (구형 브라우저용)
            alert("링크가 복사되었습니다!"); // 알림 메시지 (중복 방지됨)
        }
    });

    // 닫기 버튼 클릭 시 컨테이너 숨기기
    $("#close-button").off("click").on("click", function () {
        $("#link-container").fadeOut(); // 컨테이너 숨기기
    });

    // 외부 클릭 시 컨테이너 닫기
    $(document).off("mouseup").on("mouseup", function (e) {
        const container = $("#link-container");
        if (!container.is(e.target) && container.has(e.target).length === 0) {
            container.fadeOut(); // 외부 클릭 시 컨테이너 닫기
        }
    });
});
