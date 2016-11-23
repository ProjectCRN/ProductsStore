<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
    <spring:url value="/resources/css/style.css" var="mainCss" />
    <spring:url value="/resources/lib/bootstrap/bootstrap-grid-3.3.1.min.css" var="btsCss" />
    <spring:url value="/resources/img/spinner.gif" var="spinner" />
    <link href="${mainCss}" rel="stylesheet" />
    <link href="${btsCss}" rel="stylesheet" />
</head>
<body>
<div class="content">
    <div class="block1">
        <div class="row">
            <div class="container">

                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="/">Main</a>
                    </li>
                    <li><a href="/products">Products</a></li>
                    <li><a href="/cart">Cart</a></li>
                    <li><a href="/createOrder">Create Order</a></li>
                    <li align="left" ><a href="/createUser">Registration</a></li>
                </ul>
                <img src="${spinner}"/>
                <h1>${message}</h1>
            </div>
        </div>
    </div>
</div>
</body>
</html>