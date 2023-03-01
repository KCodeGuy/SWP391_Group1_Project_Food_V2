/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author Tran Thi Ngoc Hieu CE161025
 */
public class ShowOrderDetailForShipperController extends HttpServlet {

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
        //Get order ID from request parameter
        String orderID = request.getParameter("orderID");
        String accountID = request.getParameter("accountID");
        //Create Order object
        Order order;
        //Create OrderDAO object
        OrderDAO odao = new OrderDAO();
        //Get Order object by Order ID using OrderDAO object
        order = odao.getOrderByOrderIDForShipper(orderID);
        //Create OrderDetailDAO object
        OrderDetailDAO ddao = new OrderDetailDAO();
        //Get list of OrderDetail objects by Order ID using OrderDetailDAO object
        ArrayList<OrderDetail> listOrderShip = ddao.getListOrderDetailByOrderIDForShipper(orderID);
        //Set Order object and list of OrderDetail objects as request attributes
        request.setAttribute("order", order);
        request.setAttribute("isDelivering", odao.getDelivering(accountID) != null);
        request.setAttribute("listOrderShip", listOrderShip);
        //Forward the request and response to orderDetailForShipper.jsp page
        request.getRequestDispatcher("orderDetailForShipper.jsp").forward(request, response);
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
