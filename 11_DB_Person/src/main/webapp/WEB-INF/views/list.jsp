<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
list.jsp<br>
레코드 갯수 : ${fn:length(lists) } 개<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>이름</td>
		<td>나이</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<c:forEach var="p" items="${lists }">
		<tr>
			<td>${p.num }</td>
			<td>${p.id }</td>
			<td>${p.name }</td>
			<td>${p.age }</td>
			<td><a href="updateForm?num=${p.num }">수정</a></td>
			<td><a href="delete?num=${p.num }">삭제</a></td>
		</tr>
	</c:forEach>
	
</table>
<a href="form">삽입</a>