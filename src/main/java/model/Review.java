/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class Review {

    private String reviewID;    // The unique identifier for the review.
    private int rating;         // The rating score given by the reviewer for the product.
    private String review;      // The text content of the review.
    private String productID;   // The unique identifier for the product being reviewed.
    private String accountID;   // The unique identifier for the reviewer's account.
    private String accountName; // The unique identifier for the reviewer's name of account.

    /**
     * Constructs a new Review object with default values.
     */
    public Review() {
    }

    /**
     * Constructs a new Review object with the specified values.
     *
     * @param reviewID The unique identifier for the review.
     * @param rating The rating score given by the reviewer for the product.
     * @param review The text content of the review.
     * @param productID The unique identifier for the product being reviewed.
     * @param accountID The unique identifier for the reviewer's account.
     */
    public Review(String reviewID, int rating, String review, String productID, String accountID) {
        this.reviewID = reviewID;
        this.rating = rating;
        this.review = review;
        this.productID = productID;
        this.accountID = accountID;
    }

    /**
     * Constructs a new Review object with the specified values.
     *
     * @param reviewID The unique identifier for the review.
     * @param rating The rating score given by the reviewer for the product.
     * @param review The text content of the review.
     * @param productID The unique identifier for the product being reviewed.
     * @param accountID The unique identifier for the reviewer's account.
     * @param accountName The unique identifier for the reviewer's name of account.
     */
    public Review(String reviewID, int rating, String review, String productID, String accountID, String accountName) {
        this.reviewID = reviewID;
        this.rating = rating;
        this.review = review;
        this.productID = productID;
        this.accountID = accountID;
        this.accountName = accountName;
    }

    /**
     * Get the unique identifier for the reviewer's name of account.
     * @return The unique identifier for the reviewer's name of account.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Set the unique identifier for the reviewer's name of account.
     * @param accountName The unique identifier for the reviewer's name of account.
     */ 
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    

    /**
     * Gets the unique identifier for the review.
     *
     * @return The unique identifier for the review.
     */
    public String getReviewID() {
        return reviewID;
    }

    /**
     * Sets the unique identifier for the review.
     *
     * @param reviewID The unique identifier for the review.
     */
    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    /**
     * Gets the rating score given by the reviewer for the product.
     *
     * @return The rating score given by the reviewer for the product.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the rating score given by the reviewer for the product.
     *
     * @param rating The rating score given by the reviewer for the product.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the text content of the review.
     *
     * @return The text content of the review.
     */
    public String getReview() {
        return review;
    }

    /**
     * Sets the text content of the review.
     *
     * @param review The text content of the review.
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * Gets the unique identifier for the product being reviewed.
     *
     * @return The unique identifier for the product being reviewed.
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Sets the unique identifier for the product being reviewed.
     *
     * @param productID The unique identifier for the product being reviewed.
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * Gets the unique identifier for the reviewer's account.
     *
     * @return The unique identifier for the reviewer's account.
     */
    public String getAccountID() {
        return accountID;
    }

    /**
     * Sets the unique identifier for the reviewer's account.
     *
     * @param accountID The unique identifier for the reviewer's account.
     */
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

}
