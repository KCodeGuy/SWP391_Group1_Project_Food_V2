<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/style.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/home.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/contactUs.css" type="text/css">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css" type="text/css">
        <title>Home-Page</title>
    </head>

    <body>
        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <div class="container-fluid container-contact">
                    <div class="container ">
                        <div class="row">
                            <div class="col-xs-6 col-lg-5">
                                <h4 class="contact-header">
                                    <i class="fa-sharp fa-solid fa-angles-right"></i>
                                    Contact with G1-FOOD</h4>
                                <ul class="contact-list">
                                    <li class="contact-item">
                                        <i class="fa-solid fa-phone"></i>
                                        <span class="contact-label">Phone:</span>
                                        <span class="contact-content">(0292) 730 363 - (0292) 730 364</span>
                                    </li>
                                    <li class="contact-item">
                                        <i class="fa-solid fa-envelope"></i>
                                        <span class="contact-label">Email:</span>
                                        <span class="contact-content">group1shop@gmail.com - group1food@gmail.com</span>
                                    </li>
                                    <li class="contact-item">
                                        <i class="fa-solid fa-location-dot"></i>
                                        <span class="contact-content"><b>Store 1:</b> 600, đường Nguyễn Văn Cừ nối dài, An Bình, Ninh Kiều, Cần Thơ</span>
                                    </li>
                                    <li class="contact-item">
                                        <i class="fa-solid fa-location-dot"></i>
                                        <span class="contact-content"><b>Store 2:</b> 873 Nguyễn Văn Cừ nối dài, P. An Khánh, Q. Ninh Kiều, TP. Cần Thơ</span>
                                    </li>
                                    <li class="contact-item">
                                        <i class="fa-solid fa-location-dot"></i>
                                        <span class="contact-content"><b>Store 3:</b> 94 Đường 3/2, P. Xuân Khánh, Q. Ninh Kiều, TP. Cần Thơ</span>
                                    </li>
                                    <li class="contact-item">
                                        <i class="fa-solid fa-location-dot"></i>
                                        <span class="contact-content"><b>Store 4:</b> 55 đường 3/2, P. Xuân Khánh, Q. Ninh Kiều, TP. Cần Thơ</span>
                                    </li>
                                    <li class="contact-item">
                                        <i class="fa-solid fa-location-dot"></i>
                                        <span class="contact-content"><b>Store 5:</b> 590 đường 30/4, P. Hưng Lợi, Q. Ninh Kiều, TP. Cần Thơ</span>
                                    </li>
                                    <li class="contact-item">
                                        <i class="fa-solid fa-location-dot"></i>
                                        <span class="contact-content"><b>Store 6:</b>281 Nguyễn Văn Cừ, P. An Hòa, Q. Ninh Kiều, TP. Cần Thơ</span>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-xs-6 col-lg-7 map-container">
                                <iframe  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3929.034505845366!2d105.72955411458206!3d10.014008492841574!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31a0882139720a77%3A0x3916a227d0b95a64!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBGUFQgQ-G6p24gVGjGoQ!5e0!3m2!1svi!2s!4v1677921067943!5m2!1svi!2s" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                                <span class="contact-img-caption"><b>Store 1:</b> 600, đường Nguyễn Văn Cừ nối dài, An Bình, Ninh Kiều, Cần Thơ</span>
                            </div>
                        </div>

                        <div class="row btn-group-container">
                            <button class="btn-primary btn-see-all"><a class="" href="home">Back to home</a></button>
                        </div>
                    </div>
                </div> 
                <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>