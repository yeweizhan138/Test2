<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
<style type="text/css">
table, td {
	font: 100% Arial, Helvetica, sans-serif;
	font-size: 14px;
}

.dd table {
	border-collapse: collapse;
	border: none;
}

.dd td {
	border: solid gray 1px;
	height: 25px;
	text-align: center;
}
</style>


</head>
<body>
	RegistUser:
	<form action="${pageScope.basePath}user/add.do">
		<table>
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" /></td>
			</tr>

			<tr>
				<td>password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<!-- <tr>
				<td>age:</td>
				<td><input type="text" name="age" /></td>
			</tr>

			<tr>
				<td>sex:</td>
				<td><input type="radio" name="sex" value="0" checked="checked" />Male
					<input type="radio" name="sex" value="5" />Female</td>
			</tr>

			<tr>
				<td>address:</td>
				<td><input type="text" name="address" /></td>
			</tr>
 -->
			<tr>
				<td></td>
				<td><input type="submit" value="submit" /> <input type="reset"
					value="reset" /></td>
			</tr>
		</table>
	</form>
	<br>
	<div class="dd">
		<table width="800px">
			<tr>
				<td width="15%">id</td>
				<td width="10%">username</td>
				<td width="10%">password</td>
				<!-- <td width="10%">age</td>
				<td width="10%">sex</td>
				<td width="10%">address</td>
				<td width="20%">operation</td> -->
			</tr>

			<c:forEach items="${users}" var="user" varStatus="status">
				<tr>
					<!-- ${status.index+1}编号 -->
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.password}" /></td>
					<%-- <td><c:out value="${user.age}" /></td>
					<td><c:if test="${user.sex == 0}">
							<c:out value="Male" />
						</c:if> <c:if test="${user.sex == 5}">
							<c:out value="Female" />
						</c:if></td>
					<td><c:out value="${user.address}" /></td> --%>
					<td><a href="${pageScope.basePath}user/detail/${user.id}.do">detail</a>
						<a href="${pageScope.basePath}user/toupdate/${user.id}.do">update</a>
						<a href="${pageScope.basePath}user/delete/${user.id}.do">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<font size="2">共 ${page.totalPageCount} 页</font>
	<font size="2">第 ${page.pageNow} 页</font>
	<a href="${pageScope.basePath}user/list.do?pageNow=1&pageSize=${page.pageSize}">首页</a>
	<c:choose>
		<c:when test="${page.pageNow - 1 > 0}">
			<a
				href="${pageScope.basePath}user/list.do?pageNow=${page.pageNow - 1}&pageSize=${page.pageSize}">上一页</a>
		</c:when>
		<c:when test="${page.pageNow - 1 <= 0}">
			<a href="${pageScope.basePath}user/list.do?pageNow=1&pageSize=${page.pageSize}">上一页</a>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${page.pageNow + 1 < page.totalPageCount}">
			<a
				href="${pageScope.basePath}user/list.do?pageNow=${page.pageNow + 1}&pageSize=${page.pageSize}">下一页</a>
		</c:when>
		<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
			<a
				href="${pageScope.basePath}user/list.do?pageNow=${page.totalPageCount}&pageSize=${page.pageSize}">下一页</a>
		</c:when>
	</c:choose>
	<a
		href="${pageScope.basePath}user/list.do?pageNow=${page.totalPageCount}&pageSize=${page.pageSize}">尾页</a>
	<form action="${pageScope.basePath}user/list.do">
		ChoosePage:<input width="10px" type="text" name="pageNow" /> 
			<br/>
		ChangePageSize:<input width="10px" type="text" name="pageSize" /> <input type="submit"
			value="changePageSize" />
	</form>

</body>
</html>