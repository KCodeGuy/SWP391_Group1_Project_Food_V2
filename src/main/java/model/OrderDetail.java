/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class OrderDetail {

    private String orderDetailID; // ID of the order detail
    private int orderQuantity; // Quantity of product in the order
    private int orderPrice; // Price of the product in the order
    private String productID; // ID of the product in the order
    private String orderID; // ID of the order associated with the order detail
    private String productName; // Name of product
    private String productLink; // Link image of product

    /**
     * Constructor default
     */
    public OrderDetail() {
    }

    /**
     * Constructor with parameter orderDetailID, orderQuantity, orderPrice,
     * productID, orderID
     *
     * @param orderDetailID ID of the order detail
     * @param orderQuantity Quantity of the order detail
     * @param orderPrice Price of the order detail
     * @param productID ID of the product
     * @param orderID ID of the order
     */
    public OrderDetail(String orderDetailID, int orderQuantity, int orderPrice, String productID, String orderID) {
        this.orderDetailID = orderDetailID;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.productID = productID;
        this.orderID = orderID;
    }

    /**
     * Constructor
     *
     * @param orderQuantity Quantity of the order detail
     * @param orderPrice Price of the order detail
     * @param productName Name of the product
     * @param productLink Link image of product
     */
    public OrderDetail(int orderQuantity, int orderPrice, String productName, String productLink) {
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.productName = productName;
        this.productLink = productLink;
    }

    /**
     *
     * Get name of the product
     *
     * @return String name of the product
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * Set name of the product
     *
     * @param productName name of the product
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Get link image of product
     *
     * @return productLink link image of product
     */
    public String getProductLink() {
        return productLink;
    }

    /**
     * Set link image of product
     *
     * @param productLink link image of product
     */
    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    /**
     * Get ID of the order detail
     *
     * @return int ID of the order detail
     */
    public String getOrderDetailID() {
        return orderDetailID;
    }

    /**
     * Set ID of the order detail
     *
     * @param orderDetailID ID of the order detail
     */
    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    /**
     * Get Quantity of the order detail
     *
     * @return int Quantity of the order detail
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * Set Quantity of the order detail
     *
     * @param orderQuantity Quantity of the order detail
     */
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    /**
     * Get Price of the order detail
     *
     * @return int Price of the order detail
     */
    public int getOrderPrice() {
        return orderPrice;
    }

    /**
     * Set Price of the order detail
     *
     * @param orderPrice Price of the order detail
     */
    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * Get ID of the product
     *
     * @return String ID of the product
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Set ID of the product
     *
     * @param productID ID of the product
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * Get ID of the Order
     *
     * @return String ID of the Order
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Set ID of the Order
     *
     * @param orderID ID of the Order
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

}
