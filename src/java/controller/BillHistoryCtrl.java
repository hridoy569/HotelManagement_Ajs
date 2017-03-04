/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.BillHistoryService;

/**
 *
 * @author hridoy
 */
@Path("/billhistory")
public class BillHistoryCtrl {
    BillHistoryService bh = new BillHistoryService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getBillHistory() {

        List<Map<String, String>> listOfCountries = bh.getAllBillHistory();
        return listOfCountries;
    }
    
    @DELETE
    @Path("/{BillNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("BillNo") int BillNo) {
        bh.deleteBill(BillNo);

    }
}
