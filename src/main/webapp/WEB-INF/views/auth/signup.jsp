<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link rel="stylesheet" href="/static/css/signup.css">
		<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	
	<body>
		<form action="#">
			<table>
				<thead>
					<tr>
						<th colspan="2">회원가입</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디: </td>
						<td><input type="text" class="user-id"></td>
					</tr>
					<tr>
						<td>비밀번호: </td>
						<td><input type="password" class="user-password"></td>
					</tr>
					<tr>
						<td>이름: </td>
						<td><input type="text" class="user-name"></td>
					</tr>
					<tr>
						<td>이메일: </td>
						<td><input type="text" class="user-email"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button type="button" class="signup-button">회원가입</button>
							<button type="reset">다시작성</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
		<script type="text/javascript" src="/static/js/auth/signup.js"></script>
	</body>
</html>











