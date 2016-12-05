<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>


<form:form method="post" id="signupForm" commandName="signupForm" action="javascript:void(null);" onsubmit="signupFun()">
    <div class="col-md-4"></div>
    <div class="col-md-4">
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
    </div>
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