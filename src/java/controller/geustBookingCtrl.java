/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.GuestBooking;
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
import service.guestBookingService;

/**
 *
 * @author hr
 */
@Path("/guestBooking")
public class geustBookingCtrl {
    guestBookingService gbs = new guestBookingService();
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getGuests() {

        List<Map<String, String>> listOfGuests = gbs.getAllGuests();
        return listOfGuests;
    }
    
    @GET
    @Path("/{BookingNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public GuestBooking getCountryById(@PathParam("BookingNo") int BookingNo) {
        return gbs.getCountry(BookingNo);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public GuestBooking addGuest(GuestBooking gb) {
        return gbs.addGuest(gb);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public GuestBooking updateCountry(GuestBooking gb) {
        return gbs.updateCountry(gb);

    }

    @DELETE
    @Path("/{BookingNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("BookingNo") int BookingNo) {
        gbs.deleteCountry(BookingNo);

    }

}
