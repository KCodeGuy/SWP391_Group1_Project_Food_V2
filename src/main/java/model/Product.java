/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class Product {

    private int productID; // ID of product
    private String productName; // Name of product
    private String productDescription; // Description of product
    private int productPrice; // Price of product
    private int productSalePercent; // Sale percent of product
    private ProductStatus productStatus; // Status of product (available or not)
    private String productLink; // Link image of product
    private String categoryID; // ID of category the product belongs to

    /**
     *
     * Constructor default
     */
    public Product() {
    }

    /**
     * Constructor with parameters productID, productLink,
     * productName,productDescription, productSalePercent,peoductPrice,
     * productStatus
     *
     * @param productID ID of the product
     * @param productName Name of the product
     * @param productDescription Description of the product
     * @param productPrice Price of the product
     * @param productSalePercent Sale percent of the product
     * @param productStatus Status of the product
     * @param productLink Link image of product
     */
    public Product(int productID, String productLink, String productName, String productDescription, int productSalePercent, int productPrice, ProductStatus productStatus) {
        this.productID = productID;
        this.productLink = productLink;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productSalePercent = productSalePercent;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
    }

    /**
     *
     * Constructor with parameters productID, productName, productDescription,
     * productPrice, productSalePercent, productStatus, and categoryID
     *
     * @param productID ID of the product
     * @param productName Name of the product
     * @param productDescription Description of the product
     * @param productPrice Price of the product
     * @param productSalePercent Sale percent of the product
     * @param productStatus Status of the product
     * @param productLink Link image of product
     * @param categoryID ID of the category the product belongs to
     */
    public Product(int productID, String productName, String productDescription, int productPrice, int productSalePercent, ProductStatus productStatus, String productLink, String categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productSalePercent = productSalePercent;
        this.productStatus = productStatus;
        this.productLink = productLink;
        this.categoryID = categoryID;
    }

    /**
     *
     * Get ID of the product
     *
     * @return int ID of the product
     */
    public int getProductID() {
        return productID;
    }

    /**
     *
     * Set ID of the product
     *
     * @param productID ID of the product
     */
    public void setProductID(int productID) {
        this.productID = productID;
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
     *
     * Get description of the product
     *
     * @return String description of the product
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     *
     * Set description of the product
     *
     * @param productDescription description of the product
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     *
     * Get price of the product
     *
     * @return int price of the product
     */
    public int getProductPrice() {
        return productPrice;
    }

    /**
     *
     * Set price of the product
     *
     * @param productPrice price of the product
     */
    public void setProductPrice(int productPrice) {
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
     * Get status of the product
     *
     * @return ProductStatus status of the product
     */
    public ProductStatus getProductStatus() {
        return productStatus;
    }

    /**
     *
     * Set status of the product
     *
     * @param productStatus status of the product
     */
    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    /**
     *
     * Get the ID of the category
     *
     * @return the ID of the category
     */
    public String getCategoryID() {
        return categoryID;
    }

    /**
     *
     * Set the ID of the category
     *
     * @param categoryID the ID of the category
     */
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
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

}
