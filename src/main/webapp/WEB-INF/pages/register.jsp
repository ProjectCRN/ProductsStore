<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>


<form:form method="post" id="signupForm" commandName="signupForm" action="javascript:void(null);" onsubmit="signupFun()">

    <table class="table table-striped">
        <tr>
            <td>Login:</td>
            <td><form:input path="login"  size="30" placeholder="Login" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="required" /></td>
            <td><span class="error"><form:errors path="login" /></span></td>
        </tr>

        <tr>
            <td>Username:</td>
            <td><form:input path="userName"  size="30" placeholder="Name" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{0,20}$"/></td>
            <td><span class="error"><form:errors path="userName" /></span></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:password path="password"  size="30" required="required" placeholder="Password" /></td>
            <td><span class="error"><form:errors path="password" /></span></td>
        </tr>

        <tr>
            <td>Confirm Password:</td>
            <td><form:password path="confirmPassword"  size="30" required="required" placeholder="Confirm Password" /></td>
            <td><span class="error"><form:errors
                    path="confirmPassword" /></span></td>
        </tr>

        <tr>
            <td>Contact Phone:</td>
            <td><form:input path="contactPhone"  size="30" placeholder="Phone" pattern="^((8|\+375)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$" /></td>
            <td><span class="error"><form:errors path="contactPhone" /></span></td>
        </tr>

        <tr>
            <td>Contact Address:</td>
            <td><form:input path="contactAddress"  size="30" placeholder="Contact Address"/></td>
            <td><span class="error"><form:errors path="contactAddress" /></span></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><form:input path="email"  size="30" pattern="\S+@[a-z]+.[a-z]+" placeholder="E-mail" required="required"/></td>
            <td><span class="error"><form:errors path="email" /></span></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>


<script type="text/javascript" language="javascript">
    function signupFun() {
        var msg   = $('#signupForm').serialize();
        $.ajax({
            type: 'POST',
            url: '/createUser',
            data: msg,
            success: function(data) {
                $('.results').html(data);
            }
        });
    }


</script>