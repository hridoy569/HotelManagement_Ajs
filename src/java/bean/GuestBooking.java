/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


public class GuestBooking {

   String Title, Name, Gender, Nationality, PassportNo, VisaNo, RAddress, PhoneNo, Email, BookingDate, DateOfArival, DateOfDeparture, Relationship, CheckedStatus;
   int BookingNo, RoomNo, BookingForDays, NoOfPerson;
    public GuestBooking() {
        super();
    }

    public GuestBooking(int BookingNo, String Title, String Name, String Gender, String Nationality, String PassportNo, String VisaNo, String RAddress, String PhoneNo, String Email, String BookingDate, String DateOfArival, String DateOfDeparture, String Relationship, String CheckedStatus, int RoomNo, int BookingForDays, int NoOfPerson) {
        this.BookingNo = BookingNo;
        this.Title = Title;
        this.Name = Name;
        this.Gender = Gender;
        this.Nationality = Nationality;
        this.PassportNo = PassportNo;
        this.VisaNo = VisaNo;
        this.RAddress = RAddress;
        this.PhoneNo = PhoneNo;
        this.Email = Email;
        this.BookingDate = BookingDate;
        this.DateOfArival = DateOfArival;
        this.DateOfDeparture = DateOfDeparture;
        this.Relationship = Relationship;
        this.CheckedStatus = CheckedStatus;
        this.RoomNo = RoomNo;
        this.BookingForDays = BookingForDays;
        this.NoOfPerson = NoOfPerson;
    }

    public int getBookingNo() {
        return BookingNo;
    }

    public void setBookingNo(int BookingNo) {
        this.BookingNo = BookingNo;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getPassportNo() {
        return PassportNo;
    }

    public void setPassportNo(String PassportNo) {
        this.PassportNo = PassportNo;
    }

    public String getVisaNo() {
        return VisaNo;
    }

    public void setVisaNo(String VisaNo) {
        this.VisaNo = VisaNo;
    }

    public String getRAddress() {
        return RAddress;
    }

    public void setRAddress(String RAddress) {
        this.RAddress = RAddress;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String BookingDate) {
        this.BookingDate = BookingDate;
    }

    public String getDateOfArival() {
        return DateOfArival;
    }

    public void setDateOfArival(String DateOfArival) {
        this.DateOfArival = DateOfArival;
    }

    public String getDateOfDeparture() {
        return DateOfDeparture;
    }

    public void setDateOfDeparture(String DateOfDeparture) {
        this.DateOfDeparture = DateOfDeparture;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String Relationship) {
        this.Relationship = Relationship;
    }

    public String getCheckedStatus() {
        return CheckedStatus;
    }

    public void setCheckedStatus(String CheckedStatus) {
        this.CheckedStatus = CheckedStatus;
    }

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int RoomNo) {
        this.RoomNo = RoomNo;
    }

    public int getBookingForDays() {
        return BookingForDays;
    }

    public void setBookingForDays(int BookingForDays) {
        this.BookingForDays = BookingForDays;
    }

    public int getNoOfPerson() {
        return NoOfPerson;
    }

    public void setNoOfPerson(int NoOfPerson) {
        this.NoOfPerson = NoOfPerson;
    }
    
    
}

   