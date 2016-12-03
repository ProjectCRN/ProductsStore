<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductStore</title>
    <spring:url value="/resources/css/style.css" var="mainCss" />
    <spring:url value="/resources/lib/bootstrap/bootstrap-grid-3.3.1.min.css" var="btsCss" />
    <spring:url value="/resources/img/spinner.gif" var="spinner" />
    <spring:url value="/resources/lib/jquery/jquery-1.8.3.js" var="jquery"/>
    <link href="${btsCss}" rel="stylesheet" />
    <link href="${mainCss}" rel="stylesheet" />
    <script src="${jquery}"></script>

</head>
<body>
<div class="content">

    <div class="block1">
        <div class="row">

            <nav>
                <li><a href="/">Main</a></li>
                <li><a class="telephone" href="#">Telephone</a></li>
                <li><a class="tablet" href="#">Tablet</a></li>
                <li><a class="cart" href="#">Cart</a></li>
                <li><a class="createOrder" href="#">Create Order</a></li>
                <li><a class="createUser" href="#">Registration</a></li>
            </nav>

            <div class="container">
                <div class="results">
                    <img src="${spinner}"/>
                    <h1>${message}</h1>
                </div>
            </div>
        </div>
    </div>


</div>


<script language="javascript" type="text/javascript">
    $('.telephone').click( function() {
        $.ajax({
            url: '/products/telephone',
            success: function(data) {
                $('.results').html(data);
            }
        });
    });
    $('.tablet').click( function() {
        $.ajax({
            url: '/products/tablet',
            success: function(data) {
                $('.results').html(data);
            }
        });
    });
    $('.cart').click( function() {
        $.ajax({
            url: '/cart',
            success: function(data) {
                $('.results').html(data);
            }
        });
    });
    $('.createOrder').click( function() {
        $.ajax({
            url: '/createOrder',
            success: function(data) {
                $('.results').html(data);
            }
        });
    });
    $('.createUser').click( function() {
        $.ajax({
            url: '/createUser',
            success: function(data) {
                $('.results').html(data);
            }
        });
    });




</script>

</body>
</html>