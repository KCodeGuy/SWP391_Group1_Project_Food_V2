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
        <link rel="stylesheet" href="./assert/css/base.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/manageProduct.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
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
                                <div class="table-home-filter">
                                    <ul class="nav-list">
                                        <h4 class="sort-form-label">Category:</h4>
                                        <li class="nav-item">
                                            <a href="admin-category?categoryID=FOOD" class="nav-link" aria-current="page">Food</a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="admin-category?categoryID=DRINK" class="nav-link">Drink</a>
                                        </li>

                                        <li class="nav-item">
                                            <a href="admin-category?categoryID=SOUP" class="nav-link">Soup</a>
                                        </li>

                                        <li class="nav-item">
                                            <a href="admin-category?categoryID=COMBO" class="nav-link">Combo</a>
                                        </li>
                                    </ul>
                                    <div class="total-quantity-group">
                                        <h6 class="sort-form-label">Total quantity:</h6>
                                        <button type="button" class="btn-primary total-quantity">
                                        ${productQuantity}
                                    </button>
                                </div>
                            </div>
                            <div class="table-control-btn-group">
                                <form class="sort-form" action="admin-sort-product">
                                    <h6 class="sort-form-label">Sort product:</h6>
                                    <select style="height: 36px; margin-top: 10px;" name="txtSort" id="sort-product">
                                        <option value="asc" selected="${txtSort eq 'asc'}">Price ascending</option>
                                        <option value="desc" selected="${txtSort eq 'desc'}">Price descending</option>
                                    </select>
                                    <button type="submit" class="btn-primary btn-sort"><i
                                            class="fa-solid fa-arrow-up-a-z"></i>Sort</button>

                                </form>
                                <div class="btn-group-search-add">
                                    <button class="btn-primary btn-add">
                                        <i class="fa-solid fa-plus"></i>
                                        <a href="add-product">Add product</a>
                                    </button>
                                    <form action="admin-search-product">
                                        <div class="search-group">
                                            <input type="text" name="txtSearch" value="${txtSearch}" placeholder="Cơm sườn bì chả">
                                            <button type="submit" class="btn-main btn-search">
                                                <i class="fa-solid fa-magnifying-glass"></i>
                                            </button>
                                        </div>
                                    </form>
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
                                    <c:set var="noOfManageProduct" value="1" />
                                    <c:forEach items="${listProduct}" var="pr">
                                        <tr>   
                                            <td class="table-order">${noOfManageProduct}</td>
                                            <td class="table-order">${pr.productID}</td>
                                            <td class="table-img"><img src="${pr.productLink}"></td>
                                            <td class="table-name">${pr.productName}</a></td>
                                            <td class="table-description"><span>${pr.productDescription}</span></td>
                                            <td class="table-sale">${pr.productSalePercent}</td>
                                            <td class="table-price"><fmt:formatNumber type="number" pattern="###,###" value="${pr.productPrice}"/>đ</td>
                                            <td class="table-status">${pr.productStatus}</td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="admin-update-product?productID=${pr.productID}"><i
                                                        class="fa-solid fa-pen-to-square"></i></a>
                                                <a href="admin-delete-product?productID=${pr.productID}" onclick="return showMessageDelete();"><i
                                                        class="fa-solid fa-trash"></i></a>
                                            </td>   
                                            <c:set var="noOfManageProduct" value="${noOfManageProduct+1}" />
                                        </tr>
                                    </c:forEach>
                                        
                                    <c:if test="${listProduct.size() == 0 ||  listProduct == null}">
                                        <tr>
                                            <td colspan="9" class="table-row-no-product">No product is collected!</td>
                                        </tr>
                                    </c:if> 
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            <div class="container-fluid pagination-container">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${listProduct.size() != 0}">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <c:if test="${page eq 'home'}">
                                        <c:forEach begin="1" end="${totalPages}" step="1" var="i">
                                            <li class="page-item">
                                                <a class="page-link" href="admin-manage-product?pageNo=${i}">${i}</a>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${page eq 'category'}">
                                        <c:forEach begin="1" end="${totalPages}" step="1" var="i">
                                            <li class="page-item">
                                                <a class="page-link" href="admin-category?pageNo=${i}&categoryID=${categoryID}">${i}</a>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${page eq 'search'}">
                                        <c:forEach begin="1" end="${totalPages}" step="1" var="i">
                                            <li class="page-item">
                                                <a class="page-link" href="admin-search-product?pageNo=${i}&txtSearch=${txtSearch}">${i}</a>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${page eq 'sort'}">
                                        <c:forEach begin="1" end="${totalPages}" step="1" var="i">
                                            <li class="page-item">
                                                <a class="page-link" href="admin-sort-product?pageNo=${i}&txtSort=${txtSort}">${i}</a>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </c:if> 

                    </div>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>

    </div>
    <script src="jquery/Jquery.js" type="text/javascript"></script>
    <script src="jquery/manageVoucher.js" type="text/javascript"></script>
</body>

</html>