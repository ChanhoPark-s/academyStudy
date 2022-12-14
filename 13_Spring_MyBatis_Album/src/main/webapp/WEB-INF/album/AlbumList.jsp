<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function insert(){
		//alert(1);
		
		location.href="insert.ab";
	}
	function goUpdate(num,pageNumber){
		location.href="update.ab?num="+num+"&pageNumber="+pageNumber; 
	}

</script>
   
<%@ include file = "../common/common.jsp" %>
Album.List.jsp<br>
<center>
<h2 align="center">상품 리스트 화면(총 :${totalCount } 개)</h2>
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
		<td colspan="7" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>노래제목</th>
		<th>가수</th>
		<th>가격</th>
		<th>발매일</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="ab" items="${ lists}">
		<tr>
			<td>${ab.num }</td>
			<td>
			<a href="detail.ab?num=${ab.num }&pageNumber=${pageInfo.pageNumber}">${ab.title }</a></td>
			<td>${ab.singer }</td>
			<td>
				<fmt:formatNumber pattern="###,###" value="${ab.price }" var="price"/>${price }원
			</td>
			<td>
				<fmt:parseDate var="formattedDay" value="${ab.day }" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="newformattedDay" value="${formattedDay }" pattern="yyyy-MM-dd"/>
				${newformattedDay }
			</td>
			<td><a href="delete.ab?num=${ab.num }&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
			<td>
				<input type="button" value="수정" onClick="goUpdate(${ab.num},${pageInfo.pageNumber })">
			</td>
		</tr>
	</c:forEach>
</table>

<br><br>


${pageInfo.pagingHtml}<!-- page 버튼들 문자열로 된 변수를 가져옴 --> 
</center>