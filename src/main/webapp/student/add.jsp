<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Halal Product</title>
</head>
<body>
<h2>Halal Product Info</h2>


<s:set var="ownerId" value="halalBarcode.owner.id"/>
<s:form action="saveOrUpdate" >
<s:push value="halalBarcode">
  <s:hidden name="id" />
  <s:textfield name="halalNo" label="Halal No."  size="70"/><br>
  <s:textfield name="upc" label="Barcode" size="70"/><br>
  <s:textarea name="productName" label="Product Name" rows="3" cols="50"/><br>

  <s:combobox 	label="Owner" 
				headerKey="-1" headerValue="--- Select ---" 
				list="companyList"  
 				name="companySelected"  
 				value="%{#ownerId}" 
 				size="70" 
 				> 
 </s:combobox> 

  <s:textfield name="halalFromMonth" label="Halal From Month"/>
  <s:textfield name="halalFromYear" label="Halal From Year"/>
  <s:textfield name="halalToMonth" label="Halal To Month"/>
  <s:textfield name="halalToYear" label="Halal To Year"/>
  <s:submit value="Save"/>
</s:push>
</s:form>


<a href="list">view</a>

</body>
</html>