/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


public class Billinghistory {

   int BillNo,  BookingNo, BillingDays, TotalRoomRent, ServiceCharge, GrossBillAmount, ServiceTax, DiscountAllowed, NetBillAmount, AmountRecived, OutstandingAmount;
   String BillEntryDate, BillingMode, CardNumber;

    public Billinghistory() {
        super();
    }

    public Billinghistory(int BillNo, int BookingNo, int BillingDays, int TotalRoomRent, int ServiceCharge, int GrossBillAmount, int ServiceTax, int DiscountAllowed, int NetBillAmount, int AmountRecived, int OutstandingAmount, String BillEntryDate, String BillingMode, String CardNumber) {
        this.BillNo = BillNo;
        this.BookingNo = BookingNo;
        this.BillingDays = BillingDays;
        this.TotalRoomRent = TotalRoomRent;
        this.ServiceCharge = ServiceCharge;
        this.GrossBillAmount = GrossBillAmount;
        this.ServiceTax = ServiceTax;
        this.DiscountAllowed = DiscountAllowed;
        this.NetBillAmount = NetBillAmount;
        this.AmountRecived = AmountRecived;
        this.OutstandingAmount = OutstandingAmount;
        this.BillEntryDate = BillEntryDate;
        this.BillingMode = BillingMode;
        this.CardNumber = CardNumber;
    }

    public int getBillNo() {
        return BillNo;
    }

    public void setBillNo(int BillNo) {
        this.BillNo = BillNo;
    }

    public int getBookingNo() {
        return BookingNo;
    }

    public void setBookingNo(int BookingNo) {
        this.BookingNo = BookingNo;
    }

    public int getBillingDays() {
        return BillingDays;
    }

    public void setBillingDays(int BillingDays) {
        this.BillingDays = BillingDays;
    }

    public int getTotalRoomRent() {
        return TotalRoomRent;
    }

    public void setTotalRoomRent(int TotalRoomRent) {
        this.TotalRoomRent = TotalRoomRent;
    }

    public int getServiceCharge() {
        return ServiceCharge;
    }

    public void setServiceCharge(int ServiceCharge) {
        this.ServiceCharge = ServiceCharge;
    }

    public int getGrossBillAmount() {
        return GrossBillAmount;
    }

    public void setGrossBillAmount(int GrossBillAmount) {
        this.GrossBillAmount = GrossBillAmount;
    }

    public int getServiceTax() {
        return ServiceTax;
    }

    public void setServiceTax(int ServiceTax) {
        this.ServiceTax = ServiceTax;
    }

    public int getDiscountAllowed() {
        return DiscountAllowed;
    }

    public void setDiscountAllowed(int DiscountAllowed) {
        this.DiscountAllowed = DiscountAllowed;
    }

    public int getNetBillAmount() {
        return NetBillAmount;
    }

    public void setNetBillAmount(int NetBillAmount) {
        this.NetBillAmount = NetBillAmount;
    }

    public int getAmountRecived() {
        return AmountRecived;
    }

    public void setAmountRecived(int AmountRecived) {
        this.AmountRecived = AmountRecived;
    }

    public int getOutstandingAmount() {
        return OutstandingAmount;
    }

    public void setOutstandingAmount(int OutstandingAmount) {
        this.OutstandingAmount = OutstandingAmount;
    }

    public String getBillEntryDate() {
        return BillEntryDate;
    }

    public void setBillEntryDate(String BillEntryDate) {
        this.BillEntryDate = BillEntryDate;
    }

    public String getBillingMode() {
        return BillingMode;
    }

    public void setBillingMode(String BillingMode) {
        this.BillingMode = BillingMode;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    
}
