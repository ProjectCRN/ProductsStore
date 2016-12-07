<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-4"></div>
<div class="col-md-4">
    <c:forEach items="${orderList}" var="item">
        <ul class="listOfProducts">
        <li>
            Number: №${item.getOrderNumber()} <br>
            Total: ${item.getTotal()} <br>
                ${item.getId()}<br>
            <a class="btn btn-default btnLink seeMoreOrder_${item.getId()}" href="#">see more</a>
            <br>

            <script type="text/javascript" language="javascript">
                $('.seeMoreOrder_${item.getId()}').click( function() {
                    funLoad('/getOrder/${item.getId()}');
                });
            </script>


        </li>
        </ul>
    </c:forEach>
</div>



<script type="text/javascript" language="javascript">
    function funLoad(str) {
        $('#page-preloader').show();
        $.ajax({
            url: str,
            success: function(data) {
                $('.results').html(data);
                $('#page-preloader').hide();
            }
        });
    }


</script>