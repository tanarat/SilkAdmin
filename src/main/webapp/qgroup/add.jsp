<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Question Group</title>
</head>
<body>
<h2>Question Group</h2>

<s:form action="saveOrUpdate" >
<s:push value="questionGroup">
  <s:hidden name="id" />
  <s:textfield name="groupName" label="Question Group Name" size="70" /><br>

  <s:submit value="Save"/>
</s:push>
</s:form>

<a href="list">view</a>

</body>
</html>