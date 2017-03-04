/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.guestBookingService;

/**
 *
 * @author hridoy
 */
@Path("/checkedin")
public class CheckedIn {
    guestBookingService gbs = new guestBookingService();
    
    @PUT
    @Path("/{RoomNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public void checkedIn(@PathParam("RoomNo") int RoomNo) {
        gbs.checkedInBookingRooms(RoomNo);

    }
}
