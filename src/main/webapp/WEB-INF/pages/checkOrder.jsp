<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Your Data</title>
    <spring:url value="/resources/css/style.css" var="mainCss" />
    <spring:url value="/resources/lib/bootstrap/bootstrap-grid-3.3.1.min.css" var="btsCss" />
    <spring:url value="/resources/img/spinner.gif" var="spinner" />
    <link href="${btsCss}" rel="stylesheet" />
    <link href="${mainCss}" rel="stylesheet" />
</head>
<body>

<div class="content">


    <div class="block1">
        <div class="row">
            <div class="container">

<ul class="nav nav-tabs">
    <li><a href="/">Main</a></li>
    <li><a href="/products">Products</a></li>
    <li><a href="/cart">Cart</a></li>
    <li><a href="/createOrder">Create Order</a></li>
    <li align="left" ><a href="/createUser">Registration</a></li>
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
            </div>
        </div>
    </div>


</div>
</body>
</html>
