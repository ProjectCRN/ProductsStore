<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 08.11.2016
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/cart">cart</a>

<table border="1" width="80%">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
        <th>add</th>
    </tr>
    <c:forEach items="${productList}" var="item">
        <tr>
            <td>${item.getId()} </td>
            <td>${item.getName()} </td>
            <td>${item.getPrice()} </td>
            <td><a href="/addProduct/${item.getId()}">add to cart</a></td></tr>
    </c:forEach>
</table>
</body>
</html>
