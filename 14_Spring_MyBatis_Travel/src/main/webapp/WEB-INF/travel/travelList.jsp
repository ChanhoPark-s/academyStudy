<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">


function insert(){
	//alert(1);
	
	location.href="insert.tv";
	
}
function updateForm(num,pageNumber){
	
	location.href="update.tv?num="+num+"&pageNumber="+pageNumber;
}
</script>
    
    

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
		<td colspan="8" align="right">
			<input type="button" value="추가하기"onClick="insert()">
		</td>
	</tr>
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
			<td><a href="detail.tv?num=${tb.num }&pageNumber=${page.pageNumber}">${tb.name }</a></td>
			<td>${tb.age }</td>
			<td>${tb.area }</td>
			<td>${tb.style }</td>
			<td>${tb.price }</td>
			<td><a href="delete.tv?num=${tb.num }&pageNumber=${page.pageNumber}">삭제</a></td>
			<td><input type="button" value="수정"  onclick="updateForm(${tb.num},${page.pageNumber})"></td>
		</tr>
	</c:forEach>
</table>
</form>

${page.pagingHtml}

</center>