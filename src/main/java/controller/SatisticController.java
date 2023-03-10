/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.List;
import model.Account;
import model.Product;

/**
 *
 * @author PC
 */
public class SatisticController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String startDate = request.getParameter("start-date");
        String endDate = request.getParameter("end-date");
        final String starDateHourDetail = " 01:00:00.000";
        final String endDateHourDetail = " 23:59:00.000";
        DecimalFormat df = new DecimalFormat("#.##");

        //=======================================================
        OrderDAO odao = new OrderDAO();
        long totalRevenue = odao.getTotalRevenue(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));
        List<Product> list5BestSellerProduct = odao.getTop5BestSellerProducts(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));
        List<Account> list5BestCustomer = odao.getTop5BesTCustomers(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));

        //=======================================================
        int quantityFood, quantityDrink, quantityCombo, quantitySoup = 0;
        quantityFood = odao.getTotalQuantityFoodSelled(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));
        quantityDrink = odao.getTotalQuantityDrinkSelled(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));
        quantityCombo = odao.getTotalQuantityComboSelled(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));
        quantitySoup = odao.getTotalQuantitySoupSelled(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));
        boolean checkNullSellCategory = quantityFood == 0 && quantityDrink == 0 && quantityCombo == 0 && quantitySoup == 0;
        int sumOfQuantityCatelogry = quantityFood + quantityDrink + quantityCombo + quantitySoup;        
        //=======================================================
    
        int totalRejectOrders = odao.getTotalOrderByStatus(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail), "REJECTED");
        int totalAcceptOrders = odao.getTotalOrderByStatus(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail), "ACCEPTED");
        int totalCompletedOrders = odao.getTotalOrderByStatus(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail), "DELIVERED");
        int totalProcessingOrders = odao.getTotalOrderByStatus(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail), "PROCESSING");
        int totalDeleveringOrders = odao.getTotalOrderByStatus(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail), "DELIVERING");
        long totalSellingProducts = odao.getTotalOfProductSelled(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));
        int totalCustomerBought = odao.getTotalOfCustomerBought(startDate.concat(starDateHourDetail), endDate.concat(endDateHourDetail));
        boolean checkNullSellQuantity = totalRejectOrders == 0 && totalAcceptOrders == 0 
                && totalCompletedOrders == 0 && totalProcessingOrders == 0 && totalDeleveringOrders == 0
                && totalSellingProducts == 0 && totalCustomerBought == 0;
        
        //=======================================================
        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);
        request.setAttribute("list5BestSellerProduct", list5BestSellerProduct);
        request.setAttribute("list5BestCustomer", list5BestCustomer);
        
        request.setAttribute("sellByCategoryStatus", checkNullSellCategory);
        request.setAttribute("food", Double.parseDouble(df.format((double) (quantityFood * 100) / sumOfQuantityCatelogry)));
        request.setAttribute("drink", Double.parseDouble(df.format((double) (quantityDrink * 100) / sumOfQuantityCatelogry)));
        request.setAttribute("combo", Double.parseDouble(df.format((double) (quantityCombo * 100) / sumOfQuantityCatelogry)));
        request.setAttribute("soup", Double.parseDouble(df.format((double) (quantitySoup * 100) / sumOfQuantityCatelogry)));
        
        request.setAttribute("sellQuantityStatus", checkNullSellQuantity);
        request.setAttribute("totalRejectOrders", totalRejectOrders);
        request.setAttribute("totalAcceptOrders", totalAcceptOrders);
        request.setAttribute("totalCompletedOrders", totalCompletedOrders);
        request.setAttribute("totalProcessingOrders", totalProcessingOrders);
        request.setAttribute("totalDeleveringOrders", totalDeleveringOrders);
        request.setAttribute("totalSellingProducts", totalSellingProducts);
        request.setAttribute("totalCustomerBought", totalCustomerBought);
        request.getRequestDispatcher("statistic.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
