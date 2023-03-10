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
        <link rel="stylesheet" href="./assert/css/orderDetailForChef.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Order Detail For Shipper</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <!-- Manage product container -->
                <div class="container-fluid table-container">
                    <div class="container">
                        <div class="container-fluid body-first-orderDeatail">
                            <div class="body-form">
                                <form id="myForm">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <b class="form-label">Full name</b>
                                        </div>
                                        <div class="col-sm-9">
                                            <div>${order.userFullName}</div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <b class="form-label">Phone number</b>
                                    </div>
                                    <div class="col-sm-9">
                                        <div>${order.userPhone}</div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <b class="form-label">Order date</b>
                                    </div>
                                    <div class="col-sm-9">
                                        <div>${order.orderDate}</div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-3">
                                        <b class="form-label">Address</b>
                                    </div>
                                    <div class="col-sm-9">
                                        <div>${order.userAddress}</div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-3">
                                        <b class="form-label">Note</b>
                                    </div>
                                    <div class="col-sm-9">
                                        <div>${order.orderNote}</div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-3">
                                        <b class="form-label">Voucher</b>
                                    </div>
                                    <div class="col-sm-9">
                                        <div>${order.voucherID}</div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-3">
                                        <b class="form-label">Product Sale Percent</b>
                                    </div>
                                    <div class="col-sm-9">
                                        <div>${order.productSalePercent}%</div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <h6 class="table-header">ORDER DETAIL FOR SHIPPER</h6>
                            <div class="table-control-btn-group">
                                <form class="sort-form" action="">


                                    <div class="total-quantity-group">
                                        <h6 class="sort-form-label">Order ID:</h6>
                                        <button class="btn-primary total-quantity">
                                            ${order.orderID}
                                        </button>
                                    </div>
                                    <div class="total-quantity-group">
                                        <h6 class="sort-form-label">Total:</h6>
                                        <button class="btn-primary total-quantity">
                                            <fmt:formatNumber type="number" pattern="###,###" value="${order.totalPrice}"/>đ
                                        </button>
                                    </div>
                                </form>
                            </div>
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
                                    <c:forEach items="${listOrderShip}" var="o">
                                        <tr>
                                            <td class="table-order">1</td>
                                            <td class="table-img"><img src="${o.productLink}"></td>
                                            <td class="table-name"><a href="">${o.productName}</a></td>
                                            <td class="table-quantity">
                                                ${o.orderQuantity}
                                            </td>
                                            <td class="table-price"><fmt:formatNumber type="number" pattern="###,###" value="${o.orderPrice * o.orderQuantity}"/>đ</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="detail-table-group"> 
                                <c:if test="${isDelivering}">
                                    <button class="btn-main"><a href="shipper-delivered-order?accountID=${sessionScope.accountSesseion.accountID}&orderID=${order.orderID}">Delivered</a></button>
                                </c:if>
                                <c:if test="${!isDelivering}">
                                    <button class="btn-primary"><a href="shipper-delivering-order?accountID=${sessionScope.accountSesseion.accountID}&orderID=${order.orderID}">Delivering</a></button>
                                </c:if>                                          
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="jquery/Jquery.js" type="text/javascript"></script>
        <script src="jquery/orderDetail.js" type="text/javascript"></script>
    </body>

</html>