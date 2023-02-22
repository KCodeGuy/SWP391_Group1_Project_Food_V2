/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class Voucher {

    private String voucherID; // ID of the voucher
    private String voucherDescription; // Description of the voucher
    private String voucherStatus; // Status of the voucher (available, unavailable)
    private int productSalePercent; // Sale percent associated with the voucher

    /**
     * Constructor with parameter voucherID, voucherDescription, voucherStatus,
     * and productSalePercent
     *
     * @param voucherID ID of the voucher
     * @param voucherDescription Description of the voucher
     * @param voucherStatus Status of the voucher
     * @param productSalePercent Percentage of sale for the voucher
     */
    public Voucher(String voucherID, String voucherDescription, String voucherStatus, int productSalePercent) {
        this.voucherID = voucherID;
        this.voucherDescription = voucherDescription;
        this.voucherStatus = voucherStatus;
        this.productSalePercent = productSalePercent;
    }

    public Voucher(String toUpperCase, String voucherDescription, String voucherStatus, Integer valueOf, Integer valueOf0, String voucherSDate, String voucherEDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Get ID of the voucher
     *
     * @return string ID of the voucher
     */
    public String getVoucherID() {
        return voucherID;
    }

    /**
     * Set ID of the voucher
     *
     * @param voucherID ID of the voucher
     */
    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

    /**
     * Get Description of the voucher
     *
     * @return String Description of the voucher
     */
    public String getVoucherDescription() {
        return voucherDescription;
    }

    /**
     * Set Description of the voucher
     *
     * @param voucherDescription Description of the voucher
     */
    public void setVoucherDescription(String voucherDescription) {
        this.voucherDescription = voucherDescription;
    }

    /**
     * Get Status of the voucher
     *
     * @return string Status of the voucher
     */
    public String getVoucherStatus() {
        return voucherStatus;
    }

    /**
     * Set Status of the voucher
     *
     * @param voucherStatus Status of the voucher
     */
    public void setVoucherStatus(String voucherStatus) {
        this.voucherStatus = voucherStatus;
    }

    /**
     * Get Percentage of sale for the voucher
     *
     * @return int Percentage of sale for the voucher
     */
    public int getProductSalePercent() {
        return productSalePercent;
    }

    /**
     * Set Percentage of sale for the voucher
     *
     * @param productSalePercent Percentage of sale for the voucher
     */
    public void setProductSalePercent(int productSalePercent) {
        this.productSalePercent = productSalePercent;
    }

    public int getVoucherQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getVoucherStartDay() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getVoucherEndDay() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
