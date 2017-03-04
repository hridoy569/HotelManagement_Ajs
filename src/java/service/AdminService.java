/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Users;
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
public class AdminService {
    static HashMap<Integer, Users> countryIdMap = getCountryIdMap();
    
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
    
    public List<Map<String, String>> getAlladmins() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from users");
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
    
    public Users getCountry(int Id) {
        Users u = countryIdMap.get(Id);

        if (u == null) {
            throw new CountryNotFoundException("Country with Id " + Id + " not found");
        }
        return u;
    }
    
    public Users addUsers(Users u) {
//        country.setId(getMaxId() + 1);
//        countryIdMap.put(country.getId(), country);
//        return country;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into users (Name, UserName, Password, Role, ImageUrl) values(?,?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRole());
            ps.setString(5, u.getImageUrl());
            

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return u;
    }
    
    public Users updateCountry(Users u) {
//        if (country.getId() <= 0) {
//            return null;
//        }
//        countryIdMap.put(country.getId(), country);
//        return country;
//        if (u.getId() <= 0) {
//            return null;
//        }

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update users set Name=?, UserName=?, Password=?, Role=?, ImageUrl=? where Id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRole());
            ps.setString(5, u.getImageUrl());
            ps.setInt(6, u.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return u;
    }

    public void deleteCountry(int Id) {
//        countryIdMap.remove(id);
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from users where Id=?");
            ps.setInt(1, Id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static HashMap<Integer, Users> getCountryIdMap() {
        return countryIdMap;
    }

    // Utility method to get max id
    public static int getMaxId() {
        int max = 0;
        for (int Id : countryIdMap.keySet()) {
            if (max <= Id) {
                max = Id;
            }

        }
        return max;
    }
}
