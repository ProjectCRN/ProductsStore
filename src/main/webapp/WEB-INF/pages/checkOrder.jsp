<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 15.11.2016
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Check Your Data</title>
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
    <tr><td>Order:</td><td>№${order.getId()}</td></tr>
    <tr><td>Total:</td><td>${order.getTotal()}</td></tr>
    <tr><td>Name:</td><td>${order.getName()}</td></tr>
    <tr><td>Address:</td><td>${order.getAddress()}</td></tr>
    <tr><td>Phone:</td><td>${order.getPhone()}</td></tr>
    <tr><td>Email:</td><td>${order.getEmail()}</td></tr>
    <tr><td>Comments:</td><td>${order.getComments()}</td></tr>
</table>

<h2>Selected items:</h2>

<table class="table table-striped">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>num</th>
    </tr>
    <c:forEach items="${order.getCartItemList()}" var="item">
        <tr>
            <td>${item.getProduct().getId()} </td>
            <td>${item.getProduct().getName()} </td>
            <td>${item.getProduct().getPrice()} </td>
            <td>${item.getNumber()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
