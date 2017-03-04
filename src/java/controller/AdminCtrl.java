/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Users;
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
import service.AdminService;

/**
 *
 * @author hridoy
 */
@Path("/admins")
public class AdminCtrl {
    AdminService as = new AdminService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getCountries() {

        List<Map<String, String>> listOfCountries = as.getAlladmins();
        return listOfCountries;
    }
    
    @GET
    @Path("/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getCountryById(@PathParam("Id") int Id) {
        return as.getCountry(Id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Users addUser(Users u) {
        return as.addUsers(u);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Users updateCountry(Users u) {
        return as.updateCountry(u);

    }

    @DELETE
    @Path("/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("Id") int Id) {
        as.deleteCountry(Id);

    }
}
