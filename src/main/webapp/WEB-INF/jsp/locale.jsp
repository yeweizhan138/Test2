<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
	<!-- ʹ��spring����ǩ -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	// ��ñ���Ŀ�ĵ�ַ(����: http://localhost:8080/MyApp/)��ֵ��basePath���� 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// �� "��Ŀ·��basePath" ����pageContext�У����Ժ���EL���ʽ������ 
	pageContext.setAttribute("basePath", basePath);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>

<body>
  <fmt:message key="username"></fmt:message>
  <fmt:message key="password"></fmt:message>
</body>
</html>

