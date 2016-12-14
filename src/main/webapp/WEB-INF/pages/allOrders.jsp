<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-4"></div>
<div class="col-md-4">
    <c:forEach items="${orderList}" var="item">
        <ul class="listOfProducts">
        <li>
            Number: №${item.getOrderNumber()} <br>
            Total: ${item.getTotal()} <br>
            <a class="btn btn-default btnLink seeMore seeMoreOrder_${item.getId()}" href="#">see more</a>
            <a class="btn btn-default btnLink seeMore deleteOrder_${item.getId()}" href="#">delete</a>
            <br>

            <script type="text/javascript" language="javascript">

                var userRole = '${role}';

                if (userRole == 'A'){
                    $('.deleteOrder_${item.getId()}').show();
                } else {
                    $('.deleteOrder_${item.getId()}').hide();
                }

                $('.seeMoreOrder_${item.getId()}').click( function() {
                    funLoad('/getOrder/${item.getId()}');
                });

                $('.deleteOrder_${item.getId()}').click( function() {
                    $('#page-preloader').show();
                    $.ajax({
                        url: '/deleteOrder/${item.getId()}',
                        success: function(data) {
                            $('.results').html(data);
                            $('#page-preloader').hide();
                        }
                    });
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