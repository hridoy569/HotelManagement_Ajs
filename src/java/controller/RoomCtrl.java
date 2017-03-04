/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Rooms;
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
import service.RoomService;

/**
 *
 * @author hridoy
 */
@Path("/rooms")
public class RoomCtrl {
    RoomService rss = new RoomService();
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getCountries() {

        List<Map<String, String>> listOfCountries = rss.getAllRooms();
        return listOfCountries;
    }
    
    @GET
    @Path("/{RoomNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Rooms getCountryById(@PathParam("RoomNo") int RoomNo) {
        return rss.getCountry(RoomNo);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Rooms addCountry(Rooms r) {
        return rss.addRoom(r);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Rooms updateCountry(Rooms r) {
        return rss.updateRoom(r);

    }

    @DELETE
    @Path("/{RoomNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("RoomNo") int RoomNo) {
        rss.deleteRoom(RoomNo);

    }
}
