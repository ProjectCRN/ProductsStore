<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 09.12.2016
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Page Content -->
<div class="container">


    <!-- Content Row -->
    <div class="row">

        <div class="col-lg-12">
            <p>Пример загрузки файла с помощью Spring MVC </p>
            <form action="/uploadFile" method="post"
                  enctype="multipart/form-data">
                <table>
                    <tr>
                        <td><b>File:</b></td>
                        <td><input type="file" name="file"></td>
                        <td><input type="submit" value="загрузить файл"></td>
                    </tr>
                </table>
            </form>
            ${msg}

        </div>

    </div>
    <!-- /.row -->

    <hr>

</div>
<!-- /.container -->