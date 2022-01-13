<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: peyma
  Date: 12/23/2021
  Time: 12:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><mvc:message code="index.page.home" text="Home ALT" /></title>
</head>
<body>

    <a href="/product/show">Add Product</a> <br/>
    <a href="/product/get-all">Get Products</a>
</body>
</html>
