/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.AccountDAO;
import dao.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Account;
import model.Cart;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class LoadPayingController extends HttpServlet {
   
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
        String productSalePercent = request.getParameter("productSalePercent");
        int discount;
        if (productSalePercent == null) {
            discount = 0;
        } else {
            discount = Integer.parseInt(productSalePercent);
        }
        String voucherID = request.getParameter("voucherID");
        if (voucherID == null) {
            voucherID = "";
        }
        
        String accountID = request.getParameter("accountID");
        
        AccountDAO udao = new AccountDAO();
        Account user = udao.getUserPayingByAccountID(accountID);
        
        CartDAO cdao = new CartDAO();
        
        ArrayList<Cart> listCart = cdao.getListCartByAccountID(accountID);
        
        request.setAttribute("listCart", listCart);
        request.setAttribute("user", user);
        request.setAttribute("productSalePercent", discount);
        request.setAttribute("voucherID", voucherID);
        request.getRequestDispatcher("paying.jsp").forward(request, response);
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
