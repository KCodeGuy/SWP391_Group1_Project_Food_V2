/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class Rating {
    private int rating;
    private int ratingQuanity;

    /**
     *
     */
    public Rating() {
    }

    /**
     *
     * @param rating
     * @param ratingQuanity
     */
    public Rating(int rating, int ratingQuanity) {
        this.rating = rating;
        this.ratingQuanity = ratingQuanity;
    }

    /**
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public int getRatingQuanity() {
        return ratingQuanity;
    }

    /**
     *
     * @param ratingQuanity
     */
    public void setRatingQuanity(int ratingQuanity) {
        this.ratingQuanity = ratingQuanity;
    }
    
    
}
