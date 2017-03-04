/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.GuestBooking;
import bean.Rooms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hr
 */
public class guestBookingService {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String str;
    int num;
    String bookingDate;
    
//    public guestBookingService() {
//        getAllGuests();
//    }
    static HashMap<Integer, GuestBooking> countryIdMap = getCountryIdMap();
    
    
    public Connection getConnection() {
        
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_java", "root", "123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public List<Map<String, String>> getAllGuests() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from guestBooking");
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                Map map = new HashMap();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    String key = meta.getColumnName(i);
                    String value = rs.getString(key);
                    map.put(key, value);
                }
                list.add(map);

            }
//            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public GuestBooking getCountry(int BookingNo) {
        GuestBooking gb = countryIdMap.get(BookingNo);

        if (gb == null) {
            throw new CountryNotFoundException("Country with BookingNo " + BookingNo + " not found");
        }
        return gb;
    }
    
     public GuestBooking addGuest(GuestBooking gb) {

        try {
            Connection con = getConnection();
            

            ps = con.prepareStatement("SELECT curdate()");
            rs = ps.executeQuery();
            rs.next();
            bookingDate = rs.getString(1);
            
            PreparedStatement ps = con.prepareStatement("insert into guestBooking (Title, Name, Gender, "
                    + "Nationality, PassportNo, VisaNo, RAddress, PhoneNo, Email, RoomNo, BookingDate, DateOfArival, "
                    + "DateOfDeparture, BookingForDays, NoOfPerson, Relationship, CheckedStatus)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, gb.getTitle());
            ps.setString(2, gb.getName());
            ps.setString(3, gb.getGender());
            ps.setString(4, gb.getNationality());
            ps.setString(5, gb.getPassportNo());
            ps.setString(6, gb.getVisaNo());
            ps.setString(7, gb.getRAddress());
            ps.setString(8, gb.getPhoneNo());
            ps.setString(9, gb.getEmail());
            ps.setInt(10, gb.getRoomNo());
            ps.setString(11, bookingDate);
            ps.setString(12, gb.getDateOfArival());
            ps.setString(13, gb.getDateOfDeparture());
            ps.setInt(14, gb.getBookingForDays());
            ps.setInt(15, gb.getNoOfPerson());
            ps.setString(16, gb.getRelationship());
            ps.setString(17, "Not Yet");
            ps.executeUpdate();
            System.out.println("Inserted");
       
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
         
        return gb;
    } 
     
     public GuestBooking updateCountry(GuestBooking gb) {
//        if (country.getId() <= 0) {
//            return null;
//        }
//        countryIdMap.put(country.getId(), country);
//        return country;
        if (gb.getBookingNo()<= 0) {
            return null;
        }

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update guestBooking set Title=?, Name=?, Gender=?, "
                    + "Nationality=?, PassportNo=?, VisaNo=?, RAddress=?, PhoneNo=?, Email=?, RoomNo=?, DateOfArival=?, "
                    + "DateOfDeparture=?, BookingForDays=?, NoOfPerson=?, Relationship=?, CheckedStatus=? where BookingNo=?");
            ps.setString(1, gb.getTitle());
            ps.setString(2, gb.getName());
            ps.setString(3, gb.getGender());
            ps.setString(4, gb.getNationality());
            ps.setString(5, gb.getPassportNo());
            ps.setString(6, gb.getVisaNo());
            ps.setString(7, gb.getRAddress());
            ps.setString(8, gb.getPhoneNo());
            ps.setString(9, gb.getEmail());
            ps.setInt(10, gb.getRoomNo());
            ps.setString(11, gb.getDateOfArival());
            ps.setString(12, gb.getDateOfDeparture());
            ps.setInt(13, gb.getBookingForDays());
            ps.setInt(14, gb.getNoOfPerson());
            ps.setString(15, gb.getRelationship());
            ps.setString(16, gb.getCheckedStatus());
            ps.setInt(17, gb.getBookingNo());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return gb;
    }

    public void deleteCountry(int BookingNo) {
//        countryIdMap.remove(id);
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from guestBooking where BookingNo=?");
            ps.setInt(1, BookingNo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static HashMap<Integer, GuestBooking> getCountryIdMap() {
        return countryIdMap;
    }

    // Utility method to get max id
    public static int getMaxId() {
        int max = 0;
        for (int BookingNo : countryIdMap.keySet()) {
            if (max <= BookingNo) {
                max = BookingNo;
            }

        }
        return max;
    }
   
    public void checkedInBookingRooms(int RoomNo) {

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update guestBooking set CheckedStatus=? where RoomNo=?");
            ps.setString(1, "Checked In");
            ps.setInt(2, RoomNo);
            ps.executeUpdate();
            
            ps = con.prepareStatement("update rooms set Status=? where RoomNo=?");
            ps.setString(1, "NotAvailable");
            ps.setInt(2, RoomNo);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        
    }
    
    public void checkedOutBookingRooms(int RoomNo) {

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update guestBooking set CheckedStatus=? where RoomNo=?");
            ps.setString(1, "Checked Out");
            ps.setInt(2, RoomNo);
            ps.executeUpdate();
            
            ps = con.prepareStatement("update rooms set Status=? where RoomNo=?");
            ps.setString(1, "Available");
            ps.setInt(2, RoomNo);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        
    }
}
