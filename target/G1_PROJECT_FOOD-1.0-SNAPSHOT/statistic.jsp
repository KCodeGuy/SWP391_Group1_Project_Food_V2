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
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js">
        <link rel="stylesheet" href="./assert/css/base.css">
        <link rel="stylesheet" href="./assert/css/paying.css">
        <link rel="stylesheet" href="./assert/css/statistic.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Statistic</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <div class="container-fluid wrapper">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="statistic-container">
                                    <div class="statistic-group">
                                        <label for="" class="statistic-group-label">Start date:</label>
                                        <input class="date" type="date" name="" id="">
                                    </div>

                                    <div class="statistic-group">
                                        <label for="" class="statistic-group-label">End date:</label>
                                        <input class="date" type="date" name="" id="">
                                    </div>

                                    <button class="btn-main"><a href="">Statistic</a></button>
                                </div>
                            </div>
                        </div>

                        <div class="row statistic-table">
                            <div class="col-xs-12 col-md-8">
                                <h6 class="table-header">TOP TRENDING</h6>
                                <table class="table table-striped text-center align-middle">
                                    <thead class="table-heading">
                                        <tr>
                                            <th class="table-heading-text" scope="col">No.</th>
                                            <th class="table-heading-text" scope="col">ID</th>
                                            <th class="table-heading-text" scope="col">Name</th>
                                            <th class="table-heading-text" scope="col">Quantity</th>
                                            <th class="table-heading-text" scope="col">Order-date</th>
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
                                            <td class="table-price">90.000đ</td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="updateProduct.html"><i class="fa-solid fa-pen-to-square"></i></a>
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                            <div class="col-xs-12 col-md-4">

                                <div class="statistic-number">
                                    <h6 class="table-header">STATISTIC NUMBER</h6>
                                    <div class="statistic-number-group">
                                        <span class="statistic-number-label">Number of order:</span>
                                        <span class="statistic-number-order">100</span>
                                    </div>
                                    <div class="statistic-number-group">
                                        <span class="statistic-number-label">Number of product:</span>
                                        <span class="statistic-number-product">1000</span>
                                    </div>
                                    <div class="statistic-number-group">
                                        <span class="statistic-number-label">Food:</span>
                                        <span class="statistic-number-food">145</span>
                                    </div>
                                    <div class="statistic-number-group">
                                        <span class="statistic-number-label">Drink:</span>
                                        <span class="statistic-number-drink">123</span>
                                    </div>
                                    <div class="statistic-number-group">
                                        <span class="statistic-number-label">Combo:</span>
                                        <span class="statistic-number-combo">200</span>
                                    </div>
                                    <div class="statistic-number-separator">

                                    </div>
                                    <div class="statistic-number-group">
                                        <span class="statistic-number-label">Total:</span>
                                        <span class="statistic-number-total">20,000,000d</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>

</html>