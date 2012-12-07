<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<s:url value='../css/main.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/silkadmin/js/jquery-1.2.2.pack.js"></script>
<title><s:text name="label.halalproducts"/></title>
</head>
<body>
	<div class="titleDiv"><s:text name="application.title"/></div>
	<h1><s:text name="label.halalproducts"/></h1>
	<s:url id="url" action="edit"/>
	<a href="<s:property value="#url"/>">Add New Product</a>
	<br/><br/>
	<s:if test="halalProducts.size() > 0">
		<table class="userTable" cellpadding="5px" width="90%" >
		<tr class="even">
			<th><s:text name="label.halalproducts.id"/></th>
			<th><s:text name="label.halalproducts.upc"/></th>
			<th><s:text name="label.halalproducts.halalNo"/></th>
			<th><s:text name="label.halalproducts.productName"/></th>
			<th><s:text name="label.halalproducts.owner"/></th>
			<th><s:text name="label.halalproducts.validFromMonth"/></th>
			<th><s:text name="label.halalproducts.validFromYear"/></th>
			<th><s:text name="label.halalproducts.validToMonth"/></th>
			<th><s:text name="label.halalproducts.validToYear"/></th>
			<th></th>
			
		</tr>
			<s:iterator value="halalProducts" status="userStatus">
				<s:url id="url" action="edit">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> 
				<tr 
					class="<s:if test="#userStatus.odd == true ">odd</s:if> <s:else>even</s:else>">
					<td class="nowrap"><s:property value="id" /></td>
					<td class="nowrap"><s:property value="upc" /></td>
					<td class="nowrap"><s:property value="halalNo" /></td>
					<td class="nowrap"><s:property value="productName" /></td>
					<td class="nowrap"><s:property value="owner" /></td>
					<td class="nowrap"><s:property value="halalFromMonth" /></td>
					<td class="nowrap"><s:property value="halalFromYear" /></td>
					<td class="nowrap"><s:property value="halalToMonth"/></td>
					<td class="nowrap"><s:property value="halalToYear"/></td>
					<td class="nowrap">
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