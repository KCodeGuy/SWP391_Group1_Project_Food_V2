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
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript">
        <link rel="stylesheet" href="./assert/css/style.css" type="text/css"> 
        <link rel="stylesheet" href="./assert/css/manageUser.css" type="text/css">         
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
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
                                    <form class="sort-form" action="admin-manage-user">
                                        <h6 class="sort-form-label">Sort user:</h6>
                                        <select style="height: 36px; margin-top: 10px;" name="sort-user">
                                            <option value="asc">Name ascending</option>
                                            <option value="desc">Name descending</option>
                                        </select>
                                        <button type="submit" class="btn-primary btn-sort"><i
                                                class="fa-solid fa-arrow-up-a-z"></i>Sort</button>
                                        <div class="total-quantity-group">
                                            <h6 class="sort-form-label">Total quantity:</h6>
                                            <button class="btn-primary total-quantity">
                                            ${listUser.size()}
                                        </button>
                                    </div>
                                </form>
                                <form action="admin-search-user">
                                    <div class="btn-group-search-add">
                                        <div class="search-group">
                                            <input value="${txtSearchUsername}" type="text" name="txtSearch" placeholder="Enter user's name">
                                            <button type="submit" class="btn-main btn-search">
                                                <i class="fa-solid fa-magnifying-glass"></i>
                                            </button>
                                        </div>
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
                                        <th class="table-heading-text" scope="col">ID</th>
                                        <th class="table-heading-text" scope="col">Name</th>
                                        <th class="table-heading-text" scope="col">Email</th>
                                        <th class="table-heading-text" scope="col">Status</th>
                                        <th class="table-heading-text" scope="col">Detail</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="no" value="1" />
                                    <c:forEach items="${listUser}" var="lu">
                                        <tr>
                                            <td class="table-order">${no}</td>
                                            <td class="table-order">${lu.accountID}</td>
                                            <td class="table-name"><a href="">${lu.accountName}</a></td>
                                            <td class="table-email">
                                                ${lu.accountEmail}
                                            </td>
                                            <td class="table-name"><a href="">${lu.accountStatus}</a></td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="user-profile?accountID=${lu.accountID}"><i
                                                        class="fa-solid fa-pen-to-square"></i></a>
                                                <a href="admin-delete-user?accountID=${lu.accountID}" onclick="return showMessageDelete();"><i
                                                        class="fa-solid fa-trash"></i></a>        
                                            </td>
                                        </tr>
                                        <c:set var="no" value="${no + 1}" />
                                    </c:forEach>
                                    <c:if test="${listUser.size() == 0}">
                                        <tr>
                                            <td class="table-row-no-product" colspan="6" >
                                                ${message}
                                            </td>
                                        </tr>
                                    </c:if>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="jquery/Jquery.js" type="text/javascript"></script>
        <script src="jquery/manageUser.js" type="text/javascript"></script>
    </body>

</html>