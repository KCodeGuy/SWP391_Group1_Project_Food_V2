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
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <link rel="stylesheet" href="./assert/css/emailverification.css">
        <title>Email-Verification</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>
                <div class="container-fluid container-fluid-form" style="height: 600px">
                    <div class="wrapper-form">
                        <form action="authenEmailController" method="POST">
                            <div class="form-heading-group">
                                <i class="fa-solid fa-envelope-open-text fa-2x"></i>
                                <h2 class="form-heading">EMAIL VERIFICATION</h2>
                                <p class="form-text-caption" style="text-align: center">Please enter the OTP-code(6 numbers)
                                    send to email address<b style="margin-left: 6px">${email}.</b></p>
                        </div>
                        <c:if test="${!showSendAgainBtn}">
                            <div class="form-control-group">
                                <h4 class="form-text-label">OTP-Code:</h4>
                                <input placeholder="Enter OTP-code: 123456" required id="enteredCode" name="enteredCode" />
                            </div>
                        </c:if>
                        <div class="form-control-group disabled">
                            <h4 class="form-text-label ">Orgin-code:</h4>
                            <input placeholder="123456" id="orginalCode" name="orginalCode" value="${otpCode}"/>
                        </div>
                        <div class="form-control-group disabled">
                            <h4 class="form-text-label ">Account ID:</h4>
                            <input placeholder="123456" id="accountID" name="accountID" value="${accountID}"/>
                        </div>
                        <div class="form-control-group disabled">
                            <h4 class="form-text-label ">Time:</h4>
                            <input placeholder="" id="timeSendFailed" name="timeSendFailed" value="${timeSendFailed}"/>
                        </div>
                        <div class="form-control-group disabled">
                            <h4 class="form-text-label ">Feature:</h4>
                            <input placeholder="" id="featurePage" name="featurePage" value="${featurePage}"/>
                        </div>
                        <div class="alert-warning error-message">${wrongCodeMessage}</div>
                        <div class="form-control-group form-caption">
                            <div class="form-text-caption">
                                <b>Note:</b> Send email to verify at most 3 times!(${timeSendFailed}/3)
                            </div>
                        </div>
                        <c:if test="${!showSendAgainBtn}">
                            <div class="form-btn-group">
                                <button class="btn-primary" type="submit">Submit</button>
                                <!--                                <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                                                                <button class="btn-main" type="button"><a href="home">Cancel</a></button>-->
                            </div>
                        </c:if>
                        <c:if test="${showSendAgainBtn}">
                            <div class="form-btn-group">
                                <button class="btn-primary" type="button"><a href="reAuthenEmailController?accountID=${accountID}&timeSendFailed=${timeSendFailed}&featurePage=${featurePage}">Send again</a></button>
                                <!--                                <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                                                                <button class="btn-main" type="button"><a href="home">Cancel</a></button>-->
                            </div>
                        </c:if>

                    </form>
                </div>
            </div>

            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>

</html>