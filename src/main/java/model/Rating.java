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

    public Rating() {
    }

    public Rating(int rating, int ratingQuanity) {
        this.rating = rating;
        this.ratingQuanity = ratingQuanity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRatingQuanity() {
        return ratingQuanity;
    }

    public void setRatingQuanity(int ratingQuanity) {
        this.ratingQuanity = ratingQuanity;
    }
    
    
}
