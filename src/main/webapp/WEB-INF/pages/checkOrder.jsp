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
        <tr>
            <td>Paid Date:</td>
            <td>${order.getPaidDate()}</td>
        </tr>
        <tr>
            <td>Description:</td>
            <td>${order.getDescription()}</td>
        </tr>
    </table>

    <a class="btn btn-default btnLink" href="/">Ok</a>
</div>