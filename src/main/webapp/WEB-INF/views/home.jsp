<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<button id="signUp">user/signUp</button>
<button id="signIn">user/signIn</button>
<button id="updateUser">user/updateUser</button>
<span id="result"></span>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

	console.log(JSON.stringify({
		userId : 'g',
		userPw : 'g',
		userNm : 'g',
	}));
	
	$('#signUp').click(function () {
		$.ajax({
			url : "/traview/user/signUp",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				userId : 'g',
				userPw : 'g',
				userNm : 'g',
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
				userId : 'g',
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
			url : "/traview/user/signIn",
	        type		: "POST",
	        dataType	: "json",
	        contentType : "application/json",
			data : JSON.stringify({
				userId : 'g',
				userNm : 'jihee',
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
	
</script>

</body>
</html>
