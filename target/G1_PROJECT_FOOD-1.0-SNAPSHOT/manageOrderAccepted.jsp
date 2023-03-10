<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css" >
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript" >
        <link rel="stylesheet" href="./assert/css/style.css" type="text/css" >
        <link rel="stylesheet" href="./assert/css/manageOrderAcceptedPage.css" type="text/css" >
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css" >
        <title>Manage-Order-Accepted</title>

    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <!-- Manage product container -->
                <div class="container-fluid table-container">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <h6 class="table-header">MANAGE ORDER ACCEPTED</h6>
                                <div class="table-control-btn-group">
                                    <form class="sort-form" action="">
                                        <div class="total-quantity-group">
                                            <h6 class="sort-form-label">Total quantity:</h6>
                                            <button class="btn-primary total-quantity">
                                            ${totalOrder}
                                        </button>
                                    </div>
                                    <div class="total-quantity-group">
                                        <h6 class="sort-form-label">Total revenue:</h6>
                                        <button class="btn-primary total-quantity total-revenue">
                                            <fmt:formatNumber type="number" pattern="###,###" value="${totalPrice}"/>??
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
                                        <th class="table-heading-text" scope="col">ID</th>
                                        <th class="table-heading-text" scope="col">Customer's name</th>
                                        <th class="table-heading-text" scope="col">Quantity</th>
                                        <th class="table-heading-text" scope="col">Order-date</th>
                                        <th class="table-heading-text" scope="col">Status</th>
                                        <th class="table-heading-text" scope="col">Total</th>
                                        <th class="table-heading-text" scope="col">Detail</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="no" value="1" />
                                    <c:forEach items="${listOrder}" var="o">
                                        <tr>
                                            <td class="table-order">${no}</td>
                                            <td class="table-order">${o.orderID}</td>
                                            <td class="table-name">${o.userFullName}</td>
                                            <td class="table-quantity">${o.totalQuanityProduct}</td>
                                            <td class="table-order-date">${o.orderDate}</td>
                                            <td class="table-status">${o.orderStatus}</td>
                                            <td class="table-price">
                                                <fmt:formatNumber type="number" pattern="###,###" value="${o.totalPrice}"/>??</td>
                                            <td class="table-btn">
                                        <a class="table-btn-edit" href="chef-order-detail?orderID=${o.orderID}&accountID=&option=see"><i class="fa-solid fa-pen-to-square"></i></a>
                                    </td>
                                    </tr>
                                    <c:set var="no" value="${no + 1}" />
                                </c:forEach>  
                                <c:if test="${listOrder.size() == 0 }">
                                    <tr>
                                        <td colspan="8" class="table-row-no-product">There are no order is collected!</td>
                                    </tr>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>

</html>