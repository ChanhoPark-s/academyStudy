<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.a{
		color: red;
		size: 1px;
		font-weight: bold;
	}
</style>    
 
<%@include file="../common/common.jsp" %>

AlbumInsertForm.jsp <br>

<form:form commandName="album" action="insert.ab" method="post">
<h1><span>앨범 추가 화면</span></h1>
	<p>
		<label>노래제목</label>
		<input type="text" name="title"  value="${album.title }">
		<form:errors cssClass="a" path="title"/>
	</p>

	<p>
		<label>가수명</label>
		<input type="text" name="singer"  value="${album.singer }"> 
		<form:errors cssClass="a" path="singer"/>
	</p>
	
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${album.price }">
		<form:errors cssClass="a" path="price"/>
	</p>
	
	<p>
		<label>발매일</label>
		<input type="text" name="day" value="${album.day }">
		<form:errors cssClass="a" path="day"/>
	</p>
	<p>
			<input type="submit" value="추가하기">		
	</p>
</form:form>