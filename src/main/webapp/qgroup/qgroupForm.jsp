<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="questionGroup==null || questionGroup.id == null">
	<s:set name="title" value="%{'Add new Question Group'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update Question Group'}"/>
</s:else>

<html>
<head>
    <link href="<s:url value='../css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />
<s:form action="save" method="post">
    <s:textfield name="questionGroup.groupName" value="%{questionGroup.groupName}" label="%{getText('label.qgroup.groupName')}" size="40"/>

    <s:hidden name="questionGroup.id" value="%{questionGroup.id}"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" name="redirect-action:index"/>
</s:form>
</body>
</html>