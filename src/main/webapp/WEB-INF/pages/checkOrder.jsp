<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-4"></div>
<div class="col-md-4">
                <table class="table table-striped">
                    <tr>
                        <td>Order:</td>
                        <td>№${order.getId()}</td>
                    </tr>
                    <tr>
                        <td>Total:</td>
                        <td>${order.getTotal()}</td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>${order.getName()}</td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td>${order.getAddress()}</td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td>${order.getPhone()}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>${order.getEmail()}</td>
                    </tr>
                    <tr>
                        <td>Comments:</td>
                        <td>${order.getComments()}</td>
                    </tr>
                </table>

                <a class="btn btn-default btnLink" href="/">Ok</a>
</div>