<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <table class="table-bordered">
        <tr class="danger">
            <td colspan="6"><center>Order items</center></td>
        </tr>

        <tr>
            <td>Product Id</td>
            <td>Product name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Subtotal</td>
        </tr>

        <c:forEach items="${cartItems}" var="cartItem">
            <tr class="info">
                <td>${cartItem.productId}</td>
                <td>${cartItem.productName}</td>
                <td>${cartItem.quantity}</td>
                <td>${cartItem.price}</td>
                <td>${cartItem.price*cartItem.quantity}</td>
            </tr>
        </c:forEach>

        <tr class="warning">
            <td colspan="4">Total purchase amount</td>
            <td colspan="1">${grandTotal}</td>  
        </tr>

        <tr class="warning">
            <td colspan="4">Shipping address</td> 
        </tr>

        <form action="<c:url value="/address/update"/>" method="post">
            <tr class="info">
                <td>Address</td>
                <td colspan="3">
                    <textarea name="address" cols="32" rows="1">${address}</textarea>
                </td>

                <td>
                    <input type="submit" value="Update address" class="btn-danger"/>
                </td>

            </tr>
        </form>

        <tr class="warning">
            <td colspan="5"></td>
            <td></td>
        </tr>

        <tr class="info">
            <td colspan="2">
        <center><a href="<c:url value="/cart/"/>" class="btn-success">Modify Cart</a></center>
        </td>
        <td colspan="3">
        <center><a href="<c:url value="/payment/"/>" class="btn-success">Order Confirmation</a></center>
        </td>
        </tr>

    </table>
</div>
