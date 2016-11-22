<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="jquery-3.1.1.min.js"></script>
    <style type="text/css">
        span.error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" commandName="signupForm">

    <table class="table table-striped">
        <tr>
            <td>Login:</td>
            <td><form:input path="login" /></td>
            <td><span class="error"><form:errors path="login" /></span></td>
        </tr>

        <tr>
            <td>Username:</td>
            <td><form:input path="userName" /></td>
            <td><span class="error"><form:errors path="userName" /></span></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:password path="password" /></td>
            <td><span class="error"><form:errors path="password" /></span></td>
        </tr>

        <tr>
            <td>Confirm Password:</td>
            <td><form:password path="confirmPassword" /></td>
            <td><span class="error"><form:errors
                    path="confirmPassword" /></span></td>
        </tr>

        <tr>
            <td>Contact Phone:</td>
            <td><form:input path="contactPhone" /></td>
            <td><span class="error"><form:errors path="contactPhone" /></span></td>
        </tr>

        <tr>
            <td>Contact Address:</td>
            <td><form:input path="contactAddress" /></td>
            <td><span class="error"><form:errors path="contactAddress" /></span></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>
