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
    <link rel="stylesheet" href="./assert/css/orderDetailForChef.css">
    <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
    <title>Order Detail For Chef</title>
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
                        <h6 class="table-header">ORDER DETAIL FOR CHEF</h6>
                        <div class="table-control-btn-group">
                            <form class="sort-form" action="">


                                <div class="total-quantity-group">
                                    <h6 class="sort-form-label">Order ID:</h6>
                                    <button class="btn-primary total-quantity">
                                        ABC123
                                    </button>
                                </div>
                                <div class="total-quantity-group">
                                    <h6 class="sort-form-label">Total:</h6>
                                    <button class="btn-primary total-quantity">
                                        400.000đ
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
                                    <th class="table-heading-text" scope="col">Sale</th>
                                    <th class="table-heading-text" scope="col">Price</th>
                                    <th class="table-heading-text" scope="col">Note</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="table-order">1</td>
                                    <td class="table-img"><img src="assert/img/Com_ga_sot_thai.png"></td>
                                    <td class="table-name"><a href="">Cơm sườn bì chả trứng</a></td>
                                    <td class="table-quantity">
                                        3
                                    </td>
                                    <td class="table-sale">
                                        20
                                    </td>
                                    <td class="table-price">30.000đ</td>
                                    <td class="table-note">
                                        note
                                    </td>

                                </tr>
                                <tr>
                                    <td class="table-order">1</td>
                                    <td class="table-img"><img src="assert/img/Com_ga_sot_thai.png"></td>
                                    <td class="table-name"><a href="">Cơm sườn bì chả trứng</a></td>
                                    <td class="table-quantity">
                                        3
                                    </td>
                                    <td class="table-sale">
                                        20
                                    </td>
                                    <td class="table-price">30.000đ</td>
                                    <td class="table-note">
                                        note
                                    </td>

                                </tr>
                                <tr>
                                    <td class="table-order">1</td>
                                    <td class="table-img"><img src="assert/img/Com_ga_sot_thai.png"></td>
                                    <td class="table-name"><a href="">Cơm sườn bì chả trứng</a></td>
                                    <td class="table-quantity">
                                        3
                                    </td>
                                    <td class="table-sale">
                                        20
                                    </td>
                                    <td class="table-price">30.000đ</td>
                                    <td class="table-note">
                                        note
                                    </td>

                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="detail-table-group">
                            <button class="btn-primary"><a href="">Accept</a></button>
                            <button class="btn-main"><a href="">Reject</a></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
          
        <!-- 5. Footer  -->
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
        <script src="./bootstap/bootstrap.js"></script>
    <script src="jquery/Jquery.js"></script>
    <script src="jquery/orderDetail.js"></script>
</body>

</html>