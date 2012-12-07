<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="form==null || form.id == null">
	<s:set name="title" value="%{'Add new Evaluation Form'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update Evaluation Form'}"/>
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


<s:form action="save" method="post" >
	

	<s:select 	name="entrepreneurIdSelected" value="%{form.entrepreneur.id}" 
				label="%{getText('label.entrepreneurs.companyName')}"
				list="entrepreneurList" listKey="id" listValue="companyName"/>

	<s:select 	name="checklistIdSelected" value="%{form.checklist.id}" 
				label="%{getText('label.checklists.checklistName')}"
				list="checklistList" listKey="id" listValue="checklistName"/>
				
	<s:hidden name="form.id" value="%{form.id}"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" name="redirect-action:index"/>

</s:form>


<br>





<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/myjs.js"></script>




</body>
</html>