<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "xbcat.util.*"  %>



            <div class="align_center">

                <div class="col-md-9">
                    <ul class="listOfProducts">
                        <c:forEach items="${cartList}" var="item">

                            <li>
                                <a href="#" class="seeMore_btn_${item.getProduct().getId()}">
                                    <img src="${item.getProduct().getImageUrl()}"/>

                                    <span>${item.getProduct().getEntityName()}</span></a><br>
                                    quantity: ${item.getQuantity()} <br>


                                    ${item.getProduct().getSummary()}
                                <br>

                                <div class="btn_right">

                                    <a class="btn btn-default btnLink hide_show " id="btnAdd_${item.getProduct().getId()}" role="button"
                                       href="#">add</a>
                                    <a class="btn btn-default btnLink hide_show" id="btnDel_${item.getProduct().getId()}" role="button"
                                       href="#">delete</a><br>
                                    <sf:form id="btnQuan_${item.getProduct().getId()}" class="hide_show" method="get" modelAttribute="cartQuantity"
                                             action="javascript:void(null);" onsubmit="setFun_${item.getProduct().getId()}()">
                                        <sf:input path="quantity" size="8" placeholder="Quantity" pattern="[ 0-9]{1,6}"/><br>
                                        <input type="submit" value="setQuantity" class="btn btn-default btnLink"  style="display: none;"/>
                                    </sf:form>
                                <br><span>${item.getProduct().getPrice()}$</span> <br>

                </div>
                            </li>

                            <script type="text/javascript" language="javascript">
                                function setFun_${item.getProduct().getId()}() {
                                    var msg   = $('#btnQuan_${item.getProduct().getId()}').serialize();
                                    $.ajax({
                                        type: 'GET',
                                        url: '/setQuantity/${item.getProduct().getId()}',
                                        data: msg,
                                        success: function(data) {
                                            $('.results').html(data);
                                        }
                                    });
                                }
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

                                if(${prev} == '2'){
                                    $('.seeMore_btn_${item.getProduct().getId()}').click( function() {
                                        $.ajax({
                                            url: '/item/${item.getProduct().getValueFromList(20)}',
                                            success: function(data) {
                                                $('.results').html(data);
                                            }
                                        });
                                    });
                                } else {
                                    $('.seeMore_btn_${item.getProduct().getId()}').click( function() {
                                        $.ajax({
                                            url: '/item/${item.getProduct().getId()}',
                                            success: function(data) {
                                                $('.results').html(data);
                                            }
                                        });
                                    });
                                }


                            </script>

                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-3 left_block">
                     <h1>Total: ${total}$ </h1>
                     <a class="btn btn-default btnLink createOrder hide_show" href="#">Create Order</a>
                </div>
            </div>


<script language="javascript" type="text/javascript">




    if(${prev} == '2'){
        $('.hide_show').hide();
    } else {
        $('.hide_show').show();
    }

    if(${total} == '0'){
        $('.createOrder').hide();
    } else {
        if(${prev} != '2'){
            $('.createOrder').show();
        }
    }


    $('.createOrder').click( function() {
        funLoad('/createOrder');
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