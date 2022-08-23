<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    
    이곳은 memberResult 이당.<br>
    
    id : ${id}<br>
    id2 : <%=request.getAttribute("id") %><br>
    id3 : ${param.id}<br><!-- param은 폼에서 넘어올때 씀 -->
    id4 : ${requestScope.id}<br>
