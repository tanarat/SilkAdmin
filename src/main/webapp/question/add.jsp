<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Question</title>
</head>
<body>
<h2>Question</h2>

<s:set var="groupId" value="question.questionGroup.id"/>
<s:form id="questionForm" name="questionForm" theme="simple" >
	
<s:push value="question">
  <s:hidden name="id" />
  <s:textfield name="questionTitle" label="Question Title" size="70" /><br>
  <s:combobox 	label="Group" 
				headerKey="-1" headerValue="--- Select ---"
 				list="groups"  
				name="groupSelected"
 				value="%{#groupId}" 
 				size="70" 
 				> 
 	</s:combobox>
 	<s:property value="noList"/> 
	<s:textfield name="addNoItem"/>
	<s:submit action="addNoList" value="Add"/> 
	<table>
 	<s:iterator value="noListItem" var="no">
 	<tr><td><s:property/></td></tr>
 	</s:iterator>
	</table>
  <s:submit action="saveOrUpdate" value="Save"/>
</s:push>
</s:form>


<a href="list">view</a>

</body>
</html>