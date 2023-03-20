<%-- 
    Document   : navigation
    Created on : Feb 12, 2023, 2:14:42 AM
    Author     : PC
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./assert/font/fontawesome-free-6.1.1-web/css/all.css">
        <link rel="stylesheet" href="./bootstap/css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="./bootstap/js/bootstrap.js" type="text/javascript">
        <link rel="stylesheet" href="./assert/css/base.css" type="text/css">
        <link rel="stylesheet" href="./assert/css/statisticPage.css" type="text/css">
        <title>Statistic</title>
    </head>

    <body>

        <!-- Wrapper contains all website's components -->
        <div class="container-fluid wrapper">
            <!-- 1. Navigation -->
            <jsp:include page="navigation.jsp"></jsp:include>

                <div class="container-fluid table-container">
                    <div class="container ">
                        <div class="row">
                            <div class="col-xs-12">
                                <form action="satistic" method="POST">
                                    <h6 class="table-header">STATISTIC</h6>
                                    <div class="statistic-container">
                                        <div class="statistic-group">
                                            <div class="statistic-group">
                                                <label for="" class="statistic-group-label">Start date:</label>
                                                <input class="date" type="date" name="start-date" id="start-date" value="${startDate}">
                                        </div>
                                        <div class="statistic-group statistic-end-date-group">
                                            <label for="" class="statistic-group-label">End date:</label>
                                            <input class="date" type="date" name="end-date" id="end-date" value="${endDate}">
                                        </div>
                                        <button type="submit" class="btn-primary btn-satistic">Statistic</button>
                                    </div>
                                    <div class="statistic-group statistic-group-revenue">
                                        <label for="" class="statistic-group-label">Total revenue:</label>
                                        <div type="" class="btn-primary btn-satistic">
                                            <i class="fa-solid fa-sack-dollar"></i>
                                            <fmt:formatNumber type="number" pattern="###,###" value="${totalRevenue}"/>đ
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="row statistic-table">
                        <div class="col-xs-12 col-md-8">
                            <h6 class="table-header">TOP 5 BEST SELLER</h6>
                            <table class="table table-striped text-center align-middle">
                                <thead class="table-heading">
                                    <tr>
                                        <th class="table-heading-text" scope="col">No.</th>
                                        <th class="table-heading-text" scope="col">ID</th>
                                        <th class="table-heading-text" scope="col">Name</th>
                                        <th class="table-heading-text" scope="col">Image</th>
                                        <th class="table-heading-text" scope="col">Type</th>
                                        <th class="table-heading-text" scope="col">Price</th>
                                        <th class="table-heading-text" scope="col">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="noOfBestSeller" value="1" />
                                    <c:forEach items="${list5BestSellerProduct}" var="listBestSeller">
                                        <tr>
                                            <td class="table-order">Top ${noOfBestSeller}</td>
                                            <td class="table-id">${listBestSeller.productID}</td>
                                            <td class="table-name">
                                                <a href="product-detail?productID=${listBestSeller.productID}">${listBestSeller.productName}</a>
                                            </td>
                                            <td class="table-img">
                                                <a href="product-detail?productID=${listBestSeller.productID}">
                                                    <img src="${listBestSeller.productLink}" alt="alt"/>
                                                </a>
                                            </td>
                                            <td class="table-order-date">${listBestSeller.categoryID}</td>
                                            <td class="table-price">
                                                <fmt:formatNumber type="number" pattern="###,###" value="${listBestSeller.productPrice}"/>đ</td>
                                            <td class="table-price">${listBestSeller.productSalePercent}</td>
                                            <c:set var="noOfBestSeller" value="${noOfBestSeller+1}" />
                                        </tr>
                                    </c:forEach>
                                    <c:if test="${list5BestSellerProduct.size() == 0 ||  list5BestSellerProduct == null}">
                                        <tr>
                                            <td colspan="7" class="table-row-no-product">No product is collected!</td>
                                        </tr>
                                    </c:if>   
                                </tbody>
                            </table>
                        </div>
                        <div class="col-xs-12 col-md-4">
                            <h6 class="table-header">TOP 5 BEST CUSTOMER</h6>
                            <table class="table table-striped text-center align-middle">
                                <thead class="table-heading">
                                    <tr>
                                        <th class="table-heading-text" scope="col">No.</th>
                                        <th class="table-heading-text" scope="col">ID</th>
                                        <th class="table-heading-text" scope="col">Name</th>
                                        <th class="table-heading-text" scope="col">Spending</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="noOfBestCustomer" value="1" />
                                    <c:forEach items="${list5BestCustomer}" var="list5BestCustomer">
                                        <tr>
                                            <td class="table-order">Top ${noOfBestCustomer}</td>
                                            <td class="table-id">${list5BestCustomer.accountID}</td>
                                            <td class="table-name">${list5BestCustomer.accountName}</td>
                                            <td class="table-price">
                                                <fmt:formatNumber type="number" pattern="###,###" value="${list5BestCustomer.roleDescription}"/>đ
                                            </td>
                                            <c:set var="noOfBestCustomer" value="${noOfBestCustomer+1}" />
                                        </tr>
                                    </c:forEach>

                                    <c:if test="${list5BestCustomer.size() == 0 ||  list5BestCustomer == null}">
                                        <tr>
                                            <td colspan="7" class="table-row-no-product">No customer is collected!</td>
                                        </tr>
                                    </c:if>   
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="row justify-content-center">
                        <div class="col-xs-12 separator-container">
                            <div class="separtor"></div>
                        </div>
                    </div>

                    <div class="row satistic-row">
                        <c:if test="${!sellByCategoryStatus && sellByCategoryStatus != null}">
                            <div class="col-xs-12 col-md-6">
                                <h6 class="table-header">RATE OF SELLING BY CATEGORY</h6>
                                <div id="sellBuyCatelogyChart" style="height: 370px; width: 100%;"></div>
                            </div> 
                        </c:if>
                        <c:if test="${sellByCategoryStatus || sellByCategoryStatus == null}">
                            <div class="col-xs-12 col-md-6">
                                <h6 class="table-header">RATE OF SELLING BY CATEGORY</h6>
                                <div class="table-row-no-product" style="width: 100%; text-align: center">No data is selected to statistic!</div>
                            </div> 
                        </c:if>
                        <c:if test="${!sellQuantityStatus}">
                            <div class="col-xs-12 col-md-6">
                                <h6 class="table-header">SELLING QUANTITY</h6>
                                <div id="totalQuantityChart" style="height: 370px; width: 100%;"></div>
                            </div>
                        </c:if>
                        <c:if test="${sellQuantityStatus}">
                            <div class="col-xs-12 col-md-6">
                                <h6 class="table-header">SELLING QUANTITY</h6>
                                <div class="table-row-no-product" style="width: 100%; text-align: center">No data is selected to statistic!</div>
                            </div> 
                        </c:if>
                    </div>

