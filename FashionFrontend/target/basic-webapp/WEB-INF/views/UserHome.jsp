<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3></h3>

<div class="row">
    <c:forEach items="${productsList}" var="product">
        
        <div class="col-sm-4 col-md-3">
            <a href="<c:url value="/product/display/${product.productId}"/>"class="thumbnail"/>   
            <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="Generic placeholder thumbnail"/>
        </a>
        
        <p allign="center">Name: ${product.productName}</p>
            <p allign="center">Description: ${product.productDescription}</p>
            <p allign="center">Price: ${product.price}</p>
        </div>
    </c:forEach>
</div>

