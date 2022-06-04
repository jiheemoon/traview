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
    <style>
    	* {
    		font-size: x-small;
    	}
		textarea {
			width: 25%;height: 18%;float:right;
		}
		table {
			width: 75%;float:left;border: 1px solid gray;
      	}
      	tr:hover {
			border: 3px solid #878b93;
			outline: 1px solid #242b3a;
		}
		th, td {
			border: 1px solid gray;
		}
    </style>
</head>
<body>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

<%-- <P>  The time on the server is ${serverTime}. </P> --%>
<!--// 사용자 -->
<textarea>	
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
<table>
	<tr>
		<th>사용</th>
		<th>URL</th>
		<th>DATA TYPE</th>
		<th>DATA 필수</th>
		<th>DATA 필수X</th>
	</tr>
	<tr id="signUp">
		<td>회원가입</td>
		<td>/user/signUp</td>
		<td>POST</td>
		<td>
				userId : 'jihee',
				userPw : 'jihee',
				userNm : 'jihee',</td>
		<td>
				nickname : '지희',
				birthday : '19960824',
				gender : 'F',
				email : 'jihee@test.com',
				phone	: '01034785503'</td>
	</tr>
	<tr id="signIn">
		<td>로그인</td>
		<td>/user/signIn</td>
		<td>POST</td>
		<td>
				userId : 'jihee',
				userPw : 'jihee'</td>
		<td></td>
	</tr>
	<tr id="updateUser">
		<td>회원수정</td>
		<td>/user/updateUser</td>
		<td>POST</td>
		<td>
				userId : 'jihee'</td>
		<td>	userPw : 'jihee'
				userNm : '지희',
				nickname : '지희',
				birthday : '19960824',
				gender : 'F',
				email : 'jihee@test.com',
				phone	: '01034785503'</td>
	</tr>
	<tr id="deleteUser">
		<td>회원삭제</td>
		<td>/user/deleteUser</td>
		<td>POST</td>
		<td>
				userId : 'jihee'</td>
		<td></td>
	</tr>
	<tr id="selectUser">
		<td>회원정보, 미사용회원정보</td>
		<td>/user/selectUser</td>
		<td>POST</td>
		<td>
				userId : 'jihee',</td>
		<td>	userPw : 'jihee'
				useYn : 'Y'</td>
	</tr>
	<tr id="selectUserList">
		<td>회원정보 리스트</td>
		<td>/user/selectUserList</td>
		<td>POST</td>
		<td>
				useYn : 'Y'</td>
		<td></td>
	</tr>
</table>
<script src="resources/js/user.js"></script>
<br/>
<!-- 사용자 //-->

<!--// 게시판 -->
<textarea>	
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
<table>
	<tr>
		<th>사용</th>
		<th>URL</th>
		<th>DATA TYPE</th>
		<th>DATA 필수</th>
		<th>DATA 필수X</th>
	</tr>
	<tr id="insertPost">
		<td>게시판등록</td>
		<td>/post/insertPost</td>
		<td>POST</td>
		<td>
				postInfoId : 0,
				postTitle : '제목',
				postContents : '내용',
				postDescription : '',
				isMain : 'Y',
				createUser : 'jihee'</td>
		<td></td>
	</tr>
	<tr id="updatePost">
		<td>게시판수정</td>
		<td>/post/updatePost</td>
		<td>POST</td>
		<td>
				postSeq : 1</td>
		<td>
				postInfoId : 0,
				postTitle : '제목1',
				postContents : '내용1',
				postDescription : '설명1',
				isMain : 'Y',
				useYn : 'Y',
				updateUser : 'jihee'</td>
	</tr>
	<tr id="deletePost">
		<td>게시판 삭제</td>
		<td>/post/deletePost</td>
		<td>POST</td>
		<td>
				postSeq : 2</td>
		<td></td>
	</tr>
	<tr id="selectPost">
		<td>게시판상세</td>
		<td>/post/selectPost</td>
		<td>POST</td>
		<td>
				postSeq : 1</td>
		<td>	
				useYn : 'Y'</td>
	</tr>
	<tr id="selectPostList">
		<td>게시판리스트</td>
		<td>/post/selectPostList</td>
		<td>POST</td>
		<td>
				useYn : 'Y'</td>
		<td></td>
	</tr>
</table>
<script src="resources/js/post.js"></script>
<br/>
<!--// 게시판 -->


</body>
</html>
