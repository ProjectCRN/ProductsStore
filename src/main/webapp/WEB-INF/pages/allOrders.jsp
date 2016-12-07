<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <c:forEach items="${orderList}" var="item">
        <li>
            Number: №${item.getOrderNumber()} <br>
            Total: ${item.getTotal()} <br>
                ${item.getId()}<br>
            <a class="seeMoreOrder" href="#">see more</a>
            <br>

            <script type="text/javascript" language="javascript">
                $('.seeMoreOrder').click( function() {
                    funLoad('/getOrder/${item.getId()}');
                });
            </script>


        </li>
    </c:forEach>
    <h1>${orderInfo}</h1>
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