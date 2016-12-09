<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 05.12.2016
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>

<div align="center">
    <h1>${hello}</h1>
    <h2>${msg}</h2>
    <img src="/resources/img/spinner4.gif"><br><br>
    <a class="btn btn-default btnLink" href="/">Ok</a>
</div>

<script language="javascript" type="text/javascript">

    var role = '${userRole}';

    if (role == 'N'){
        $('.userRole').hide();
        $('.adminRole').hide();
        $('.guestRole').show();
    }
    if (role == 'U'){
        $('.adminRole').hide();
        $('.guestRole').hide();
        $('.userRole').show();
    }
    if (role == 'A'){
        $('.guestRole').hide();
        $('.userRole').hide();
        $('.adminRole').show();
    }
</script>