<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    test2 - test1Form.jsp <br>
    
    <form action="join2" method="get"> <!-- join2 만해도 이 전에 test2에서 왔기때문에 자동으로 test2에있다고 생각함. -->
    	<table>
			<tr>    	
    			<td>name</td>
    			<td><input type="text" name="name"></td>
    		</tr>
			<tr>    	
    			<td colspan="2">
    				<input type="submit" value="전송">
    			</td>
    		</tr>
    	</table>
    </form>