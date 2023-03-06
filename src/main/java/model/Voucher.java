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
    private int voucherQuantity; // quantity of voucher
    private String voucherStartDay; // start day voucher
    private String voucherEndDay; // end day voucher

    /**
     * Constructor with parameter voucherID, voucherDescription, voucherStatus,
     * and productSalePercent
     *
     * @param voucherID ID of the voucher
     * @param voucherDescription Description of the voucher
     * @param voucherStatus Status of the voucher
     * @param productSalePercent Percentage of sale for the voucher
     * @param voucherQuantity quantity of voucher
     * @param voucherStartDay start day voucher
     * @param voucherEndDay end day voucher
     */
    public Voucher(String voucherID, String voucherDescription, String voucherStatus, int productSalePercent, int voucherQuantity, String voucherStartDay, String voucherEndDay) {
        this.voucherID = voucherID;
        this.voucherDescription = voucherDescription;
        this.voucherStatus = voucherStatus;
        this.productSalePercent = productSalePercent;
        this.voucherQuantity = voucherQuantity;
        this.voucherStartDay = voucherStartDay;
        this.voucherEndDay = voucherEndDay;
    }

    /**
     * Get quantity of voucher
     * @return quantity of voucher
     */
    public int getVoucherQuantity() {
        return voucherQuantity;
    }

    /**
     * Set quantity of voucher
     * @param voucherQuantity quantity of voucher
     */
    public void setVoucherQuantity(int voucherQuantity) {
        this.voucherQuantity = voucherQuantity;
    }

    /**
     * Get start day voucher
     * @return start day voucher
     */
    public String getVoucherStartDay() {
        return voucherStartDay;
    }

    /**
     * Set start day voucher 
     * @param voucherStartDay start day voucher
     */
    public void setVoucherStartDay(String voucherStartDay) {
        this.voucherStartDay = voucherStartDay;
    }

    /**
     * Get end day voucher
     * @return end day voucher
     */
    public String getVoucherEndDay() {
        return voucherEndDay;
    }

    /**
     * Set end day voucher
     * @param voucherEndDay end day voucher
     */
    public void setVoucherEndDay(String voucherEndDay) {
        this.voucherEndDay = voucherEndDay;
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

}
