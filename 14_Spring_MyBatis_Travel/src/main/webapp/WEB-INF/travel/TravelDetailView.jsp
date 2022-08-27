<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	td{
		height : 50px;
		width : 200px;
		text-align: center;
	}
	
</style>

TravelDetailView.jsp<br>

	
	<center>
		<h2>여행 상세 화면</h2>
		<table border="1">
			<tr>
				<th>번호</th>
				<td>${tb.num }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${tb.name }</td>
			</tr>
			<tr>
				<th>관심지역</th>
				<td>${tb.area }</td>
			</tr>
			<tr>
				<th>여행타입</th>
				<td>${tb.style }</td>
			</tr>
			<tr>
				<th>가격대</th>
				<td>${tb.price }</td>
			</tr>
			<tr>
				<td colspan="2" >
					<a href="list.tv?pageNumber=${pageNumber }">여행리스트 화면으로 돌아감</a>
				</td>
			</tr>
		</table>
	</center>