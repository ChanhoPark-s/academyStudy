<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

updateForm.jsp

	<form action="update" method="post">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
				<input type="hidden" name="num" size="50" value="${p.num }">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="50" value="${p.id }"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="50" value="${p.name }"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age"  value="${p.age }"></input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정하기">
					&nbsp;&nbsp; <a href="list">목록보기</a></td>
			</tr>
		</table>
	</form>