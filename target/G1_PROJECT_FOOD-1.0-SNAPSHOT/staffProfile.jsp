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
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript">
        <link rel="stylesheet" href="./assert/css/base.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/staffProfilePage.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Staff profile</title>
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
                                <h2 class="form-heading">STAFF PROFILE</h2>
                            </div>
                            <div class="form-control-group">
                                <label class="form-text-label">Name:</label>
                                <label>${staff.accountName}</label>  
                        </div>
                        <div class="form-control-group">
                            <label class="form-text-label">Phone number:</label>
                            <label>${staff.accountPhone}</label>  
                        </div>
                        <div class="form-control-group">
                            <label class="form-text-label">Email:</label>
                            <label>${staff.accountEmail}</label>   
                        </div>
                        <div class="form-control-group">
                            <label class="form-text-label">Address:</label>
                            <label>${staff.accountAddress}</label>   
                        </div>
                        <div class="form-control-group">
                            <label class="form-text-label">On-option:</label>
                            <label>${staff.roleDescription}</label> 
                        </div>
                        <div class="form-control-group">
                            <label class="form-text-label">Start date:</label>
                            <label>${staff.accountStartDay}</label>
                        </div>
                        <c:if test="${!sessionScope.accountSesseion.accountID.startsWith('AD')}">
                            <div class="form-btn-group">
                                <button type="button" name="submit" class="btn-primary"><a href="staff-update-profile?accountID=${sessionScope.accountSesseion.accountID}">Update profile</a></button>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.accountSesseion.accountID.startsWith('AD')}">
                            <div class="form-btn-group">
                                <button type="button" name="button" class="btn-primary"><a href="admin-manage-user?sort-user=none">Back to</a></button>
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