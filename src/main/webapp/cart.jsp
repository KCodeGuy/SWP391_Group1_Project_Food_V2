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
        <link rel="stylesheet" href="./assert/css/cartPage.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Cart</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>
                <div class="container-fluid table-container margin-nav-fixed">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <h4 class="table-header">CART</h4>
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
                                            <th class="table-heading-text" scope="col">Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listCart}" var="cart">
                                        <tr>
                                            <td class="table-order">${cart.cartID}</td>
                                            <td class="table-img"><a href="product-detail?productID=${cart.productID}"><img src="${cart.productLink}"></a></td>
                                            <td class="table-name"><a href="product-detail?productID=${cart.productID}">${cart.productName}</a></td>
                                            <td class="table-quantity">
                                                ${cart.cartQuantity}
                                            </td>
                                            <td class="table-price"><fmt:formatNumber type="number" pattern="###,###" value="${(cart.productPrice * (1-(cart.productSalePercent/100)))*cart.cartQuantity}"/>đ</td>
                                            <td class="table-btn">
                                                <a href="cart-delete?productID=${cart.productID}&accountID=${sessionScope.accountSesseion.accountID}" onclick="return showMessageDelete();"><i class="fa-solid fa-trash"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${listCart.size() == 0}">
                                        <tr>
                                            <td colspan="6">There are no items in your cart.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="row cart-btn-group">
                        <div class="col-xs-12 col-md-2">
                            <button type="button" class="btn-primary" >
                                <a href="home">Back to home</a>
                            </button>
                        </div>
                        <div class="col-xs-12 col-md-3">
                            <div class="table-total-group">
                                <div class="table-total-sub-group">
                                    <h4 class="table-label">Total:</h4>
                                    <span class="table-total"><fmt:formatNumber type="number" pattern="###,###" value="${totalPrice}"/>đ</span>
                                </div>
                                <button class="btn-primary btn-paying">
                                    <a href="load-paying?accountID=${sessionScope.accountSesseion.accountID}">Paying</a>
                                </button>
                            </div>
                        </div>
                    </c:if>

                </div>
            </div>
        </div>

        <!-- 5. Footer  -->
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <script src="jquery/Jquery.js" type="text/javascript"></script>
    <script src="jquery/cart.js" type="text/javascript"></script>
</body>

</html>