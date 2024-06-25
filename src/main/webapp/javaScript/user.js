function checkEmail(event) {
	// 이벤트 발생 객체
	const obj = event.target;	// button #check-email인거
	const target = obj.getAttribute("data-target");	// API 호출 위치
	const frm = obj.form;	// form
	
	const email = frm.email.value.trim();
	
	if(email.lenth === 0) {
		alert("이메일을 입력하세요");
		return;
	}
	

	fetch(`${target}?email=${email}`)
	.then(response => {
		console.log(response);
		return response;
	})
	.then(json => {
		console.log(json);
	
	// 중복 여부
	if(json.exists) {
		alert(`이미 사용중인 이메일 입니다`)
		throw new Error(`중복된 이메일입니다`);
	} else {
		alert(`사용 가능한 이메일 입니다`)
		frm.emailCheck.value="y";
	}
})

	.catch(error => console.error(error));
}

window.addEventListener("load",event => {
	document.getElementById("check-email").addEventListener("click",checkEmail);
	
	// 가입 폼 validation
	document.getElementById("join-form")
	.addEventListener("submit",event =>{
		const frm = event.target;
		
		event.preventDefault();
		
		// 이름 검증
		if(frm.name.value.trim().length ===0) {
			alert("이름을 입력하세요");
			frm.name.focus();
			return;
		}
		
		// 비밀번호 검증
		if(frm.password.value.trim().length === 0) {
			alert("비밀번호를 입력하세요");
			frm.password.focus();
			return;
		}
		
		// 이메일 검증
		if(frm.email.value.trim().length === 0) {
			alert("이메일을 입력하세요");
			frm.email.focus();
			return;
		}
		
		// 성별 검증
		const genders = document.querySelector(`input[name=gender]:checked`);
		if(genders === null) { //  체크된 radio가 없다
			alert("성별을 선택하세요");
			return;
			
		}
		
		// 이메일 중복체크 여부 판단
		if(frm.emailCheck.value !== "y") {
			alert("이메일 중복확인을 해주세요");
			return;
		}
		
		// 약관동의 여부
		if(!frm.agree.checked) {
			alert("약관에 동의해야 합니다");
			return;
		}
		
		// 폼 전송
		frm.submit();
	});
	
});