<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/silkadmin/css/s2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h3>ข้อมูลรับรองฮาลาล</h3>
<table >
<tr class="label"><td>ผลิตภัณฑ์</td></tr>
<tr class="info"><td><s:text name="halalBarcode.productName"/></td></tr>
<tr class="label"><td>บริษัทผู้ผลิต</td></tr>
<tr class="info"><td><s:text name="halalBarcode.owner.companyName"/></td></tr>
<tr class="label"><td>ที่อยู่</td></tr>
<tr class="info"><td><s:text name="halalBarcode.owner.address"/> โทร. <s:text name="halalBarcode.owner.phone"/></td></tr>
<tr class="label"><td>หมายเลขรับรองฮาลาล</td></tr>
<tr class="info"><td><s:text name="halalBarcode.halalNo"/></td></tr>
<tr class="label"><td>บาร์โค้ด</td></tr>
<tr class="info"><td><s:text name="halalBarcode.upc"/></td></tr>
<tr class="label"><td>รับรองฮาลาลถึง</td></tr>
<tr class="info"><td><s:text name="halalBarcode.halalValidTo"/></td></tr>
</table>




</body>
</html>