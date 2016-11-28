<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <spring:url value="/resources/lib/bootstrap/bootstrap-grid-3.3.1.min.css" var="btsCss"/>
    <spring:url value="/resources/lib/jquery/jquery-1.8.3.js" var="jquery"/>
    <spring:url value="/resources/img/spinner.gif" var="spinner"/>
    <link href="${btsCss}" rel="stylesheet"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <script src="${jquery}"></script>
    <script>
        $(window).on('load', function () {
            var $preloader = $('#page-preloader'),
                    $spinner   = $preloader.find('.spinner');
            $spinner.fadeOut();
            $preloader.delay(350).fadeOut('slow');
        });
    </script>
</head>
<body>
<div id="page-preloader"><span class="spinner"></span></div>
<div class="content">


    <div class="block1">
        <div class="row">
            <nav>
                <li><a href="/">Main</a></li>
                <li><a href="/products" class="active">Products</a></li>
                <li><a href="/cart">Cart</a></li>
                <li><a href="/createOrder">Create Order</a></li>
                <li><a href="/createUser">Registration</a></li>
            </nav>
            <div class="container">

                <div class="col-md-3 search">
                    <h3>Search:</h3>
                    <sf:form method="post" modelAttribute="searchAttr" action="products">


                        <label>Type: </label>
                        <sf:select path="type">
                            <c:forEach items="${types}" var="item">
                                <option
                                        <c:if test="${item eq currType}">selected="selected"</c:if>
                                        value="${item}">${item}</option>
                            </c:forEach>
                        </sf:select><br>


                        <label>Name: </label>
                        <sf:input path="name" size="21"/><br>
                        <label>Price: </label>
                        <sf:input path="minPrice" size="8" placeholder="from"/>
                        <sf:input path="maxPrice" size="8" placeholder="to"/><br>

                        <label>Size : </label>
                        <sf:input path="minSize" size="8" placeholder="from"/>
                        <sf:input path="maxSize" size="8" placeholder="to"/><br>


                        <label>Ram : </label>
                        <sf:input path="minRam" size="8" placeholder="from"/>
                        <sf:input path="maxRam" size="8" placeholder="to"/><br>

                        <input type="submit" value="Search" class="btn"/>

                        ${SearchRes}
                    </sf:form>
                </div>
                <div class="col-md-8">
                    <ul class="listOfProducts">

                        <c:forEach items="${productList}" var="item">
                            <li>
                                <a href="/item/${item.getId()}">
                                    <img src="${item.getImageUrl()}"/>

                                    <span>${item.getEntityName()}</span><br>
                                    id: ${item.getId()}

                                </a>
                                ${item.getSummary()}
                                <br>

                                <div class="btn_right">
                                    <a class="btn btn-default btnLink" role="button" href="/addProduct/${item.getId()}">add to
                                        cart</a><br>
                                    <a class="btn btn-default btnLink" role="button" href="/item/${item.getId()}">see more</a>
                                    <br><span>${item.getPrice()}$</span> <br>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>


            </div>
        </div>
    </div>


</div>
</body>
</html>