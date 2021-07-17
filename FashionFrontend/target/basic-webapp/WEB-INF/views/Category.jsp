<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<c:url value="/category/add"/>" method="post">
    <table allign="center" class="table">
        <tr>
            <td colspan="2">
        <center><h3>Category</h3></center>
        </td>
        </tr>

        <tr>
            <td>Category name</td>
            <td><input type="text" name="catName" /></td>
        </tr>

        <tr>
            <td>Category Desc</td>
            <td colspan="2">
        <center><input type="text" name="catDesc"/></center>
        </td>
        </tr>

        <tr>
            <td colspan="2">
        <center><input type="submit" value="Add category"/></center>
        </td>
        </tr>
    </table>
</form>

<table class="table-bordered">
    <tr>
        <td>Category Id</td>
        <td>Category name</td>
        <td>Category description</td>
        <td>Operation</td>
    </tr>

    <c:forEach items="${listCategories}" var="category">
        <tr>
            <td>${category.categoryId}</td>
            <td>${category.categoryName}</td>
            <td>${category.categoryDescription}</td>
            <td><a href="<c:url value="/category/edit/${category.categoryId}"/>" class="btn btn-success">Edit</td>
            <td><a href="<c:url value="/category/delete/${category.categoryId}"/>" class="btn btn-danger">Delete</td>
        </tr>
    </c:forEach>


</table>