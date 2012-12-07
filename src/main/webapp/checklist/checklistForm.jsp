<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="checklist==null || checklist.id == null">
	<s:set name="title" value="%{'Add new Checklist'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update Checklist'}"/>
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

<table border="0">
<s:form action="save" method="post" theme="simple">
	<tr>
	<td><s:text name="%{getText('label.checklists.checklistName')}" /> </td>
    <td><s:textfield name="checklist.checklistName" value="%{checklist.checklistName}" label="%{getText('label.checklists.checklistName')}" size="40"/></td>
    </tr>
    
	<tr>
	<td></td>
    <td><s:hidden name="checklist.id" id="checklistId" value="%{checklist.id}"/></td>
    </tr>
    <tr>
    <td>Question</td>
    <td>
    	<table>
    	<s:iterator value="questionList" var="question" status="status">
    	<s:set name="qid" value="%{question.id}"/>
    	<tr>
    		<td>
    		<s:if test="%{#question.id in checklist.listOfQuestionIds}">
    			<input type=checkbox class="serialcheck" name="questionCheck" 
    				value="<s:property value='%{#question.id}' />"  checked="checked" />
    		</s:if>
    		<s:else>
    			<input type=checkbox class="serialcheck" name="questionCheck" 
    				value="<s:property value='%{#question.id}' />"   />
    		</s:else>
    		
    		<s:property value='%{#question.questionTitle}' />
    		</td>
<%--     		<td><s:property value='%{#question.id}' /></td> --%>
<%--     		<td><s:property value="tmp"/></td> --%>
<%--     		<td><s:property value="checklist.listOfQuestionIds"/></td> --%>
    		<td><s:property value='%{#question.questionGroup.groupName}' /></td>
    	</tr>
    	</s:iterator>
    	</table>
    	
    </td>
    </tr>
    <tr>
    <td></td>
    <td>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" name="redirect-action:index"/>
    </td>
    </tr>
    
</s:form>
</table>

<br>





<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/myjs.js"></script>




</body>
</html>