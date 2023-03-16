<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript">
        <link rel="stylesheet" href="./assert/css/base.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/updateVoucherPage.css" type="text/css">
        <title>Update Voucher</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <!-- Form update product -->
                <div class="container-fluid container-fluid-form">
                    <div class="wrapper-form">
                        <form id="myForm" action="UpdateVoucherController" method="POST">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-file-pen"></i>
                                <h2 class="form-heading">UPDATE VOUCHER</h2>
                            </div>

                            <div class="form-control-group">
                                <h4 class="form-text-label">Voucher's code:</h4>
                                <input type="text" id="voucherID" name="voucherID" placeholder="ABC123" required="" value="${param.voucherID}" readonly="">
                            <div class="alert-warning" id="txtVoucherIDMessage">${requestScope.MESSAGE}</div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Voucher's condition:</h4>
                            <input type="text" id="voucherCondition" name="voucherCondition"
                                   value="${param.voucherCondition}">
                            <div class="alert-warning" id="txtVoucherConditionMessage"></div>
                        </div>
                        <div class="form-control-group">
                            <h4 class="form-text-label">Voucher's description:</h4>
                            <input type="text" id="voucherDescription" name="voucherDescription"
                                   value="${param.voucherDescription}">
                            <div class="alert-warning" id="txtVoucherDescriptionMessage"></div>
                        </div>
                        <div class="form-control-group">
                            <h4 class="form-text-label">Voucher's discount percent:</h4>
                            <input type="number" id="voucherPercent" name="voucherPercent" placeholder="50" required="" value="${param.voucherPercent}" min="0" max="100">
                            <div class="alert-warning" id="txtVoucherPercentMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Voucher's quantity:</h4>
                            <input type="number" id="voucherPercent" name="voucherQuantity" placeholder="50" required="" min="0" value="${param.voucherQuantity}">
                            <div class="alert-warning" id="txtVoucherPercentMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Voucher's start date:</h4>
                            <input type="date" id="voucherPercent" name="voucherSDate" required="" value="${param.voucherSDate}" >
                            <div class="alert-warning" id="txtVoucherPercentMessage">${requestScope.DATEERROR}</div>
                        </div>
                        <div class="form-control-group">
                            <h4 class="form-text-label">Voucher's end date:</h4>
                            <input type="date" id="voucherPercent" name="voucherEDate" required="" value="${param.voucherEDate}" >
                            <div class="alert-warning" id="txtVoucherPercentMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Voucher's status:</h4>
                            <select  id="voucherStatus" name="voucherStatus" >
                                <option ${param.voucherStatus == 'AVAILABLE' ? 'selected=/"/"' : ''}  value="AVAILABLE">AVAILABLE</option>
                                <option ${param.voucherStatus == 'UNAVAILABLE' ? 'selected=/"/"' : ''} value="UNAVAILABLE">UNAVAILABLE</option>
                            </select>
                        </div>

                        <div class="form-btn-group">
                            <button type="Submit" name="submit" class="btn-primary">Update</button>
                            <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                            <button type="button" name="submit" class="btn-main"><a href="manageVoucher.jsp">Cancel</a></button>
                        </div>
                    </form>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="jquery/Jquery.js" type="text/javascript"></script>
        <script src="jquery/updateVoucher.js" type="text/javascript"></script>
    </body>

</html>