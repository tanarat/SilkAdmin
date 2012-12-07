<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Circle</h1>
<h2>Add Circle</h2>
<s:form>
Radius : <s:textfield name="txtRadius" />
<s:submit action="add" value="Add"/>
</s:form>
<s:property value="circleList"/>
<s:iterator value="circleList" var="circle">
<s:property value="radius"/>
</s:iterator>
</body>
</html>