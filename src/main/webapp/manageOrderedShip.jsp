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
        <link rel="stylesheet" href="./assert/css/manageOrderedShip.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Manage-Ordered-Ship</title>
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
                                <h6 class="table-header">MANAGE ORDERED SHIP</h6>
                                <div class="table-control-btn-group">
                                    <form class="sort-form" action="">
                                        <h6 class="sort-form-label">Sort order:</h6>
                                        <select style="height: 36px; margin-top: 10px;" name="sort-product" id="sort-product">
                                            <option value="asc">Price ascending</option>
                                            <option value="desc">Price descending</option>
                                        </select>
                                        <button type="submit" class="btn-primary btn-sort"><i class="fa-solid fa-arrow-up-a-z"></i>Sort</button>
                                        <div class="total-quantity-group">
                                            <h6 class="sort-form-label">Total quantity:</h6>
                                            <button class="btn-primary total-quantity">
                                                150
                                            </button>
                                        </div>
                                        <div class="total-quantity-group">
                                            <h6 class="sort-form-label">Total revenue:</h6>
                                            <button class="btn-primary total-quantity total-revenue">
                                                12.000.000đ
                                            </button>
                                        </div>
                                    </form>
                                    <div class="btn-group-search-add">
                                        <div class="search-group">
                                            <input type="text" placeholder="Enter order's ID">
                                            <button class="btn-main btn-search">
                                                <i class="fa-solid fa-magnifying-glass"></i>
                                            </button>
                                        </div>
                                    </div>
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