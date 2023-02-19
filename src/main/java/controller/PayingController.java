/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CartDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class PayingController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        String voucherID = request.getParameter("voucherID");
        String productSalePercent = request.getParameter("productSalePercent");
        int discount;
        if (productSalePercent == null) {
            discount = 0;
        } else {
            discount = Integer.parseInt(productSalePercent);
        }
        String note = request.getParameter("note");
        String name = request.getParameter("name");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String address = request.getParameter("address");
        
        OrderDAO odao = new OrderDAO();
        OrderDetailDAO ddao = new OrderDetailDAO();
        CartDAO cdao = new CartDAO();
        
        odao.createOrder(note, accountID, name, phone, address, voucherID, discount);
        ddao.createOrderDetails(cdao.getListCartToPaying(accountID), odao.getNewOrderID());
        cdao.deleteCartByAccountID(accountID);
        
        response.sendRedirect("home");
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}