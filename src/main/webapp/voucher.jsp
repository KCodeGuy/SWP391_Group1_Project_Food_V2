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
        <link rel="stylesheet" href="./assert/css/style.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/homePage.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Home-Page</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

            <div class="container-fluid container-voucher " style="margin: 100px 0px">
                    <div class="container ">
                        <div class="row voucher-header-container">
                            <div class="col-xs-6 col-md-4">
                                <img class="voucher-header-img" src="./assert/img/voucher.png " alt="alt"/>
                                <h4 class="voucher-header">All of vouchers</h4>
                            </div>
                             <div class="col-xs-6 col-md-8">
                                <button class="btn-primary btn-see-all"><a class="" href="home">Back to home</a></button>
                            </div>
                        </div>
                        <div class="row mb-6 padding">
                        <c:forEach items="${listAllVoucher}" var="listAllVoucher">
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="vocher-item">
                                    <div class="voucher-group"> 
                                        <div class="voucher-group"> 
                                            <img class="voucher-img" src="./assert/img/voucher.png " alt="alt"/>
                                            <div class="voucher-sub-group">
                                                <h5 class="voucher-name">Woman day voucher</h5>
                                                <div class="voucher-group">
                                                    <div class="voucher-group">
                                                        <i class="fa-sharp fa-solid fa-key id-icon"></i>
                                                        <span class="voucher-id">${listAllVoucher.voucherID}</span>
                                                    </div>
                                                    <span class="voucher-discount">-${listAllVoucher.productSalePercent}k</span>
                                                </div>
                                                <h6 class="voucher-end-date">
                                                    To: <b>${listAllVoucher.voucherEndDay} -12PM</b>
                                                </h6>
                                                <h6 class="voucher-end-date">
                                                    Remain quantity: ${listAllVoucher.voucherQuantity}
                                                </h6>
                                            </div>
                                        </div>
                                    </div>
                                    <span class="voucher-descript">${listAllVoucher.voucherDescription}</span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>