<!--                                       <div class="row justify-content-center">
                                            <div class="col-xs-12 separator-container">
                                                <div class="separtor"></div>
                                            </div>
                                        </div>
                    
                                        <div class="row satistic-row">
                                            <div class="col-xs-12">
                                                <div id="revenueChart" style="height: 370px; width: 100%;"></div>
                                            </div>
                                        </div>-->
                </div>
            </div>

            <div class="disabled">
                <span id="quantityOfSaleFood" style="margin:  12px 36px;">${food}</span>
                <span id="quantityOfSaleDrink" style="margin:  12px 36px;">${drink}</span>
                <span id="quantityOfSaleCombo" style="margin:  12px 36px;">${combo}</span>
                <span id="quantityOfSaleSoup" style="margin:  12px 36px;">${soup}</span>
            </div>
            <div class="disabled">
                <span id="sumOfAceepted" style="margin:  12px 36px;">${totalAcceptOrders}</span>
                <span id="sumOfRejected" style="margin:  12px 36px;">${totalRejectOrders}</span>
                <span id="sumOfCompleted" style="margin:  12px 36px;">${totalCompletedOrders}</span>        
                <span id="sumOfProcessing" style="margin:  12px 36px;">${totalProcessingOrders}</span>
                <span id="sumOfDelivering" style="margin:  12px 36px;">${totalDeleveringOrders}</span>
                <span id="sumOfSellProduct" style="margin:  12px 36px;">${totalSellingProducts}</span>
                <span id="sumOfCustomerBought" style="margin:  12px 36px;">${totalCustomerBought}</span>
            </div>   


            <!-- 5. Footer  -->
            <jsp:include page="footer.jsp"></jsp:include>
            <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

            <script>
                window.onload = function () {
                    const food = document.getElementById('quantityOfSaleFood');
                    const foodContent = food.innerHTML;

                    const drink = document.getElementById('quantityOfSaleDrink');
                    const drinkContent = drink.innerHTML;

                    const combo = document.getElementById('quantityOfSaleCombo');
                    const comboContent = combo.innerHTML;

                    const soup = document.getElementById('quantityOfSaleSoup');
                    const soupContent = soup.innerHTML;

                    //=============================================
                    const apcceptedOrderTag = document.getElementById('sumOfAceepted');
                    const acceptedTagContent = apcceptedOrderTag.innerHTML;

                    const rejectedOrderTag = document.getElementById('sumOfRejected');
                    const rejectedTagContent = rejectedOrderTag.innerHTML;

                    const completedOrderTag = document.getElementById('sumOfCompleted');
                    const completedTagContent = completedOrderTag.innerHTML;

                    const processingOrderTag = document.getElementById('sumOfProcessing');
                    const processingTagContent = processingOrderTag.innerHTML;

                    const deliveringOrderTag = document.getElementById('sumOfDelivering');
                    const deliveringTagContent = deliveringOrderTag.innerHTML;

                    const sumOfSellProductTag = document.getElementById('sumOfSellProduct');
                    const sumOfSellProductContent = sumOfSellProductTag.innerHTML;

                    const sumOfBoughtCustomerTag = document.getElementById('sumOfCustomerBought');
                    const sumOfBoughtCustomerContent = sumOfBoughtCustomerTag.innerHTML;


                    console.log(typeof foodContent);

                    var chart1 = new CanvasJS.Chart("sellBuyCatelogyChart", {
                        exportEnabled: true,
                        animationEnabled: true,
                        title: {
                            text: ""
                        },
                        legend: {
                            cursor: "pointer",
                            itemclick: explodePie
                        },
                        data: [{
                                type: "pie",
                                showInLegend: true,
                                toolTipContent: "{name}: <strong>{y}%</strong>",
                                indexLabel: "{name} - {y}%",
                                dataPoints: [
                                    {y: foodContent, name: "FOOD", exploded: true},
                                    {y: drinkContent, name: "DRINK"},
                                    {y: comboContent, name: "COMBO"},
                                    {y: soupContent, name: "SOUP"}
                                ]
                            }]
                    });
                    chart1.render();

                    //=============================================
                    var chart2 = new CanvasJS.Chart("totalQuantityChart", {
                        exportEnabled: true,
                        animationEnabled: true,
                        theme: "light1", // "light1", "light2", "dark1", "dark2"
                        title: {
                            text: ""
                        },
                        axisY: {
                            title: "Quantity"
                        },
                        data: [{
                                type: "column",
                                showInLegend: true,
                                legendMarkerColor: "grey",
                                legendText: "Statistic items",
                                dataPoints: [
                                    {y: parseInt(sumOfBoughtCustomerContent), label: "Customer buy"},
                                    {y: parseInt(processingTagContent), label: "Processing orders"},
                                    {y: parseInt(acceptedTagContent), label: "Accepted orders"},
                                    {y: parseInt(rejectedTagContent), label: "Rejected orders"},
                                    {y: parseInt(deliveringTagContent), label: "Delivering orders"},
                                    {y: parseInt(completedTagContent), label: "Delivered orders"},
                                    {y: parseInt(sumOfSellProductContent), label: "Selled products"}

                                ]
                            }]
                    });
                    chart2.render();


                    //=============================================
                    var chart3 = new CanvasJS.Chart("revenueChart", {
                        exportEnabled: true,
                        animationEnabled: true,
                        theme: "light2",
                        title: {
                            text: "STATITIC TOTAL REVEUEW"
                        },
                        data: [{
                                type: "line",
                                indexLabelFontSize: 16,
                                dataPoints: [
                                    {y: 450},
                                    {y: 414},
                                    {y: 520, indexLabel: "\u2191 highest", markerColor: "red", markerType: "triangle"},
                                    {y: 460},
                                    {y: 450},
                                    {y: 500},
                                    {y: 480},
                                    {y: 480},
                                    {y: 410, indexLabel: "\u2193 lowest", markerColor: "DarkSlateGrey", markerType: "cross"},
                                    {y: 500},
                                    {y: 480},
                                    {y: 510},
                                ]
                            }]
                    });
                    chart3.render();
                };

                function explodePie(e) {
                    if (typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
                        e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
                    } else {
                        e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
                    }
                    e.chart.render();
                }
            </script>
        </div>
    </body>

</html>