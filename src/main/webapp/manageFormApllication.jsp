<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Account"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.AccountDAO"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css" >
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript" >
        <link rel="stylesheet" href="./assert/css/base.css" type="text/css" >
        <link rel="stylesheet" href="./assert/css/manageformapplication.css" type="text/css" >
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css" >
        <title>Manage-Form-Application</title>
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
                                <h6 class="table-header">LIST FORM APPLICATION</h6>
                                <div class="table-control-btn-group">
                                    <div class="total-quantity-group">
                                        <h6 class="sort-form-label">Total quantity:</h6>
                                    <%
                                        AccountDAO ad = new AccountDAO();
                                        List<Account> listFormApplication = ad.getListFormApplication();
                                    %>
                                    <button class="btn-primary total-quantity">
                                        <%=listFormApplication.size()%>
                                    </button>
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
                                        <th class="table-heading-text" scope="col">Role</th>
                                        <th class="table-heading-text" scope="col">Detail</th>
                                    </tr>

                                </thead>
                                <tbody>
                                    <!-- display information in the form of a list on the page -->

                                    <c:forEach var="list" items="<%=listFormApplication%>">
                                        <tr>
                                            <td class="table-order">1</td>
                                            <td class="table-id">${list.accountID}</td>
                                            <td class="table-name"><a href="">${list.accountName}</a></td>
                                            <td class="table-email">${list.accountEmail}</td>
                                            <td class="table-role">${list.roleDescription}</td>
                                            <td class="table-btn">
                                                <a class="table-btn-edit" href="admin-application-detail?accountID=${list.accountID}"><i
                                                        class="fa-solid fa-pen-to-square"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:if test="<%=listFormApplication.size() == 0%>">
                                        <tr>
                                            <td colspan="6" class="table-row-no-product">There are no order is collected!</td>
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
    </body>

</html>