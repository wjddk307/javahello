/**
 *  upload.js
 */

// java script 영역.

document.addEventListener('DOMContentLoaded', function() { // DOMContentLoaded: HTML실행 후 실행되도록 실행순서 변경해주는 이벤트.

	let tbl = document.querySelector('#show table');
	let capt = document.createElement('caption');
	capt.innerHTML = '회원리스트';
	tbl.append(capt);

	// 리스트 출력.  // <body>에 method="post" enctype="multipart/form-data"로 변경.
	let ajax = new XMLHttpRequest();
	ajax.open('get', 'member?cmd=list');
	ajax.send();
	ajax.onload = function() {
		let data = JSON.parse(this.responseText)

		let tbody = document.querySelector('#show tbody');
		data.forEach(member => {
			tbody.append(makeTr(member));
		})
	}

	// form 기본 기능 => ajax로 처리. (XMLHttpRequest, fetch): 두개 다 ajax
	document.forms.memberFrm.addEventListener("submit", function(e) {
		e.preventDefault();
		let formData = new FormData(e.target); // Form 태그 안 요소들 / /e.target = form
		for (let ent of formData.entries()) {
			console.log(ent);
		};

		// get: url, post: 추가정보 지정.
		fetch('memberUpload', {
			   method: 'post',
			   body: formData
		    })
			.then(function(result) {
				return result.json();
			})
			.then(function(result) {
				console.log(result);
			})
			.catch(function(err) {
				console.error(err);
			})
	})


});



let fields = ['membNo', 'membName', 'membPhone', 'membAddr', 'membBirth', 'membImage'];

//회원정보 => tr생성.
function makeTr(member) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', member.membNo); // tr의 attribute중에 id 를 활용.
	//tr.addEventListener('click', showTr);
	fields.forEach(field => {
		let td = document.createElement('td');
		// null, 0, undefind, '' => false 이외 true;
		td.innerHTML = member[field] ? (field == 'membImage' ? '<img width="60px" src="images/' + member[field] + '">' : member[field]) : '';
		tr.append(td);
	})
	// 삭제버튼
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
    btn.addEventListener('click', rowDelete, false); // bubble, capture 
	let td = document.createElement('td');
	td.append(btn);
	tr.append(td);

	// 체크박스. input type='checkbox'
	let chk = document.createElement('input');
	chk.setAttribute('type', 'checkbox');
	td = document.createElement('td');
	td.append(chk);
	tr.append(td);
	return tr;
}

function rowDelete() {
	let delId = this.parentElement.parentElement.getAttribute('id');
	let formData = new FormData();
	formData.append("cmd", "delete");
	formData.append("delId", delId);
	// id=32&name=hong
	fetch('memberUpload', {
		
		method:'post',
		headers: {'Content-type': 'application/x-www-form-urlencoded'
		},
		body: `cmd=delete&delId=${delId}`
	})
	.then(function(result) {
		return result.json();
	})
	.then(function(result) {
		console.log(result);
		// 화면에서도 지우도록 기능 추가.
	})
	.catch(function(err) {
		console.error(err);
	})
}

