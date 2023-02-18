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
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Paying</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <form action="" class="container-fluild table-container">
                    <div class="container">
                        <div class="row">
                            <!-- User profile paying -->
                            <div class="col-xs-12 col-lg-4">
                                <div class="form-customer-info">
                                    <div class="wrapper-form">
                                        <form action="login" id="myForm">
                                            <div class="form-heading-group">
                                                <h2 class="form-heading">PROFILE PAYING</h2>
                                            </div>

                                            <div class="form-control-group">
                                                <h4 class="form-text-label">Full name:</h4>
                                                <input type="text" id="name" name="name" placeholder="Le Van A"  />
                                            </div>

                                            <div class="form-control-group">
                                                <h4 class="form-text-label">Phone number:</h4>
                                                <input type="text" id="phone" name="phone" placeholder="0932987654"  />
                                            </div>

                                            <div class="form-control-group">
                                                <h4 class="form-text-label">Email address:</h4>
                                                <input type="text" id="email" name="email" placeholder="levana@gmail.com"
                                                        readonly/>
                                            </div>

                                            <div class="form-control-group">
                                                <h4 class="form-text-label">Address:</h4>
                                                <input type="text" id="address" name="address"
                                                       placeholder="An Binh, Ninh Kieu, Can Tho"  />
                                            </div>
                                            <div class="form-control-group">
                                                <h4 class="form-text-label">Note:</h4>
                                                <input type="text" id="note" name="note" placeholder="Nhiều gà ít cơm, ít rau." />
                                            </div>

                                        </form>
                                    </div>



                                </div>
                            </div>

                            <!-- Product paying -->
                            <div class="col-xs-12 col-lg-8">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <h4 class="table-header">PRODUCT PAYING</h4>
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
                                                    <tr>
                                                        <td class="table-order">1</td>
                                                        <td class="table-img"><img src="assert/img/Com_ga_sot_thai.png"></td>
                                                        <td class="table-name"><a href="">Cơm sườn bì chả trứng</a></td>
                                                        <td class="table-quantity">
                                                            20
                                                        </td>
                                                        <td class="table-price">30.000đ</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-order">1</td>
                                                        <td class="table-img"><img src="assert/img/Com_ga_sot_thai.png"></td>
                                                        <td class="table-name"><a href="">Cơm sườn bì chả trứng</a></td>
                                                        <td class="table-quantity">
                                                            20
                                                        </td>
                                                        <td class="table-price">30.000đ</td>
                                                    </tr>
                                                    <!-- <tr><td colspan="5" class="table-row-no-product">No product here!</td></tr> -->
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12 col-md-7">
                                            <table class="table table-striped align-middle table-voucher">
                                                <tbody>
                                                    <tr>
                                                        <td class="table-voucher-label">Mã giảm:</td>
                                                        <td class="table-number table-voucher-btn-group">
                                                            <select name="" id="">
                                                                <option value="AXRT123">AXRT123</option>
                                                                <option value="AXRT123">AXRT124</option>
                                                                <option value="AXRT123">AXRT125</option>
                                                            </select>
                                                            <button type="button" class="btn-primary">
                                                                <a href="">Apply</a>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-voucher-label">Tạm tính:</td>
                                                        <td class="table-number table-voucher-price">
                                                            35,000d
                                                            <!-- <fmt:formatNumber type="number" pattern="###,###" value="" />đ -->
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-voucher-label">Voucher:</td>
                                                        <td class="table-number table-voucher-tax">- 0đ</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-voucher-label">Phí ship:</td>
                                                        <td class="table-number table-voucher-ship">+ 30,000đ</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-voucher-label">Tổng tiền:</td>
                                                        <td class="table-number">
                                                            <span  class="table-voucher-total">450.000đ</span>
                                                            <!-- <fmt:formatNumber type="number" pattern="###,###" value="${totalPrice}" />đ -->
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="col-xs-12 col-md-5">
                                        <div class="form-paying-btn">
                                            <p>
                                                <strong>Note:</strong> Quý khách vui lòng kiểm tra lại đúng
                                                thông tin khách hàng và thông tin sản phẩm trước khi tiến hành
                                                đặt hàng. Rất cảm ơn quí khách đã quan đặt hàng tại
                                                <strong>Group-1-food
                                                </strong> store. Mọi thắc mắc xin liên hệ hotline <strong>0366.777.999</strong>. Chúc quí khách may mắn!.
                                            </p>
                                            <div class="form-paying-btn-group">
                                                <button type="button" class="btn-primary">
                                                    <a href="home">Paying</a>
                                                </button>
                                                <button type="submit" class="btn-main">
                                                    <a href="">Cancel</a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>


            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>

</html>