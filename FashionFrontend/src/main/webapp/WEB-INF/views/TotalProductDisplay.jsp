<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<br><br>

<form action="<c:url value="/cart/add/${product.productId}"/>">

    <table class="table-bordered">
        <tr>
            <td rowspan="8">
                <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" height="300" width="300" alt="Generic placeholder thumbnail"/>
            <td><c:url value="/resources/images/${product.productId}.jpg"/></td>
            </td>      
        </tr>
        <tr>
            <td>Product Id</td>
            <td>${product.productId}</td>
        </tr>
        <tr>
            <td>Product name</td>
            <td>${product.productName}</td>
        </tr>
         <tr>
            <td>Product description</td>
            <td>${product.productDescription}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>Stock</td>
            <td>${product.stock}</td>
        </tr>
        <tr>
            <td>Category</td>
            <td>${product.categoryId}</td>
        </tr>
        <tr>
            <td>Supplier</td>
            <td>${product.supplierId}</td>
        </tr>
        
        <tr>
            <td>Quantity
                <select name="quantity">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </td>
            <td><input type="submit" value="BUY" class="btn btn-success"></td>
        </tr>


</form>