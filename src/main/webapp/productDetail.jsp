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
        <style>
            .review-header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-bottom: 20px;
            }

            .review-title {
                font-size: 24px;
                margin: 0;
            }

            .review-stars {
                display: flex;
            }

            .fa {
                font-size: 20px;
                color: #f8ce0b;
            }

            .fa-star-o {
                color: #ddd;
            }

            .review-form {
                margin-bottom: 20px;
            }

            .form-group {
                margin-bottom: 10px;
            }

            label {
                display: block;
                font-size: 16px;
                font-weight: bold;
                margin-bottom: 5px;
            }

            textarea {
                display: block;
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
            }
            .review-stars i {
                font-size: 24px;
                color: #ffd700;
            }
        </style>
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
                                <form action="add-product-cart-product-details" method="">
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


                    <div class="product-review">
                        <form id="rating-form" action="user-add-review">
                            <div class="stars">
                                <input type="radio" id="star5" name="rating" value="1" />
                                <label for="star5"><i class="fa fa-star"></i></label>
                                <input type="radio" id="star4" name="rating" value="2" />
                                <label for="star4"><i class="fa fa-star"></i></label>
                                <input type="radio" id="star3" name="rating" value="3" />
                                <label for="star3"><i class="fa fa-star"></i></label>
                                <input type="radio" id="star2" name="rating" value="4" />
                                <label for="star2"><i class="fa fa-star"></i></label>
                                <input type="radio" id="star1" name="rating" value="5" />
                                <label for="star1"><i class="fa fa-star"></i></label>
                            </div>
                            <input name="productID" value="${productID}" hidden="true">
                            <input name="accountID" value="${sessionScope.accountSesseion.accountID}" hidden="true">
                            <textarea id="review" name="review" rows="5" placeholder="Nhập bình luận"></textarea>
                            <button type="submit">Send review</button>
                        </form>
                        <c:if test="${listReview.size() > 0}">
                            <div class="review-list">
                                <h3 class="review-list-title">Đánh giá từ khách hàng</h3>
                                <ul class="review-items">
                                    <c:forEach items="${listReview}" var="rv">
                                        <li class="review-item">
                                            <div class="review-item-header">
                                                <div class="review-item-stars">
                                                    <c:forEach begin="1" end="${rv.rating}" step="1" var="counter">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                    <c:forEach begin="${rv.rating}" end="5" step="1" var="counter">
                                                        <i class="fa fa-star-o"></i>
                                                    </c:forEach>
                                                    <c:if test="${sessionScope.accountSesseion.accountID == rv.accountID}">
                                                        <a href="user-delete-review?reviewID=${rv.reviewID}&productID=${rv.productID}" onclick="return showMessageDelete();"><i
                                                                class="fa-solid fa-trash"></i></a>
                                                        </c:if>
                                                </div>
                                                <div class="review-item-author">${rv.accountName}</div>
                                            </div>
                                            <div class="review-item-content">
                                                ${rv.review}
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
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
                                    <a href="product-detail?productID=${pr.productID}"><img src="${pr.productLink}" class="card-img-top" alt="..."></a>
                                    <div class="card-body">
                                        <c:if test="${pr.productSalePercent != 0}">
                                            <div class="card-sale-percent"><span>-${pr.productSalePercent}%</span></div>
                                        </c:if>

                                        <h5 class="card-title"><a href="product-detail?productID=${pr.productID}">${pr.productName}</a></h5>
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
                                            <a href="add-product-cart-home" class="">BUY NOW</a>
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

            function showMessageDelete() {
                var result = confirm("Are you sure to delete this review?");
                if (result) {
                    return true;
                } else {
                    return false;
                }
            }

        </script>
    </body>

</html>