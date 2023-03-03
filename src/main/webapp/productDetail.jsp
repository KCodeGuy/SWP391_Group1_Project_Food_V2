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
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript">
        <link rel="stylesheet" href="./assert/css/style.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/home.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/productOfDetail.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Product-detail</title>

    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <div class="container-fluild container-product-detail">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 col-md-5">
                                <img class="product-detail-img" src="${product.productLink}" alt="">
                        </div>
                        <div class="col-xs-12 col-md-7">
                            <ul class="product-detail-container">
                                <li class="product-detail-item heading">
                                    <img class="product-detail-tag" src="./assert/img/tag.png" alt="alt"/>
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
                                        <div class="product-detail-btn-group">
                                            <button class="btn-primary btn-change-quantity" type="button" onclick="decrement()">-</button>
                                            <input class="product-detail-quantity" type="text" id="number" name="quantity" value="1" readonly min="0" max="50"> 
                                            <button class="btn-primary btn-change-quantity" type="button" onclick="increment()">+</button>
                                        </div>
                                        <input name="productID" value="${productID}" hidden="true">
                                        <input name="accountID" value="${sessionScope.accountSesseion.accountID}" hidden="true">
                                    </li>
                                    <li class="product-detail-item">
                                        <button type="submit" class="btn-main">
                                            Add to cart
                                        </button>
                                        <button type="button" class="btn-primary" >
                                            <a href="home">Back to home</a>
                                        </button>
                                    </li>
                                </form>
                            </ul>
                        </div>
                    </div>

                    <div class="row rating-progress-container">
                        <div class="col-xs-12 col-lg-5">
                            <h3 class="product-detail-heading">
                                <i class="fa-sharp fa-solid fa-chart-simple"></i>
                                Rating quantity of product
                            </h3>
                            <c:forEach var="entry" items="${listRating}">
                                <div class="rating">
                                    <span class="stars">
                                        <c:forEach begin="1" end="${entry.key}" step="1" var="counter">
                                            &#9733;
                                        </c:forEach>
                                    </span>
                                    <div class="progress-bar">
                                        <div class="progress" style="width: ${(entry.value / sizeReview) * 100}%;"></div>
                                    </div>
                                    <span class="count">(${entry.value})</span>
                                </div><br>
                            </c:forEach>
                        </div>
                        <div class="col-xs-12 col-lg-7">
                            <h3 class="product-detail-heading">
                                <i class="fa-solid fa-comments"></i>
                                Your comment</h3>
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
                                    <input type="radio" id="star1" name="rating" value="5" checked="true"/>
                                    <label for="star1"><i class="fa fa-star"></i></label>
                                </div>
                                <input name="productID" value="${productID}" hidden="true">
                                <input name="accountID" value="${sessionScope.accountSesseion.accountID}" hidden="true">
                                <textarea id="review" name="review" rows="5" placeholder="Enter your feeback here!"></textarea>
                                <div class="rating-btn-group">
                                    <button type="submit" class="btn-primary">Comment</button>
                                    <button type="reset" class="btn-main"btn-related-product>
                                        Cancel
                                    </button>
                                </div>
                            </form> 
                        </div>
                    </div>

                    <div class="row product-review">
                        <c:if test="${listReview.size() > 0}">
                            <div class="review-list">
                                <div class="review-item-group">
                                     <h3 class="product-detail-heading">
                                    <i class="fa-solid fa-comments"></i>
                                    Other's comments
                                </h3>
                                <button class="btn-main btn-see-all"><a class="" href="home">See all<i class="fa-solid fa-arrow-right-long"></i></i></a></button>
                                </div>
                                <ul class="review-items">
                                    <c:forEach items="${listReview}" var="rv">
                                        <li class="review-item">
                                            <div class="review-item-header">
                                                <div class="review-item-group">
                                                    <div class="review-item-sub-group">
                                                        <i class="fa-solid fa-user option-list-user-icon"></i>
                                                        ${rv.accountName}
                                                    </div>
                                                    <c:if test="${sessionScope.accountSesseion.accountID == rv.accountID}">
                                                        <a class="btn-delete-comment" href="user-delete-review?reviewID=${rv.reviewID}&productID=${rv.productID}" onclick="return showMessageDelete();"><i
                                                                class="fa-solid fa-trash"></i>
                                                        </a>
                                                    </c:if>
                                                </div>
                                                <div class="review-item-stars">
                                                    <c:forEach begin="1" end="${rv.rating}" step="1" var="counter">
                                                        <i class="fa fa-star"></i>
                                                    </c:forEach>
                                                    <c:forEach begin="${rv.rating}" end="5" step="1" var="counter">
                                                        <i class="fa fa-star-o"></i>
                                                    </c:forEach>
                                                </div>
                                            </div>

                                            <div class="review-item-group">
                                                <div class="review-item-content">${rv.review}</div>
                                                <div class="review-item-date">
                                                    <i class="fa-sharp fa-regular fa-clock"></i>
                                                    21/122023
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-xs-12 separator-container">
                            <div class="separtor"></div>
                        </div>
                    </div>

                    <div class="row mb-6 padding">
                        <h3 class="product-detail-heading"><i class="fa-solid fa-french-fries"></i>
                            List of related products
                        </h3>
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