<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
  function setRemoveIndex(val)
   {    
       alert(val);
       document.getElementById("removeIndex").value=val;
       //$('input[name="removeIndex"]').val(removeIndex);
       document.myform.action="remove.action";
       document.myform.submit();
        return true;
   }
  function beforeRemove(){
	  alert("remove");
	  document.myform.action="remove.action";
	  document.myform.submit();
	  return true;
  }
</script>

<s:form action="methodA">
<s:submit value="OK"/>
</s:form>

<s:form theme="simple" id="myform" name="myform">
<s:submit action="add" cssClass="ButtonSmall" value="Add estimate" />
<s:submit action="remove" value="Remove" onclick="return beforeRemove()"/>

<s:hidden name="removeIndex" id="removeIndex"/>
<table>
<s:iterator value="estimates" var="estimate" status="status">
<tr>
	<td><s:textfield name="estimates[%{#status.index}]" cssClass="ButtonSmall" /></td>
  
   <td>
   <s:submit action="remove" cssClass="ButtonSmall" value="Remove this estimate" onclick="return setRemoveIndex('%{#status.index}')"/>
   </td>
</tr>
</s:iterator>
</table>
</s:form>
</body>
</html>