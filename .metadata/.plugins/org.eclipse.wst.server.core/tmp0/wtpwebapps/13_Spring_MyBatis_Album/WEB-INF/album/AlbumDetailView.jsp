<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
    AlbumDetailView.jsp<br>
    ${album.singer}<br>
    ${album.num}<br>
    
    
    <h2>상품 상세 화면</h2>
    
    <table border="1">
    	<tr>
    		<td>번호</td>
    		<td>${album.num }</td>
    	</tr>
    	<tr>
    		<td>노래제목</td>
    		<td>${album.title }</td>
    	</tr>
    	<tr>
    		<td>가수명</td>
    		<td>${album.singer }</td>
    	</tr>
    	<tr>
    		<td>가격</td>
    		<td><fmt:formatNumber pattern="###,###" var="price" value="${album.price }"/>${price}원</td>
    	</tr>
    	<tr>
    		<td>발매일</td>
    		<td>
    		
    		${album.day }
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2"><a href="list.ab?pageNumber=${pageNumber }">앨범 리스트 화면으로 돌아감</a></td>
    	</tr>
    
    
    </table>
    
    