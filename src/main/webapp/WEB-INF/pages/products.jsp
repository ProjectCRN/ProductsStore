<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-md-3 search">
    <h3>Search:</h3>
    <sf:form method="get" id="formSearch" modelAttribute="searchAttr" action="javascript:void(null);" onsubmit="searchFun()">

        <label>Price: </label><br>
        <sf:input path="minPrice" size="12" placeholder="min" pattern="^[ 0-9]+$"/>
        <sf:input path="maxPrice" size="12" placeholder="max" pattern="^[ 0-9]+$"/><br><br><br>

        <label>Capacity (GB): </label><br>
        <sf:input path="minCapacity" size="12" placeholder="min" pattern="^[ 0-9]+$"/>
        <sf:input path="maxCapacity" size="12" placeholder="max" pattern="^[ 0-9]+$"/><br><br><br>


        <label>Battery (Hours): </label><br>
        <sf:input path="minBattery" size="12" placeholder="min" pattern="^[ 0-9]+$"/>
        <sf:input path="maxBattery" size="12" placeholder="max" pattern="^[ 0-9]+$"/><br><br><br>

        <label>Products per Page: </label><br>
        <sf:input path="numPerPage" size="12" placeholder="products per page" pattern="^[ 0-9]+$"/><br><br>

        <sf:input path="type" style="display: none;" value="${currType}"/>
        <input type="submit" value="Search" class="btn"/>

    </sf:form>
</div>
<div class="col-md-8">
    <ul class="listOfProducts">
        ${emptyList}
        <c:forEach items="${productList}" var="item">
            <li>
                <a href="#" class="seeMore_btn_${item.getId()}">
                    <img src="${item.getImageUrl()}"/>

                    <span>${item.getEntityName()}</span><br>
                    <!--id: ${item.getId()}-->

                </a>
                    ${item.getSummary()}
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
                            $.ajax({
                                url: '/deleteProduct/${currType}/${item.getId()}',
                                success: function(data) {
                                    $('.results').html(data);
                                }
                            });
                        });
                        $('.restore_btn_${item.getId()}').click( function() {
                            $.ajax({
                                url: '/restoreProduct/${currType}/${item.getId()}',
                                success: function(data) {
                                    $('.results').html(data);
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
    <ul class="list_pagination">

        <c:forEach items="${pages}" var="page">
            <li><a class="page_${page.getKey()}  ${page.getValue()}" href="#">${page.getKey()}</a>

                <script type="text/javascript" language="javascript">
                    $('.page_${page.getKey()}').click( function() {
                        $('#page-preloader').show();
                        var msg   = $('#formSearch').serialize();
                        $.ajax({
                            url: '${searchReq}/${currType}/page/${page.getKey()}',
                            data: msg,
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