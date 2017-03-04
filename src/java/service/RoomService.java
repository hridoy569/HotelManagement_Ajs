/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
 * @author hridoy
 */
public class RoomService {
    static HashMap<Integer, Rooms> countryIdMap = getCountryIdMap();
    
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

    public List<Map<String, String>> getAllRooms() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from rooms");
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
    
    public Rooms getCountry(int RoomNo) {
        Rooms r = countryIdMap.get(RoomNo);

        if (r == null) {
            throw new CountryNotFoundException("Country with RoomNo " + RoomNo + " not found");
        }
        return r;
    }
    
    public Rooms addRoom(Rooms r) {
//        country.setId(getMaxId() + 1);
//        countryIdMap.put(country.getId(), country);
//        return country;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into rooms (RoomType, RoomRent, Status)values(?,?,?)");
//            ps.setInt(1, r.getRoomNo());
            ps.setString(1, r.getRoomType());
            ps.setInt(2, r.getRoomRent());
            ps.setString(3, "Available");
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return r;
    }

    public Rooms updateRoom(Rooms r) {

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update rooms set RoomType=?, RoomRent=?, Status=? where RoomNo=?");
            ps.setString(1, r.getRoomType());
            ps.setInt(2, r.getRoomRent());
            ps.setString(3, r.getStatus());
            ps.setInt(4, r.getRoomNo());
            
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return r;
    }

    public void deleteRoom(int RoomNo) {
//        countryIdMap.remove(id);
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from rooms where RoomNo=?");
            ps.setInt(1, RoomNo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static HashMap<Integer, Rooms> getCountryIdMap() {
        return countryIdMap;
    }

    // Utility method to get max id
    public static int getMaxId() {
        int max = 0;
        for (int RoomNo : countryIdMap.keySet()) {
            if (max <= RoomNo) {
                max = RoomNo;
            }

        }
        return max;
    }
}
