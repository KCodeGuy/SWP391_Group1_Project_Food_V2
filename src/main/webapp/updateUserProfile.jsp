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
        <link rel="stylesheet" href="./assert/css/updateUserProfile.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title> Update user profile</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <div class="container-fluid container-fluid-form">
                    <div class="wrapper-form">
                        <form action="user-update-profile" id="myForm" method="post">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-file-pen"></i>
                                <h2 class="form-heading">UPDATE USER PROFILE</h2>
                            </div>

                            <div class="form-control-group">
                                <h4 class="form-text-label">Full name:</h4>
                                <input type="text" id="name" name="name" value="${user.accountName}">
                            <input type="text" id="accountID" name="accountID" value="${accountID}"hidden="true" >
                            <div class="alert-warning" id="txtNameMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Date of birth:</h4>
                            <input type="date" id="date-of-birth" name="date-of-birth" value="${user.accountDOB}">
                            <div class="alert-warning" id="txtDateOfBirthMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Phone number:</h4>
                            <input type="text" id="phone" name="phone" value="${user.accountPhone}">
                            <div class="alert-warning" id="txtPhoneMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Email:</h4>
                            <input type="email" id="email" name="email" placeholder="${user.accountEmail}" readonly>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Address:</h4>
                            <input type="text" id="address" name="address" value="${user.accountAddress}">
                            <div class="alert-warning" id="txtAddressMessage"></div>
                        </div>

                        <div class="form-btn-group">
                            <button type="Submit" name="submit" class="btn-primary">Update</button>
                            <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                            <button type="button" class="btn-main"><a href="user-profile?accountID=${sessionScope.accountSesseion.accountID}">Cancel</a></button>
                        </div>

                    </form>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="./bootstap/bootstrap.js"></script>
        <script src="jquery/Jquery.js"></script>
        <script src="jquery/updateUserProfile.js"></script>
    </body>

</html>