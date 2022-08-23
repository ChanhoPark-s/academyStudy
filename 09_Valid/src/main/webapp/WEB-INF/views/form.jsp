<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
	.err{
		font-size: 9pt;
		color : red;
		font-weight: bold;
	}

</style>


<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
form.jsp
<br>

<form:form commandName="mb" action="input" method="post">
	아이디 : <input type="text" name="id" value="${mb.id }">
		<form:errors cssClass="err" path="id"/>
	
	<br> 비밀번호 : <input type="text" name="pw"  value="${mb.pw }">
		<form:errors cssClass="err" path="pw"/>
	
	<br> <input type="submit" value="전송">
</form:form>