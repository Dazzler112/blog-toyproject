<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasAuthority('admin')">	
<style>
</style>
<html>
<head>
		<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Review Pages</title>
		
		<link rel="stylesheet" href="/css/style.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
  <my:message></my:message>
	<div class="main_post-modify-container">
		<div>

         <div class="main_posting-container">
               <div id="category_div-div" >
               	   <input type="text" id="get_post-board_id" name="board_id"  readonly hidden/>
	               <span class="category_title" style="font-weight: 600;">카테고리</span>
	               <select id="modi_game-category" name="category">
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
	               <input id="modify-title" type="text"  class="form-control" name="title" />
               </div>
               <div class="main_post-div-container">
	               <label for="modify-body" class="form-label"></label><span style="font-weight: 600;">본문</span>
	               <textarea rows="10" id="modify-body" class="form-control" name="body" ></textarea>
               </div>
               <div class="main_post-div-container">
                  <label for="add-file" class="form-label"></label>
                  <span style="font-weight: 600;">사진</span>
                  <input id="modify-file" class="form-control" type="file"  name="photoFile" accept="image/*" multiple/>
               </div>   

				<div id="file-list-container"></div>               
                
               		<input id="add-date" type="text"  class="form-control" name="write_date" style="display:none;" readonly/>
               <br>
	            <div class="main_post-btn-container">
	               <button id="modify-writer-button">수정</button>
	               <button id="modify_cancle">취소</button> 
				</div>    
         </div>

		</div>
	</div>


	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/main/modify.js"></script>
	
</body>
</html>
</sec:authorize>