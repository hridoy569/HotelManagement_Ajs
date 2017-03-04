/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Service;
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
 * @author hridoy
 */
public class ServiceService {
    String serviceDate;
    PreparedStatement ps;
    ResultSet rs;
    
    static HashMap<Integer, Service> countryIdMap = getCountryIdMap();

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

    public List<Map<String, String>> getAllServices() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from service");
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

    public Service getService(int id) {
        Service s = countryIdMap.get(id);

        if (s == null) {
            throw new CountryNotFoundException("Country with id " + id + " not found");
        }
        return s;
    }

    public Service addService(Service s) {
//        country.setId(getMaxId() + 1);
//        countryIdMap.put(country.getId(), country);
//        return country;
        try {
            Connection con = getConnection();
            
            ps = con.prepareStatement("SELECT curdate()");
            rs = ps.executeQuery();
            rs.next();
            serviceDate = rs.getString(1);
            PreparedStatement ps = con.prepareStatement("insert into service (Breakfast, Lunch, Dinner, Laundary, Telephone, "
                    + "Gym, SwimmingPool, TotalServiceCharge, BookingNo, ServiceDate)values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, s.getBreakfast());
            ps.setString(2, s.getLunch());
            ps.setString(3, s.getDinner());
            ps.setString(4, s.getLaundary());
            ps.setString(5, s.getTelephone());
            ps.setString(6, s.getGym());
            ps.setString(7, s.getSwimmingPool());
            ps.setInt(8, s.getTotalServiceCharge());
            ps.setInt(9, s.getBookingNo());
            ps.setString(10, serviceDate);
            

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return s;
    }

    public Service updateService(Service s) {
//        if (country.getId() <= 0) {
//            return null;
//        }
//        countryIdMap.put(country.getId(), country);
//        return country;
//        if (country.getId() <= 0) {
//            return null;
//        }

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update service set Breakfast=?, Lunch=? where id=?");
            ps.setString(1, s.getBreakfast());
            ps.setString(2, s.getLunch());
            ps.setInt(3, s.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    public void deleteService(int id) {
//        countryIdMap.remove(id);
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from service where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static HashMap<Integer, Service> getCountryIdMap() {
        return countryIdMap;
    }

    // Utility method to get max id
    public static int getMaxId() {
        int max = 0;
        for (int id : countryIdMap.keySet()) {
            if (max <= id) {
                max = id;
            }

        }
        return max;
    }
}
