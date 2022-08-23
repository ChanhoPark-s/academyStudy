<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
personView2.jsp<br>

<% PersonBean pb = new PersonBean()%>

id : <%=pb.getId() %><br>
pw : ${personBean.pw}<br>
name : ${personBean.name}<br>
addr : ${personBean.addr}<br>
