$(document).ready(function () {
    const board_id = window.location.pathname.split("/").pop();

    $.ajax(`/post/views/containerview/${board_id}`, {
        method: "GET",
        contentType: "application/json",
        success: function (response) {
            console.log(response);

            const { previous, next, previousExtra } = response;
            const bucketUrl =
                "https://bucket0503-2345lhc5232.s3.ap-northeast-2.amazonaws.com/review_blog_project";

            // 공통 렌더링 함수
			function renderPostData(containerSelector, data, bucketUrl) {
			    const photoUrl = data.photo_name
			        ? `${bucketUrl}/${data.board_id}/${data.photo_name}`
			        : "default.png";
			
			    $(containerSelector + " .list_view-id").val(data.board_id);
			    $(containerSelector + " .list_view-img").attr("src", photoUrl);
			    $(containerSelector + " .list-view_get").attr("href", `/main/${data.board_id}`);
			    $(containerSelector + " .list_view-title").text(data.title || "제목 없음");
			    $(containerSelector + " .list_view-count").text(`👁 ${data.views || 0}`);
			    $(containerSelector + " .list_view-comment").text(`🗨 ${data.reply_count || 0}`);
			    
				if(data.liked) {
					$(containerSelector + " .list_view-likeheart").text("🧡");
				} else {
					$(containerSelector + " .list_view-likeheart").text("🤍");
				}
			}
		
            // 다음글 처리
            if (next) {
                renderPostData(".list_view-container-f", next, bucketUrl);
            } else {
                $(".list_view-container-f").hide();
            }

			// 이전글 처리
			if (!previousExtra || previousExtra.length === 0) {
			    if (previous) {
			        renderPostData(".list_view-container-b", previous, bucketUrl);
			    } else {
			        $(".list_view-container-b").hide();
			    }
			} else {
			    $(".list_view-container-b").hide(); // previous를 숨기도록 처리
			}

            // 이전글 추가 데이터 처리
            if (previousExtra && previousExtra.length > 0) {
                if (previousExtra.length > 0) {
                    renderPostData(".list_view-container-extra-1", previousExtra[0], bucketUrl);
                }
                if (previousExtra.length > 1) {
                    renderPostData(".list_view-container-extra-2", previousExtra[1], bucketUrl);
                }
            } else {
                $(".list_view-container-extra-1, .list_view-container-extra-2").hide();
            }
            
        },
        error: function (err) {
            console.error("Error fetching board data:", err);
        },
    });
});