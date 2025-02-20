let aboutValue = "all";

listAbout(aboutValue);

function listAbout() {
	const aboutId = 1;

	$.ajax(`/about/post/${aboutId}`, {
		method: "get",
		contentType: "application/json",
		success: function(result) { // 결과 성공 콜백함수
			console.log(result.body);
			$("#about-body").html(`<p>${result.body}</p>`);

				// 해당 게시물ID가 있으면 버튼 숨기기
				if(result.about_id == 1){
					$("#post-button").hide();
				} else if(result.about_id != null || result.about_id == undefined) { // 해당 게시물ID가 없으면 버튼 보이게
					$("#post-button").show();
				}
		},
		error: function(request, status, error) { // 결과 에러 콜백함수
			console.log(error)
		}
	});

}



const track = document.querySelector('.carousel-track'); // 슬라이드 전체 컨테이너
const images = Array.from(track.children); // 모든 이미지
const imageWidth = images[0].getBoundingClientRect().width + 11; // 이미지 + 마진 너비
let currentPosition = 0; // 현재 슬라이더 위치

function moveCarousel() {
    currentPosition -= imageWidth; // 왼쪽으로 이동

    // 마지막 이미지에서 첫 번째 이미지로 바로 이동
    const maxPosition = -(imageWidth * (images.length - 3)); // 마지막 이미지 위치
    if (currentPosition < maxPosition) {
        currentPosition = 0; // 첫 번째 이미지로 복귀
    }

    track.style.transform = `translateX(${currentPosition}px)`; // 이동 적용
}

// 3초마다 이동
setInterval(moveCarousel, 3000);