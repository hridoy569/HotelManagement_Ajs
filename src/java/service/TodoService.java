/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Todo;
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
public class TodoService {
    static HashMap<Integer, Todo> countryIdMap = getCountryIdMap();

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

    public List<Map<String, String>> getAllTodos() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from todo");
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
            System.out.println(list);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Todo getTodo(int id) {
        Todo t = countryIdMap.get(id);

        if (t == null) {
            throw new CountryNotFoundException("Country with id " + id + " not found");
        }
        return t;
    }

    public Todo addTodo(Todo t) {
//        country.setId(getMaxId() + 1);
//        countryIdMap.put(country.getId(), country);
//        return country;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into todo (Actions, Date, Time)values(?,?,?)");
            ps.setString(1, t.getActions());
            ps.setString(2, t.getDate());
            ps.setString(3, t.getTime());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return t;
    }

    public Todo updateTodo(Todo t) {

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update todo set Actions=?, Date=?, Time=? where id=?");
            ps.setString(1, t.getActions());
            ps.setString(2, t.getDate());
            ps.setString(3, t.getTime());
            ps.setInt(4, t.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return t;
    }

    public void deleteTodo(int id) {
//        countryIdMap.remove(id);
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from todo where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static HashMap<Integer, Todo> getCountryIdMap() {
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
