<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()+"/"%>">
<title>Insert title here</title>
</head>
<body>
<h3>展示书籍信息</h3>
<a href="addBook.jsp">添加书籍</a>
<table border="1">
	<tr>
		<td>书名</td>
		<td>价格</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${books}" var="book">
		<tr>
		<td>${book.bookName}</td>
		<td>${book.priceDouble}</td>
		<td>
			<a href="book/deleteBook/${book.id}">删除</a>
			<a href="book/toUpdate/${book.id}">编辑</a>
		</td>
	</tr>
	</c:forEach>
</table>
<%@include file="common/page.jsp" %>
</body>
</html>