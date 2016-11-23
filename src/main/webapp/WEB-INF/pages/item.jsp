<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${item.getName()}</title>
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
    <tr><td>Id</td><td>${item.getId()}</td></tr>
    <tr><td>Name</td><td>${item.getName()}</td></tr>
    <tr><td>Price</td><td>${item.getPrice()}</td></tr>
</table>
            </div>
        </div>
    </div>


</div>
</body>
</html>
