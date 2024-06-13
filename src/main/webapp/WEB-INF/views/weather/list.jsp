<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/table.css" rel ="stylesheet"> 
</head>
<body>
		<h1>날씨 정보 리스트</h1>
		<table class="tb1">
			<thead>
				<tr>
					<th>Num</th>
					<th>도시</th>
					<th>기온</th>
					<th>상태</th>
					<th>습도</th>
				</tr>
			</thead>
		<tbody>
		<!-- items : weathercontroller 에서 request.setAttribute 속성으로 담아서 보낸거 꺼내 쓸라고    -->
		<!--  requestScope :  request 안에 무언가 꺼내 사용하려면 사용 | 값을 var="w"에 넣는다. -->
		<!-- pageScope :  이 페이지 안에서 사용하려면 사용 | setter를 이용해 값을 넣음 -->
			<c:forEach items="${requestScope.list}" var="w">
				<tr>
					<!--  파라미터 key의 이름은 : DTO의 setter의 이름과 동일하게 만들어라 -->
					<td>${pageScope.w.num}</td> 
					<td><a href="./detail?num=${pageScope.w.num}">${pageScope.w.city}</a></td>
				    <td>${pageScope.w.gion}</td>
				    <td>${pageScope.w.status}</td>
				    <td>${pageScope.w.huminity}</td>
				</tr>
			</c:forEach >
		</tbody>
	</table>
	
	<div>
		<a href="./add">날씨등록</a>
	</div>
</body>
</html>