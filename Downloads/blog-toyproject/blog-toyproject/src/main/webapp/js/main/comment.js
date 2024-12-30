commentlist();

    // 댓글 작성 영역 클릭 시 버튼 생성
    $("#comment_write-box").click(function () {
        if ($(".comment-cancel-btn").length === 0) {
            $(".comment_write-container-btn").html(`
                <button class="comment-cancel-btn">Cancel</button>
                <button id="comment_publish-btn" class="comment-publish-btn">Publish</button>
            `);
        }
    });

    // "Cancel" 버튼 클릭 이벤트
    $(".comment-container").on("click", ".comment-cancel-btn", function () {
        $(".comment_write-container-btn").empty(); // 버튼 컨테이너 비우기
        $("#comment_write-box").val(""); // textarea 내용 비우기
    });

    // "Publish" 버튼 클릭 이벤트 위임
    $(".comment-container").on("click", "#comment_publish-btn", function () {
        const now = new Date();
        const koreaDate = new Date(now.getTime() + 9 * 60 * 60 * 1000); // UTC+9
        const comment_date = koreaDate.toISOString().split("T")[0]; // YYYY-MM-DD 형식 추출

        const board_id = $("#board_get-id").val();
        const comment_body = $("#comment_write-box").val();
        const data = { board_id, comment_body, comment_date };

        $.ajax(`/post/comment`, {
            method: "post",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (data) {
                console.log("Comment added successfully:", data);
                $("#comment_write-box").val(""); // 댓글 입력창 초기화
                $(".comment_write-container-btn").empty(); // 버튼 제거
                //location.reload(); // 댓글 목록 갱신
                commentlist();
            },
            error: function (request, status, error) {
                console.log("Error adding comment:", error);
                alert("Please SignUp.");
            },
        });
    });

    // 댓글 리스트 조회 함수
    function commentlist() {
        const board_id = window.location.pathname.split("/").pop();
        if (!board_id) {
            console.error("Board ID is missing!");
            return;
        }

        $.ajax("/post/comment?board_id=" + board_id, {
            method: "get",
            success: function (comments) {
                $("#commentListContainer").empty();
                for (const comment of comments) {
                    const editButtons = `
                        <button 
                            id="commentDeleteBtn" 
                            class="commentDeleteButton">
                                <i class="fa-regular fa-trash-can"></i>
                        </button>
                        <button
                            id="commentUpdateBtn${comment.reply_id}"
                            class="commentUpdateButton btn btn-secondary"
                            data-bs-toggle="modal" data-bs-target="#commentUpdateModal"
                            data-comment-id="${comment.reply_id}">
                                <i class="fa-regular fa-pen-to-square"></i>
                        </button>
                    `;

                    $("#comment_reply-container").append(`
                        <li style="display:flex; justify-content:space-between; align-items: start;" class="comment-list">
                            <div class="ms-2 me-auto">
                            	<input id="comment_replyid" type="text" name="reply_id" value="${comment.reply_id}" hidden/>
                                <div class="fw-bold"> <i class="fa-solid fa-user"></i> ${comment.member_id}</div>
                                <div style="white-space: pre-wrap;">${comment.comment_body}</div>
                            </div>
                            <div>
                                <span class="badge bg-primary rounded-pill">${comment.comment_date}</span>
                                <div class="text-end mt-2">
                                    ${comment.editable ? editButtons : ''}
                                </div>
                            </div>
                        </li>
                    `);
                }
            },
            error: function (request, status, error) {
                console.error("Error fetching comments:", error);
            }            
        });
    }
    
    $(".comment-container").on("click", ".commentDeleteButton", function () {
        const reply_id = $(this).closest("li").find("#comment_replyid").val(); // 댓글 ID 가져오기
        $.ajax("/post/comment/" + reply_id, {
            method: "delete",
            success: function (data) {
                //location.reload();
                console.log("Comment deleted successfully:", data);
                commentlist();
            },
            error: function (request, status, error) {
                console.error("Error deleting comment:", error);
                alert("댓글 삭제에 실패하였습니다.");
            }
        });
    });
	
