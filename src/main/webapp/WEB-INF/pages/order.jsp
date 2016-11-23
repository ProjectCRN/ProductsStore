<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Order</title>
    <spring:url value="/resources/css/style.css" var="mainCss" />
    <spring:url value="/resources/lib/bootstrap/bootstrap-grid-3.3.1.min.css" var="btsCss" />
    <spring:url value="/resources/img/spinner.gif" var="spinner" />
    <link href="${btsCss}" rel="stylesheet" />
    <link href="${mainCss}" rel="stylesheet" />
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
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
    <li class="active">
        <a href="/createOrder">Create Order</a>
    </li>
    <li align="left" ><a href="/createUser">Registration</a></li>
</ul>

<sf:form method="post"  modelAttribute="order" action="createOrder">

    <table class="table table-striped">

            <tr>
                <th><label>Name:</label></th>
                <td><sf:input path="name" size="30" /><br/>
                    <sf:errors path="name"/>
                    <small>No spaces, please.</small><br/>
                </td>
            </tr>

            <tr>
                <th><sf:label path="address">Address:</sf:label></th>
                <td><sf:input path="address" size="30" /><br/>
                    <sf:errors path="address" cssClass="error" />
                </td>
            </tr>

            <tr>
                <th><sf:label path="phone">Phone:</sf:label></th>
                <td><sf:input path="phone" size="30" /><br/>
                    <sf:errors path="phone" cssClass="error" />
                    <small>Possible patterns +375XX XXX XX XX and 80XX XXX XX XX</small><br/>
                </td>
            </tr>

            <tr>
                <th><sf:label path="email">Email:</sf:label></th>
                <td><sf:input path="email" size="30" pattern="\S+@[a-z]+.[a-z]+" placeholder="E-mail"  /><br/>
                    <sf:errors path="email" cssClass="error" />
                </td>
            </tr>

            <tr>
                <th><sf:label path="comments">Comments:</sf:label></th>
                <td><sf:input path="comments" size="30" /><br/>
                    <sf:errors path="comments" cssClass="error" />
                    <small>if you need something else</small><br/>
                </td>
            </tr>
            <tr>
                <th></th>
                <td><input type="submit" value="Create Order"/><br/>
                    <small>${msg}</small><br/>
                </td>
            </tr>

        </table>

</sf:form>
            </div>
        </div>
    </div>


</div>
</body>

</html>
