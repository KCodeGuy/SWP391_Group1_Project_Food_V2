/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CartDAO;
import dao.VoucherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonObject;
import model.Cart;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class UseVoucherController extends HttpServlet {

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
        String voucher = request.getParameter("voucherID");
        String accountID = request.getParameter("accountID");
        CartDAO cdao = new CartDAO();
        ArrayList<Cart> listCart = cdao.getListCartByAccountID(accountID);
        int totalPrice = 0;
        if (!listCart.isEmpty()) {
            for (Cart c : listCart) {
                totalPrice += ((c.getProductPrice() * (100 - c.getProductSalePercent())) / 100 * c.getCartQuantity());
            }
        }
        
        System.out.println(accountID + totalPrice);

        VoucherDAO vdao = new VoucherDAO();
        int discount = vdao.getProductSalePrecent(voucher);

        JsonObject json = Json.createObjectBuilder()
                .add("discount", discount)
                .add("discountPrice", (totalPrice * discount)/100)
                .add("totalPrice", totalPrice - (totalPrice * discount)/100)
                .build();

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
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
