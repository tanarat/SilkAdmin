<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/silkadmin/css/s2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/silkadmin/js/jquery-1.2.2.pack.js"></script>
<title>Student</title>


</head>
<body>
	<h1>Student</h1>
	<a href="edit">add</a><br><br>
	<s:if test="studentList.size() > 0">
		<table class="userTable" cellpadding="5px" width="90%" >
		<tr class="even">
			<th>Id</th>
			<th>Name</th>
			<th>Nickname</th>
			
			<th></th>
			
		</tr>
			<s:iterator value="halalBarcodeList" status="userStatus">
				<s:url id="url" action="edit">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> 
				<tr 
					class="<s:if test="#userStatus.odd == true ">odd</s:if> <s:else>even</s:else>">
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="nickname" /></td>
					
					<td>
						<s:url id="editURL" action="edit">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> 
						<s:a href="%{editURL}">Edit</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
</body>
<br><br><br>
<a href="..">Menu</a>

<script type="text/javascript" src="/silkadmin/js/myjs.js"></script>
</html>