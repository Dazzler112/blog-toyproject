$(document).ready(function () {
    const aphoto_id = window.location.pathname.split("/").pop();

    // 기존 게시물 데이터 로드
    $.ajax(`/about/imgpost/${aphoto_id}`, {
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log("🚀 서버 응답 데이터:", response);
            if (response) {
                $("#about_modi-aphotid").val(aphoto_id);
                $("#about_modi-writer").val(response.member_id);

                const fileListContainer = $("#about_img-list-container");
                fileListContainer.empty();

                if (response.photo_name && Array.isArray(response.photo_name)) {
                    response.photo_name.forEach((photo) => {
                        const fileItem = `
                            <div class="file-item">
                                <span>${photo}</span>
                                <button type="button" class="delete-file-btn" data-filename="${photo}">삭제</button>
                            </div>
                        `;
                        fileListContainer.append(fileItem);
                    });
                }
            } else {
                alert("게시글 정보를 불러올 수 없습니다.");
            }
        },
        error: function (request, status, error) {
            console.error("데이터 로드 실패", error);
            alert("데이터를 불러오는 중 오류가 발생했습니다.");
        },
    });

    // 파일 삭제 이벤트 처리
    let removeFiles = [];
    $(document).on("click", ".delete-file-btn", function () {
        const fileToDelete = $(this).data("filename");
        if (!removeFiles.includes(fileToDelete)) {
            removeFiles.push(fileToDelete);
        }
        $(this).closest(".file-item").remove();
    });

    // 수정 버튼 클릭 이벤트
    $("#modify_about-Img-button").click(function (e) {
        e.preventDefault();

        const formData = new FormData();
        formData.append("aphoto_id", aphoto_id); // 📌 aphoto_id 추가
        formData.append("member_id", $("#about_modi-writer").val()); // 📌 member_id 추가

        if (removeFiles.length > 0) {
            removeFiles.forEach((fileName) => {
                formData.append("deleteAboutPhoto", fileName);
            });
        }

        const fileInputs = [
            "#modify_about-file1",
            "#modify_about-file2",
            "#modify_about-file3",
            "#modify_about-file4",
            "#modify_about-file5"
        ];

        fileInputs.forEach(selector => {
            const inputElement = $(selector)[0];
            if (inputElement && inputElement.files.length > 0) {
                for (let i = 0; i < inputElement.files.length; i++) {
                    formData.append("AboutPhoto", inputElement.files[i]);
                }
            }
        });

        $.ajax({
            url: `/about/imgpost/${aphoto_id}`,
            method: "POST",
            data: formData,
            processData: false,
            contentType: false,
            success: function (result) {
                console.log("수정 성공", result);
                showAlert("게시물 수정이 성공적으로 완료되었습니다.", "success");
                setTimeout(() => {
                    window.location.href = `/about`;
                }, 2000);
            },
            error: function (request, status, error) {
                console.error("수정 실패", error);
                showAlert("수정 중 문제가 발생했습니다.", "error");
            },
        });
    });
});