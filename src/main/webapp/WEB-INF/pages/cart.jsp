<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



            <div class="align_center">

                <div class="col-md-9">
                    <ul class="listOfProducts">
                        <c:forEach items="${cartList}" var="item">

                            <li>
                                <a href="#" class="seeMore_btn_${item.getProduct().getId()}">
                                    <img src="/resources/img/img_phone.jpg"/>

                                    <span>${item.getProduct().getEntityName()}</span></a><br>
                                    id: ${item.getProduct().getId()} <br>
                                    quantity: ${item.getQuantity()} <br>


                                    ${item.getProduct().getSummary()}
                                <br>

                                <div class="btn_right">

                                    <a class="btn btn-default btnLink " id="btnAdd_${item.getProduct().getId()}" role="button"
                                       href="#">add</a><br>
                                    <a class="btn btn-default btnLink " id="btnDel_${item.getProduct().getId()}" role="button"
                                       href="#">delete</a>
                                    <br><span>${item.getProduct().getPrice()}$</span> <br>
                                </div>
                            </li>

                            <script type="text/javascript" language="javascript">
                                $('#btnAdd_${item.getProduct().getId()}').click( function() {
                                    $.ajax({
                                        url: '/addCartProduct/${item.getProduct().getId()}',
                                        success: function(data) {
                                            $('.results').html(data);
                                        }
                                    });
                                });
                                $('#btnDel_${item.getProduct().getId()}').click( function() {
                                    $.ajax({
                                        url: '/deleteCartProduct/${item.getProduct().getId()}',
                                        success: function(data) {
                                            $('.results').html(data);
                                        }
                                    });
                                });

                                $('.seeMore_btn_${item.getProduct().getId()}').click( function() {
                                    $.ajax({
                                        url: '/item/${item.getProduct().getId()}',
                                        success: function(data) {
                                            $('.results').html(data);
                                        }
                                    });
                                });
                            </script>

                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-3 left_block">
                     <h1>Total: ${total}$</h1>
                     <a class="btn btn-default btnLink createOrder" href="#">Create Order</a>
                </div>
            </div>


<script language="javascript" type="text/javascript">

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
    $('.createOrder').click( function() {
        funLoad('/createOrder');
    });
    if(${total} == '0'){
        $('.createOrder').hide();
    } else {
        $('.createOrder').show();
    }

</script>