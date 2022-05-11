	$('#insertPost').click(function () {
		$.ajax({
			url : "/traview/post/insertPost",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				postInfoId : 0,
				postTitle : '제목',
				postContents : '내용',
				postDescription : '',
				isMain : 'Y',
				createUser : 'jihee',
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
				postSeq : 1,
				postInfoId : 0,
				postTitle : '제목1',
				postContents : '내용1',
				postDescription : '설명1',
				isMain : 'Y',
				useYn : 'Y',
				updateUser : 'jihee',
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
				postSeq : 2
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
				postSeq : 1,
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
				useYn : 'Y',
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
	
