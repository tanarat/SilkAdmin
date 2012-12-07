<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<s:url value='../css/main.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/silkadmin/js/jquery-1.2.2.pack.js"></script>
<title><s:text name="label.entrepreneurs"/></title>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.entrepreneurs"/></h1>
	<s:url id="url" action="edit"/>
	<a href="<s:property value="#url"/>">Add New Entrepreneur</a>
	<br/><br/>
	<s:if test="entrepreneurList.size() > 0">
		<table class="userTable" cellpadding="5px" width="90%">
		<tr class="even">
			<th><s:text name="label.entrepreneurs.id"/></th>
			<th><s:text name="label.entrepreneurs.companyName"/></th>
			<th><s:text name="label.entrepreneurs.address"/></th>
			<th><s:text name="label.entrepreneurs.phone"/></th>
			<th></th>

			
		</tr>
			<s:iterator value="entrepreneurList" status="userStatus">
				<tr
					class="<s:if test="#userStatus.odd == true ">odd</s:if> <s:else>even</s:else>">
					<td class="nowrap"><s:property value="id" /></td>
					<td class="nowrap"><s:property value="companyName" /></td>
					<td class="nowrap"><s:property value="address" /></td>
					<td class="nowrap"><s:property value="phone" /></td>
					<td class="nowrap"><s:url id="editURL" action="edit">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
</body>
<br><br><br>
<a href="..">Menu</a>
<script type="text/javascript" src="/silkadmin/js/myjs.js"></script>
</html>