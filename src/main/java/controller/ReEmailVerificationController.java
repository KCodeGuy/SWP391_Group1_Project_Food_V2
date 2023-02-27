package controller;

import dao.AccountDAO;
import emailHandler.EmailHandler;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author PC
 */
public class ReEmailVerificationController extends HttpServlet {

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
        // get parameters on input for hanle.
        // get account's id of an account.
        String accountID = request.getParameter("accountID");
        // get current fueature this page is handling (update password or email verification)
        String featurePage = request.getParameter("featurePage");
        // count time of wrong entering otp-code
        int timeSendingFailed = Integer.parseInt(request.getParameter("timeSendFailed"));

        EmailHandler eh = new EmailHandler();
        AccountDAO adao = new AccountDAO();
        // get account by id
        Account acc = adao.getAccountByID(accountID);

        // crate otp-code
        String otpCode = eh.generateRandomCode();
        // send an email to verify.
        eh.sendEmailAuthen(acc.getAccountEmail(), otpCode);
        request.setAttribute("timeSendFailed", timeSendingFailed);
        // check current feature this page is handling (update password or email verification)
        if (featurePage.equalsIgnoreCase("AUTHENEMAIL")) { // feature is authen email
            request.setAttribute("featurePage", "AUTHENEMAIL");
        } else if (featurePage.equalsIgnoreCase("UPDATEPASS")) { // feature is update password.
            request.setAttribute("featurePage", "UPDATEPASS");
        } else if (featurePage.equalsIgnoreCase("FORM-APPLY")) { // register form application feature
            request.setAttribute("featurePage", "FORM-APPLY");
        }
        request.setAttribute("accountID", accountID);
        request.setAttribute("email", acc.getAccountEmail());
        request.setAttribute("otpCode", otpCode);
        request.getRequestDispatcher("emailVerification.jsp").forward(request, response);
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
