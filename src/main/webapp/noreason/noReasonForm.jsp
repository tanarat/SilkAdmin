<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="noReason==null || noReason.id == null">
	<s:set name="title" value="%{'Add new No Reason'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update No Reason'}"/>
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
    <s:textfield name="noReason.reason" value="%{noReason.reason}" label="%{getText('label.noreasons.reason')}" size="40"/>

	<s:select 	name="questionIdSelected" value="%{noReason.question.id}" 
				label="%{getText('label.noreasons.forQuestion')}"
				list="questionList" listKey="id" listValue="questionTitle"/>

    <s:hidden name="noReason.id" value="%{noReason.id}"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" name="redirect-action:index"/>
</s:form>
</body>
</html>