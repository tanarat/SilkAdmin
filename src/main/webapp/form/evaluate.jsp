<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="form==null || form.id == null">
	<s:set name="title" value="%{'Unknown Form'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Evaluate'}"/>
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


<table class="borderAll">
    <tr>
        <th><s:text name="label.question.questionTitle"/></th>
        <th><s:text name="label.question.questionGroup"/></th>
		
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="%{form.checklist.questions}" status="status" var="question">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap">
            <s:url id="url" action="answer" namespace="/answer" >
            	<s:param name="formId" value="%{form.id}"/>
            	<s:param name="questionId" value="%{#question.id}"/>
            </s:url>
            <a href="<s:property value="#url"/>"><s:property value="%{#question.questionTitle}"/></a>
            </td>
            <td class="nowrap"><s:property value="%{#question.questionGroup}"/></td>
			
        </tr>
    </s:iterator>
</table>



<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/myjs.js"></script>




</body>
</html>