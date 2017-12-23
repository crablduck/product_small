<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="${pageContext.request.contextPath}/">
</head>
<body>
<form action="book/updateBook" method="post">
	<input type="hidden" name="id" value="${book.id}"/>
	书名：<input type="text" name="bookName" value="${book.bookName}"/><br/>
	价钱:<input type="text" name="priceDouble" value="${book.priceDouble}"/><br/>
	<input type="submit" value="修改"/>
</form>
</body>
</html>