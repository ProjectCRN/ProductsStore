<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:url value="/resources/img/spinner6.gif" var="spinner6" />
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



            <div class="container">

                <div id="page-preloader" style="display: none;">
                    <span class="spinner">loading...</span>
                </div>



                <div class="results">

                    <h1 style="align-content: center">Page not found</h1>
                    <img  src="${spinner6}"/>
                    <a href="/" class="btn btn-default btnLink mainBtn">Main</a>


                </div>
            </div>
        </div>

    </div>


</div>


</body>
</html>