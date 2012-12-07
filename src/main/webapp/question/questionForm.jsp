<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="question==null || question.id == null">
	<s:set name="title" value="%{'Add new Question'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update Question'}"/>
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
	<td><s:text name="%{getText('label.question.questionTitle')}" /> </td>
    <td><s:textfield name="question.questionTitle" value="%{question.questionTitle}" label="%{getText('label.question.questionTitle')}" size="40"/></td>
    </tr>
    <tr>
    <td><s:text name="%{getText('label.question.questionGroup')}" /> </td>
	<td><s:select 	name="groupIdSelected" value="%{question.questionGroup.id}" 
				label="%{getText('label.question.questionGroup')}"
				list="questionGroups" listKey="id" listValue="groupName"/>
	</td>
	</tr>
	<tr>
		<td>No List.</td>
<%-- 		<td><s:a >add</s:a></td> --%>
		<td><s:property value="question.noList"/></td>
		
	</tr>
	<tr><td></td><td>
	<table>
		<s:iterator value="noReasons" var="noItem" status="status">
			<tr>
				<td><s:property value="#status.index + 1"/></td>
				<td><s:property value="noItem" /></td>
			</tr>
		</s:iterator>
	</table>
	
	</td></tr>
	<tr>
	<td></td>
    <td><s:hidden name="question.id" id="questionId" value="%{question.id}"/></td>
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