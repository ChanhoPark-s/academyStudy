<%@page import="com.spring.ex.MusicBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	result2.jsp
    
    
    제목 : ${mb['title'] }<br>
    가수명 : ${mb.singer }<br>
    가격 : ${mb.price}<br>
    s: ${s}<br>
    
    ----------------------------<br>
    
    <% MusicBean mb = (MusicBean)request.getAttribute("mb"); %>
		title1 : ${mb.title }<br>
		singer : ${mb['singer'] }<br>
		price : <%=mb.getPrice() %><br>
    