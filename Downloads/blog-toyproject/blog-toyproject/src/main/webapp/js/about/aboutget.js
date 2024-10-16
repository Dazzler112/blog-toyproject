let aboutValue = "all";

listAbout(aboutValue);

function listAbout() {
const memberId = "dummy";
const aboutId = 1;

/*const requestMemberId = {
	member_id : "dummy"
};

const requestAboutId = {
	about_id : 1
};


const param1 = new URLSearchParams(requestMemberId).toString();
const param2 = new URLSearchParams(requestAboutId).toString();
*/
$.ajax(`/about/${memberId}/post/${aboutId}`, {
      method: "get",
      contentType: "application/json",
      complete: function(data) {
		 const aboutList = data.aboutList;
		 const abody = document.getElementById("about-body");
		 abody.innerHTML= "";
		 aboutList.forEach((about) => {
			 const aboutHTML = `
			 	<span style="display: none;">${about.about_id}</span>
			 	<span style=" display: flex; justify-content: center; padding: 0px 200px; margin: 0px 80px;">${about.body}</span>
			 `;
			 abody.insertAdjacentHTML('beforeend', aboutHTML);
		 });
      }
});

}