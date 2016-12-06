<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>


<form:form method="post" id="signupForm" commandName="signupForm" action="javascript:void(null);" onsubmit="signupFun()">
    <div class="col-md-4"></div>
    <ul class="col-md-4 formOrder">
        <li><h3>Register</h3></li>
        <li>
            <form:input path="login"  size="30" placeholder="Login" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="required" />
            <span class="error"><form:errors path="login" /></span>
        </li>

        <li>
            <form:input path="userName"  size="30" placeholder="Name" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{0,20}$"/>
            <span class="error"><form:errors path="userName" /></span>
        </li>

        <li>
            <form:password path="password"  size="30" required="required" placeholder="Password" />
            <span class="error"><form:errors path="password" /></span>
        </li>

        <li>
            <form:password path="confirmPassword"  size="30" required="required" placeholder="Confirm Password" />
            <span class="error"><form:errors  path="confirmPassword" /></span>
        </li>

        <li>
            <form:input path="contactPhone"  size="30" placeholder="Phone" pattern="^((8|\+375)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$" />
            <span class="error"><form:errors path="contactPhone" /></span>
        </li>

        <li>
            <form:input path="contactAddress"  size="30" placeholder="Contact Address"/>
            <span class="error"><form:errors path="contactAddress" /></span>
        </li>

        <li>
            <form:input path="email"  size="30" pattern="\S+@[a-z]+.[a-z]+" placeholder="E-mail" required="required"/>
            <span class="error"><form:errors path="email" /></span>
        </li>

        <li>
            <input type="submit" class="btn btn-default btnLink submit_btn" value="Submit" />
        </li>
    </ul>

</form:form>

<script type="text/javascript" language="javascript">
    function signupFun() {
        $('#page-preloader').show();
        var msg   = $('#signupForm').serialize();
        $.ajax({
            type: 'POST',
            url: '/createUser',
            data: msg,
            success: function(data) {
                $('.results').html(data);
                $('#page-preloader').hide();
            }
        });
    }


</script>