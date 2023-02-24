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
        <title>Login</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>
                <!-- Login form -->
                <div class="container-fluid-form" style="height: 640px">
                    <div class="container wrapper-form">
                        <form action="loginController" id="myForm" method="post">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-arrow-right-to-bracket fa-2x"></i>
                                <h2 class="form-heading ">LOGIN</h2>
                                <p class="form-text-caption">Please login your account to buy the products!</p>
                            </div>
                            <div class="alert-warning success-message" style="color: green">${registerSuccesMessage}</div>
                        <div class="form-control-group">
                            <h4 class="form-text-label">Email address:</h4>
                            <input type="email" id="email" name="email" placeholder="levana@gmail.com" />
                            <div class="alert-warning" id="txtEmailMessage"></div>
                        </div>
                        <div class="form-control-group">
                            <h4 class="form-text-label">Password:</h4>
                            <input type="password" id="password" name="password" placeholder="AbAc1234@" />
                            <div class="alert-warning" id="txtPasswordMessage"></div>
                        </div>
                        <div class="form-control-group form-caption">
                            <div class="form-text-caption">If you forgot password click
                                <a class="form-link" href="enterEmail.jsp">forgot password?</a>
                            </div>
                        </div>
                        <div class="alert-warning error-message">${loginFailedMessage}</div>
                        <div class="form-btn-group">
                            <button class="btn-primary" type="submit">Login</button>
                            <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                            <button class="btn-main" type="button"><a href="register.jsp">Register</a></button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>

        <script src="jquery/Jquery.js"></script>
        <script src="jquery/login.js"></script>
    </body>

</html>