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

	<h1>학생 목록</h1>

	<!--  가로부터 만듬 -->

	

	<!--  JSTL 이라는 라이브러리 -->
	<!--  for(데이터 타입 변수명 : 배열명 -->
	<!--  page Scope jsp가 나오면 실행되고 jsp로 나오면 소멸->  -->
	<!--  requestScope -> 응답이 나가면 소멸되는 스코프 -->
	<div>
		<img alt="" src="/resources/images/cat1.jpeg">
	</div>
	
	<table class="tb1">
		<thead>
			<th>번호</th>
			<th>이름</th>
			<th>평균</th>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="student">
				<tr>
					<td>${pageScope.student.num}</td>
				    <td><a href="./detail?name=${pageScope.student.name}"></a>${pageScope.student.name}</td>
				    <td>${pageScope.student.avg}</td>
				</tr>
			</c:forEach >
		</tbody>
	</table>
	
</body>
</html>