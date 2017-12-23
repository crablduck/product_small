<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=request.getContextPath()+"/"%>">
</head>
<body>

	<form action="register" method="post">
		<input type="hidden" name="action" value="register"/>
		用户名：<input type="text" name="username"/>
		密码：<input type="text" name="password"/>
		<input type="submit" value="submit"/>
	</form>
</body>
</html>