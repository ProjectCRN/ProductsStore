<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>


<form:form method="post" id="loginForm" commandName="loginForm" action="login">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <table class="table table-striped">
            <tr>
                <td>Login:</td>
                <td><form:input path="login"  size="30" placeholder="Login" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="required" /></td>
                <td><span class="error"><form:errors path="login" /></span></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="password"  size="30" required="required" placeholder="Password" /></td>
                <td><span class="error"><form:errors path="password" /></span></td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </div>
</form:form>

<script type="text/javascript" language="javascript">
    function loginFun() {
        var msg   = $('#loginForm').serialize();
        $.ajax({
            type: 'POST',
            url: '/login',
            data: msg,
            success: function(data) {
                $('.results').html(data);
            }
        });
    }


</script>
