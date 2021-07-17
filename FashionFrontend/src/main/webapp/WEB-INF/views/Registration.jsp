<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%><html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Guru Registration Form</title>
    </head>
    <body>
        <h1>Guru Register Form</h1>
        <form action="<c:url value="/reg"/>" method="post">
                <table style="with: 50%">
                    <tr>
                        <td>Customer name</td>
                        <td><input type="text" name="customerName" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" /></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                </table>
                <input type="submit" value="Submit" /></form>
        </body>
        
