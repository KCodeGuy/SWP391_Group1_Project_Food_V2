/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.CartDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.VoucherDAO;
import emailHandler.EmailHandler;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Account;
import model.OrderDetail;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class PayingController extends HttpServlet {

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
        String voucherID = request.getParameter("voucherID");

        VoucherDAO vdao = new VoucherDAO();

        if (voucherID != null) {
            if (vdao.quantityOfVoucher(voucherID) < 1) {
                HttpSession session = request.getSession();
                session.setAttribute("messageVoucher", "Voucher quantity is not enough. Please try again later.");
                response.sendRedirect(request.getHeader("referer"));
                return;
            }
        }

        int discount = vdao.getProductSalePrecent(voucherID);

        String note = request.getParameter("note");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        OrderDAO odao = new OrderDAO();
        OrderDetailDAO ddao = new OrderDetailDAO();
        CartDAO cdao = new CartDAO();
        EmailHandler eh = new EmailHandler();
        AccountDAO adao = new AccountDAO();
        Account acc = adao.getAccountByID(accountID);

        odao.createOrder(note, accountID, name, phone, address, voucherID, discount);
        String orderID = odao.getLastIDOfOrder();
        ddao.createOrderDetails(cdao.getListCartToPaying(accountID), orderID);
        vdao.updateQuantity(voucherID);
        cdao.deleteCartByAccountID(accountID);
        List<OrderDetail> listOrderDetail = ddao.getListOrderDetailByOrderID(orderID);
        long totalPrice = 0;
        for (OrderDetail orderDetail : listOrderDetail) {
            totalPrice += orderDetail.getOrderPrice() * orderDetail.getOrderQuantity();
        }

        eh.sendEmailOrderSuccess(name, acc.getAccountEmail(), phone, address, orderID, "PROCESSING", listOrderDetail.size(), totalPrice);

        HttpSession session = request.getSession();
        int cartSize = cdao.getListCartByAccountID(accountID).size();
        session.setAttribute("cartSize", cartSize);
        response.sendRedirect("home");
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
