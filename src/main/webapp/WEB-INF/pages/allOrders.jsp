<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <c:forEach items="${orderList}" var="item">
        <li>
            Number: №${item.getOrderNumber()} <br>
            Total: ${item.getTotal()} <br>
            ${item.getDescription()}<br>
            <a href="/getOrder/"${item.getId()}>see more</a>
            <br>
        </li>
    </c:forEach>
</div>