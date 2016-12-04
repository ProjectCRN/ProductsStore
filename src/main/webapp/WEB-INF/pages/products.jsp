<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--<script>
        $(window).on('load', function () {
            var $preloader = $('#page-preloader'),
                    $spinner   = $preloader.find('.spinner');
            $spinner.fadeOut();
            $preloader.delay(350).fadeOut('slow');
        });
    </script>-->

                <div class="col-md-3 search">
                    <h3>Search:</h3>
                    <sf:form method="get" id="formSearch" modelAttribute="searchAttr" action="javascript:void(null);" onsubmit="searchFun()">

                        <label>Price: </label>
                        <sf:input path="minPrice" size="8" placeholder="min" pattern="^[ 0-9]+$"/>
                        <sf:input path="maxPrice" size="8" placeholder="max" pattern="^[ 0-9]+$"/><br>

                        <label>Capacity (GB): </label>
                        <sf:input path="minCapacity" size="8" placeholder="min" pattern="^[ 0-9]+$"/>
                        <sf:input path="maxCapacity" size="8" placeholder="max" pattern="^[ 0-9]+$"/><br>


                        <label>Battery (Hours): </label>
                        <sf:input path="minBattery" size="8" placeholder="min" pattern="^[ 0-9]+$"/>
                        <sf:input path="maxBattery" size="8" placeholder="max" pattern="^[ 0-9]+$"/><br>

                        <sf:input path="type" style="display: none;" value="${currType}"/>
                        <input type="submit" value="Search" class="btn"/>
                    </sf:form>
                </div>
                <div class="col-md-8">
                    <ul class="listOfProducts">
                        ${emptyList}
                        <c:forEach items="${productList}" var="item">
                            <li>
                                <a href="#" id="seeMore_${item.getId()}">
                                    <img src="/resources/img/img_phone.jpg"/>

                                    <span>${item.getEntityName()}</span><br>
                                    id: ${item.getId()}

                                </a>
                                ${item.getSummary()}
                                <br>

                                <div class="btn_right">

                                    <button name="sample1${item.getId()}" class="sample1${item.getId()} btn btn-default btnLink">add to
                                        cart</button>
                                    <div  id="added${item.getId()}"  style="display: none;">Added</div>


                                    <a class="btn btn-default btnLink" role="button" id="seeMore_${item.getId()}" href="#">see more</a>
                                    <br><span>${item.getPrice()}$</span> <br>

                                    <script>
                                        $('.sample1${item.getId()}').click( function() {
                                            $.ajax({
                                                url: '/addProduct/${item.getId()}',
                                            });
                                            document.getElementById('added${item.getId()}').style.display = "block";
                                        });

                                        $('#seeMore_${item.getId()}').click( function() {
                                            $.ajax({
                                                url: '/item/${item.getId()}',
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
                    <ul class="pagination">
                        <c:forEach items="${pages}" var="page">
                            <li><a id="page" href="#">${page}</a>

                            <script type="text/javascript" language="javascript">

                                $('#page').click( function() {
                                    $('#page-preloader').show();
                                    $.ajax({
                                        url: '${searchReq}/${currType}/page/${page}',
                                        success: function(data) {
                                            $('.results').html(data);
                                            $('#page-preloader').hide();
                                        }
                                    });
                                });
                            </script>
                            </li>
                        </c:forEach>
                    </ul>
                </div>


<script type="text/javascript" language="javascript">
    function searchFun() {
        $('#page-preloader').show();
        var msg   = $('#formSearch').serialize();
        $.ajax({
            type: 'GET',
            url: '/products/${searchBtn}',
            data: msg,
            success: function(data) {
                $('.results').html(data);
                $('#page-preloader').hide();
            }
        });
    }


</script>