<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-4"></div>
<div class="col-md-4">
    <table class="table table-striped">
        <tr>
            <td>Order:</td>
            <td>№${order.getOrderNumber()}</td>
        </tr>
        <tr>
            <td>Total:</td>
            <td>${order.getTotal()}</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${order.getContactName()}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${order.getContactAddress()}</td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td>${order.getContactPhone()}</td>
        </tr>
        <tr>
            <td>Created Date:</td>
            <td>${order.getCreatedDate()}</td>
        </tr>

    </table><br>
    <br>
    <a class="btn btn-default btnLink" href="/">Ok</a><br>
    <a class="btn btn-default btnLink cartFromOrder" href="#">See Cart</a>
    <a class="btn btn-default btnLink allOrdersInCheck" href="#">All Orders</a>

    <script type="text/javascript" language="javascript">

        if(${order.getId()} == 0){
            $('.cartFromOrder').hide()
            $('.allOrdersInCheck').show()
        } else {
            $('.cartFromOrder').show()
            $('.allOrdersInCheck').hide()
        }

        $('.cartFromOrder').click( function() {
            funLoad('/getCart/${order.getId()}');
        });
        $('.allOrders').click( function() {
            funLoad('/getAllOrders');
        });


        function funLoad(str) {
            $('#page-preloader').show();
            $.ajax({
                url: str,
                success: function(data) {
                    $('.results').html(data);
                    $('#page-preloader').hide();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $('.results').html('<img src="/resources/img/spinner3.gif" /><span class="error">'+textStatus + errorThrown + '</spam>');
                    $('#page-preloader').hide();
                }
            });
        }

    </script>
</div>