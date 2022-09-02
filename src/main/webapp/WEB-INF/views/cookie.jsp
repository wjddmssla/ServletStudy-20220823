<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
	<style type="text/css">
		* {
			box-sizing: border-box;
		}
	
		body {
			display: flex;
			flex-direction: column;
			justify-content: center;
			align-items: center;
		}
	
		table {
			border-collapse: collapse;
			border: 1px solid #141414;
			width: 1300px;
		}
		
		th, td {
			border: 1px solid #141414;
			text-align: center;
		}
		
	</style>

</head>
<body>
	<div>
		<input class="cookie-key" placeholder="key값">
		<input class="cookie-value" placeholder="value값">
		<button type="button" class="add-button">추가</button>
	</div>
	

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>콘텐츠</th>
				<th>도메인</th>
				<th>경로</th>
				<th>만료시간</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	<script type="text/javascript" src="/static/js/cookie.js"></script>
</body>
</html>



