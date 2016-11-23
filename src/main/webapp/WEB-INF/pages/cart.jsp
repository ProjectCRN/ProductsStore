<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
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
                    <li class="active">
                        <a href="/cart">Cart</a>
                    </li>
                    <li><a href="/createOrder">Create Order</a></li>
                    <li align="left" ><a href="/createUser">Registration</a></li>
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

            </div>
        </div>
    </div>


</div>
</body>
</html>