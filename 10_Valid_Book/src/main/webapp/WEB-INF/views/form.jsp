<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <style>
 	.c{
 		size: 1;
 		font-weight: bold;
 		color : red;
 	}
 
 </style>   
    
    
form.jsp<br>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form commandName="bb" action="inputProc" method="post">
	
	제목 : <input type="text" name="title" value="${bb.title }">
		<form:errors cssClass="c" path="title"/><br><br>
	
	저자 : <input type="text" name="author" value="${bb.author }">
		<form:errors cssClass="c" path="author"/><br><br>
	
	가격 : <input type="text" name="price" value="${bb.price }">
		<form:errors cssClass="c" path="price"/><br><br>
	
	출판사 : <input type="text" name="publisher" value="${bb.publisher }">
		<form:errors cssClass="c" path="publisher"/><br><br>
		
	구입 가능 서점:
		교보문고<input type="checkbox" name="bookstore" value="교보문고" <c:if test="${fn:contains(bb.bookstore,'교보문고') }">checked</c:if>> 
		알라딘<input type="checkbox" name="bookstore" value="알라딘"<c:if test="${fn:contains(bb.bookstore,'알라딘') }">checked</c:if>> 
		yes24<input type="checkbox" name="bookstore" value="yes24" <c:if test="${fn:contains(bb.bookstore,'yes24') }">checked</c:if>> <br><br>
		<form:errors cssClass="c" path="bookstore"/><br><br>
	
	배송비 :
		유료<input type="radio" name="kind" value="유료" <c:if test="${bb.kind=='유료' }">checked</c:if>>
		무료<input type="radio" name="kind" value="무료"  <c:if test="${bb.kind eq '무료' }">checked</c:if>>
		<form:errors cssClass="c" path="kind"/><br><br>
		
		
	<input type="submit" value="전송">
</form:form>

<!-- 제목 ㅣ 제목 입력 누락 
저자 : 저자 입렭누락, 5글자 이상으로 입력,
가격 : 숫자로 입력, 5자리 이하로 입력
출판사 : 출판사 입력 누락

result.jsp에서 결과출력
--> 