<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <style>
   
   	.e{
   		font-weight: bold;
   		color: red;
   	}
   </style>
<%@ include file="../common/common.jsp" %>
    AlbumDetailView.jsp<br>
    
    <h2>상품 수정 화면</h2>
   <form:form commandName="album" action="update.ab" method="post">
    	<input type="hidden" name="num" value="${album.num }">
    	<input type="hidden" name="pageNumber" value="${pageNumber }">
    <table border="1">
    	<tr>
    		<td>노래제목</td>
    		<td>
    			<input type="text" value="${album.title }" name="title" >
    			<form:errors cssClass="e" path="title"/>
    		</td>
    	</tr>
    	<tr>
    		<td>가수명</td>
    		<td>
    			<input type="text" value="${album.singer }" name="singer">
    			<form:errors cssClass="e" path="singer"/>
    		</td>
    	</tr>
    	<tr>
    		<td>가격</td>
    		<td>
    			<input type="text" value="${album.price }" name="price">
    			<form:errors cssClass="e" path="price"/>
    		</td>
    	</tr>
    	<tr>
    		<td>발매일</td>
    		<td>
    			<fmt:parseDate var="day" value="${album.day }" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="nday" value="${day }" pattern="yyyy-MM-dd"/>
    			
    			<input type="text" value="${nday }" name="day">
    		</td>
    	</tr>
    	<tr>
    		<td><a href="list.ab">목록보기</a></td>
    		<td align="center"><input type="submit" value="수정하기"></td>
    	</tr>
    
    
    </table>
   </form:form> 
    