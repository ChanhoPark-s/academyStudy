<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

person/result1.jsp <br>

name1 : ${param.name}<br>
name2 : <%=request.getParameter("name") %><br>


name2-1 : ${requestScope.name2}<br>
name2-2 : ${name2}<br>
name2-3 : <%=request.getAttribute("name2") %><br>



age1 : ${param.age}<br>
age2 : <%=request.getParameter("age")%><br>