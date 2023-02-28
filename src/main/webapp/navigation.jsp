<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="./assert/css/base.css"/>
        <link rel="stylesheet" href="./assert/css/home.css"/>
        <title>Navigation</title>
    </head>
    <body>
        <!-- 1. Navigation -->
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a href="home">
                    <img class="navbar-logo" src="./assert/img/Logo.png" alt="">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                        aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarScroll">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                        <c:if test="${sessionScope.accountSesseion != null}">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="home">Home-page</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="home">Top-sale</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="home">Contact</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="logout">Logout</a>
                            </li>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('AD')}">
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="admin-manage-order">Manage orders</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="admin-manage-product">Manage products</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="admin-manage-user">Manage users</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="admin-manage-staff">Manage staff</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="manageFormApllication.jsp">Manage application</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="manageVoucher.jsp">Manage voucher</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="statistic.jsp">Statistic</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('CH')}">
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="chef-manage-order">Manage orders</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="staffProfile.jsp">Manage accepted orders</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="staff-profile?accountID=${sessionScope.accountSesseion.accountID}">${sessionScope.accountSesseion.accountName}</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('SP')}">
                                 <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="shipper-manage-order">Manage ship</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="staffProfile.jsp">Manage pickup orders</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="staff-profile?accountID=${sessionScope.accountSesseion.accountID}">${sessionScope.accountSesseion.accountName}</a>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('US')}">
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="loadorderhistoryforuser?accountID=${sessionScope.accountSesseion.accountID}">Manage orders</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" aria-current="page" href="user-profile?accountID=${sessionScope.accountSesseion.accountID}">${sessionScope.accountSesseion.accountName}</a>
                                </li>
                            </c:if>
                        </c:if>
                        <c:if test="${sessionScope.accountSesseion == null}">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="home">Home-page</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Top-sale</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Contact</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="formApplication.jsp">Recriut</a>
                            </li>
                             <li class="nav-item">
                                <a class="nav-link" href="register.jsp">Register</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">Login</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
