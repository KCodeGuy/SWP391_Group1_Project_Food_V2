/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class Cart {

    private int cartID; // ID of the cart
    private int cartQuantity; // Quantity of items in the cart
    private int productID; // ID of the product in the cart
    private int accountID; // ID of the account associated with the cart
    private String productName; // Name of product
    private String productLink; // Link image of product
    private double productPrice; // Price of product
    private int productSalePercent; // Sale percent of product

    /**
     *
     * Constructs a new Cart object with default values.
     */
    public Cart() {
    }

    public Cart(int cartQuantity, int productID, double productPrice) {
        this.cartQuantity = cartQuantity;
        this.productID = productID;
        this.productPrice = productPrice;
    }
    
    

    /**
     *
     * Constructs a new Cart object with specified values.
     *
     * @param cartID the ID of the cart.
     * @param cartQuantity the quantity of items in the cart.
     * @param productID the ID of the product in the cart.
     * @param accountID the ID of the account associated with the cart.
     * @param productName Name of the product
     * @param productLink Link image of product
     * @param productPrice Price of the product
     * @param productSalePercent Sale percent of the product
     */
    public Cart(int cartID, int cartQuantity, int productID, int accountID, String productName, String productLink, double productPrice, int productSalePercent) {
        this.cartID = cartID;
        this.cartQuantity = cartQuantity;
        this.productID = productID;
        this.accountID = accountID;
        this.productName = productName;
        this.productLink = productLink;
        this.productPrice = productPrice;
        this.productSalePercent = productSalePercent;
    }

    /**
     *
     * Get price of the product
     *
     * @return int price of the product
     */
    public double getProductPrice() {
        return productPrice;
    }

    /**
     *
     * Set price of the product
     *
     * @param productPrice price of the product
     */
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     *
     * Get sale percent of the product
     *
     * @return int sale percent of the product
     */
    public int getProductSalePercent() {
        return productSalePercent;
    }

    /**
     *
     * Set sale percent of the product
     *
     * @param productSalePercent sale percent of the product
     */
    public void setProductSalePercent(int productSalePercent) {
        this.productSalePercent = productSalePercent;
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
     * @return productLink link image of product
     */
    public String getProductLink() {
        return productLink;
    }

    /**
     * Set link image of product
     * @param productLink link image of product
     */
    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }
    
    /**
     *
     * Gets the ID of the cart.
     *
     * @return the ID of the cart.
     */
    public int getCartID() {
        return cartID;
    }

    /**
     *
     * Sets the ID of the cart.
     *
     * @param cartID the ID of the cart.
     */
    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    /**
     *
     * Gets the quantity of items in the cart.
     *
     * @return the quantity of items in the cart.
     */
    public int getCartQuantity() {
        return cartQuantity;
    }

    /**
     *
     * Sets the quantity of items in the cart.
     *
     * @param cartQuantity the quantity of items in the cart.
     */
    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    /**
     *
     * Gets the ID of the product in the cart.
     *
     * @return the ID of the product in the cart.
     */
    public int getProductID() {
        return productID;
    }

    /**
     *
     * Sets the ID of the product in the cart.
     *
     * @param productID the ID of the product in the cart.
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     *
     * Gets the ID of the account associated with the cart.
     *
     * @return the ID of the account associated with the cart.
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     *
     * Sets the ID of the account associated with the cart.
     *
     * @param accountID the ID of the account associated with the cart.
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

}
