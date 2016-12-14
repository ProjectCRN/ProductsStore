<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




    <ul class="listOfProducts">
        ${emptyList}
        <c:forEach items="${productList}" var="item">
            <li>
                <a href="#" class="seeMore_btn_${item.getId()}">
                    <img src="${item.getImageUrl()}"/>

                    <span>${item.getEntityName()}</span><br>
                    <!--id: ${item.getId()}-->
                </a>
                    ${item.getSummary()}<br>
                Capacity, GB: ${item.getCapacity()}<br>
                Battery (Hours): ${item.getBattery()}
                <br>

                <div class="btn_right">

                    <button name="sample1${item.getId()}" class="sample1${item.getId()} btn btn-default btnLink">add to
                        cart</button>
                    <div  id="added${item.getId()}"  style="display: none;">Added</div>
                    <a class="btn btn-default btnLink activeDelete${item.getId()} delete_btn_${item.getId()}" role="button"  href="#">delete</a>
                    <a class="btn btn-default btnLink activeRestore${item.getId()} restore_btn_${item.getId()}" role="button"  href="#">restore</a>
                    <a class="btn btn-default btnLink update_btn_${item.getId()}" role="button"  href="#">update</a>
                    <a class="btn btn-default btnLink seeMore_btn_${item.getId()}" role="button"  href="#">see more</a>
                    <br><span>${item.getPrice()}$</span> <br>

                    <script>
                        var userRole = '${role}';

                        if (userRole == 'A' && '${item.getisActive()}' == '0'){
                            $('.activeRestore${item.getId()}').show();
                        } else {
                            $('.activeRestore${item.getId()}').hide();
                        }

                        if (userRole == 'A' && '${item.getisActive()}' == '1'){
                            $('.activeDelete${item.getId()}').show();
                        } else {
                            $('.activeDelete${item.getId()}').hide();
                        }

                        if (userRole == 'A'){
                            $('.update_btn_${item.getId()}').show();
                        } else {
                            $('.update_btn_${item.getId()}').hide();
                        }

                        $('.sample1${item.getId()}').click( function() {
                            $.ajax({
                                url: '/addProduct/${item.getId()}',
                            });
                            document.getElementById('added${item.getId()}').style.display = "block";
                        });

                        $('.seeMore_btn_${item.getId()}').click( function() {
                            $.ajax({
                                url: '/item/${item.getId()}',
                                success: function(data) {
                                    $('.results').html(data);
                                }
                            });
                        });
                        $('.delete_btn_${item.getId()}').click( function() {
                            $('#page-preloader').show();
                            $.ajax({
                                url: '/deleteProduct/${currType}/${item.getId()}',
                                success: function(data) {
                                    $('.results').html(data);
                                    $('#page-preloader').hide();
                                }
                            });
                        });
                        $('.restore_btn_${item.getId()}').click( function() {
                            $('#page-preloader').show();
                            $.ajax({
                                url: '/restoreProduct/${currType}/${item.getId()}',
                                success: function(data) {
                                    $('.results').html(data);
                                    $('#page-preloader').hide();
                                }
                            });
                        });
                        $('.update_btn_${item.getId()}').click( function() {
                            $.ajax({
                                url: '/updateProduct/${currType}/${item.getId()}',
                                success: function(data) {
                                    $('.results').html(data);
                                }
                            });
                        });
                    </script>
                </div>
            </li>
        </c:forEach>
    </ul>

