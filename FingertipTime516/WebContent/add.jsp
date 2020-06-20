<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="AddUserServlet" method="post">
		用户名：<input type="text" name="uname"/><br>
		账号：<input type="text" name="uid"/><br>
		性别：<input type="text" name="usex"/><br>
		密码：<input type="password" name="upwd"/><br>
		<input type="submit" value="新增"/>
		</form>
</body>
</html>