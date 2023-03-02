/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paging;

import java.util.List;
import model.Product;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class PagingUtil {

    /**
     * Retrieves a specific paginated list of products for the current page.
     *
     * @param allProducts The list of all products.
     * @param pageNo The requested page number.
     * @param pageSize The page size.
     * @return A paginated list of products for the current page.
     */
    public static List<Product> getPagingProducts(List<Product> allProducts, int pageNo, int pageSize) {
        int start = (pageNo - 1) * pageSize;
        int end = Math.min(start + pageSize, allProducts.size());
        return allProducts.subList(start, end);
    }

    /**
     * Calculates the total number of pages based on the page size and the total
     * number of items.
     *
     * @param allProducts The list of all products.
     * @param pageSize The page size.
     * @return The total number of pages.
     */
    public static int getTotalPages(List<Product> allProducts, int pageSize) {
        return (int) Math.ceil((double) allProducts.size() / pageSize);
    }

}
