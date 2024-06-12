<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생정보입력 페이지</h1>
	<!--  action="" : 요청할 url | method=""-->
	<!--  label의 for 값과 input태그의 id값을 일치시켜주면 라벨 옆에 인풋태그가 생김  -->
	<form action="/student/add" method="post">
		<div>
			<label for="num">번호</label>
			<!--  name속성 : Parmeter 이름 | -->
			<!--  Parmeter이름 작성법 : setter의 이름과 동일하게 만들기 | set빼고 첫글자를 대문자에서 소문자로 -->
			<!--  value : 선택해야되는 것들은 개발자가 값을 넣어줘야 이게 어떤게 선택 되었다고 알수 있음 -->
			<input type="text" id= "num" name ="num" value="">
		</div>
		
		<div>
			<label for="name">이름</label>
			<input type="text" id= "name" name ="name">
		</div>
		
		<div>
			<label for="avg">평균</label>
			<input type="text" id= "avg" name ="avg">
		</div>
		
		<div>
			<label></label>
			<input type="radio" name="ch" value="여성">
			<input type="radio" name="ch" value="남성">
		</div>
		
		<div>
		<!--  선택된거 value값만 넘어감 -->
			<select name="mobile">
				<option value ="kt">KT</option>
				<option value ="lg">LG</option>
				<option value ="skt">SKT</option>
			</select>
		</div>
		
		<div>		
			<input type="checkbox" name="ch2" value="chek1">
			<input type="checkbox" name="ch2" value="chek2">
			<input type="checkbox" name="ch2" value="chek3">
		</div>
		
		<div>
			<textarea rows="" cols="" name ="contents"></textarea>
		</div>
		
		
		<div>
			<input type="submit" value="등록">
			<button type ="submit">작성</button>
		</div>
	</form>
	
	
</body>
</html>