<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
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


                <ul>
                    <li><a href="/">Main</a></li>
                    <li class="active">
                        <a href="/products">Products</a>
                    </li>
                    <li><a href="/cart">Cart</a></li>
                    <li><a href="/createOrder">Create Order</a></li>
                    <li align="left" ><a href="/createUser">Registration</a></li>
                </ul>

                <div class="col-md-4">
                    <h2>Search:</h2>
                <sf:form method="post"  modelAttribute="searchAttr" action="products">

                    <table class="table table-striped">


                        <tr>
                            <th><label>Type: </label></th>
                            <td><sf:select path="type">
                                <c:forEach items="${types}" var="item">
                                    <option <c:if test="${item eq currType}">selected="selected"</c:if> value="${item}">${item}</option>
                                </c:forEach>
                            </sf:select></td>
                        </tr>

                        <tr>
                            <th><label>Name: </label></th>
                            <td><sf:input path="name" size="15" /></td>
                        </tr>

                        <tr>
                            <th><label>Price: </label></th>
                            <td>from <sf:input path="minPrice" size="8" />
                            to <sf:input path="maxPrice" size="8" /></td>
                        </tr>

                        <tr>
                            <th><label>Size: </label></th>
                            <td>from <sf:input path="minSize" size="8" />
                                to <sf:input path="maxSize" size="8" /></td>
                        </tr>

                        <tr>
                            <th><label>Ram: </label></th>
                            <td>from <sf:input path="minRam" size="8" />
                                to <sf:input path="maxRam" size="8" /></td>
                        </tr>

                        <tr>
                            <th></th>
                            <td><input type="submit" value="Search"/></td>
                        </tr>

                    </table>

                </sf:form>
                </div>
                <div class="col-md-8">
                <table>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>price</th>
                        <th>add</th>
                        <th>see more</th>
                    </tr>
                    <c:forEach items="${productList}" var="item">
                        <tr>
                            <td>${item.getId()} </td>
                            <td>${item.getName()} </td>
                            <td>${item.getPrice()} </td>
                            <td><a class="btn btn-default" role="button" href="/addProduct/${item.getId()}">add to cart</a></td>
                            <td><a class="btn btn-default" role="button" href="/item/${item.getId()}">see more about item</a></td>
                        </tr>
                    </c:forEach>
                </table>
                </div>


            </div>
        </div>
    </div>
    ${SearchRes}

</div>
</body>
</html>