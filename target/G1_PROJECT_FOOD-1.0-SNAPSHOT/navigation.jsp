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
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/base.css"  type="text/css">
        <link rel="stylesheet" href="./assert/css/home.css" type="text/css">
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
                                <i class="fa-solid fa-house"></i>
                                <a class="nav-link" aria-current="page" href="home">Home-page</a>
                            </li>
                            <li class="nav-item">
                                <i class="fa-solid fa-tags"></i>
                                <a class="nav-link" href="#">Top-sale</a>
                            </li>
                            <li class="nav-item">
                                <i class="fa-solid fa-envelope"></i>
                                <a class="nav-link" href="#">Contact</a>
                            </li>
                            <li class="nav-item">
                                <i class="fa-solid fa-clipboard-user"></i>
                                <a class="nav-link" href="formApplication.jsp">Recruit</a>
                            </li>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('AD')}">
                                <li class="nav-item nav-option-list">
                                    <i class="fa-solid fa-user option-list-user-icon"></i>
                                    <a class="nav-link option-list-user-name" aria-current="page" href="home">Admin</a>
                                    <ul class="nav-item-persinal-tab">
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                            <a class="nav-link" aria-current="page" href="admin-manage-order">Manage orders</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                            <a class="nav-link" aria-current="page" href="admin-manage-product">Manage products</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-solid fa-user-group"></i>
                                            <a class="nav-link" aria-current="page" href="admin-manage-user">Manage users</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-user-tie"></i>
                                            <a class="nav-link" aria-current="page" href="admin-manage-staff">Manage staff</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-solid fa-clipboard-user"></i>
                                            <a class="nav-link" aria-current="page" href="manageFormApllication.jsp">Manage recruit</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-money-bills"></i>
                                            <a class="nav-link" aria-current="page" href="manageVoucher.jsp">Manage voucher</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-chart-column"></i>
                                            <a class="nav-link" aria-current="page" href="statistic.jsp">Statistic</a>
                                        </li>
                                        <div class="separator-persional-tab"></div>
                                        <li class="nav-item">
                                            <i class="fa-solid fa-right-from-bracket"></i>
                                            <a class="nav-link" href="logout">Logout</a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('CH')}">
                                <li class="nav-item nav-option-list">
                                    <i class="fa-solid fa-user option-list-user-icon"></i>
                                    <a class="nav-link option-list-user-name" aria-current="page" href="home">${sessionScope.accountSesseion.accountName}</a>
                                    <ul class="nav-item-persinal-tab">
                                        <li class="nav-item ">
                                            <i class="fa-solid fa-user"></i>
                                            <a class="nav-link" aria-current="page" href="staff-profile?accountID=${sessionScope.accountSesseion.accountID}">My profile</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                            <a class="nav-link" aria-current="page" href="chef-manage-order">Manage orders</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                            <a class="nav-link" aria-current="page" href="chef-order-history?accountID=${sessionScope.accountSesseion.accountID}">Order processed</a>
                                        </li>
                                        <div class="separator-persional-tab"></div>
                                        <li class="nav-item">
                                            <i class="fa-solid fa-right-from-bracket"></i>
                                            <a class="nav-link" href="logout">Logout</a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('SP')}">
                                <li class="nav-item nav-option-list">
                                    <i class="fa-solid fa-user option-list-user-icon"></i>
                                    <a class="nav-link option-list-user-name" aria-current="page" href="home">${sessionScope.accountSesseion.accountName}</a>
                                    <ul class="nav-item-persinal-tab">
                                        <li class="nav-item ">
                                            <i class="fa-solid fa-user"></i>
                                            <a class="nav-link" aria-current="page" href="staff-profile?accountID=${sessionScope.accountSesseion.accountID}">My profile</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                            <a class="nav-link" aria-current="page" href="shipper-manage-order?accountID=${sessionScope.accountSesseion.accountID}">Manage ship</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                            <a class="nav-link" aria-current="page" href="ship-list-order-history?accountID=${sessionScope.accountSesseion.accountID}">My orders</a>
                                        </li>
                                        <div class="separator-persional-tab"></div>
                                        <li class="nav-item">
                                            <i class="fa-solid fa-right-from-bracket"></i>
                                            <a class="nav-link" href="logout">Logout</a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('US')}">
                                <li class="nav-item nav-option-list">
                                    <i class="fa-solid fa-user option-list-user-icon"></i>
                                    <a class="nav-link option-list-user-name" aria-current="page" href="home">${sessionScope.accountSesseion.accountName}</a>
                                    <ul class="nav-item-persinal-tab">
                                        <li class="nav-item ">
                                            <i class="fa-solid fa-user"></i>
                                            <a class="nav-link" aria-current="page" href="user-profile?accountID=${sessionScope.accountSesseion.accountID}">My profile</a>
                                        </li>
                                        <li class="nav-item">
                                            <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                            <a class="nav-link" aria-current="page" href="user-order-history?accountID=${sessionScope.accountSesseion.accountID}">My Order</a>
                                        </li>
                                        <div class="separator-persional-tab"></div>
                                        <li class="nav-item">
                                            <i class="fa-solid fa-right-from-bracket"></i>
                                            <a class="nav-link" href="logout">Logout</a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                        </c:if>
                        <c:if test="${sessionScope.accountSesseion == null}">
                            <li class="nav-item">
                                <i class="fa-solid fa-house"></i>
                                <a class="nav-link" aria-current="page" href="home">Home-page</a>
                            </li>
                            <li class="nav-item">
                                <i class="fa-solid fa-tags"></i>
                                <a class="nav-link" href="#">Top-sale</a>
                            </li>
                            <li class="nav-item">
                                <i class="fa-solid fa-envelope"></i>
                                <a class="nav-link" href="#">Contact</a>
                            </li>
                            <li class="nav-item">
                                <i class="fa-solid fa-clipboard-user"></i>
                                <a class="nav-link" href="formApplication.jsp">Recruit</a>
                            </li>
                            <li class="nav-item">
                                <i class="fa-solid fa-user-plus"></i>
                                <a class="nav-link" href="register.jsp">Register</a>
                            </li>
                            <li class="nav-item">
                                <i class="fa-sharp fa-solid fa-right-to-bracket"></i>
                                <a class="nav-link" href="login.jsp">Login</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
