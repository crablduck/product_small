<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${empty page.list}">
		暂无数据
	</c:when>
	<c:otherwise>
		<a href="${pageContext.request.contextPath}/${page.url}/1">首页</a>
		<c:if test="${page.currentPage!=1}">
			<a href="${pageContext.request.contextPath}/${page.url}/${page.currentPage-1}">上一页</a>
		</c:if>
		<c:if test="${page.currentPage < page.totalPage}">
			<a href="${pageContext.request.contextPath}/${page.url}/${page.currentPage+1}">下一页</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/${page.url}/${page.totalPage}">尾页</a>
	</c:otherwise>
</c:choose>