	$('#insertPost').click(function () {
		$.ajax({
			url : "/traview/post/insertPost",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				postId : 'jihee',
				postPw : 'jihee',
				postNm : 'jihee',
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

	$('#updatePost').click(function () {
		$.ajax({
			url : "/traview/post/updatePost",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				postId : 'g',
				postNm : 'jihee',
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

	$('#deletePost').click(function () {
		$.ajax({
			url : "/traview/post/deletePost",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				postId : 'g',
				postNm : 'jihee',
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

	$('#selectPost').click(function () {
		$.ajax({
			url : "/traview/post/selectPost",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				postId : 'g',
				postPw : 'g',
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
	
	$('#selectPostList').click(function () {
		$.ajax({
			url : "/traview/post/selectPostList",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				postId : 'g',
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
	
