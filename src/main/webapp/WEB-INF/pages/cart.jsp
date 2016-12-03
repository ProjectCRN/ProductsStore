<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



            <div class="container align_center">

                <div class="col-md-9">
                    <ul class="listOfProducts">
                        <c:forEach items="${cartList}" var="item">

                            <li>
                                <a href="/item/${item.getProduct().getId()}">
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

                            </script>

                        </c:forEach>
                    </ul>
                </div>

                <h1>Total: ${total}</h1>

            </div>


