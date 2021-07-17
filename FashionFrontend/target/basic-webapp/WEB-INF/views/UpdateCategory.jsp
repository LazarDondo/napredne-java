<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="<c:url value="/category/update"/>" method="post">
    <table allign="center" class="table">
        <tr>
            <td colspan="2"><h2><center>Category</center></h2></td>
        </tr>
        <tr>
            <td>Category Id</td>
            <td><input type="text" name="catId" value="${categoryId}" readonly/></td>
        </tr>
        <tr>
            <td>Category Name</td>
            <td><input type="text" name="catName" value="${category.categoryName}"/></td>
        </tr>
        <tr>
            <td>Category Description</td>
            <td><input type="text" name="catDesc" value="${category.categoryDescription}"/></td>
        </tr>
        <tr>
            <td colspan="2">
        <center><input type="submit" value="Update category"/></center>
        </td>
        </tr>

    </table>


</form>