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
                <li><a href="/products/telephone">Telephone</a></li>
                <li><a href="/products/tablet">Tablet</a></li>
                <li><a href="/cart">Cart</a></li>
                <li><a href="/createOrder">Create Order</a></li>
                <li><a href="/createUser">Registration</a></li>
            </nav>
            <div class="container">

                <div class="col-md-3 search">
                    <h3>Search:</h3>
                    <sf:form method="get" modelAttribute="searchAttr" action="search">

                        <label>Price: </label>
                        <sf:input path="minPrice" size="8" placeholder="min" pattern="^[ 0-9]+$"/>
                        <sf:input path="maxPrice" size="8" placeholder="max" pattern="^[ 0-9]+$"/><br>

                        <label>Capacity (GB): </label>
                        <sf:input path="minCapacity" size="8" placeholder="min" pattern="^[ 0-9]+$"/>
                        <sf:input path="maxCapacity" size="8" placeholder="max" pattern="^[ 0-9]+$"/><br>


                        <label>Battery (Hours): </label>
                        <sf:input path="minBattery" size="8" placeholder="min" pattern="^[ 0-9]+$"/>
                        <sf:input path="maxBattery" size="8" placeholder="max" pattern="^[ 0-9]+$"/><br>

                        <sf:input path="type" style="display: none;" value="${currType}"/>
                        <input type="submit" value="Search" class="btn"/>
                    </sf:form>
                </div>
                <div class="col-md-8">
                    <ul class="listOfProducts">
                        ${emptyList}
                        <c:forEach items="${productList}" var="item">
                            <li>
                                <a href="/item/${item.getId()}">
                                    <img src="/resources/img/img_phone.jpg"/>

                                    <span>${item.getEntityName()}</span><br>
                                    id: ${item.getId()}

                                </a>
                                ${item.getSummary()}
                                <br>

                                <div class="btn_right">

                                    <button name="sample1${item.getId()}" class="sample1${item.getId()} btn btn-default btnLink">add to
                                        cart</button>
                                    <div  id="added${item.getId()}"  style="display: none;">Added</div>
                                    <script>
                                        $('.sample1${item.getId()}').click( function() {

                                            $.ajax({
                                                url: '/addProduct/${item.getId()}',

                                            });
                                            document.getElementById('added${item.getId()}').style.display = "block";
                                        });
                                    </script>

                                    <!--<a class="btn btn-default btnLink" role="button" href="/addProduct/${item.getId()}">add to
                                        cart</a><br>-->
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