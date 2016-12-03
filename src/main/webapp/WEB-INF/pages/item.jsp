<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


                <table class="table table-striped">
                    <tr>
                        <td>Id</td>
                        <td>${item.getId()}</td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>${item.getEntityName()}</td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td>${item.getPrice()}</td>
                    </tr>
                </table>
