<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/static/css/signup.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th colspan="2">로그인</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>아이디</th>
				<td><input class="user-id"></td>				
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input class="user-password"></td>				
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<button type="button" class="signin-button">로그인</button>
					<button type="button" class="signup-button">회원가입</button>
				</td>
			</tr>
		</tfoot>
	</table>
	<script type="text/javascript" src="/static/js/auth/signin.js"></script>
</body>
</html>









