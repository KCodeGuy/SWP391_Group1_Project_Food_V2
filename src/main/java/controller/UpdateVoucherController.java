/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.VoucherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Voucher;

/**
 *
 * @author admin
 */
@WebServlet(name = "UpdateVoucherController", urlPatterns = {"/UpdateVoucherController"})
public class UpdateVoucherController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        String voucherID = request.getParameter("voucherID");
        int voucherCondition = Integer.parseInt(request.getParameter("voucherCondition"));
        String voucherDescription = request.getParameter("voucherDescription");
        String voucherPercent = request.getParameter("voucherPercent");
        String voucherStatus = request.getParameter("voucherStatus");
        String voucherQuantity = request.getParameter("voucherQuantity");
        String voucherSDate = request.getParameter("voucherSDate");
        String voucherEDate = request.getParameter("voucherEDate");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
        if (sdf.parse(voucherSDate).after(sdf.parse(voucherEDate))) {
            request.setAttribute("DATEERROR", "Start date is before end date");
            request.setAttribute("voucherID", voucherID);
            request.setAttribute("voucherCondition", voucherCondition);
            request.setAttribute("voucherDescription", "abc");
            request.setAttribute("voucherPercent", voucherPercent);
            request.setAttribute("voucherQuantity", voucherQuantity);
            request.setAttribute("voucherSDate", voucherSDate);
            request.setAttribute("voucherEDate", voucherEDate);
            request.getRequestDispatcher("updateVoucher.jsp").forward(request, response);
        }
        Voucher vc = new Voucher(
                voucherID.toUpperCase(),
                voucherCondition,
                voucherDescription,
                voucherStatus,
                Integer.valueOf(voucherPercent),
                Integer.valueOf(voucherQuantity),
                voucherSDate,
                voucherEDate
        );
        VoucherDAO.updateVoucher(vc);
        response.sendRedirect("manageVoucher.jsp");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateVoucherController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateVoucherController.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateVoucherController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateVoucherController.class.getName()).log(Level.SEVERE, null, ex);
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
    } // </editor-fold>
}
