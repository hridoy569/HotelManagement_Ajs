/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Billing;
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
public class BillingService {
    static HashMap<Integer, Billing> countryIdMap = getCountryIdMap();

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

    public List<Map<String, String>> getAllCountries() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from billing");
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

    public Billing getBill(int BillNo) {
        Billing b = countryIdMap.get(BillNo);

        if (b == null) {
            throw new CountryNotFoundException("Country with BillNo " + BillNo + " not found");
        }
        return b;
    }

    public Billing addBill(Billing b) {
//        country.setId(getMaxId() + 1);
//        countryIdMap.put(country.getId(), country);
//        return country;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into billing (BillEntryDate, BookingNo, BillingDays, "
                    + "TotalRoomRent, ServiceCharge, GrossBillAmount, ServiceTax, DiscountAllowed, NetBillAmount, "
                    + "BillingMode, CardNumber, AmountRecived, OutstandingAmount)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, b.getBillEntryDate());
            ps.setInt(2, b.getBookingNo());
            ps.setInt(3, b.getBillingDays());
            ps.setInt(4, b.getTotalRoomRent());
            ps.setInt(5, b.getServiceCharge());
            ps.setInt(6, b.getGrossBillAmount());
            ps.setInt(7, b.getServiceTax());
            ps.setInt(8, b.getDiscountAllowed());
            ps.setInt(9, b.getNetBillAmount());
            ps.setString(10, b.getBillingMode());
            ps.setString(11, b.getCardNumber());
            ps.setInt(12, b.getAmountRecived());
            ps.setInt(13, b.getOutstandingAmount());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }

    public Billing updateBill(Billing b) {
//        if (country.getId() <= 0) {
//            return null;
//        }
//        countryIdMap.put(country.getId(), country);
//        return country;
//        if (b.getId() <= 0) {
//            return null;
//        }

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update billing set BillEntryDate=?, BookingNo=?, BillingDays=?, "
                    + "TotalRoomRent=?, ServiceCharge=?, GrossBillAmount=?, ServiceTax=?, DiscountAllowed=?, "
                    + "NetBillAmount=?, BillingMode=?, CardNumber=?, AmountRecived=?, OutstandingAmount=? where BillNo=?");
            ps.setString(1, b.getBillEntryDate());
            ps.setInt(2, b.getBookingNo());
            ps.setInt(3, b.getBillingDays());
            ps.setInt(4, b.getTotalRoomRent());
            ps.setInt(5, b.getServiceCharge());
            ps.setInt(6, b.getGrossBillAmount());
            ps.setInt(7, b.getServiceTax());
            ps.setInt(8, b.getDiscountAllowed());
            ps.setInt(9, b.getNetBillAmount());
            ps.setString(10, b.getBillingMode());
            ps.setString(11, b.getCardNumber());
            ps.setInt(12, b.getAmountRecived());
            ps.setInt(13, b.getOutstandingAmount());
            ps.setInt(14, b.getBillNo());
            
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return b;
    }

    public void deleteBill(int BillNo) {
//        countryIdMap.remove(id);
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("delete from billing where BillNo=?");
            ps.setInt(1, BillNo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static HashMap<Integer, Billing> getCountryIdMap() {
        return countryIdMap;
    }

    // Utility method to get max id
    public static int getMaxId() {
        int max = 0;
        for (int BillNo : countryIdMap.keySet()) {
            if (max <= BillNo) {
                max = BillNo;
            }

        }
        return max;
    }
}
