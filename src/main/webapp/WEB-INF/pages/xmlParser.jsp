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
                <li><a class="logo" href="/"><br></a></li>
                <li><a class="mainLink" href="/">Main</a></li>
                <li>
                    <a class="telephone" href="#">Products</a>
                    <ul class="submenu">
                        <li><a class="telephone" href="#">Telephone</a></li>
                        <li><a class="tablet" href="#">Tablet</a></li>
                    </ul>
                </li>
                <li><a class="cart" href="#">Cart</a></li>
                <li class="userRole" style="display: none"><a href="#">User</a>
                    <ul class="submenu">
                        <li><a class="logout" href="#">LogOut</a></li>
                        <li><a class="allOrders" href="#">Orders</a></li>
                    </ul>
                </li>
                <li class="guestRole" style="display: none"><a href="#">User</a>
                    <ul class="submenu">
                        <li><a class="login" href="#">LogIn</a></li>
                        <li><a class="registerUser" href="#">Register</a></li>
                    </ul>
                </li>
                <li class="adminRole" style="display: none"><a href="#">Admin</a>
                    <ul class="submenu">
                        <li><a class="logout" href="#">LogOut</a></li>
                        <li><a class="allOrders" href="#">Orders</a></li>
                        <li><a class="newTelephone" href="#">Create Telephone</a></li>
                        <li><a class="newTablet" href="#">Create Tablet</a></li>
                        <li><a class="crateXml" href="/uploadFile">Xml Parser</a></li>
                    </ul>
                </li>
            </nav>

            <div class="container">

                <div id="page-preloader" style="display: none;">
                    <span class="spinner">loading...</span>
                </div>

                <div class="results">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <br>
                        <h2>Xml Parser</h2><br>
                        <form action="/uploadFile" method="post" enctype="multipart/form-data">

                            <input type="file" name="file"><br>
                            <input type="submit" value="upload File" class="btn btn-default btnLink uploadBtn">

                        </form>
                        <a class="btn btn-default btnLink downloadBtn" href="/downloadSchema">schema</a>
                        <a class="btn btn-default btnLink downloadBtn" href="/downloadCatalog">catalog</a><br>
                        ${msg}<br>
                        ${msg2}

                    </div>
                </div>
            </div>
        </div>

    </div>


</div>


<script language="javascript" type="text/javascript">


    var role = '${userRole}';

    if (role == 'N'){
        $('.guestRole').show();
    }
    if (role == 'U'){
        $('.userRole').show();
    }
    if (role == 'A'){
        $('.adminRole').show();
    }

    function funLoad(str) {
        $('#page-preloader').show();
        $.ajax({
            url: str,
            success: function(data) {
                $('.results').html(data);
                $('#page-preloader').hide();
            }
        });
    }
    $('.telephone').click( function() {
        funLoad('/products/telephone');
    });
    $('.tablet').click( function() {
        funLoad('/products/tablet');
    });
    $('.newTelephone').click( function() {
        funLoad('/newProduct/telephone');
    });
    $('.newTablet').click( function() {
        funLoad('/newProduct/tablet');
    });
    $('.cart').click( function() {
        funLoad('/cart');
    });
    $('.login').click( function() {
        funLoad('/login');
    });
    $('.allOrders').click( function() {
        funLoad('/getAllOrders');
    });
    $('.registerUser').click( function() {
        funLoad('/createUser');
    })

    $('.logout').click( function() {
        funLoad('/logout');
    });
</script>

</body>
</html>