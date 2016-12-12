<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-md-3 search">
    <sf:form method="get" id="formSearch" modelAttribute="searchAttr" action="javascript:void(null);"
             onsubmit="searchFun()">

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
        <sf:input path="numPerPage" size="12" placeholder="products per page" pattern="^[ 0-9]+$"/><br><br><br>

        <label>Sort By Name: </label><br>
        <sf:select path="name">
            <c:forEach items="${searchAttr.getSortValues()}" var="c">
                <option
                        <c:if test="${c eq currSort}">selected="selected"</c:if> value="${c}">${c}</option>
            </c:forEach>
        </sf:select><br><br>

        <sf:input path="type" style="display: none;" value="${currType}"/>
        <input type="submit" value="Search" class="btn"/>

    </sf:form>
</div>
<div class="col-md-8">


    <sf:form id="byName" method="get" modelAttribute="searchName"
             action="javascript:void(null);" onsubmit="byNameFun()">
        <sf:input path="name" size="12" class="searchByName" placeholder="Search..."
                  pattern="^[a-zA-Z][a-zA-Z0-9-_\. ]{1,20}$"  required="required"/>
        <input type="submit" value="Search" style="display: none;"/>
    </sf:form>
    <script type="text/javascript" language="javascript">
        function byNameFun() {
            $('#page-preloader').show();
            var msg = $('#byName').serialize();
            $.ajax({
                type: 'GET',
                url: '/searchByName',
                data: msg,
                success: function (data) {
                    $('.resultsSearch').html(data);
                    $('#page-preloader').hide();
                }
            });
        }
    </script>

    <div class="resultsSearch">

        <ul class="listOfProducts">
            ${emptyList}
            <c:forEach items="${productList}" var="item">
                <li>
                    <a href="#" class="seeMore_btn_${item.getId()}">
                        <img src="${item.getImageUrl()}"/>

                        <span>${item.getEntityName()}</span><br>
                        <!--id: ${item.getId()}-->
                        <p>Capacity, GB: ${item.getCapacity()}</p>

                        <p>Battery (Hours): ${item.getBattery()}</p>

                    </a>
                        ${item.getSummary()}
                    <br>

                    <div class="btn_right btn_position">

                        <div id="added${item.getId()}" class="btn_position_Add" style="display: none;">Added</div>
                        <button name="sample1${item.getId()}" class="sample1${item.getId()} btn btn-default btnLink">add
                            to cart
                        </button>
                        <a class="btn btn-default btnLink activeDelete${item.getId()} delete_btn_${item.getId()}"
                           role="button" href="#">delete</a>
                        <a class="btn btn-default btnLink activeRestore${item.getId()} restore_btn_${item.getId()}"
                           role="button" href="#">restore</a>
                        <a class="btn btn-default btnLink update_btn_${item.getId()}" role="button" href="#">update</a>
                        <a class="btn btn-default btnLink seeMore_btn_${item.getId()}" role="button" href="#">see
                            more</a>
                        <br><span>${item.getPrice()}$</span> <br>

                        <script>
                            var userRole = '${role}';

                            if (userRole == 'A' && '${item.getisActive()}' == '0') {
                                $('.activeRestore${item.getId()}').show();
                            } else {
                                $('.activeRestore${item.getId()}').hide();
                            }

                            if (userRole == 'A' && '${item.getisActive()}' == '1') {
                                $('.activeDelete${item.getId()}').show();
                            } else {
                                $('.activeDelete${item.getId()}').hide();
                            }

                            if (userRole == 'A') {
                                $('.update_btn_${item.getId()}').show();
                            } else {
                                $('.update_btn_${item.getId()}').hide();
                            }

                            $('.sample1${item.getId()}').click(function () {
                                $.ajax({
                                    url: '/addProduct/${item.getId()}',
                                });
                                document.getElementById('added${item.getId()}').style.display = "block";
                            });

                            $('.seeMore_btn_${item.getId()}').click(function () {
                                $.ajax({
                                    url: '/item/${item.getId()}',
                                    success: function (data) {
                                        $('.results').html(data);
                                    }
                                });
                            });
                            $('.delete_btn_${item.getId()}').click(function () {
                                $('#page-preloader').show();
                                $.ajax({
                                    url: '/deleteProduct/${currType}/${item.getId()}',
                                    success: function (data) {
                                        $('.results').html(data);
                                        $('#page-preloader').hide();
                                    }
                                });
                            });
                            $('.restore_btn_${item.getId()}').click(function () {
                                $('#page-preloader').show();
                                $.ajax({
                                    url: '/restoreProduct/${currType}/${item.getId()}',
                                    success: function (data) {
                                        $('.results').html(data);
                                        $('#page-preloader').hide();
                                    }
                                });
                            });
                            $('.update_btn_${item.getId()}').click(function () {
                                $.ajax({
                                    url: '/updateProduct/${currType}/${item.getId()}',
                                    success: function (data) {
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
                        $('.page_${page.getKey()}').click(function () {
                            $('#page-preloader').show();
                            var msg = $('#formSearch').serialize();
                            $.ajax({
                                url: '${searchReq}/${currType}/page/${page.getKey()}',
                                data: msg,
                                success: function (data) {
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

</div>


<script type="text/javascript" language="javascript">

    function searchFun() {
        $('#page-preloader').show();
        var msg = $('#formSearch').serialize();
        $.ajax({
            type: 'GET',
            url: '/products/${searchBtn}',
            data: msg,
            success: function (data) {
                $('.results').html(data);
                $('#page-preloader').hide();
            }
        });
    }
</script>