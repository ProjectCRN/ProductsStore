<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>


<form:form method="post" id="profileForm" commandName="profileForm" action="javascript:void(null);" onsubmit="profileFun()">
    <div class="col-md-4"></div>
    <ul class="col-md-4 formOrder">
        <li><h3>Register</h3></li>

        <li>
            <form:input path="userName"  size="30"  class="requiredField" required="required"
                        placeholder="Name" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{0,20}$"/>
            <span class="error"><form:errors path="userName" /></span>
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
            <input type="submit" class="btn btn-default btnLink submit_btn" value="Save changes" />
        </li>
    </ul>

</form:form>

<script type="text/javascript" language="javascript">
    function profileFun() {
        $('#page-preloader').show();
        var msg   = $('#profileForm').serialize();
        $.ajax({
            type: 'POST',
            url: '/updateUser',
            data: msg,
            success: function(data) {
                $('.results').html(data);
                $('#page-preloader').hide();
            }
        });
    }


</script>