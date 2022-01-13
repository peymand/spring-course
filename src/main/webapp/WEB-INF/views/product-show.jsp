<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: peyma
  Date: 12/30/2021
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>


<form:form action="/product/save" method="post" modelAttribute="dto">
    Name: <form:input path="name" /> <br/> <br/>
    Price : <form:input path="price"/> <br/> <br/>
    Type:
    <form:select path="type">
        <form:options items="${dto.validTypes}"/>
    </form:select>

    <input type="submit" value="add product"/>
</form:form>




</body>
</html>
