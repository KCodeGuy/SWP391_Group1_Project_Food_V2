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
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript">
        <link rel="stylesheet" href="./assert/css/base.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/emailverificationPage.css" type="text/css">
        <title>Email-Verification</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                 <div class="container-fluid container-fluid-form" style="height: 600px">
                    <div class="wrapper-form" style="width: 400px">
                        <form id="myForm" action="emailauthenupdatepassword" method="POST">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-envelope-open-text fa-2x"></i>
                                <h2 class="form-heading">FORGOT PASSWORD</h2>
                                <p class="form-text-caption">Please enter your email to update password!</p>
                            </div>
                            <div class="form-control-group">
                                <h4 class="form-text-label">Email address (Username):</h4>
                                <input type="email" placeholder="group1food123@gmail.com" id="email" name="email"/>
                                <div class="alert-warning" id="txtEmailMessage"></div>
                            </div>
                            <div class="form-control-group form-caption">
                                <div class="form-text-caption">
                                    If you don't have account, please
                                    <a class="form-link" href="register.jsp">register here!</a>
                                </div>
                            </div>
                            <div class="alert-warning error-message">${accountExistMessage}</div>
                            <div class="form-btn-group">
                                <button class="btn-primary" type="submit">Submit</button>
                                <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                                <button class="btn-main" type="button"><a href="home">Cancel</a></button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="jquery/Jquery.js"></script>
        <script src="jquery/enterEmail.js"></script>
    </body>

</html>