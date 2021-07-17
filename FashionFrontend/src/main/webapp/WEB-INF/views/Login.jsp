<%-- 
    Document   : Login
    Created on : Jun 28, 2021, 8:49:12 AM
    Author     : Lazar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/Header.jsp"%>

<form action="perform_login" method="post">

    <table border="1" align="center">
        <tr bgcolor="gray">
            <td colspan="2"><center>Sign in</center></td>
        </tr>
        
        <tr bgcolor="pink">
            <td>Username</td>
            <td><input type="text" name="username" required/></td>
        </tr>
        
        <tr bgcolor="pink">
            <td>Password</td>
            <td><input type="password" name="password" required/></td>
        </tr>
        
        <tr bgcolor="gray">
            <td colspan="2"><center><input type="submit" value="Login"/></center></td>
        </tr>

    </table>

</form>
