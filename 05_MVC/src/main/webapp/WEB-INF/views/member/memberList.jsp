<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

    memberList.jsp<br>
    
    name1 : ${name} <br>
    name2 : ${param.name} <br>
    name3 : ${requestScope.name} <br>
    name4 : <%=request.getParameter("name") %> <br>
    name5 : <%=request.getAttribute("name") %> <br>