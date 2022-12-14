<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
updateForm.jsp<br>

<%
 String[] w = {"한국","미국","독일","스페인"};
String[] r = {"한국","멕시코","독일","브라질","스위스","잉글랜드"};
%>
<c:set  var="w" value="<%=w %>"/>
<c:set  var="r" value="<%=r %>"/>

<form action="update" method="post">
		<table width="700" height="200" cellpadding="0" cellspacing="0" border="1" >
				<input type="hidden" name="num" value="${f.num }">
			<tr>
				<td>아이디</td>
				<td>${f.id }"
			</tr>
			<tr>
				<td>비번</td>
				<td><input type="text" name="pw" size="50" value="${f.pw }"></td>
			</tr>
			<tr>
				<td>우승예상국가</td>
				<td>
					<c:forEach var="win" items="${w }">
						<input type="radio" name="win" value="${win }"<c:if test="${f.win eq win }">checked</c:if>>${win} 
					</c:forEach>
				
					<%-- <input type="radio" name="win" value="한국" <c:if test="${f.win eq '한국' }">checked</c:if>>한국
					<input type="radio" name="win" value="미국" <c:if test="${f.win eq '미국' }">checked</c:if>>미국
					<input type="radio" name="win" value="독일" <c:if test="${f.win eq '독일' }">checked</c:if>>독일
					<input type="radio" name="win" value="스페인" <c:if test="${f.win eq '스페인' }">checked</c:if>>스페인 --%>
				</td>
			</tr>
			<tr>
				<td>16강예상국가</td>
				<td> 
					<c:forEach var="round" items="${r }">
						<input type="checkbox" name="round16" value="${round }" <c:if test="${fn:contains(f.round16,round) }">checked</c:if>>${round }
					</c:forEach>
					<%-- <input type="checkbox" name="round16" value="한국" <c:if test="${fn:contains(f.round16,'한국') }">checked</c:if>>한국
					<input type="checkbox" name="round16" value="멕시코" <c:if test="${fn:contains(f.round16,'멕시코') }">checked</c:if>>멕시코
					<input type="checkbox" name="round16" value="독일" <c:if test="${fn:contains(f.round16,'독일') }">checked</c:if>>독일
					<input type="checkbox" name="round16" value="브라질" <c:if test="${fn:contains(f.round16,'브라질') }">checked</c:if>>브라질
					<input type="checkbox" name="round16" value="스위스" <c:if test="${fn:contains(f.round16,'스위스') }">checked</c:if>>스위스
					<input type="checkbox" name="round16" value="잉글랜드" <c:if test="${fn:contains(f.round16,'잉글랜드') }">checked</c:if>>잉글랜드 --%>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="수정">
					&nbsp;&nbsp; 
					<a href="list">목록보기</a>
					&nbsp;&nbsp; 
					<a href="delete?num=${f.num }">삭제</a>
				</td>
			</tr>
		</table>
	</form>
