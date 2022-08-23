<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/common.jsp" %>
Album.List.jsp<br>

<h2 align="center">상품 리스트 화면(총 : ${fn:length(lists) } 개)</h2>
<form action="list.ab" method="get">
	<select name="whatColumn">
		<option value="">전체검색
		<option value="title">노래제목
		<option value="singer">가수명
	</select>
	<input type="text" name="keyword" value="아이유">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td>번호</td>
		<td>노래제목</td>
		<td>가수</td>
		<td>가격</td>
		<td>발매일</td>
	</tr>
	<c:forEach var="ab" items="${ lists}">
		<tr>
			<td>${ab.num }</td>
			<td>${ab.title }</td>
			<td>${ab.singer }</td>
			<td>
				<fmt:formatNumber pattern="###,###" value="${ab.price }" var="price"/>원
			</td>
			<td>
				<fmt:parseDate var="formattedDay" value="${ab.day }" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="newformattedDay" value="${formattedDay }" pattern="yyyy-MM-dd"/>
				${newformattedDay }
			</td>
		</tr>
	</c:forEach>

</table>