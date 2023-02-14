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
        <link rel="stylesheet" href="./assert/css/home.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Home-Page</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <!-- 2. Slider -->
                <div class="container-fluid slider-large">
                    <div class="row">
                        <div class="col col-xs-12">
                            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
                                <div class="carousel-indicators">
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                                            aria-current="true" aria-label="Slide 1"></button>
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                                            aria-label="Slide 2"></button>
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                                            aria-label="Slide 3"></button>
                                </div>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="./assert/img/slider-background-1.png" class="d-block w-100" alt="...">
                                        <div class="slider-large-caption carousel-caption d-none d-md-block">
                                            <button class="btn-main btn-main-slider">
                                                <a href="home.html" class="carousel-caption-titel ">BUY NOW</a>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                                        data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                                        data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 3. Product body -->
                <div class="container-fluid home-filter">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                                <nav class="navbar navbar-expand-lg">
                                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                                            aria-label="Toggle navigation">
                                        <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                            <li class="nav-link">
                                                Menu:
                                            </li>
                                            <li class="nav-item">
                                                <a href="home.html" class="nav-link" aria-current="page">Food</a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="home.html" class="nav-link">Drink</a>
                                            </li>

                                            <li class="nav-item">
                                                <a href="home.html" class="nav-link">Soup</a>
                                            </li>

                                            <li class="nav-item">
                                                <a href="home.html" class="nav-link">Combo</a>
                                            </li>
                                        </ul>
                                        <form class="d-flex" role="search" action="search" method="get">
                                            <input class="form-control me-2" type="search" placeholder="Cơm sườn bì chả" aria-label="Search"
                                                   name="txtSearch" value="" />
                                            <button class="btn btn-search" type="submit">
                                                <i class="fa-solid fa-magnifying-glass"></i>
                                            </button>
                                            <a class="cart" href="home">
                                                <i class="fa-solid fa-cart-plus"></i>
                                                <span class="cart-quantity">2</span>
                                            </a>
                                        </form>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- separator -->
                <div class="container container-sep">
                    <div class="separator"></div>
                </div>

                <div class="container-fluid container-card">
                    <div class="container">
                        <div class="row mb-6 padding">
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="card">
                                    <img src="./assert/img/Com_suon.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <div class="card-sale-percent"><span>-35%</span></div>
                                        <div class="card-sold-out"><span>Sold-out</span></div>
                                        <h5 class="card-title"><a href="#">Cơm sườg bì chả</a></h5>
                                        <p class="card-text">1 cơm trắng, thịt, bì chả, trứng bì chả, trứngbì chả, trứng</p>
                                        <div class="card-group">
                                            <div class="card-price-group">
                                                <span class="card-price">
                                                    35,000d
                                                </span>
                                                <span class="card-original-price">
                                                    35,000d
                                                </span>
                                            </div>
                                        </div>
                                        <button class="btn-main ">
                                            <a href="#" class="">BUY NOW</a>
                                        </button>
                                    </div>
                                </div>

                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="card">
                                    <img src="./assert/img/Com_suon.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <div class="card-sale-percent"><span>-35%</span></div>
                                        <div class="card-sold-out"><span>Sold-out</span></div>
                                        <h5 class="card-title"><a href="#">Cơm sườg bì chả</a></h5>
                                        <p class="card-text">1 cơm trắng, thịt, bì chả, trứng bì chả, trứngbì chả, trứng</p>
                                        <div class="card-group">
                                            <div class="card-price-group">
                                                <span class="card-price">
                                                    35,000d
                                                </span>
                                                <span class="card-original-price">
                                                    35,000d
                                                </span>
                                            </div>
                                        </div>
                                        <button class="btn-main ">
                                            <a href="#" class="">BUY NOW</a>
                                        </button>
                                    </div>
                                </div>

                            </div>

                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="card">
                                    <img src="./assert/img/Com_suon.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <div class="card-sale-percent"><span>-35%</span></div>
                                        <div class="card-sold-out"><span>Sold-out</span></div>
                                        <h5 class="card-title"><a href="#">Cơm sườg bì chả</a></h5>
                                        <p class="card-text">1 cơm trắng, thịt, bì chả, trứng bì chả, trứngbì chả, trứng</p>
                                        <div class="card-group">
                                            <div class="card-price-group">
                                                <span class="card-price">
                                                    35,000d
                                                </span>
                                                <span class="card-original-price">
                                                    35,000d
                                                </span>
                                            </div>
                                        </div>
                                        <button class="btn-main ">
                                            <a href="#" class="">BUY NOW</a>
                                        </button>
                                    </div>
                                </div>

                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="card">
                                    <img src="./assert/img/Com_suon.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <div class="card-sale-percent"><span>-35%</span></div>
                                        <div class="card-sold-out"><span>Sold-out</span></div>
                                        <h5 class="card-title"><a href="#">Cơm sườg bì chả</a></h5>
                                        <p class="card-text">1 cơm trắng, thịt, bì chả, trứng bì chả, trứngbì chả, trứng</p>
                                        <div class="card-group">
                                            <div class="card-price-group">
                                                <span class="card-price">
                                                    35,000d
                                                </span>
                                                <span class="card-original-price">
                                                    35,000d
                                                </span>
                                            </div>
                                        </div>
                                        <button class="btn-main ">
                                            <a href="#" class="">BUY NOW</a>
                                        </button>
                                    </div>
                                </div>

                            </div>

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
    </body>

</html>