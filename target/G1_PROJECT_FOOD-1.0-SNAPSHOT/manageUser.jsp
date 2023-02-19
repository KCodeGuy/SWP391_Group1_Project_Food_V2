<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
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
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Manage-user</title>
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
                                <h6 class="table-header">MANAGE USER</h6>
                                <div class="table-control-btn-group">
                                    <form class="sort-form" action="">
                                        <h6 class="sort-form-label">Sort user:</h6>
                                        <select style="height: 36px; margin-top: 10px;" name="sort-product" id="sort-product">
                                            <option value="asc">Name ascending</option>
                                            <option value="desc">Name descending</option>
                                        </select>
                                        <button type="submit" class="btn-primary btn-sort"><i
                                                class="fa-solid fa-arrow-up-a-z"></i>Sort</button>
                                        <div class="total-quantity-group">
                                            <h6 class="sort-form-label">Total quantity:</h6>
                                            <button class="btn-primary total-quantity">
                                                150
                                            </button>
                                        </div>
                                    </form>
                                    <div class="btn-group-search-add">
                                        <div class="search-group">
                                            <input type="text" placeholder="Enter user's name">
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
                                            <th class="table-heading-text" scope="col">Name</th>
                                            <th class="table-heading-text" scope="col">Email</th>
                                            <th class="table-heading-text" scope="col">Detail</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listUser}" var="lu">
                                        <tr>
                                            <td class="table-order">1</td>
                                            <td class="table-id">${lu.accountID}</td>
                                            <td class="table-name"><a href="">${lu.accountName}</a></td>
                                            <td class="table-email">
                                                ${lu.accountEmail}
                                            </td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="loaduserprofile?accountID=${lu.accountID}"><i
                                                        class="fa-solid fa-pen-to-square"></i></a>
                                                <a href="deleteuser?accountID=${lu.accountID}" onclick="return showMessageDelete();"><i
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
        <script src="jquery/manageUser.js"></script>
    </body>

</html>