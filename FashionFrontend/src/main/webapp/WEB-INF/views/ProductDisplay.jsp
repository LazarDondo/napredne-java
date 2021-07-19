<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <c:forEach items="${productList}" var="product">
    
        <div class="col-sm-4 col-md-3">
        <a href="<c:url value="/product/display/${product.productId}"/>"class="thumbnail"/>   
        <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="500" height="600" alt="Generic placeholder thumbnail"/>
        </a>
        </div>
            <p allign="center">Name: ${product.productName}</p>
            <p allign="center">Description: ${product.productDescription}</p>
            <p allign="center">Price: ${product.price}</p>
    </c:forEach>
</div>