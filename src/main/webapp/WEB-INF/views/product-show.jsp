<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags" %>
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

<h2><mvc:message code="product.add"  /> </h2>

<a href="?lang=en">EN</a>
<a href="?lang=fa">FA</a>
<form:form action="/product/save" method="post" modelAttribute="dto">

    <mvc:message code="form.product.name"/>: <form:input path="name" /> <br/> <br/>
    <form:errors path="name" cssStyle="color: red"/>
    <mvc:message code="form.product.price"/> : <form:input path="price"/> <br/> <br/>
    <form:errors path="price" cssStyle="color: red"/>
    <br/>
    <br/>
    Type:
    <form:select path="type" cssStyle="width: fit-content">
        <form:option value="---Please Select one Item----"/>
        <form:options items="${dto.validTypes}"/>
    </form:select>
    <br/>
    <br/>
    Color:<br/>
    Black <form:radiobutton path="color" value="black"/>
    Green <form:radiobutton path="color" value="green"/>
    Blue <form:radiobutton path="color" value="blue"/>

    <br/>
    <br/>

    sizes:
    XL: <form:checkbox path="sizes" value="4"/>
    L: <form:checkbox path="sizes" value="3"/>
    M: <form:checkbox path="sizes" value="2"/>
    S: <form:checkbox path="sizes" value="1"/>

    <input type="submit" value="add product"/>
</form:form>




</body>
</html>
