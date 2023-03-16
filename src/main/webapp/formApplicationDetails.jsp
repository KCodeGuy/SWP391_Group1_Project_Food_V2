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
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css" >
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript" >
        <link rel="stylesheet" href="./assert/css/base.css" type="text/css" >
        <link rel="stylesheet" href="./assert/css/formApplicationDetails.css" type="text/css" >
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css" >
        <title> Form-Application-Details</title>
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
                                <h2 class="form-heading">FORM APPLICATION</h2>
                            </div>
                             <div class="alert-warning success-message" style="color: green">${registerFormApplicationSuccess}</div>
                            <!-- Display name of staff -->
                            
                            <div class="form-control-group">
                                <label class="form-text-label">Name:</label>
                                <label>${staff.accountName}</label>    <!-- Push the value from Servlet -->
                        </div>
                        <div class="form-control-group">
                            <label class="form-text-label">Date of birth:</label>
                            <label>${staff.accountDOB}</label>       <!-- Push the value from Servlet -->
                        </div>
                        <!-- Display phone number of staff -->
                        <div class="form-control-group">
                            <label class="form-text-label">Phone number:</label>
                            <label>${staff.accountPhone}</label>       <!-- Push the value from Servlet -->
                        </div>
                        <!-- Display email of staff -->
                        <div class="form-control-group">
                            <label class="form-text-label">Email:</label>
                            <label>${staff.accountEmail}</label>       <!-- Push the value from Servlet -->
                        </div>
                        <!-- Display address of staff -->
                        <div class="form-control-group">
                            <label class="form-text-label">Address:</label>
                            <label>${staff.accountAddress}</label>     <!-- Push the value from Servlet -->
                        </div>
                        <!-- Display on-option of staff -->
                        <div class="form-control-group">
                            <label class="form-text-label">On-option:</label>
                            <label>${position}</label>    <!-- Push the value from Servlet -->
                        </div>
                        <!-- Display start date of staff -->
                        <div class="form-control-group">
                            <label class="form-text-label">Start date:</label>
                            <label>${staff.accountStartDay}</label>
                        </div>
                        <div class="form-control-group">
                            <label class="form-text-label">Operation's status:</label>
                            <label>${staff.accountStatus}</label>       <!-- Push the value from Servlet -->
                        </div>
                        <div class="form-control-group form-caption">
                            <div class="form-text-caption">Please wait for our shop reponse with you!
                            </div>
                        </div>
                        <div class="form-btn-group">
                            <button type="button" name="button" class="btn-primary"><a href="home">Back to home</a></button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="./jquery/Jquery.js" type="text/javascript" ></script>
        <script src="./jquery/formApplication.js" type="text/javascript" ></script>
    </body>
</html>
























