<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
   
    list.jsp<br>
    
    레코드갯수 ${fn:length(lists) }
    <table border="1">
    	<tr>
    		<td>번호</td>
    		<td>아이디</td>
    		<td>비번</td>
    		<td>우승 예상국가</td>
    		<td>16강 예상국가</td>
    	</tr>
    	<c:forEach var="f" items="${lists }">
    	<tr>
    		<td>${f.num}</td>
    		<td><a href="updateForm?num=${f.num }">${f.id}</a></td>
    		<td>${f.pw}</td>
    		<td>${f.win}</td>
    		<td>${f.round16}</td>
    	</tr>
    	</c:forEach>
    	<tr>
    		<td colspan="5">
    			<a href="javascript:history.go(-1)">돌아가기</a>
    			<a href="form">삽입</a>
    		</td>
    	</tr>
    </table>