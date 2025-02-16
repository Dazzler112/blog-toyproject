<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	<div class="main_post-container">
		<div>

         <div class="main_posting-container">
            <form action="" method="post" enctype="multipart/form-data">

               <div class="main_post-div-container">
	               <input id="about_modi-writer" type="text"  class="form-control" name="member_id"  readonly/>
	               <input id="about_modi-aphotid" type="text"  class="form-control" name="aphoto_id" readonly/>
               </div>
               
               <div class="main_post-div-container">
                  <label for="add-file" class="form-label"></label>
                  <span style="font-weight: 600;">사진</span>
                  <input id="modify_about-file1" class="form-control" type="file"  name="photoFile" accept="image/*" multiple/>
                  <input id="modify_about-file2" class="form-control" type="file"  name="photoFile" accept="image/*" multiple/>
                  <input id="modify_about-file3" class="form-control" type="file"  name="photoFile" accept="image/*" multiple/>
                  <input id="modify_about-file4" class="form-control" type="file"  name="photoFile" accept="image/*" multiple/>
                  <input id="modify_about-file5" class="form-control" type="file"  name="photoFile" accept="image/*" multiple/>
               </div>    
               <br>
               <span style="font-weight: 600;">기존</span>
               <div id="about_img-list-container"></div>
               <br>
	            <div class="main_post-btn-container">
	               <button id="modify_about-Img-button">게시</button>
	               <a href="/about" id="cancle_about-img-button" style="margin: 0px 0px 0px 10px; text-decoration: none;">취소</a>
				</div>               
            </form>
         </div>

		</div>
	</div>


	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script src="/js/about/modifyimg.js"></script>
	
</body>
</html>
