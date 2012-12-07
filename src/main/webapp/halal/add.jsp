<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<s:if test="halalProduct==null || halalProduct.id == null">
	<s:set name="title" value="%{'Add new Halal Product'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update Halal Product'}"/>
</s:else>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<s:url value='../css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />


<s:set var="ownerId" value="halalProduct.owner.id"/>
<s:form action="saveOrUpdate" >
<s:push value="halalProduct">
  <s:hidden name="id" />
  <s:textfield name="halalNo" label="%{getText('label.halalproducts.halalNo')}"  size="70"/><br>
  <s:textfield name="upc" label="%{getText('label.halalproducts.upc')}" size="70"/><br>
  <s:textarea name="productName" label="%{getText('label.halalproducts.productName')}" rows="3" cols="50"/><br>

  <s:combobox 	label="%{getText('label.halalproducts.owner')}" 
				headerKey="-1" headerValue="--- Select ---" 
				list="companyList"  
 				name="companySelected"  
 				value="%{#ownerId}" 
 				size="70" 
 				> 
 </s:combobox> 

  <s:textfield name="halalFromMonth" label="%{getText('label.halalproducts.validFromMonth')}"/>
  <s:textfield name="halalFromYear" label="%{getText('label.halalproducts.validFromYear')}"/>
  <s:textfield name="halalToMonth" label="%{getText('label.halalproducts.validToMonth')}"/>
  <s:textfield name="halalToYear" label="%{getText('label.halalproducts.validToYear')}"/>
  <s:submit value="Save"/>
</s:push>
</s:form>


<a href="list">view</a>

</body>
</html>