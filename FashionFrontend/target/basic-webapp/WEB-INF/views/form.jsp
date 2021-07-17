<form action="<c:url value="/product/add"/>" modelAttribute="product" method="post" enctype="multipart/form-data">
    <table allign="center" class="table">
        <tr>
            <td colspan="2"><h2><center>Product info</center></h2></td>
        </tr>
        <tr>
            <td>Product name</td>
            <td><input type="text" name="prodName"/></td>
        </tr>
        <tr>
            <td>Product price</td>
            <td><input type="text" name="prodPrice" "/></td>
        </tr>
        <tr>
            <td>Product description</td>
            <td><input type="text" name="prodStock"/></td>
        </tr>
        <tr>
            <td>Product category</td>
            <td>
                <select id="category" name="prodCat">
                    <c:forEach items="${categoryList}" var="category">
                    <option value="${category.categoryId}">${category.categoryName}</option>
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td>Product supplier</td>
            <td><input type="text" name="prodSup"/></td>
        </tr>
        <tr>
            <td>Product image</td>
            <td><input type="file" name="prodImage"/></td>
        </tr>
        <tr>
            <td colspan="2">
        <center><input type="submit" value="Insert product"/></center>
        </td>
        </tr>

    </table>

</form>