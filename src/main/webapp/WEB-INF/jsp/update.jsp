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
</head>
<body>
	<form action="${pageScope.basePath}user/update.do">
		<table>
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" value="${user.username}" /></td>
			</tr>

			<tr>
				<td>password:</td>
				<td><input type="password" name="password" value="${user.password}" /></td>
			</tr>
			<%-- <tr>
				<td>age:</td>
				<td><input type="text" name="age" value="${user.age}" /></td>
			</tr>

			<tr>
				<td>sex:</td>
				<td><c:choose>
						<c:when test="${user.sex == 0 }">
							<input type="radio" name="sex" value="0" checked="checked" />Male
					<input type="radio" name="sex" value="5" />Female
						</c:when>

						<c:when test="${user.sex == 5 }">
							<input type="radio" name="sex" value="0" />Male
					<input type="radio" name="sex" value="5" checked="checked" />Female
						</c:when>
					</c:choose></td>
			</tr>

			<tr>
				<td>address:</td>
				<td><input type="text" name="address" value="${user.address}" /></td>
			</tr> --%>

			<tr>
				<td><input type="hidden" name="sid" value="${user.id }" /><input
					type="submit" value="submit" /></td>
				<td><input type="reset" value="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>