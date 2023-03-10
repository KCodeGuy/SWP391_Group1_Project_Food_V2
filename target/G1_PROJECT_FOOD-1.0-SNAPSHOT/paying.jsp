<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript">
        <link rel="stylesheet" href="./assert/css/style.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/paying.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Paying</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <!-- 1. Navigation -->
        <jsp:include page="navigation.jsp"></jsp:include>

            <form action="paying" class="container-fluild table-container margin-nav-fixed" id="myForm">
                <div class="container">
                    <div class="row">
                        <!-- User profile paying -->
                        <div class="col-xs-12 col-xl-4">
                            <div class="form-customer-info">
                                <div class="wrapper-form">
                                    <div class="form-heading-group">
                                        <h2 class="form-heading">PROFILE PAYING</h2>
                                    </div>
                                    <div class="form-control-group">
                                        <h4 class="form-text-label">Full name:</h4>
                                        <input type="text" id="name" name="name" placeholder="Huỳnh Hữu Nghĩa" value="${user.accountName}">
                                    <input type="text" id="accountID" name="accountID" placeholder="Huỳnh Hữu Nghĩa" value="${user.accountID}" hidden="true">
                                    <input type="text" id="voucherID" name="voucherID" placeholder="Huỳnh Hữu Nghĩa" value="${voucherID}" hidden="true">
                                    <input type="text" id="productSalePercent" name="productSalePercent" placeholder="Huỳnh Hữu Nghĩa" value="${productSalePercent}" hidden="true">
                                    <div class="alert-warning" id="txtNameMessage"></div>
                                </div>

                                <div class="form-control-group">
                                    <h4 class="form-text-label">Phone number:</h4>
                                    <input type="text" id="phone" name="phone" placeholder="0345678234" value="${user.accountPhone}">
                                    <div class="alert-warning" id="txtPhoneMessage"></div>
                                </div>

                                <div class="form-control-group">
                                    <h4 class="form-text-label">Email address:</h4>
                                    <input type="text" id="email" name="email" placeholder="levana@gmail.com" value="${user.accountEmail}"
                                           readonly/>
                                </div>

                                <div class="form-control-group">
                                    <h4 class="form-text-label">Address:</h4>
                                    <input type="text" id="address" name="address" placeholder="An bình, ninh kiều, cần thơ" value="${user.accountAddress}">
                                    <div class="alert-warning" id="txtAddressMessage"></div>
                                </div>
                                <div class="form-control-group">
                                    <h4 class="form-text-label">Note:</h4>
                                    <input type="text" id="note" name="note" placeholder="Nhiều gà ít cơm, ít rau." />
                                </div>
                                <div class="form-control-group form-caption">
                                    <div class="form-text-caption">If you don't have account
                                        <a class="form-link" href="register.jsp">register here?</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Product paying -->
                    <div class="col-xs-12 col-xl-8">
                        <div class="container">
                            <div class="row">
                                <div class="col-xs-12">
                                    <h4 class="table-header">PRODUCT PAYING</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <table class="table table-striped text-center align-middle">
                                        <thead class="table-heading">
                                            <tr>
                                                <th class="table-heading-text" scope="col">No.</th>
                                                <th class="table-heading-text" scope="col">Picture</th>
                                                <th class="table-heading-text" scope="col">Name</th>
                                                <th class="table-heading-text" scope="col">Quantity</th>
                                                <th class="table-heading-text" scope="col">Price</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:set var="no" value="1" />
                                            <c:forEach items="${listCart}" var="cart">
                                                <tr>
                                                    <td class="table-order">${no}</td>
                                                    <td class="table-img"><a href="product-detail?productID=${cart.productID}"><img src="${cart.productLink}"></a></td>
                                                    <td class="table-name"><a href="product-detail?productID=${cart.productID}">${cart.productName}</a></td>
                                                    <td class="table-quantity">
                                                        ${cart.cartQuantity}
                                                    </td>
                                                    <td class="table-price">
                                                        <fmt:formatNumber type="number" pattern="###,###" value="${(cart.productPrice * (1-(cart.productSalePercent/100)))*cart.cartQuantity}"/>đ
                                                    </td>
                                                </tr>
                                                <c:set var="no" value="${no+1}" />
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 col-lg-7">
                                    <c:set var="shipFee" value="25000"></c:set>
                                        <div class="voucher-container">
                                            <div class="voucher-form-group">
                                                <span class="voucher-form-label">Voucher:</span>
                                                <div class="voucher-form-sub-group">
                                                </div>
                                            </div>
                                            <div class="voucher-form-group">
                                                <span class="voucher-form-label">Pre-total:</span>
                                                <span class="voucher-number">
                                                <fmt:formatNumber type="number" pattern="###,###" value="${totalPrice}"/>đ
                                            </span>
                                        </div>
                                        <div class="voucher-form-group">
                                            <span class="voucher-form-label">Ship fee:</span>
                                            <span class="voucher-number">+${shipFee}đ</span>
                                        </div>
                                        <div class="voucher-form-group">
                                            <span class="voucher-form-label">Voucher discount: (-${productSalePercent}%)</span>
                                            <span class="voucher-number">

                                                -<fmt:formatNumber type="number" pattern="###,###" value="${totalPrice * productSalePercent / 100}"/>đ
                                            </span>
                                        </div>
                                        <div class="voucher-form-group">
                                            <span class="voucher-form-label">Total:</span>
                                            <span class="voucher-number voucher-total"> 
                                                <fmt:formatNumber type="number" pattern="###,###" value="${(((100 - productSalePercent) * totalPrice) / 100) + shipFee}"/>đ
                                            </span>
                                        </div>
                                    </div>

                                </div>
                                <div class="col-xs-12 col-lg-5">
                                    <div class="form-paying-btn">
                                        <p>
                                            <strong>Note: </strong>Please check the your information and product to paying carefully before proceeding with the order. 
                                            Thank you very much for choosing to place an order at Group-1-food store.
                                            If you have any questions, please contact our hotline at 0366.777.999. We wish you good luck!
                                        </p>
                                        <div class="form-paying-btn-group">
                                            <button type="Submit" class="btn-primary">
                                                Paying
                                            </button>
                                            <button type="button" class="btn-main">
                                                <a href="home">Cancel</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- 5. Footer  -->
        <div class="container-fluid footer">
            <form action="use-voucher" class="voucher-form" id="voucher-form-id">
                <input class="voucher-from-input" type="text" id="accountID" name="accountID" placeholder="" hidden="true" value="${user.accountID}" readonly=""/>
                <input class="voucher-from-input" type="text" id="voucherID" name="voucherID" placeholder="ABC123" required="" value="${voucherID}"/>
                <button type="submit" class="btn-primary btn-apply">
                    Apply
                </button>
            </form>
            <div class="row">
                <div class="col-sm-12 col-md-4">
                    <i class="fa-solid fa-phone footer-icon"></i>
                    <h2 class="footer-heading">Phone</h2>
                    <p class="footer-info">(0292) 730 363</p>
                    <p class="footer-info">(0292) 730 364</p>
                    <p class="footer-info">(0292) 730 365</p>
                </div>
                <div class="col-sm-12 col-md-4">
                    <i class="fa-solid fa-envelope footer-icon"></i>
                    <h2 class="footer-heading">Email</h2>
                    <p class="footer-info">group1shop@gmail.com</p>
                    <p class="footer-info">group1food@gmail.com</p>
                </div>
                <div class="col-sm-12 col-md-4">
                    <i class="fa-solid fa-location-dot footer-icon"></i>
                    <h2 class="footer-heading">Address</h2>
                    <p class="footer-info">Store 1: 600, đường Nguyễn Văn Cừ nối dài, An Bình, Ninh Kiều, Cần Thơ</p>
                    <p class="footer-info">Store 2: 123/1A Hai Bà Trưng, Thủ Đức, Tp.HCM</p>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <span class="footer-copycript">© 2023 GROUP1-FOOD - a software of group1 students in FPT university </span>
                </div>
            </div>
        </div>


        <script src="jquery/Jquery.js" type="text/javascript"></script>

    </body>

</html>