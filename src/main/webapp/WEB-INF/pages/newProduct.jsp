<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ксения
  Date: 06.12.2016
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form method="post" id="newProduct" commandName="prod" action="javascript:void(null);" onsubmit="newProductFun()">
    <div class="col-md-4"></div>
    <ul class="col-md-4 formOrder">
        <li><h3>Add product</h3></li>
        <li>
            <form:input path="name"  size="30" placeholder="name" pattern="${pattern.getName()}" required="required" />
            <span class="error"><form:errors path="name" /></span>
        </li>
        <li>
            <form:input path="price"  size="30" placeholder="price" pattern="${pattern.getPrice()}" required="required" />
            <span class="error"><form:errors path="price" /></span>
        </li>
        <li>
            <form:input path="summary"  size="30" placeholder="summary" pattern="${pattern.getSummary()}" required="required" />
            <span class="error"><form:errors path="summary" /></span>
        </li>
        <li>
            <form:input path="operatingSystem"  size="30" placeholder="operatingSystem" pattern="${pattern.getOperatingSystem()}" required="required" />
            <span class="error"><form:errors path="operatingSystem" /></span>
        </li>
        <li>
            <form:input path="processorSpeed"  size="30" placeholder="processorSpeed" pattern="${pattern.getProcessorSpeed()}" required="required" />
            <span class="error"><form:errors path="processorSpeed" /></span>
        </li>
        <li>
            <form:input path="capacity"  size="30" placeholder="capacity" pattern="${pattern.getCapacity()}" required="required" />
            <span class="error"><form:errors path="capacity" /></span>
        </li>
        <li>
            <form:input path="display"  size="30" placeholder="display" pattern="${pattern.getDisplay()}" required="required" />
            <span class="error"><form:errors path="display" /></span>
        </li>
        <li>
            <form:input path="height"  size="30" placeholder="height" pattern="${pattern.getHeight()}" required="required" />
            <span class="error"><form:errors path="height" /></span>
        </li>
        <li>
            <form:input path="width"  size="30" placeholder="width" pattern="${pattern.getWidth()}" required="required" />
            <span class="error"><form:errors path="width" /></span>
        </li>
        <li>
            <form:input path="depth"  size="30" placeholder="depth" pattern="${pattern.getDepth()}" required="required" />
            <span class="error"><form:errors path="depth" /></span>
        </li>
        <li>
            <form:input path="weight"  size="30" placeholder="weight" pattern="${pattern.getWeight()}" required="required" />
            <span class="error"><form:errors path="weight" /></span>
        </li>
        <li>
            <form:input path="camera"  size="30" placeholder="camera" pattern="${pattern.getCamera()}" required="required" />
            <span class="error"><form:errors path="camera" /></span>
        </li>
        <li>
            <form:input path="battery"  size="30" placeholder="battery" pattern="${pattern.getBattery()}" required="required" />
            <span class="error"><form:errors path="battery" /></span>
        </li>
        <li>
            <form:input path="simCard"  size="30" placeholder="simCard" pattern="${pattern.getSimCard()}" required="required" />
            <span class="error"><form:errors path="simCard" /></span>
        </li>
        <li>
            <form:input path="fabricator"  size="30" placeholder="fabricator" pattern="${pattern.getFabricator()}" required="required" />
            <span class="error"><form:errors path="fabricator" /></span>
        </li>
        <li>
            <form:input path="imageUrl"  size="30" placeholder="imageUrl" pattern="${pattern.getImageUrl()}" required="required" />
            <span class="error"><form:errors path="imageUrl" /></span>
        </li>



        <li>
            <input type="submit" class="btn btn-default btnLink submit_btn" value="Submit" />
        </li>
    </ul>

</form:form>

<script type="text/javascript" language="javascript">
    function newProductFun() {
        var msg   = $('#newProduct').serialize();
        $.ajax({
            type: 'POST',
            url: '/newProduct/${currType}',
            data: msg,
            success: function(data) {
                $('.results').html(data);
            }
        });
    }


</script>
