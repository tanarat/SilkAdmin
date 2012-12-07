<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:if test="entrepreneur==null || entrepreneur.id == null">
	<s:set name="title" value="%{'Add new Entrepreneur'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update Entrepreneur'}"/>
</s:else>
<html>
<head>
<link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />
<s:form action="saveOrUpdate" >
<s:push value="entrepreneur">
  <s:hidden name="id" />
  <s:textfield name="companyName" label="Company Name" size="70" /><br>
  <s:textarea name="address" label="Address" cols="50" rows="3"/><br>
  <s:textfield name="phone" label="Phone" size="70"/><br>
  <s:submit value="Save"/>
</s:push>
</s:form>

<a href="list">view</a>

</body>
</html>