<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../../taglib.jsp"%>


<h2>movieList.jsp</h2>
<hr>
<center>
<h3></h3>
<form action="list.mv" method="post">
	<select name="whatColumn">
		<option value="">전체 검색</option>
		<option value="genre">장르</option>
		<option value="grade">등급</option>
		<option value="actor">출연배우</option>

	</select> <input type="text" name="keyword"> <input type="submit"
		value="검색">
</form>
<br>


<table border=1>
	<tr align=right>
		<td colspan=9><input type="button" value="추가하기" onclick="">
		</td>
	</tr>
	<tr align=center>
		<th>번호</th>
		<th>제목</th>
		<th>대륙</th>
		<th>제작국가</th>
		<th>장르</th>
		<th>등급</th>
		<th>출연배우</th>
		<th>삭제</th>
		<th>수정</th>


		<c:forEach var="mb" items="${lists}">
			<tr align=center>
				<td>${mb.num}</td>
				<td><a href="">${mb.title}</a></td>
				<td>${mb.continent}</td>
				<td>${mb.nation}</td>
				<td>${mb.genre}</td>
				<td>${mb.grade}</td>
				<td>${mb.actor}</td>
				<td><a href="">삭제</a></td>
				<td><input type="button" value="수정" onclick=""></td>
			</tr>
		</c:forEach>
</table>
${pageInfo.pagingHtml}
</center>

