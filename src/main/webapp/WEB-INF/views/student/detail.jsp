<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생정보 한명</h1>
	
	<!-- EL 표현식 -->
	<!-- EL (Expression Language) 데이터 출력 전용 -->
	<%--${스코프영역명.속성명 } -> <h3>${requestScope.avg}</h3> --%>
	<!--  getter의 이름 : get을 빼고 첫글자를 소문자로 바꾼것 -->
	<!--  setter의 이름 : set을 빼고 첫글자를 소문자로 바꾼것 -->
	<h3>${requestScope.s.name}</h3>
	<h3>${requestScope.s.num}</h3>
	<h3>${requestScope.s.avg}</h3>
</body>
</html>