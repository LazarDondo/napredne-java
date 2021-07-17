<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Fashion World</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <c:if test="${!sessionScope.loggedIn}">

                <a class="nav-item nav-link active" href="<c:url value="/home"/>">Home</a>
                <a class="nav-item nav-link" href="<c:url value="/login"/>">Login</a>
                <a class="nav-item nav-link" href="<c:url value="/register"/>">Register</a>
                <a class="nav-item nav-link disabled" href="<c:url value="/contactus"/>">Contact us</a>
                <a class="nav-item nav-link disabled" href="<c:url value="/aboutus"/>">About us</a>

            </c:if>

            <c:if test="${sessionScope.loggedIn}">
                <c:if test="${sessionScope.role=='admin'}">
                    <a class="nav-item nav-link active" href="/adminhome">Home <span class="sr-only"></span></a>
                    <a class="nav-item nav-link disabled" href="<c:url value="/category"/>">Category</a>
                    <a class="nav-item nav-link disabled" href="<c:url value="/product"/>">Product</a>
                    <a class="nav-item nav-link disabled" href="<c:url value="/product/display"/>">Product Display</a>
                    <a class="nav-item nav-link disabled" href="<c:url value="/cart"/>">Cart</a>
                </c:if>

                <c:if test="${sessionScope.role=='user'}">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/userhome"/>">Home</a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">Category<span class="caret"></span></a>

                            <ul class="dropdown-menu">
                                <li><a href="c:url value='/mens'/>">Men's</a></li>
                                <li><a href="c:url value='/mens'/>">Women's</a></li>
                                <li><a href="c:url value='/mens'/>">Kid's</a></li>
                            </ul>

                        </li>

                        <li><a c href="<c:url value="/contactus"/>">Contact us</a></li>
                        <li> <a  href="<c:url value="/aboutus"/>">About us</a></li>
                        <li> <a" href="<c:url value="/cart"/>">Cart</a></li>           
                    </ul>   
                </c:if>
            </c:if>

                    <c:if test="${sessionScope.loggedIn}">
                        <div class="nav navbar-nav navbar-right">
                            <font color="red" face="calibri" size="2">Welcome ${sessionScope.username}</font>
                            <a href="<c:url value='/perform_logout'/>" class="btn-danger">Logout</a>
                        </div>
                    </c:if>

            </div>
        </div>
    </nav>