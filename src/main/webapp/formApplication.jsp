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
        <link rel="stylesheet" href="./assert/css/home.css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <title>Home-Page</title>
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
                                <input type="text" id="name" name="name" placeholder="Huỳnh Hữu Nghĩa">
                                <div class="alert-warning" id="txtNameMessage"></div>
                            </div>

                            <div class="form-control-group">
                                <h4 class="form-text-label">Phone:</h4>
                                <input type="text" id="phone" name="phone" placeholder="0345678234">
                                <div class="alert-warning" id="txtPhoneMessage"></div>
                            </div>

                            <div class="form-control-group">
                                <h4 class="form-text-label">Email:</h4>
                                <input type="email" id="email" name="email" placeholder="nghiaMeGai@gmail.com">
                                <div class="alert-warning" id="txtEmailMessage"></div>
                            </div>

                            <div class="form-control-group">
                                <h4 class="form-text-label">Address:</h4>
                                <input type="text" id="address" name="address" placeholder="An bình, ninh kiều, cần thơ">
                                <div class="alert-warning" id="txtAddressMessage"></div>
                            </div>

                            <div class="form-control-group">
                                <h4 class="form-text-label">On-position:</h4>
                                <select id="on-position" name="on-position" >
                                    <option value="1">Option 1</option>
                                    <option value="2">Option 2</option>
                                </select>
                            </div>

                            <div class="form-control-group">
                                <h4 class="form-text-label">Note:</h4>
                                <input type="text" id="note" name="note" placeholder="Your note">
                                <div class="alert-warning" id="txtNoteMessage"></div>
                            </div>

                            <div class="form-control-group">
                                <span class="form-text-caption">Please check your's entered information before submitting!</span>
                            </div>
                            <div class="alert-warning disabled" id="">Message-error</div>

                            <div class="form-btn-group">
                                <button type="Submit" name="submit" class="btn-primary">Submit</button>
                                <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                                <button type="button" name="submit" class="btn-main">Cancel</button>
                            </div>

                        </form>
                    </div>
                </div>
                <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>

</html>