<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 13.12.2016
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductStore</title>
    <spring:url value="/resources/css/style.css" var="mainCss" />
    <spring:url value="/resources/lib/bootstrap/bootstrap-grid-3.3.1.min.css" var="btsCss" />
    <spring:url value="/resources/img/spinner6.gif" var="spinner6" />
    <spring:url value="/resources/lib/jquery/jquery-1.8.3.js" var="jquery"/>
    <link href="${btsCss}" rel="stylesheet" />
    <link href="${mainCss}" rel="stylesheet" />
    <script src="${jquery}"></script>

</head>
<body>

<h1 style="align-content: center">Page not found</h1>
<img class="mainSpinner" src="${spinner6}"/>
<a href="/" class="btn btnLink">return</a>

</body>
</html>
