<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 15.11.2016
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${item.getName()}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="/">Main</a></li>
    <li><a href="/products">Products</a></li>
    <li><a href="/cart">Cart</a></li>
    <li><a href="/createOrder">Create Order</a></li>
</ul>

<table class="table table-striped">
    <tr><td>Id</td><td>${item.getId()}</td></tr>
    <tr><td>Name</td><td>${item.getName()}</td></tr>
    <tr><td>Price</td><td>${item.getPrice()}</td></tr>
</table>
</body>
</html>
