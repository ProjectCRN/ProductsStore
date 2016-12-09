<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<h2>${cartInfo}</h2>
<sf:form method="post" id="formOrder" modelAttribute="order" action="javascript:void(null);" onsubmit="orderFun()">
    <div class="col-md-4"></div>
    <ul class="col-md-4 formOrder">

        <li>
            <sf:input path="contactName" size="30" placeholder="Contact Name" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="required" /><br/>
            <sf:errors path="contactName"/>
        </li>

        <li>
            <sf:input path="contactAddress" size="30" placeholder="Contact Address" required="required"/><br/>
            <sf:errors path="contactAddress" cssClass="error"/>
        </li>

        <li>
            <sf:input path="contactPhone" size="30" placeholder="Contact Phone" pattern="^((8|\+375)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$" required="required"/><br/>
            <sf:errors path="contactPhone" cssClass="error"/>
        </li>

        <li>
            <br>
            <input type="submit" class="btn btn-default btnLink submit_btn" value="Create Order"/>
        </li>

    </ul>

</sf:form>

<script type="text/javascript" language="javascript">
    function orderFun() {
        $('#page-preloader').show();
        var msg = $('#formOrder').serialize();
        $.ajax({
            type: 'POST',
            url: 'createOrder',
            data: msg,
            success: function (data) {
                $('.results').html(data);
                $('#page-preloader').hide();
            }
        });
    }
</script>