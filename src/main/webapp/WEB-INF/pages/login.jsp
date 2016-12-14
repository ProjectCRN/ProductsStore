<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>


<form:form method="post" id="loginForm" commandName="loginForm" action="javascript:void(null);" onsubmit="loginFun()">
    <div class="col-md-4"></div>
        <ul class="col-md-4 formOrder">
            <li><h3>Login</h3></li>
            <li>
                <form:input path="login" class="requiredField"  size="30" placeholder="Login" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="required" />
                <span class="error"><form:errors path="login" /></span>
            </li>
            <li>
                <form:password path="password" class="requiredField"  size="30" required="required" placeholder="Password" />
                <span class="error"><form:errors path="password" /></span>
            </li>

            <li>
                <input type="submit" class="btn btn-default btnLink submit_btn" value="Submit" />
            </li>
        </ul>
</form:form>

<script type="text/javascript" language="javascript">
    function loginFun() {
        $('#page-preloader').show();
        var msg   = $('#loginForm').serialize();
        $.ajax({
            type: 'POST',
            url: '/login',
            data: msg,
            success: function(data) {
                $('.results').html(data);
                $('#page-preloader').hide();
            }
        });
    }

</script>
