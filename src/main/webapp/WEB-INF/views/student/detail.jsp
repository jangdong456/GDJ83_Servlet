<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/table.css" rel="stylesheet">
</head>
<body>
	<h1>학생정보 한명</h1>
	
	<!-- EL 표현식 -->
	<!-- EL (Expression Language) 데이터 출력 전용 -->
	<%--${스코프영역명.속성명 } -> <h3>${requestScope.avg}</h3> --%>
	<!--  getter의 이름 : get을 빼고 첫글자를 소문자로 바꾼것 -->
	<!--  setter의 이름 : set을 빼고 첫글자를 소문자로 바꾼것 -->
	<table class="tb1">
		<thead>
			<th>번호</th>
			<th>이름</th>
			<th>평균</th>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${pageScope.dto.num}</a></td>
				    <td><a href="./detail?name=${pageScope.dto.name}">${pageScope.dto.name}</td>
				    <td>${pageScope.dto.avg}</td>
				</tr>
			</c:forEach >
		</tbody>
	</table>
	
</body>
</html>