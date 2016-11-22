<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 08.11.2016
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>

<ul class="nav nav-tabs">
    <li><a href="/">Main</a></li>
    <li class="active">
        <a href="/products">Products</a>
    </li>
    <li><a href="/cart">Cart</a></li>
    <li><a href="/createOrder">Create Order</a></li>
    <li align="left" ><a href="/createUser">Registration</a></li>
</ul>

<table class="table table-striped">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>add</th>
        <th>see more</th>
    </tr>
    <c:forEach items="${productList}" var="item">
        <tr>
            <td>${item.getId()} </td>
            <td>${item.getName()} </td>
            <td>${item.getPrice()} </td>
            <td><a class="btn btn-default" role="button" href="/addProduct/${item.getId()}">add to cart</a></td>
            <td><a class="btn btn-default" role="button" href="/item/${item.getId()}">see more about item</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>