<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : CE160438
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
        <link rel="stylesheet" href="./assert/css/updatestaffProfile.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title> Form-Application-Details</title>
    </head>
    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <div class="container-fluid container-fluid-form">
                    <div class="wrapper-form">
                        <form id="myForm">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-user-pen fa-circle"></i>
                                <h2 class="form-heading">FORM APPLICATION</h2>

                            </div>

                            <div class="form-control-group">
                                <h4 class="form-text-label">Full name:</h4>
                                <input type="text" id="name" name="name" placeholder="Huỳnh Hữu Nghĩa" value="${staff.accountName}" readonly>
                            <div class="alert-warning" id="txtNameMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Phone:</h4>
                            <input type="text" id="phone" name="phone" placeholder="0345678234" value="${staff.accountPhone}" readonly>
                            <div class="alert-warning" id="txtPhoneMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Email:</h4>
                            <input type="email" id="email" name="email" placeholder="nghiaMeGai@gmail.com" value="${staff.accountEmail}" readonly>
                            <div class="alert-warning" id="txtEmailMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Address:</h4>
                            <input type="text" id="address" name="address" placeholder="An bình, ninh kiều, cần thơ" value="${staff.accountAddress}" readonly>
                            <div class="alert-warning" id="txtAddressMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">On-position:</h4>
                            <input type="text" id="position" name="position" placeholder="An bình, ninh kiều, cần thơ" value="${staff.roleDescription}" readonly>
                            <div class="alert-warning" id="txtPositionMessage"></div>
                        </div>      

                    </form>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="detail-table-group">
                                <button class="btn-primary"><a href="admin-accept-applicaion?accountID=${accountID}">Accept</a></button>
                                <button class="btn-main"><a href="admin-reject-application?accountID=${accountID}">Reject</a></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="./bootstap/bootstrap.js"></script>
        <script src="jquery/Jquery.js"></script>
        <script src="jquery/formApplication.js"></script>
    </body>
</html>
























