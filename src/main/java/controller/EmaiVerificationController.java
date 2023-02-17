package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class EmaiVerificationController extends HttpServlet {

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
        String fullName = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String enteredCode = request.getParameter("enteredCode");
        String originCode = request.getParameter("orginalCode");
        String featurePage = request.getParameter("featurePage");
        int timeSendingFailed = Integer.parseInt(request.getParameter("timeSendFailed")) + 1;

        if (enteredCode.equals(originCode)) {
            if (featurePage.equalsIgnoreCase("AUTHENEMAIL")) {
                AccountDAO adao = new AccountDAO();
                adao.registerAccount(fullName, email, password, phone, address);
                request.setAttribute("registerSuccesMessage", "Register successfully! Please login your account!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("authenEmailSuccess", "Verify email  successfully! Please enter password!");
                request.setAttribute("email", email);
                request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
            }
        } else {
            if (timeSendingFailed >= 3) {
                response.sendRedirect("home");
            } else {
                if (featurePage.equalsIgnoreCase("AUTHENEMAIL")) {
                    request.setAttribute("featurePage", "AUTHENEMAIL");
                    request.setAttribute("name", fullName);
                    request.setAttribute("phone", phone);
                    request.setAttribute("address", address);
                    request.setAttribute("password", password);
                }else {
                     request.setAttribute("featurePage", "UPDATEPASS");
                }
                request.setAttribute("timeSendFailed", timeSendingFailed);
                request.setAttribute("email", email);
                request.setAttribute("showSendAgainBtn", true);
                request.setAttribute("wrongCodeMessage", "Entered OPT-code is incorect! Please try again!");
                request.getRequestDispatcher("emailVerification.jsp").forward(request, response);
            }
        }
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
