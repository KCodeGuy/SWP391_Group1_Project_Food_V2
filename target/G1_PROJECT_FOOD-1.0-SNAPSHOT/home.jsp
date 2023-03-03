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
        <link rel="stylesheet" href="./assert/css/home.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Home-Page</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <!-- 2. Slider -->
                <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                                aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="./assert/img/slider_1.jpg"
                                 class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="./assert/img/slider_2.jpg"
                                 class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="./assert/img/slider_3.jpg"
                                 class="d-block w-100" alt="...">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                            data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>


                <div class="container-fluid container-voucher ">
                    <div class="container ">
                        <div class="row voucher-header-container">
                            <div class="col-xs-6 col-md-4">
                                <img class="voucher-header-img" src="./assert/img/voucher.png " alt="alt"/>
                                <h4 class="voucher-header">Top vouchers</h4>
                            </div>
                            <div class="col-xs-6 col-md-8">
                                <button class="btn-primary btn-see-all"><a class="" href="home">See more<i class="fa-solid fa-arrow-right-long"></i></i></a></button>
                            </div>
                        </div>
                        <div class="row mb-6 padding">
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="vocher-item">
                                    <div class="voucher-group"> 
                                        <div class="voucher-group"> 
                                            <img class="voucher-img" src="./assert/img/voucher.png " alt="alt"/>
                                            <div class="voucher-sub-group">
                                                <h5 class="voucher-name">Bất khả chiến bại</h5>
                                                <div class="voucher-group">
                                                    <div class="voucher-group">
                                                        <i class="fa-sharp fa-solid fa-key id-icon"></i>
                                                        <span class="voucher-id">abxxyz</span>
                                                    </div>
                                                    <span class="voucher-discount">-50k</span>
                                                </div>
                                                <h6 class="voucher-end-date">
                                                    To: 20/12/20220-12PM
                                                </h6>
                                            </div>
                                        </div>
                                    </div>
                                    <span class="voucher-descript">Giảm 50K cho đơn giá trị trên 300K</span>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="vocher-item">
                                    <div class="voucher-group"> 
                                        <div class="voucher-group"> 
                                            <img class="voucher-img" src="./assert/img/voucher.png " alt="alt"/>
                                            <div class="voucher-sub-group">
                                                <h5 class="voucher-name">Bất khả chiến bại</h5>
                                                <div class="voucher-group">
                                                    <div class="voucher-group">
                                                        <i class="fa-sharp fa-solid fa-key id-icon"></i>
                                                        <span class="voucher-id">abxxyz</span>
                                                    </div>
                                                    <span class="voucher-discount">-140k</span>
                                                </div>
                                                <h6 class="voucher-end-date">
                                                    To: 20/12/20220-12PM
                                                </h6>
                                            </div>
                                        </div>
                                    </div>
                                    <span class="voucher-descript">Giảm 50K cho đơn giá trị trên 300K</span>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="vocher-item">
                                    <div class="voucher-group"> 
                                        <div class="voucher-group"> 
                                            <img class="voucher-img" src="./assert/img/voucher.png " alt="alt"/>
                                            <div class="voucher-sub-group">
                                                <h5 class="voucher-name">Bất khả chiến bại</h5>
                                                <div class="voucher-group">
                                                    <div class="voucher-group">
                                                        <i class="fa-sharp fa-solid fa-key id-icon"></i>
                                                        <span class="voucher-id">abxxyz</span>
                                                    </div>
                                                    <span class="voucher-discount">-100k</span>
                                                </div>
                                                <h6 class="voucher-end-date">
                                                    To: 20/12/20220-12PM
                                                </h6>
                                            </div>
                                        </div>
                                    </div>
                                    <span class="voucher-descript">Giảm 50K cho đơn giá trị trên 300K</span>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="vocher-item">
                                    <div class="voucher-group"> 
                                        <div class="voucher-group"> 
                                            <img class="voucher-img" src="./assert/img/voucher.png " alt="alt"/>
                                            <div class="voucher-sub-group">
                                                <h5 class="voucher-name">Bất khả chiến bại</h5>
                                                <div class="voucher-group">
                                                    <div class="voucher-group">
                                                        <i class="fa-sharp fa-solid fa-key id-icon"></i>
                                                        <span class="voucher-id">abxxyz</span>
                                                    </div>
                                                    <span class="voucher-discount">-50k</span>
                                                </div>
                                                <h6 class="voucher-end-date">
                                                    To: 20/12/20220-12PM
                                                </h6>
                                            </div>
                                        </div>
                                    </div>
                                    <span class="voucher-descript">Giảm 50K cho đơn giá trị trên 300K</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
            <jsp:include page="homeFilter.jsp"></jsp:include>
                <!-- separator -->
                <div class="container container-sep">
                    <div class="separator"></div>
                </div>

                <div class="container-fluid container-card">
                    <div class="container">
                        <div class="row mb-6 padding">
                        <c:forEach items="${listProduct}" var="pr">
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="card">
                                    <a href="product-detail?productID=${pr.productID}">
                                        <img src="${pr.productLink}" class="card-img-top" alt="...">
                                    </a>
                                    <div class="card-body">
                                        <c:if test="${pr.productSalePercent != 0}">
                                            <div class="card-sale-percent"><span>-${pr.productSalePercent}%</span></div>
                                        </c:if>
                                        <div class="card-sold-out"><span>${pr.productStatus}</span></div>
                                        <h5 class="card-title"><a href="product-detail?productID=${pr.productID}">
                                                
                                                ${pr.productName}</a>
                                        </h5>
                                        <p class="card-text">${pr.productDescription}</p>
                                        <div class="card-group">
                                            <div class="card-price-group">
                                                <span class="card-price">
                                                    <img src="./assert/img/tag.png" alt="alt"/>
                                                    <fmt:formatNumber type="number" pattern="###,###" value="${pr.productPrice * (1-(pr.productSalePercent/100))}"/>đ
                                                </span>
                                                <c:if test="${pr.productSalePercent != 0}">
                                                    <span class="card-original-price">
                                                        <fmt:formatNumber type="number" pattern="###,###" value="${pr.productPrice}"/>đ
                                                    </span>
                                                </c:if>
                                            </div>
                                        </div>
                                        <button class="btn-main ">
                                            <a href="add-product-cart-home?accountID=${sessionScope.accountSesseion.accountID}&productID=${pr.productID}">BUY NOW</a>
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>

            <!-- 4. Paging -->
            <div class="container-fluid pagination-container">
                <div class="row">
                    <div class="col-xs-12">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="./jquery/Jquery.js" type="text/javascript"></script>
        <script language="JavaScript" type="text/javascript" src="./bootstap/js/bootstrap.js"></script>
        <script language="JavaScript" type="text/javascript">
            $(document).ready(function () {
                $('.carousel').carousel({
                    interval: 3000
                });
            });
        </script>
    </body>
</html>