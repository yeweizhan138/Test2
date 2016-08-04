<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>

    下面展示的是后台获取的国际化信息：<br/>
    ${username}<br/>
    ${birth}<br/>

    下面展示的是视图中直接绑定的国际化信息：<br/>
    <spring:message code="username"/>:<br/>
    <spring:eval expression="contentModel.username"></spring:eval><br/>
    <spring:message code="birth"/>:<br/>
    <spring:eval expression="contentModel.birth"></spring:eval><br/>
    
</body>
</html>