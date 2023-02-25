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
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js">
        <link rel="stylesheet" href="./assert/css/base.css">
        <link rel="stylesheet" href="./assert/css/home.css">
        <link rel="stylesheet" href="./assert/css/productDetail.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Product-detail</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <!-- 3. Product body -->
                <div class="container-fluid home-filter">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                                <nav class="navbar navbar-expand-lg">
                                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                            aria-expanded="false" aria-label="Toggle navigation">
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
                                            <input class="form-control me-2" type="search" placeholder="Cơm sườn bì chả"
                                                   aria-label="Search" name="txtSearch" value="" />
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


                <div class="container-fluild container-product-detail">
                    <div class="container">

                        <div class="row">
                            <div class="col-xs-12 col-md-5">
                                <img class="product-detail-img" src="${product.productLink}" alt="">
                        </div>
                        <div class="col-xs-12 col-md-7">
                            <ul class="product-detail-container">
                                <li class="product-detail-item heading">
                                    <h3 class="product-detail-name">${product.productName}</h3>
                                    <span class="product-detail-sale-percent">${product.productSalePercent}%</span>
                                </li> 
                                <li class="product-detail-item">
                                    <span class="product-detail-label">Description:</span>
                                    <span class="product-detail-descript">${product.productDescription}</span>
                                </li>
                                <li class="product-detail-item">
                                    <span class="product-detail-label">Price:</span>
                                    <span class="product-detail-price"> <fmt:formatNumber type="number" pattern="###,###" value="${product.productPrice * (1-(product.productSalePercent/100))}"/>đ</span>
                                    <c:if test="${product.productSalePercent != 0}">
                                    <tr>
                                    <span class="product-detail-original-price"><fmt:formatNumber type="number" pattern="###,###" value="${product.productPrice}"/>đ</span>

                                    </tr>
                                </c:if>


                                </li>

                                <li class="product-detail-item">
                                    <span class="product-detail-label">Status:</span>
                                    <span class="product-detail-status">${product.productStatus}</span>
                                </li>
                                <form action="addproductintocartfromproductdetails" method="">
                                    <li class="product-detail-item">
                                        <button type="button" onclick="increment()">+</button>
                                        <input type="text" id="number" name="quantity" value="1" readonly> 
                                        <input name="productID" value="${productID}" hidden="true">
                                        <input name="accountID" value="${sessionScope.accountSesseion.accountID}" hidden="true">
                                        <button type="button" onclick="decrement()">-</button>
                                    </li>
                                    <li class="product-detail-item">
                                        <button type="submit" class="btn-main"btn-related-product>
                                            Add to cart
                                        </button>
                                        <button class="btn-primary"btn-related-product>
                                            <a href="home">Back to home</a>
                                        </button>
                                    </li>
                                </form>
                            </ul>
                        </div>
                    </div>
                    <dvi class="row justify-content-center">
                        <div class="separtor">
                        </div>
                    </dvi>

                    <div class="row mb-6 padding">
                        <h3 class="product-detail-related-heading">List of related products</h3>
                        <c:forEach items="${listProduct}" var="pr">
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="card">
                                    <a href="loadproductdetail?productID=${pr.productID}"><img src="${pr.productLink}" class="card-img-top" alt="..."></a>
                                    <div class="card-body">
                                        <c:if test="${pr.productSalePercent != 0}">
                                            <div class="card-sale-percent"><span>-${pr.productSalePercent}%</span></div>
                                        </c:if>

                                        <h5 class="card-title"><a href="loadproductdetail?productID=${pr.productID}">${pr.productName}</a></h5>
                                        <p class="card-text">${pr.productDescription}</p>
                                        <div class="card-group">
                                            <div class="card-price-group">
                                                <span class="card-price">
                                                    <fmt:formatNumber type="number" pattern="###,###" value="${pr.productPrice * (1-(pr.productSalePercent/100))}"/>đ
                                                </span>
                                                <c:if test="${pr.productSalePercent != 0}">
                                                    <span class="card-original-price">
                                                        <fmt:formatNumber type="number" pattern="###,###" value="${pr.productPrice}"/>đ
                                                    </span>
                                                </c:if>
                                            </div>
                                        </div>
                                        <button class="btn-main btn-related-product">
                                            <a href="#" class="">BUY NOW</a>
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </c:forEach>

                    </div>

                </div>
            </div>


            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script>
            function increment() {
                var numberInput = document.getElementById("number");
                var currentValue = parseInt(numberInput.value);

                if (currentValue < 100) {
                    numberInput.value = currentValue + 1;
                }
            }

            function decrement() {
                var numberInput = document.getElementById("number");
                var currentValue = parseInt(numberInput.value);

                if (currentValue > 1) {
                    numberInput.value = currentValue - 1;
                }
            }

        </script>
    </body>

</html>