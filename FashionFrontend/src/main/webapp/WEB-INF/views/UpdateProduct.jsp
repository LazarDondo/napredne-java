<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="<c:url value="/product/update"/>"  method="post" enctype="multipart/form-data">
    <table allign="center" class="table">
        <tr>
            <td colspan="2"><h2><center>Product info</center></h2></td>
        </tr>
        <tr>
            <td>Product id</td>
            <td><input type="text" name="prodId" value="${product.productId}" readonly/></td>
        </tr>
        <tr>
            <td>Product name</td>
            <td><input type="text" name="prodName" value="${product.productName}" /></td>
        </tr>
        <tr>
            <td>Product price</td>
            <td><input type="number" name="prodPrice" value="${product.price}"/></td>
        </tr>
        <tr>
            <td>Product stock</td>
            <td><input type="number" name="prodStock" value="${product.stock}"/></td>
        </tr>
        <tr>
            <td>Product description</td>
            <td><input type="text" name="prodDesc" value="${product.productDescription}"/></td>
        </tr>
        <tr>
            <td>Product category</td>
            <td>
                <select id="categoryId" name="prodCat">
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.categoryId}">${category.categoryName}</option>
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td>Product supplier</td>
            <td><select id="supplierId" name="prodSupp">
                    <c:forEach items="${supplierList}" var="supplier">
                        <option value="${supplier.supplierId}">${supplier.supplierName}</option>
                    </c:forEach>
                </select></td></td>
        </tr>
        <a href="<c:url value="/product/display/${product.productId}"/>"class="thumbnail"/>   
        <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" height="300" width="300" alt="Generic placeholder thumbnail"/>
        </a>

        <tr>
            <td colspan="2">
        <center><input type="submit" value="Update product"/></center>
        </td>
        </tr>

    </table>

</form>


<table class="table-bordered">
    <tr>
        <td>Product Id</td>
        <td>Product name</td>
        <td>Price</td>
        <td>Stock</td>
        <td>Supplier</td>
        <td>Operations</td>
    </tr>

    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td>${product.supplierId}</td>
            <td><a href="<c:url value="/product/edit/${product.productId}"/>"  class="btn btn-success">Edit</td>
            <td><a href="<c:url value="/product/delete/${product.productId}"/>" class="btn btn-danger">Delete</td>
        </tr>
    </c:forEach>


</table>