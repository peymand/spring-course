<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: peyma
  Date: 2/22/2022
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
       <form:form modelAttribute="order" method="post">
           <label class="col-xs-3 control-label" for="customerName">Name :</label>
           <form:input path="cart.customer.customerName" id="customerName" disabled="true"/>


       </form:form>
</body>
</html>
