<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>사용자 관리 페이지</title>
		<link rel="stylesheet" href="/static/css/user-management.css">
		<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
	</head>
	<body>
		<div id="container">
			<header>
				<h1>사용자 관리 페이지</h1>
			</header>
		
			<main>
				<div class="input-items">
					<input type="text" class="user-input" placeholder="아이디">
					<input type="text" class="user-input" placeholder="비밀번호">
					<input type="text" class="user-input" placeholder="이름">
					<input type="text" class="user-input" placeholder="이메일">
					<button type="button" class="add-button">추가</button>
				</div>
			
				<table>
					<thead>
						<tr>
							<th>user_code</th>
							<th>user_id</th>
							<th>user_password</th>
							<th>user_name</th>
							<th>user_email</th>
							<th>user_phone</th>
							<th>user_address</th>
							<th>update</th>
							<th>delete</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</main>
		
		</div>
		<script type="text/javascript" src="/static/js/auth/user-management.js"></script>
	</body>
</html>












