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
        <link rel="stylesheet" href="./assert/css/userProfile.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>User profile</title>
        
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <div class="container-fluid container-fluid-form">
                    <div class="wrapper-form">
                        <form>
                            <div class="form-heading-group">
                                <i class="fa-solid fa-clipboard-user fa-circle"></i>
                                <h2 class="form-heading">USER PROFILE</h2>
                            </div>

                            <div class="form-control-group">
                                <label class="form-text-label">Name:</label>
                                <label>${user.accountName}</label>
                            </div>
                            <div class="form-control-group">
                                <label class="form-text-label">Date of birth:</label>
                                <label>${user.accountDOB}</label>
                            </div>
                            <div class="form-control-group">
                                <label class="form-text-label">Phone number:</label>
                                <label>${user.accountPhone}</label>
                            </div>
                            <div class="form-control-group">
                                <label class="form-text-label">Email:</label>
                                <label>${user.accountEmail}</label>
                            </div>
                            <div class="form-control-group">
                                <label class="form-text-label">Address:</label>
                                <label>${user.accountAddress}</label>
                            </div>

                            <div class="form-btn-group">
                                <button type="button" name="submit" class="btn-primary"><a href="user-update-profile?accountID=${sessionScope.accountSesseion.accountID}">Update profile</a></button>
                                <!-- <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                                <button type="button" name="submit" class="btn-main">Cancel</button> -->
                            </div>
                        </form>
                    </div>
                </div>

                <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="./bootstap/bootstrap.js"></script>
    </body>

</html>