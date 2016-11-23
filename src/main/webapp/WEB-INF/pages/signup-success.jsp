<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
    <title>Successfull Sign Up</title>
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

<h1>Successfull Sign Up</h1>

<p>Congratulations! Your signup was successful</p>

<a href="${pageContext.request.contextPath}/" title="Home">Home</a>
            </div>
        </div>
    </div>


</div>
</body>
</html>