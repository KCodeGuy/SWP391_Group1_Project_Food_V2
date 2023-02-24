<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
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
        <link rel="stylesheet" href="./assert/css/login.css">
        <title>Forgot-password</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

             <div class="container-fluid-form">
                    <div class="container wrapper-form">
                        <form action="forgotPasswordController" id="myForm" method="POST">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-lock"></i>
                                <h2 class="form-heading ">FORGOT PASSWORD</h2>
                            </div>
                            <div class="alert-warning success-message" style="color: green">${authenEmailSuccess}</div>
                            <div class="form-control-group">
                                <h4 class="form-text-label">New password:</h4>
                                <input type="" id="password" name="password" placeholder="AbAc1234@" />
                                <div class="alert-warning" id="txtPasswordMessage"></div>
                            </div>
                            <div class="form-control-group">
                                <h4 class="form-text-label">Confirm password:</h4>
                                <input type="password" id="confirm" name="confirm" placeholder="AbAc1234@" />
                                <div class="alert-warning" id="txtConfirmMessage"></div>
                            </div>

                            <div class="form-control-group disabled">
                                <h4 class="form-text-label">Email:</h4>
                                <input type="" id="email" name="email" value="${email}"/>
                        </div>
                        <div class="form-control-group form-caption">
                            <div class="form-text-caption">Please check password again before submitting!
                            </div>
                        </div>
                        <div class="form-btn-group">
                            <button class="btn-primary" type="submit">Update password</button>
                        </div>
                    </form>
                </div>
            </div>
                        
            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="jquery/Jquery.js"></script>
        <script src="jquery/fogetPassword.js"></script>
    </body>

</html>