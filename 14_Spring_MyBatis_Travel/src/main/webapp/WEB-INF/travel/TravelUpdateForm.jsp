<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<style>
	.e{
		color: red;
		font-weight: bold;
	}

	
</style>

<%@include file="../taglib.jsp" %>

<%
String[] areaArr = { "유럽", "동남아", "일본", "중국" };
String[] styleArr = { "패키지", "크루즈", "자유여행", "골프여행" };
String[] priceArr = { "100~200", "200~300", "300~400", "400~500" };
%>

travelUpdateForm.jsp<br>

<center>
<form:form commandName="t" method="post"  action="update.tv">
		<input type="hidden" name="pageNumber" value="${pageNumber }">
		<input type="hidden" name="num" value="${t.num }">
	<h1><span>여행 정보 수정 화면</span></h1>
	<p>
		<label for="name">이름</label>
		<input type="text" name="name" value="${t.name }">
		<form:errors cssClass="e" path="name"/>
	</p>

	<p>
		<label for="age">나이</label>
		<input type="text" name="age" value="${t.age }">
		<form:errors cssClass="e" path="age"/>
	</p>
	<p>
		<label for="area">관심지역</label>
		<c:forEach var="area" items="<%=areaArr %>">
		<input type="checkbox" name="area" value="${area }" <c:if test="${fn:contains(t.area,area) }">checked</c:if>>${area }
		</c:forEach>
		<form:errors cssClass="e" path="area"/>
		
	</p>
	
	<p>
		<label for="style">여행 타입</label>
		<c:forEach var="s" items="<%=styleArr %>">
		<input type="radio" name="style"  value="${s }" <c:if test="${t.style==s }">checked</c:if>>${s }
		</c:forEach>
		<form:errors cssClass="e" path="style"/>
	</p>
	
	 <p>
		<label for="price">가격</label>
		<select name = "price">
			<option value="">선택하세요</option> 
				<c:forEach var="p" items="<%=priceArr %>">
						<option value="${p }" <c:if test="${t.price==p }">selected</c:if>>${p }</option>
				</c:forEach>
		</select>
		<form:errors cssClass="e" path="price"/>
	</p>
	<p>
			<input type="submit" value="수정하기" >	
			<a href="list.tv?pageNumber=${pageNumber }">목록보기</a>	
	</p>
</form:form>

</center>