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
    <link rel="stylesheet" href="./assert/css/style.css" type="text/css">
    <link rel="stylesheet" href="./assert/css/updateProductPage.css" type="text/css">
    <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
    <title> Add-Product</title>
</head>

<body>
    <!-- Wrapper contains all website's components -->
    <div class="container-fluid wrapper">
        <!-- 1. Navigation -->
        <jsp:include page="navigation.jsp"></jsp:include>
        
        <!-- Form update product -->
        <div class="container-fluid container-fluid-form">
            <div class="wrapper-form">
                <form id="myForm" action="admin-add-product" method="get">
                    <div class="form-heading-group">
                        <i class="fa-solid fa-plus"></i>
                        <h2 class="form-heading">ADD PRODUCT</h2>
                    </div>             
                    <div class="form-control-group">
                        <h4 class="form-text-label">Name:</h4>
                        <input type="text" id="name" name="name" placeholder="Enter name of product">
                        <div class="alert-warning" id="txtNameMessage"></div>
                    </div>
                    
                    <div class="form-control-group">
                        <h4 class="form-text-label">Price of product:</h4>
                        <input type="number" id="price" name="price" placeholder="Enter price of product">
                        <div class="alert-warning" id="txtNameMessage1"></div>
                    </div>

                    <div class="form-control-group">
                        <h4 class="form-text-label">Sale-Percent:</h4>
                        <input type="number" id="salesoff" name="salesoff" min="1" max="100" placeholder="Enter sales of product">
                        <div class="alert-warning" id="txtNameMessage2"></div>
                    </div>
                       
                    <div class="form-control-group disabled ">
                        <h4 class="form-text-label">Status:</h4>
                        <select id="status" name="status" >
                            <option value="SOUL_OUT">SOUL_OUT</option>
                            <option selected="selected" value="AVAILABLE">AVAILABLE</option>
                            <option value="REMOVED">REMOVED</option>
                        </select>
                    </div>

                    <div class="form-control-group">
                        <h4 class="form-text-label">Category:</h4>
                        <select id="category" name="category">
                            <option value="FOOD">FOOD</option>
                            <option value="DRINK">DRINK</option>
                            <option value="SOUP">SOUP</option> 
                            <option value="COMBO">COMBO</option>
                        </select>
                    </div>
                    
                    <div class="form-control-group">
                        <h4 class="form-text-label">Description:</h4>
                        <input type="text" id="description" name="description" placeholder="Enter description of product">
                        <div class="alert-warning" id="txtDescriptionMessage"></div>
                    </div>
                    
                     <div class="form-control-group">
                        <h4 class="form-text-label">Link Image: <h4>
                        <input type="file" id="upload" name="upload" accept=".jpg, .jpeg, .png">
                        <img id="image" style="width: 50px; height: 50px; display: none" src="">
                        <input type="text" id="base64" readonly hidden="true">
                        <div class="alert-warning" id="txtImage"></div>
                    </div>

                    <div class="form-btn-group">
                        <button type="submit" name="submit" class="btn-primary">Add product</button>
                        <h6 class="form-btn-separator">&nbsp;OR&nbsp;</h6>
                        <button type="button" name="submit" class="btn-main"><a href="admin-manage-product">Cancel</a></button>
                    </div>
                </form>
            </div>
        </div>

        <!-- 5. Footer  -->
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <script src="jquery/Jquery.js" type="text/javascript"></script>
    <!--<script src="jquery/updateProduct.js" type="text/javascript"></script>-->
    <script>
            $(function () {
                $('#upload').change(function () {
                    var file = this.files[0];
                    if (file) {
                        var reader = new FileReader();
                        reader.readAsDataURL(file);
                        reader.onload = function () {
                            var base64 = reader.result.split(',')[1];
                            $.ajax({
                                url: 'image',
                                type: 'POST',
                                data: {base64: base64},
                                success: function () {
                                    if (base64) {
                                        $('#image').show();
                                        $('#image').attr('src', 'data:image/png;base64,' + base64);
                                    } else {
                                        $('#image').hide();
                                    }
                                },
                                error: function () {
                                    alert('Error');
                                }
                            });
                            $('#base64').val(base64);
                        };
                    }
                });
            });
            $(document).ready(function() {
                $('#upload').on('change', function() {
                  var fileInput = $(this);
                  var filePath = fileInput.val();

                  var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;
                  if (!allowedExtensions.exec(filePath)) {
                    alert('Please select an image file with JPG, JPEG or PNG format.');
                    fileInput.val('');
                    return false;
                  }
                });
              });
        </script>
</body>

</html>