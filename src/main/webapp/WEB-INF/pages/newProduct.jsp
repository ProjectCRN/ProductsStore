<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 06.12.2016
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" id="newProduct" commandName="prod" action="javascript:void(null);" onsubmit="signupFun()">
    <div class="col-md-4"></div>
    <ul class="col-md-4 formOrder">
        <li><h3>Add product</h3></li>
        <li>
            <form:input path="price"  size="30" placeholder="price" pattern="\d+(\.\d{0,2})?" required="required" />
            <span class="error"><form:errors path="price" /></span>
        </li>
        <li>
            <form:input path="processorSpeed"  size="30" placeholder="processorSpeed" pattern="[ 0-9]{1,}" required="required" />
            <span class="error"><form:errors path="processorSpeed" /></span>
        </li>
        <li>
            <form:input path="display"  size="30" placeholder="display" pattern="\d+(\.\d{0,1})?" required="required" />
            <span class="error"><form:errors path="display" /></span>
        </li>
        <li>
            <form:input path="height"  size="30" placeholder="height" pattern="\d+(\.\d{0,2})?" required="required" />
            <span class="error"><form:errors path="height" /></span>
        </li>
        <li>
            <form:input path="width"  size="30" placeholder="width" pattern="\d+(\.\d{0,2})?" required="required" />
            <span class="error"><form:errors path="width" /></span>
        </li>
        <li>
            <form:input path="depth"  size="30" placeholder="depth" pattern="\d+(\.\d{0,2})?" required="required" />
            <span class="error"><form:errors path="depth" /></span>
        </li>


        <li>
            <input type="submit" class="btn btn-default btnLink submit_btn" value="Submit" />
        </li>
    </ul>

</form:form>

<script type="text/javascript" language="javascript">
    function signupFun() {
        var msg   = $('#newProduct').serialize();
        $.ajax({
            type: 'POST',
            url: '/newProduct',
            data: msg,
            success: function(data) {
                $('.results').html(data);
            }
        });
    }


</script>
