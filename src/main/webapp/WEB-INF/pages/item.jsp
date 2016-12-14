<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container align_center">

    <div class="col-md-9">
        <ul class="listOfProducts">


            <li>

                <img src="${item.getImageUrl()}"/>

                <span>${item.getEntityName()}</span><br>
                ${item.ValuestoString()}
                <br>

                <div class="btn_right">

                    <button name="sample1${item.getId()}" class="sample1${item.getId()} btn btn-default btnLink isActive">add to
                        cart
                    </button>
                    <div id="added${item.getId()}" style="display: none;">Added</div>
                    <br><span>${item.getPrice()}$</span> <br>


                    <script>

                        if( ${item.getisActive()}){
                            $('.isActive').show();
                        } else {
                            $('.isActive').hide();
                        }


                        $('.sample1${item.getId()}').click(function () {
                            $.ajax({
                                url: '/addProduct/${item.getId()}',
                            });
                            document.getElementById('added${item.getId()}').style.display = "block";
                        });
                    </script>
                </div>
            </li>


        </ul>
    </div>


</div>