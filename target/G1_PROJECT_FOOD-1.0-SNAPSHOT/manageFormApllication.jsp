<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
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
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js">
        <link rel="stylesheet" href="./assert/css/base.css">
        <link rel="stylesheet" href="./assert/css/manageformapplication.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
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
                                    <form class="sort-form" action="">

                                        <div class="total-quantity-group">
                                            <h6 class="sort-form-label">Total quantity:</h6>
                                        <%
                                            AccountDAO ad2 = new AccountDAO();
                                            int la3 = ad2.getCountListAccount();


                                        %>
                                        <button class="btn-primary total-quantity">
                                            <%=la3%>
                                        </button>

                                        <%
                                        %>
                                    </div>
                                </form>
                                <div class="btn-group-search-add">
                                    <div class="search-group">
                                        <input type="text" placeholder="Enter indicate's name">
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
                                        <th class="table-heading-text" scope="col">Role</th>
                                        <th class="table-heading-text" scope="col">Detail</th>
                                    </tr>

                                </thead>
                                <tbody>
                                      <!-- display information in the form of a list on the page -->
                                    <%
                                        AccountDAO ad = new AccountDAO();
                                        List<Account> la = ad.getListAccount();

                                        for (int idx = 0; idx < la.size(); idx++) {

                                    %>
                                    <tr>
                                        <td class="table-order"><%= idx + 1%></td>
                                        <td class="table-id"><%= la.get(idx).getAccountID()%></td>
                                        <td class="table-name"><a href=""><%= la.get(idx).getAccountName()%></a></td>
                                        <td class="table-email">
                                            <%= la.get(idx).getAccountEmail()%>
                                        </td>
                                        <td class="table-role"><%= la.get(idx).getRoleDescription()%></td>
                                        <td class="table-btn">
                                            <a class="table-btn-edit" href="loadformapplicationdetailforadmin?accountID=<%= la.get(idx).getAccountID()%>"><i
                                                    class="fa-solid fa-pen-to-square"></i></a>
                                        </td>
                                    </tr>


                                    <%
                                        }
                                    %>


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