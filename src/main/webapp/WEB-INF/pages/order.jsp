<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




                <sf:form method="post" id="formOrder" modelAttribute="order" action="javascript:void(null);" onsubmit="orderFun()">

                    <table class="table table-striped">

                        <tr>
                            <th><label>Name:</label></th>
                            <td><sf:input path="name" size="30"/><br/>
                                <sf:errors path="name"/>
                                <small>No spaces, please.</small>
                                <br/>
                            </td>
                        </tr>

                        <tr>
                            <th><sf:label path="address">Address:</sf:label></th>
                            <td><sf:input path="address" size="30"/><br/>
                                <sf:errors path="address" cssClass="error"/>
                            </td>
                        </tr>

                        <tr>
                            <th><sf:label path="phone">Phone:</sf:label></th>
                            <td><sf:input path="phone" size="30"/><br/>
                                <sf:errors path="phone" cssClass="error"/>
                                <small>Possible patterns +375XX XXX XX XX and 80XX XXX XX XX</small>
                                <br/>
                            </td>
                        </tr>

                        <tr>
                            <th><sf:label path="email">Email:</sf:label></th>
                            <td><sf:input path="email" size="30" pattern="\S+@[a-z]+.[a-z]+" placeholder="E-mail"/><br/>
                                <sf:errors path="email" cssClass="error"/>
                            </td>
                        </tr>

                        <tr>
                            <th><sf:label path="comments">Comments:</sf:label></th>
                            <td><sf:input path="comments" size="30"/><br/>
                                <sf:errors path="comments" cssClass="error"/>
                                <small>if you need something else</small>
                                <br/>
                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td><input type="submit" value="Create Order"/><br/>
                                <small>${msg}</small>
                                <br/>
                            </td>
                        </tr>

                    </table>

                </sf:form>

<script type="text/javascript" language="javascript">
    function orderFun() {
        var msg   = $('#formOrder').serialize();
        $.ajax({
            type: 'POST',
            url: 'createOrder',
            data: msg,
            success: function(data) {
                $('.results').html(data);
            }
        });
    }


</script>