<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
	<!-- 使用spring表单标签 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</head>
<body>
	<!-- 文件的上传 -->
	<form action="${pageScope.basePath}file/upload.do" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file"><br> <input type="submit"
			value="submit">
	</form>

	<form:form action="${pageScope.basePath}form/add.do" method="post" modelAttribute="user">
    id:<form:input path="id" />
		<form:errors path="id" />
		<br>
    username:<form:input path="username" />
		<form:errors path="username" />
		<br>
    birth:<form:input path="birth" />
		<form:errors path="birth" />
		<input type="submit" value="submit">
	</form:form>
</body>
</html>