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
        <link rel="stylesheet" href="./assert/css/manageProduct.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Manage-product</title>
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
                                <h6 class="table-header">MANAGE PRODUCT</h6>
                                <div class="table-control-btn-group">
                                    <form class="sort-form" action="">
                                        <h6 class="sort-form-label">Sort staff:</h6>
                                        <select style="height: 36px; margin-top: 10px;" name="sort-product" id="sort-product">
                                            <option value="asc">Name ascending</option>
                                            <option value="desc">Name descending</option>
                                        </select>
                                        <button type="submit" class="btn-primary btn-sort"><i
                                                class="fa-solid fa-arrow-up-a-z"></i>Sort</button>
                                        <div class="total-quantity-group">
                                            <h6 class="sort-form-label">Total quantity:</h6>
                                            <button class="btn-primary total-quantity">
                                            ${size}
                                        </button>
                                    </div>
                                </form>
                                <div class="btn-group-search-add">
                                    <button class="btn-primary btn-add">
                                        <i class="fa-solid fa-plus"></i>
                                        <a href="">Add product</a>
                                    </button>
                                    <div class="search-group">
                                        <input type="text" placeholder="Cơm sườn bì chả">
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
                                        <th class="table-heading-text" scope="col">Picture</th>
                                        <th class="table-heading-text" scope="col">Name</th>
                                        <th class="table-heading-text" scope="col">Description</th>
                                        <th class="table-heading-text" scope="col">Sale</th>
                                        <th class="table-heading-text" scope="col">Price</th>
                                        <th class="table-heading-text" scope="col">Status</th>
                                        <th class="table-heading-text" scope="col">Option</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listProduct}" var="pr">
                                        <tr>   
                                            <td class="table-order">1</td>
                                            <td class="table-order">${pr.productID}</td>
                                            <td class="table-img"><img src="${pr.productLink}"></td>
                                            <td class="table-name">${pr.productName}</a></td>
                                            <td class="table-description"><span>${pr.productDescription}</span></td>
                                            <td class="table-sale">${pr.productSalePercent}</td>
                                            <td class="table-price"><fmt:formatNumber type="number" pattern="###,###" value="${pr.productPrice}"/>đ</td>
                                            <td class="table-status">${pr.productStatus}</td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="updateproduct?productID=${pr.productID}"><i
                                                        class="fa-solid fa-pen-to-square"></i></a>
                                                <a href="deleteproduct?productID=${pr.productID}" onclick="return showMessageDelete();"><i
                                                        class="fa-solid fa-trash"></i></a>
                                            </td>   
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="./bootstap/bootstrap.js"></script>
        <script src="jquery/Jquery.js"></script>
        <script src="jquery/manageVoucher.js"></script>
    </body>

</html>