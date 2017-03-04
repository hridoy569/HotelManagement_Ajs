/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Billing;
import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.BillingService;

/**
 *
 * @author hr
 */
@Path("/bills")
public class BillingCtrl {
    BillingService bs = new BillingService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getCountries() {

        List<Map<String, String>> listOfCountries = bs.getAllCountries();
        return listOfCountries;
    }

    @GET
    @Path("/{BillNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Billing getCountryById(@PathParam("BillNo") int BillNo) {
        return bs.getBill(BillNo);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Billing addCountry(Billing b) {
        return bs.addBill(b);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Billing updateCountry(Billing b) {
        return bs.updateBill(b);

    }

    @DELETE
    @Path("/{BillNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("BillNo") int BillNo) {
        bs.deleteBill(BillNo);

    }
}
