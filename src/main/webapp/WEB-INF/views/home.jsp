<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="shortcut icon" href="resources/img/fav.ico">
	<title>Home</title>
</head>
<body>

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
<textarea style="width: 35%; height: 50%;">	
	/* ID */
	private String userId;
	/* password */
	private String userPw;
	/* 이름 */
	private String userNm;
	/* 별명 */
	private String nickname;
	/* 생일 8글자 */
	private String birthday;
	/* 성별 */
	private String gender;
	/* 이메일 */
	private String email;
	/* 휴대번호 */
	private String phone;
	/* 생성일 */
	private String createDate;
	/* 수정일 */
	private String updateDate;
	/* 사용여부 */
	private String useYn;
</textarea>
<button id="signUp">user/signUp</button>
<button id="signIn">user/signIn</button>
<button id="updateUser">user/updateUser</button>
<button id="selectUser">user/selectUser</button>
<button id="selectUserList">user/selectUserList</button>
<br/>
<textarea style="width: 35%; height: 50%;">	
	/* 게시글 고유번호 */
	private int postSeq;
	/* 게시글 분류ID */
	private int postInfoId;
	/* 게시글 제목 */
	private String postTitle;
	/* 게시글 내용 */
	private String postContents;
	/* 게시글 설명 */
	private String postDescription;
	/* 공지글 여부 */
	private String isMain;
	/* 생성일 */
	private String createDate;
	/* 생성자 */
	private String createUser;
	/* 수정일 */
	private String updateDate;
	/* 수정자 */
	private String updateUser;
	/* 사용여부 */
	private String useYn;
</textarea>
<button id="insertPost">post/insertPost</button>
<button id="updatePost">post/updatePost</button>
<button id="deletePost">post/deletePost</button>
<button id="selectPost">post/selectPost</button>
<button id="selectPostList">post/selectPostList</button><br/>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="resources/js/user.js"></script>
<script src="resources/js/post.js"></script>


</body>
</html>
