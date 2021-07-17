<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">

    <table class="table table-bordered">
        <tr class="danger">
            <td colspan="6"><center>Wishlist</center></td>
        </tr>

        <tr>
            <td>Product Id</td>
            <td>Product name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Subtotal</td>
            <td>Operation</td>
        </tr>

        <c:forEach items="${cartItems}" var="cartItem">

            <form action="<c:url value="/cart/update/${cartItem.cartItemId}"/>" method="get"> 
                <tr class="info">
                    <td>${classItem.productId}</td>
                    <td>${classItem.productName}</td>
                    <td><input type="text" value="${cartItem.quantity}" name="quantity"></td>
                    <td>${cartItem.price}</td>
                    <td>${cartItem.price*cartItem.quantity}</td>

                    <td>
                        <input type="submit" value="Update" btn="btn-success">
                        <a href="<c:url value="/cart/delete/${cartItem.cartItemId}"/>" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </form>
        </c:forEach>

        <tr class="warning">
            <td colspan="4">Total purchase amount</td>
            <td colspan="2">${grandTotal}</td>
        </tr>
        
        <tr class="info">
            <td colspan="3">
        <center><a href="<c:url value="/product/display"/>" class="btn btn-success">Continue Your Shopping</a></center> </td>

  <td colspan="3">
        <center><a href="<c:url value="/checkout"/>" class="btn btn-success">Check out</a></center> </td>
</tr>

        
        
</div>