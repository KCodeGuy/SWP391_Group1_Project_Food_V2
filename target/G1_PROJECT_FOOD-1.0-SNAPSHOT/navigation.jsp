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
        <link rel="stylesheet" href="./assert/css/style.css"  type="text/css">
        <link rel="stylesheet" href="./assert/css/home.css" type="text/css">
        <title>Navigation</title>
    </head>
    <body>
        <!-- 1. Navigation -->
        <nav class="nabar-fixed navbar navbar-expand-lg " style="position: fixed; width: 100%; top: 0;z-index: 10" >
            <div class="container-fluid">
                <a href="home">
                    <img class="navbar-logo" src="./assert/img/Logo.png" alt="">
                </a>
                <form class="d-flex form-search-group" role="search" action="home" method="get">
                    <input class="form-control me-2" type="search" placeholder="Cơm sườn bì chả" aria-label="Search"
                           name="txtSearch" value="${param.txtSearch}" />
                    <button class="btn-search" type="submit">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
                    <a class="cart" href="cart?accountID=${sessionScope.accountSesseion.accountID}">
                        <i class="fa-solid fa-cart-plus"></i>
                        <span class="cart-quantity">4</span>
                    </a>
                </form>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                        aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarScroll">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                        <c:if test="${sessionScope.accountSesseion != null}">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="home">
                                    <i class="fa-solid fa-house"></i>
                                    Home-page
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <i class="fa-solid fa-tags"></i>
                                    Top-sale
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <i class="fa-solid fa-envelope"></i>
                                    Contact
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="formApplication.jsp">
                                    <i class="fa-solid fa-clipboard-user"></i>
                                    Recruit
                                </a>
                            </li>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('AD')}">
                                <li class="nav-item nav-option-list">
                                    <a class="nav-link option-list-user-name" aria-current="page" href="home">
                                        <i class="fa-solid fa-user option-list-user-icon"></i>
                                        Admin
                                    </a>
                                    <ul class="nav-item-persinal-tab">
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="admin-manage-order">
                                                <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                                Manage orders
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="admin-manage-product">
                                                <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                                Manage products
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="admin-manage-user">
                                                <i class="fa-solid fa-user-group"></i>
                                                Manage users
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="admin-manage-staff">
                                                <i class="fa-sharp fa-solid fa-user-tie"></i>
                                                Manage staff
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="manageFormApllication.jsp">
                                                <i class="fa-solid fa-clipboard-user"></i>
                                                Manage recruit
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="manageVoucher.jsp">
                                                <i class="fa-sharp fa-solid fa-money-bills"></i>
                                                Manage voucher
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="statistic.jsp">
                                                <i class="fa-sharp fa-solid fa-chart-column"></i>
                                                Statistic
                                            </a>
                                        </li>
                                        <div class="separator-persional-tab"></div>
                                        <li class="nav-item">
                                            <a class="nav-link" href="logout">
                                                <i class="fa-solid fa-right-from-bracket"></i>
                                                Logout
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('CH')}">
                                <li class="nav-item nav-option-list">
                                     <a class="nav-link option-list-user-name" aria-current="page" href="home">
                                        <i class="fa-solid fa-user option-list-user-icon"></i>
                                        ${sessionScope.accountSesseion.accountName}
                                    </a>
                                    <ul class="nav-item-persinal-tab">
                                        <li class="nav-item ">
                                            <a class="nav-link" aria-current="page" href="staff-profile?accountID=${sessionScope.accountSesseion.accountID}">
                                                <i class="fa-solid fa-user"></i>
                                                My profile
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="chef-manage-order">
                                                <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                                Manage orders
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="staffProfile.jsp">
                                                <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                                Accepted orders
                                            </a>
                                        </li>
                                        <div class="separator-persional-tab"></div>
                                        <li class="nav-item">
                                            <a class="nav-link" href="logout">
                                                <i class="fa-solid fa-right-from-bracket"></i>
                                                Logout
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('SP')}">
                                <li class="nav-item nav-option-list">
                                     <a class="nav-link option-list-user-name" aria-current="page" href="home">
                                        <i class="fa-solid fa-user option-list-user-icon"></i>
                                        ${sessionScope.accountSesseion.accountName}
                                    </a>
                                    <ul class="nav-item-persinal-tab">
                                        <li class="nav-item ">
                                            <a class="nav-link" aria-current="page" href="staff-profile?accountID=${sessionScope.accountSesseion.accountID}">
                                                <i class="fa-solid fa-user"></i>
                                                My profile
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href=shipper-manage-order">
                                                <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                                Manage ship
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="staffProfile.jsp">
                                                <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                                Pickup orders
                                            </a>
                                        </li>
                                        <div class="separator-persional-tab"></div>
                                        <li class="nav-item">
                                            <a class="nav-link" href="logout">
                                                <i class="fa-solid fa-right-from-bracket"></i>
                                                Logout
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                            <c:if test="${sessionScope.accountSesseion.accountID.startsWith('US')}">
                                <li class="nav-item nav-option-list">
                                    <a class="nav-link option-list-user-name" aria-current="page" href="home">
                                        <i class="fa-solid fa-user option-list-user-icon"></i>
                                        ${sessionScope.accountSesseion.accountName}
                                    </a>
                                    <ul class="nav-item-persinal-tab">
                                        <li class="nav-item ">
                                            <a class="nav-link" aria-current="page" href="user-profile?accountID=${sessionScope.accountSesseion.accountID}">
                                                <i class="fa-solid fa-user"></i>
                                                My profile
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" aria-current="page" href="admin-manage-order">
                                                <i class="fa-sharp fa-solid fa-file-invoice-dollar"></i>
                                                My orders
                                            </a>
                                        </li>
                                        <div class="separator-persional-tab"></div>
                                        <li class="nav-item">
                                            <a class="nav-link" href="logout">
                                                <i class="fa-solid fa-right-from-bracket"></i>
                                                Logout
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                        </c:if>
                        <c:if test="${sessionScope.accountSesseion == null}">
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page" href="home">
                                    <i class="fa-solid fa-house"></i>
                                    Home-page
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <i class="fa-solid fa-tags"></i>
                                    Top-sale
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <i class="fa-solid fa-envelope"></i>
                                    Contact
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="formApplication.jsp">
                                    <i class="fa-solid fa-clipboard-user"></i>
                                    Recruit
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">
                                    <i class="fa-sharp fa-solid fa-right-to-bracket"></i>
                                    Login
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
