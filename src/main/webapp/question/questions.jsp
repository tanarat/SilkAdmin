<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link href="<s:url value='../css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.questions"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:text name="label.questions"/></h1>
<s:url id="url" action="edit" />
<a href="<s:property value="#url"/>">Add New Question</a>
<br/><br/>
<table class="borderAll">
    <tr>
        <th><s:text name="label.question.questionTitle"/></th>
        <th><s:text name="label.question.questionGroup"/></th>
		
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="questions" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="questionTitle"/></td>
            <td class="nowrap"><s:property value="questionGroup"/></td>
			
            <td class="nowrap">
                <s:url action="edit" id="url">
                    <s:param name="questionId" value="id"/>
                </s:url>
                <a href="<s:property value="#url"/>">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <s:url action="crud!delete" id="url">
                    <s:param name="question.id" value="questionId"/>
                </s:url>
                <a href="<s:property value="#url"/>">Delete</a>
            </td>
        </tr>
    </s:iterator>
    </table>
</body>
</html>