<%@page import="com.spring.ex.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
personView1.jsp<br>


id : ${param.id } <br>
pw : ${param.pw } <br>
name : ${param.name } <br>
addr : ${param.addr} <br>

--------------------<br>

id : ${pb.id}<br>
pw : ${pb.pw}<br>
name : ${pb.name}<br>
addr : ${pb.addr}<br>


<%PersonBean pb= (PersonBean)request.getAttribute("pb"); %>
id4 : <%=pb.getId() %><br>
pw4 : <%=pb.getPw() %><br>
name4 : <%=pb.getName() %><br>
addr4 : <%=pb.getAddr() %><br>
