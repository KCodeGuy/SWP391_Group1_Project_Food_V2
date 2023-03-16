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
        <link rel="stylesheet" href="./assert/css/home.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/register.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Form-application</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>
                <div class="container-fluid container-fluid-form">
                    <div class="wrapper-form">
                        <form action="register" id="myForm" method="POST">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-user-pen fa-circle"></i>
                                <h2 class="form-heading">FORM APPLICATION</h2>
                            </div>
                            <div class="form-control-group" style="display: flex; margin-bottom: 0px">
                                <div class="form-control-group" style="width: 48%">
                                    <h4 class="form-text-label">Full name:</h4>
                                    <input type="text" id="name" name="name" placeholder="Le Van A" />
                                    <div class="alert-warning" id="txtNameMessage"></div>
                                </div>
                                <div class="form-control-group" style="margin-left: 6px; width: 52%">
                                    <h4 class="form-text-label">Date of birth:</h4>
                                    <input style="" type="date" id="birthday" name="birthday" min="1960-01-01" max="2018-01-01" value="2000-01-01"/>
                                    <div class="alert-warning" id="txtNameMessage"></div>
                                </div>
                            </div>
                            <div class="form-control-group" style="display: flex; margin-bottom: 0px">
                                <div class="form-control-group" style="width: 48%">
                                    <h4 class="form-text-label">Phone number:</h4>
                                    <input type="text" id="phone" name="phone" placeholder="0932987654" />
                                    <div class="alert-warning" id="txtPhoneMessage"></div>
                                </div>
                                <div class="form-control-group" style="margin-left: 6px; width: 52%">
                                    <h4 class="form-text-label">Email address:</h4>
                                    <input type="email" id="email" name="email" placeholder="levana@gmail.com" />
                                    <div class="alert-warning" id="txtEmailMessage"></div>
                                </div>
                            </div>
                            <div class="form-control-group" style="display: flex; margin-bottom: 0px">
                                <div class="form-control-group" style="width: 48%">
                                    <h4 class="form-text-label">Password:</h4>
                                    <input type="password" id="password" name="password" placeholder="Your password" />
                                    <div class="alert-warning" id="txtPasswordMessage"></div>
                                </div>
                                <div class="form-control-group" style="margin-left: 6px; width: 52%">
                                    <h4 class="form-text-label">Confirm password:</h4>
                                    <input type="password" id="confirm" name="confirm" placeholder="Your password" />
                                    <div class="alert-warning" id="txtConfirmMessage"></div>
                                </div>
                            </div>
                            <div class="form-control-group" style="display: flex; margin-bottom: 0px">
                                <div class="form-control-group" style="width: 100%">
                                    <h4 class="form-text-label">On-Position</h4>
                                    <select id="position" name="position">
                                        <option value="chef">Chef-Staff</option>
                                        <option value="shipper">Shipper-Staff</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-control-group">
                                <h4 class="form-text-label">Address:</h4>
                                <input type="text" id="address" name="address" placeholder="An Binh, Ninh Kieu, Can Tho" />
                                <div class="alert-warning" id="txtAddressMessage"></div>
                            </div>
                            <div class="form-control-group form-caption">
                                <div class="form-text-caption">Please check your entered carefully before submitting!</div>
                            </div>
                            <div class="alert-warning error-message">${accountExistMessage}</div>
                        <div class="form-btn-group">
                            <button class="btn-primary" type="submit">Apply</button>
                            <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                            <button class="btn-main" type="button"><a href="home">Cancel</a></button>
                        </div>
                    </form>
                </div>
            </div>
            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
        <script src="./jquery/Jquery.js" type="text/javascript" ></script>
        <script src="./jquery/register.js"  type="text/javascript" ></script>
    </body>

</html>