<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
    <title>Register</title>
    <spring:url value="/resources/css/style.css" var="mainCss" />
    <spring:url value="/resources/lib/bootstrap/bootstrap-grid-3.3.1.min.css" var="btsCss" />
    <spring:url value="/resources/img/spinner.gif" var="spinner" />
    <link href="${btsCss}" rel="stylesheet" />
    <link href="${mainCss}" rel="stylesheet" />
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>

<div class="content">


    <div class="block1">
        <div class="row">
            <nav>
                <li><a href="/">Main</a></li>
                <li><a href="/products/telephone">Telephone</a></li>
                <li><a href="/products/tablet">Tablet</a></li>
                <li><a href="/cart" >Cart</a></li>
                <li><a href="/createOrder" class="active">Create Order</a></li>
                <li><a href="/createUser">Registration</a></li>
            </nav>
            <div class="container">



                <form:form method="post" commandName="signupForm">

    <table class="table table-striped">
        <tr>
            <td>Login:</td>
            <td><form:input path="login" /></td>
            <td><span class="error"><form:errors path="login" /></span></td>
        </tr>

        <tr>
            <td>Username:</td>
            <td><form:input path="userName" /></td>
            <td><span class="error"><form:errors path="userName" /></span></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:password path="password" /></td>
            <td><span class="error"><form:errors path="password" /></span></td>
        </tr>

        <tr>
            <td>Confirm Password:</td>
            <td><form:password path="confirmPassword" /></td>
            <td><span class="error"><form:errors
                    path="confirmPassword" /></span></td>
        </tr>

        <tr>
            <td>Contact Phone:</td>
            <td><form:input path="contactPhone" /></td>
            <td><span class="error"><form:errors path="contactPhone" /></span></td>
        </tr>

        <tr>
            <td>Contact Address:</td>
            <td><form:input path="contactAddress" /></td>
            <td><span class="error"><form:errors path="contactAddress" /></span></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
            </div>
        </div>
    </div>


</div>
</body>
</html>
