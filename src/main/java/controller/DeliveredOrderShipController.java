/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import emailHandler.EmailHandler;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Account;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author Tran Thi Ngoc Hieu CE161025
 */
public class DeliveredOrderShipController extends HttpServlet {

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
        String accountID = request.getParameter("accountID");
        String orderID = request.getParameter("orderID");
        
        OrderDAO odao = new OrderDAO(); // create orderDAO
        odao.deliveredOrderByOrderID(accountID,orderID);
        EmailHandler eh = new EmailHandler();
        AccountDAO adao = new AccountDAO();
        
        Order order = odao.getOrderByOrderID(orderID);
        OrderDetailDAO ddao = new OrderDetailDAO();
        
        Account acc = adao.getAccountByID(order.getAccountID());
        List<OrderDetail> listOrderDetail = ddao.getListOrderDetailByOrderID(orderID);
        long totalPrice = 0;
        for (OrderDetail orderDetail : listOrderDetail) {
            totalPrice += orderDetail.getOrderPrice() * orderDetail.getOrderQuantity();
        }
        eh.sendEmailIsDelivered(order.getUserFullName(),acc.getAccountEmail() , orderID, listOrderDetail.size(), totalPrice);
        response.sendRedirect("shipper-manage-order?accountID=" +accountID + "&sort-option=none");
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
