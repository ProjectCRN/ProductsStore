<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



    <sf:form method="post" id="formOrder" modelAttribute="order" action="javascript:void(null);" onsubmit="orderFun()">
        <div class="col-md-4"></div>
        <ul class="col-md-4 formOrder">

            <li>
                <sf:input path="name" size="30" placeholder="Name" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" required="required" /><br/>
                <sf:errors path="name"/>
            </li>

            <li>
                <sf:input path="address" size="30" placeholder="Address" required="required"/><br/>
                <sf:errors path="address" cssClass="error"/>
            </li>

            <li>
                <sf:input path="phone" size="30" placeholder="Phone" pattern="^((8|\+375)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$" required="required"/><br/>
                <sf:errors path="phone" cssClass="error"/>
            </li>

            <li>
                <sf:input path="email" size="30" pattern="\S+@[a-z]+.[a-z]+" placeholder="E-mail" required="required"/><br/>
                <sf:errors path="email" cssClass="error"/>
            </li>

            <li>
                <sf:input path="comments" size="30" placeholder="Comments"/><br/>
                <sf:errors path="comments" cssClass="error"/><br>
            </li>
            <li>
                <br>
                <input type="submit" class="btn btn-default btnLink" value="Create Order"/>
                    ${msg}
            </li>

        </ul>

    </sf:form>

<script type="text/javascript" language="javascript">
    function orderFun() {
        var msg = $('#formOrder').serialize();
        $.ajax({
            type: 'POST',
            url: 'createOrder',
            data: msg,
            success: function (data) {
                $('.results').html(data);
            }
        });
    }


</script>