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
        <link rel="stylesheet" href="./assert/css/updatestaffProfile.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title> Update-staff-profile</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <div class="container-fluid container-fluid-form">
                    <div class="wrapper-form">
                        <form action="staff-update-profile" id="myForm" method="post">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-file-pen"></i>
                                <h2 class="form-heading">UPDATE STAFF PROFILE</h2>
                            </div>

                        <div class="form-control-group">
                                <h4 class="form-text-label">Staff's ID:</h4>
                                <input type="text" id="id" name="id" value="${staff.accountID}" readonly>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Staff's full name:</h4>
                            <input type="text" id="name" name="name" value="${staff.accountName}">
                            <input type="text" id="accountID" name="accountID" value="${accountID}"hidden="true" >
                            <div class="alert-warning" id="txtNameMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Staff's phone:</h4>
                            <input type="text" id="phone" name="phone" value="${staff.accountPhone}">
                            <div class="alert-warning" id="txtPhoneMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Staff's email:</h4>
                            <input type="email" id="email" name="email" placeholder="${staff.accountEmail}" readonly>
                            <div class="alert-warning" id="txtNameMessage3"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Staff's address:</h4>
                            <input type="text" id="address" name="address" value="${staff.accountAddress}">
                            <div class="alert-warning" id="txtAddressMessage"></div>
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Staff's start date:</h4>
                            <input type="date" id="start-date" name="start-date" value="${staff.accountStartDay}">
                        </div>

                        <div class="form-control-group">
                            <h4 class="form-text-label">Staff's role:</h4>
                            <input type="text" id="role" name="role" value="${staff.roleDescription}">
                        </div>

                        <div class="form-btn-group">
                            <button type="Submit" name="submit" class="btn-primary">Update</button>
                            <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                            <button type="button" class="btn-main"><a href="staff-profile?accountID=${sessionScope.accountSesseion.accountID}">Cancel</a></button>
                        </div>

                    </form>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="./bootstap/bootstrap.js"></script>
        <script src="jquery/Jquery.js"></script>
        <script src="jquery/updateStaffProfile.js"></script>
    </body>

</html>