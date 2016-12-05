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

<div id="page-preloader" style="display: none;"><span class="spinner">loading...</span></div>


<div class="content">

    <div class="block1">
        <div class="row">

            <nav>
                <li><a class="logo" href="/"><br></a></li>
                <li><a class="mainLink" href="/">Main</a></li>
                <li>
                    <a href="#">Products</a>
                    <ul class="submenu">
                        <li><a class="telephone" href="#">Telephone</a></li>
                        <li><a class="tablet" href="#">Tablet</a></li>
                    </ul>
                </li>
                <li><a class="cart" href="#">Cart</a></li>
                <li><a class="createUser" href="#">User</a></li>
            </nav>

            <div class="container">
                <div class="results">
                    <img src="${spinner}"/>
                    <h1>${message}</h1>
                    <h2>Hello, ${userName}!</h2>
                </div>
            </div>
        </div>
    </div>


</div>


<script language="javascript" type="text/javascript">
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
    $('.cart').click( function() {
        funLoad('/cart');
    });
    $('.createUser').click( function() {
        funLoad('/createUser');
    });
</script>

</body>
</html>