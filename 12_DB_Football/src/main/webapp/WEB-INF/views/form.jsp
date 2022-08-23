<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
form.jsp <br><br>

	<form:form commandName="fb" action="write" method="post">
		<table width="700" height="200" cellpadding="0" cellspacing="0" border="1" >
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="50" value="${fb.id }">
					<form:errors path="id"/>
				</td>
			</tr>
			<tr>
				<td>비번</td>
				<td><input type="text" name="pw" size="50" value="${fb.pw }">
				<form:errors path="pw"/>
				</td>
			</tr>
			<tr>
				<td>우승예상국가</td>
				<td>
					<input type="radio" name="win" value="한국" <c:if test="${fb.win eq '한국' }">checked</c:if>>한국
					<input type="radio" name="win" value="미국" <c:if test="${fb.win eq '미국' }">checked</c:if>>미국
					<input type="radio" name="win" value="독일" <c:if test="${fb.win eq '독일' }">checked</c:if>>독일
					<input type="radio" name="win" value="스페인" <c:if test="${fb.win eq '스페인' }">checked</c:if>>스페인
				<form:errors path="win"/>
				</td>
			</tr>
			<tr>
				<td>16강예상국가</td>
				<td>
					<input type="checkbox" name="round16" value="한국" <c:if test="${fn:contains(fb.round16,'한국') }">checked</c:if>>한국
					<input type="checkbox" name="round16" value="멕시코" <c:if test="${fn:contains(fb.round16,'멕시코') }">checked</c:if>>멕시코
					<input type="checkbox" name="round16" value="독일" <c:if test="${fn:contains(fb.round16,'독일') }">checked</c:if>>독일
					<input type="checkbox" name="round16" value="브라질" <c:if test="${fn:contains(fb.round16,'브라질') }">checked</c:if>>브라질
					<input type="checkbox" name="round16" value="스위스" <c:if test="${fn:contains(fb.round16,'스위스') }">checked</c:if>>스위스
					<input type="checkbox" name="round16" value="잉글랜드" <c:if test="${fn:contains(fb.round16,'잉글랜드') }">checked</c:if>>잉글랜드
				<form:errors path="round16"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">
					&nbsp;&nbsp; 
					<a href="list">목록보기</a>
				</td>
			</tr>
		</table>
	</form:form>
