<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 26.10.2016
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductStore</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="jquery-3.1.1.min.js"></script>
</head>
<body>

<ul class="nav nav-tabs">
    <li class="active">
        <a href="/">Main</a>
    </li>
    <li><a href="/products">Products</a></li>
    <li><a href="/cart">Cart</a></li>
    <li><a href="/createOrder">Create Order</a></li>
</ul>
<h1>${message}</h1>
</html>
