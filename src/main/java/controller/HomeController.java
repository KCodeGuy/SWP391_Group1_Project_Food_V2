package controller;

import dao.ProductDAO;
import dao.VoucherDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.stream.Stream;
import model.Product;
import model.Voucher;
import paging.PagingUtil;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class HomeController extends HttpServlet {

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
        int pageNo = 1;
        if (request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        }
        int pageSize = 8;

        ProductDAO pdao = new ProductDAO();
        List<Product> listAllProduct = pdao.getListProduct();
        List<Product> listProduct = PagingUtil.getPagingProducts(listAllProduct, pageNo, pageSize); // get list product to load page

        String txtSearch = request.getParameter("txtSearch");
        String category = request.getParameter("category");
        if (txtSearch != null || category != null) {
            if (txtSearch == null) {
                txtSearch = "";
            }
            listProduct = pdao.findProductByName(txtSearch, category);
            if (listProduct.isEmpty()) {
                request.setAttribute("MESSAGE", "Product not found");
            }
        }

        int totalPages = PagingUtil.getTotalPages(listAllProduct, pageSize);

        VoucherDAO vdao = new VoucherDAO();
        List<Voucher> listTop4Voucher = vdao.getTop4Voucher();

        request.setAttribute("page", "home");
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("listTop4Voucher", listTop4Voucher);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
