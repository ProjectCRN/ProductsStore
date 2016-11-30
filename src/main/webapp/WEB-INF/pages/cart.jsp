<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <spring:url value="/resources/lib/bootstrap/bootstrap-grid-3.3.1.min.css" var="btsCss"/>
    <spring:url value="/resources/lib/jquery/jquery-1.8.3.js" var="jquery"/>
    <spring:url value="/resources/img/spinner.gif" var="spinner"/>
    <link href="${btsCss}" rel="stylesheet"/>
    <link href="${mainCss}" rel="stylesheet"/>
</head>
<body>

<div class="content">


    <div class="block1">
        <div class="row">
            <nav>
                <li><a href="/">Main</a></li>
                <li><a href="/products">Products</a></li>
                <li><a href="/cart" class="active">Cart</a></li>
                <li><a href="/createOrder">Create Order</a></li>
                <li><a href="/createUser">Registration</a></li>
            </nav>
            <div class="container align_center">

                <div class="col-md-9">
                    <ul class="listOfProducts">
                        <c:forEach items="${cartList}" var="item">

                            <li>
                                <a href="/item/${item.getProduct().getId()}">
                                    <img src="/resources/img/img_phone.jpg"/>

                                    <span>${item.getProduct().getEntityName()}</span></a><br>
                                    id: ${item.getProduct().getId()} <br>
                                    quantity: ${item.getQuantity()} <br>


                                    ${item.getProduct().getSummary()}
                                <br>

                                <div class="btn_right">

                                    <a class="btn btn-default btnLink" role="button"
                                       href="/addCartProduct/${item.getProduct().getId()}">add</a><br>
                                    <a class="btn btn-default btnLink" role="button"
                                       href="/deleteCartProduct/${item.getProduct().getId()}">delete</a>
                                    <br><span>${item.getProduct().getPrice()}$</span> <br>
                                </div>
                            </li>


                        </c:forEach>
                    </ul>
                </div>

                <h1>Total: ${total}</h1>

            </div>
        </div>
    </div>


</div>
</body>
</html>