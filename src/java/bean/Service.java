/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


public class Service{

    String  Breakfast, Lunch, Dinner, Laundary, Telephone, Gym, SwimmingPool,  ServiceDate;
    int id, TotalServiceCharge, BookingNo;
    public Service() {
        super();
    }

    public Service(String Breakfast, String Lunch, String Dinner, String Laundary, String Telephone, String Gym, String SwimmingPool, String ServiceDate, int id, int TotalServiceCharge, int BookingNo) {
        this.Breakfast = Breakfast;
        this.Lunch = Lunch;
        this.Dinner = Dinner;
        this.Laundary = Laundary;
        this.Telephone = Telephone;
        this.Gym = Gym;
        this.SwimmingPool = SwimmingPool;
        this.ServiceDate = ServiceDate;
        this.id = id;
        this.TotalServiceCharge = TotalServiceCharge;
        this.BookingNo = BookingNo;
    }

    public String getBreakfast() {
        return Breakfast;
    }

    public void setBreakfast(String Breakfast) {
        this.Breakfast = Breakfast;
    }

    public String getLunch() {
        return Lunch;
    }

    public void setLunch(String Lunch) {
        this.Lunch = Lunch;
    }

    public String getDinner() {
        return Dinner;
    }

    public void setDinner(String Dinner) {
        this.Dinner = Dinner;
    }

    public String getLaundary() {
        return Laundary;
    }

    public void setLaundary(String Laundary) {
        this.Laundary = Laundary;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getGym() {
        return Gym;
    }

    public void setGym(String Gym) {
        this.Gym = Gym;
    }

    public String getSwimmingPool() {
        return SwimmingPool;
    }

    public void setSwimmingPool(String SwimmingPool) {
        this.SwimmingPool = SwimmingPool;
    }

    public String getServiceDate() {
        return ServiceDate;
    }

    public void setServiceDate(String ServiceDate) {
        this.ServiceDate = ServiceDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalServiceCharge() {
        return TotalServiceCharge;
    }

    public void setTotalServiceCharge(int TotalServiceCharge) {
        this.TotalServiceCharge = TotalServiceCharge;
    }

    public int getBookingNo() {
        return BookingNo;
    }

    public void setBookingNo(int BookingNo) {
        this.BookingNo = BookingNo;
    }

  
    
}
