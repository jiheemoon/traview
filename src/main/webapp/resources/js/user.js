	$('#signUp').click(function () {
		$.ajax({
			url : "/traview/user/signUp",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				userId : 'jihee',
				userPw : 'jihee',
				userNm : 'jihee'
			}),
			success : function(a, b) {
				console.log(a);
				console.log(b);
			},
			error : function(a, b, c){
				console.log(a);
				console.log(b);
				console.log(c);
			},
            done : function(e) {
				console.log(e);
            }
		});
	});

	$('#signIn').click(function () {
		$.ajax({
			url : "/traview/user/signIn",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				userId : 'jihee',
				userPw : 'jihee',
				useYn : 'Y'
			}),
			success : function(a, b) {
				console.log(a);
				console.log(b);
			},
			error : function(a, b, c){
				console.log(a);
				console.log(b);
				console.log(c);
			},
            done : function(e) {
				console.log(e);
            }
		});
	});

	$('#updateUser').click(function () {
		$.ajax({
			url : "/traview/user/updateUser",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				userId : 'jihee',
				userPw : 'jihee',
				birthday : '19960824',
				phone	: '01034785503'
			}),
			success : function(a, b) {
				console.log(a);
				console.log(b);
			},
			error : function(a, b, c){
				console.log(a);
				console.log(b);
				console.log(c);
			},
            done : function(e) {
				console.log(e);
            }
		});
	});

	$('#deleteUser').click(function () {
		$.ajax({
			url : "/traview/user/deleteUser",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				userId : 'jihee'
			}),
			success : function(a, b) {
				console.log(a);
				console.log(b);
			},
			error : function(a, b, c){
				console.log(a);
				console.log(b);
				console.log(c);
			},
            done : function(e) {
				console.log(e);
            }
		});
	});
	
	$('#selectUser').click(function () {
		$.ajax({
			url : "/traview/user/selectUser",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				userId : 'jihee',
				useYn : 'Y'
			}),
			success : function(a, b) {
				console.log(a);
				console.log(b);
			},
			error : function(a, b, c){
				console.log(a);
				console.log(b);
				console.log(c);
			},
            done : function(e) {
				console.log(e);
            }
		});
	});
	
	$('#selectUserList').click(function () {
		$.ajax({
			url : "/traview/user/selectUserList",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				useYn : 'Y'
			}),
			success : function(a, b) {
				console.log(a);
				console.log(b);
			},
			error : function(a, b, c){
				console.log(a);
				console.log(b);
				console.log(c);
			},
            done : function(e) {
				console.log(e);
            }
		});
	});
	