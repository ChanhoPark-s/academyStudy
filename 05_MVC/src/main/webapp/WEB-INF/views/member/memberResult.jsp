<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    �̰��� memberResult �̴�.<br>
    
    id : ${id}<br>
    id2 : <%=request.getAttribute("id") %><br>
    id3 : ${param.id}<br><!-- param�� ������ �Ѿ�ö� �� -->
    id4 : ${requestScope.id}<br>