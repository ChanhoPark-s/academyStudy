<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../taglib.jsp" %>
travelList.jsp<br>
<center>

<form action="list.tv" method="get">
<h2>여행 리스트 화면(총 갯수 : ${count })</h2>

<select name="whatColumn">
	<option>전체검색
	<option  value="area">관심지역
	<option  value="style">여행타입
</select>
<input type="text" name="keyword">
<input type="submit" value="검색"><br><br>


<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>관심지역</th>
		<th>여행타입</th>
		<th>예상비용</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="tb" items="${lists }">
		<tr>
			<td>${tb.num }</td>
			<td>${tb.name }</td>
			<td>${tb.age }</td>
			<td>${tb.area }</td>
			<td>${tb.style }</td>
			<td>${tb.price }</td>
			<td><a href="delete.tv?num=${tb.num }">삭제</a></td>
			<td><button href="updateForm.tv?num=${tb.num }">수정</button></td>
		</tr>
	</c:forEach>
</table>
<a href="insert.tv">추가</a>
</form>

${page.pagingHtml}

</center>