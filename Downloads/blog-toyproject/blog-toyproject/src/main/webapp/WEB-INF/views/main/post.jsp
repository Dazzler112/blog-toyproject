<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<html>
<head>
		<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Review Pages</title>
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<div class="main_post-container">
		<div>

         <div class="main_posting-container">
            <form action="" method="post" enctype="multipart/form-data">
               <div id="category_div-div" >
	               <span class="category_title" style="font-weight: 600;">카테고리</span>
	               <select id="game-category" name="category">
		               <option value="전략/시뮬레이션"> 전략/시뮬레이션
		               <option value="RPG"> RPG
		               <option value="액션/격투"> 액션/격투
		               <option value="슈팅"> 슈팅
		               <option value="어드벤쳐"> 어드벤쳐
		               <option value="캐주얼"> 캐주얼
		               <option value="모바일"> 모바일
	               </select>
               </div>
               <div class="main_post-div-container">
	               <label for="add-title" class="form-label"></label><span style="font-weight: 600;">제목</span>
	               <input id="add-title" type="text"  class="form-control" name="title" />
               </div>
               <div class="main_post-div-container">
	               <label for="add-body" class="form-label"></label><span style="font-weight: 600;">본문</span>
	               <textarea rows="10" id="add-body" class="form-control" name="body" ></textarea>
               </div>
               <div class="main_post-div-container">
                  <label for="add-file" class="form-label"></label>
                  <span style="font-weight: 600;">사진</span>
                  <input id="add-file" class="form-control" type="file"  name="photoFile" accept="image/*" multiple/>
               </div>    
               		<input id="add-date" type="text"  class="form-control" name="write_date" style="display:none;" readonly/>
               <br>
	            <div class="main_post-btn-container">
	               <button id="add-writer-button">글쓰기</button>
	               <a href="/main" id="cancle-writer-button" style="margin: 0px 0px 0px 10px; text-decoration: none;">취소</a>
				</div>               
            </form>
         </div>

		</div>
	</div>


	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/main/post.js"></script>
	
</body>
</html>