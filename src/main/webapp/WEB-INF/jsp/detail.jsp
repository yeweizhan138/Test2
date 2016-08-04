<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
String path = request.getContextPath(); 
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
pageContext.setAttribute("basePath",basePath); 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
<style type="text/css">
table,td {
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
	<div class="dd">
		<table>

			<tr>
				<td width="25%">ID</td>
				<td width="10%">username</td>
				<td width="10%">password</td>
				<!-- <td width="10%">age</td>
				<td width="10%">sex</td>
				<td width="10%">address</td>
				<td width="20%">operation</td> -->
			</tr>

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
				<td><a href="${pageScope.basePath}user/detail.do/${user.id}">detail</a> <a
					href="${pageScope.basePath}user/toupdate.do/${user.id}">update</a> <a
					href="${pageScope.basePath}user/delete.do/${user.id}">delete</a></td>
			</tr>
		</table>
	</div>
	<a href="${pageScope.basePath}user/list.do?pageNow=1">首页</a>
</body>
</html>