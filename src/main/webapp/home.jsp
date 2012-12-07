<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
</head>
<html>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1>Main Menu</h1>
<ul>
<br>
<li><a href="halal/list">Halal Product</a></li>
<li><a href="entrepreneur/list">Entrepreneur</a></li>
<br>
<li><a href="question/index">Question</a></li>
<li><a href="qgroup/index">Question Group</a></li>
<li><a href="noreason/list">No Reason</a></li>
<li><a href="checklist/list">Checklist</a></li>
<li><a href="form/list">Evaluation Form</a></li>
</ul>
</body>
</html>
