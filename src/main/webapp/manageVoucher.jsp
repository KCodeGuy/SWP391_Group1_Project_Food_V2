<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.Voucher"%>
<%@page import="java.util.List"%>
<%@page import="dao.VoucherDAO"%>
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
        <link rel="stylesheet" href="./assert/css/base.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/manageVoucherPage.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Manage voucher</title>
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
                            <% List<Voucher> list = VoucherDAO.getAllVoucherForAdmin();%>
                            <h6 class="table-header">MANAGE VOUCHER</h6>
                            <div class="table-control-btn-group">
                                <div class="total-quantity-control">
                                    <h6 class="sort-form-label">Total quantity:</h6>
                                    <button class="btn-primary total-quantity">
                                        <%=list.size()%>
                                    </button>
                                </div>
                                <button class="btn-primary btn-add">
                                    <i class="fa-solid fa-plus"></i>
                                    <a href="addVoucher.jsp">Add voucher</a>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <table class="table table-striped text-center align-middle">
                                <thead class="table-heading">
                                    <tr>
                                        <th class="table-heading-text" scope="col">No.</th>
                                        <th class="table-heading-text" scope="col">Voucher-Code</th>
                                        <th class="table-heading-text" scope="col">Discount percent</th>
                                        <th class="table-heading-text" scope="col">Condition</th>
                                        <th class="table-heading-text" scope="col">Description</th>
                                        <th class="table-heading-text" scope="col">Status</th>
                                        <th class="table-heading-text" scope="col">Option</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach var="vc" items="<%=list%>" varStatus="count">
                                        <tr>
                                            <td class="table-order">${count.count}</td>
                                            <td class="table-code">${vc.voucherID}</td>
                                            <td class="table-sale">
                                                ${vc.productSalePercent}
                                            </td>
                                            <td class="table-code">
                                                <fmt:formatNumber type="number" pattern="###,###" value="${vc.voucherCondition}"/>đ
                                            </td>
                                            <td class="table-name"><a href="">${vc.voucherDescription}</a></td>
                                            <td class="table-status">
                                                ${vc.voucherStatus}
                                            </td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="updateVoucher.jsp?voucherID=${vc.voucherID}&voucherCondition=${vc.voucherCondition}&voucherDescription=${vc.voucherDescription}&voucherPercent=${vc.productSalePercent}&voucherStatus=${vc.voucherStatus}&voucherQuantity=${vc.voucherQuantity}&voucherSDate=${vc.voucherStartDay}&voucherEDate=${vc.voucherEndDay}"><i
                                                        class="fa-solid fa-pen-to-square"></i></a>
                                                <a href="#" onclick="return showMessageDelete();"><i
                                                        class="fa-solid fa-trash"></i></a>
                                            </td>
                                        </tr> 
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="jquery/Jquery.js" type="text/javascript"></script>
        <script src="jquery/manageVoucher.js" type="text/javascript"></script>
    </body>

</html>