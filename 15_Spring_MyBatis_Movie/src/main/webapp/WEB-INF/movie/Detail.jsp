<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	td{
		height: 50px;
	}
</style>

Detail.jsp<br>
  <center>
  <h2>영화 상세 화면</h2>
 <table border="1">
 	<tr>
 		<th>번호</th>
 		<td width="200px">${mb.num }</td> 
 	</tr>
 	<tr>
 		<th>제목</th>
 		<td>${mb.title }</td> 
 	</tr>
 	<tr>
 		<th>제작국가</th>
 		<td>${mb.continent }</td> 
 	</tr>
 	<tr>
 		<th>장르</th>
 		<td>${mb.genre }</td> 
 	</tr>
 	<tr>
 		<th>등급</th>
 		<td>${mb.grade }</td> 
 	</tr>
 	<tr>
 		<th>배우</th>
 		<td>${mb.actor }</td> 
 	</tr>
 	<tr>
 		<td colspan="2" align="center"><a href="list.mv?pageNumber=${pageNumber }">영화 리스트 화면으로 돌아감</a></td> 
 	</tr>
 </table>
 </center>