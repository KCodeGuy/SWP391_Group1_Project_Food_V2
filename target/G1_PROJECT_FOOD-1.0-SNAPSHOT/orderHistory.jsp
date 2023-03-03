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
        <link rel="stylesheet" href="./assert/css/style.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/manageOrderAccepted.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Order-History</title>
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
                                <h6 class="table-header">ORDER HISTORY</h6>
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
                                        <tr>
                                            <td class="table-order">1</td>
                                            <td class="table-order">ABC123</td>
                                            <td class="table-name">Nguyen Van A</td>
                                            <td class="table-quantity">4</td>
                                            <td class="table-order-date">12/01/2023</td>
                                            <td class="table-status">ACCEPTED</td>
                                            <td class="table-price">90.000đ</td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="updateProduct.html"><i class="fa-solid fa-pen-to-square"></i></a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="table-order">1</td>
                                            <td class="table-order">ABC123</td>
                                            <td class="table-name">Nguyen Van A</td>
                                            <td class="table-quantity">4</td>
                                            <td class="table-order-date">12/01/2023</td>
                                            <td class="table-status">ACCEPTED</td>
                                            <td class="table-price">90.000đ</td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="updateProduct.html"><i class="fa-solid fa-pen-to-square"></i></a>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="table-order">1</td>
                                            <td class="table-order">ABC123</td>
                                            <td class="table-name">Nguyen Van A</td>
                                            <td class="table-quantity">4</td>
                                            <td class="table-order-date">12/01/2023</td>
                                            <td class="table-status">ACCEPTED</td>
                                            <td class="table-price">90.000đ</td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="updateProduct.html"><i class="fa-solid fa-pen-to-square"></i></a>
                                            </td>
                                        </tr>
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