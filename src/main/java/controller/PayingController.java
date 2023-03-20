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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Order;
import model.OrderDetail;
import model.Voucher;

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
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String accountID = request.getParameter("accountID");
        String voucherID = request.getParameter("voucherID");
        int totalPriceCheck = Integer.parseInt(request.getParameter("totalPrice"));
        HttpSession session = request.getSession();
        VoucherDAO vdao = new VoucherDAO();
        Voucher v;
        int discount = 0;
        if (!voucherID.isEmpty()) {
            v = vdao.getVoucherByID(voucherID);
            if (v == null) {
                session.setAttribute("messageVoucher", "Voucher is not exist! Please try again!");
                response.sendRedirect(request.getHeader("referer"));
                return;
            } else {
                int condition = v.getVoucherCondition();
                discount = v.getProductSalePercent();
                if (v.getVoucherQuantity() < 1) {
                    session.setAttribute("messageVoucher", "Voucher is not enough quantity!");
                    response.sendRedirect(request.getHeader("referer"));
                    return;
                } else {
                    if (!VoucherDAO.checkVoucherIsUsed(condition, totalPriceCheck)) {
                        session.setAttribute("messageVoucher", "Total of order must be greater than or equal " + condition + "đ!");
                        response.sendRedirect(request.getHeader("referer"));
                        return;
                    }
                }
            }
        }
        
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
        int totalPrice = 0;
        Order order = odao.getOrderByOrderID(orderID);
        totalPrice = order.getTotalPrice();
        int cartSize = cdao.getListCartByAccountID(accountID).size();
        session.setAttribute("cartSize", cartSize);
        eh.sendEmailIsOrdered(name, acc.getAccountEmail(), phone, address, orderID, "PROCESSING", listOrderDetail.size(), discount, totalPrice);
        request.getRequestDispatcher("home").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PayingController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PayingController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
