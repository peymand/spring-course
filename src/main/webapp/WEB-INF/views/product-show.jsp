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

    <form action="/product/save" method="post">
        Name : <input name="name" type="text"/> <br/> <br/>
        Price : <input name="price" type="text"/> <br/> <br/>
        <input type="submit" value="add product"/>
    </form>

</body>
</html>
