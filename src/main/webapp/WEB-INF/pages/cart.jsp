<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 08.11.2016
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>

<ul class="nav nav-tabs">
    <li><a href="/">Main</a></li>
    <li><a href="/products">Products</a></li>
    <li class="active">
        <a href="/cart">Cart</a>
    </li>
    <li><a href="/createOrder">Create Order</a></li>
</ul>

<table class="table table-striped">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>num</th>
        <th>add</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${cartList}" var="item">
        <tr>
            <td>${item.getProduct().getId()} </td>
            <td>${item.getProduct().getName()} </td>
            <td>${item.getProduct().getPrice()} </td>
            <td>${item.getNumber()}</td>
            <td><a  class="btn btn-default" role="button" href="/addCartProduct/${item.getProduct().getId()}">add</a></td>
            <td><a  class="btn btn-default" role="button" href="/deleteCartProduct/${item.getProduct().getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<h1>Total: ${total}</h1>
</body>
</html>