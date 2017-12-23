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
<h3>展示学生信息</h3>
<a href="add.jsp">添加学生</a>
<table border="1">
	<tr>
		<td>学生名</td>
		<td>年龄</td>
		<td>密码</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${page.list}" var="stu">
		<tr>
		<td><a href="book/booksByStu/${stu.id}/1">${stu.name}</a></td>
		<td>${stu.age}</td>
		<td>${stu.password}</td>
		<td>
			<a href="student/deleteStudent/${stu.id}">删除</a>
			<a href="student/toUpdate/${stu.id}">编辑</a>
		</td>
	</tr>
	</c:forEach>
</table>
<%@include file="common/page.jsp" %>
</body>
</html>