<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 15.11.2016
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="jquery-3.1.1.min.js"></script>
    <style>
        .error {
            color: red; font-weight: bold;
        }
    </style>
</head>
<body>
<ul class="nav nav-tabs">
    <li><a href="/">Main</a></li>
    <li><a href="/products">Products</a></li>
    <li><a href="/cart">Cart</a></li>
    <li class="active">
        <a href="/createOrder">Create Order</a>
    </li>
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
                <td><sf:input path="email" size="30" /><br/>
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

</body>

</html>
