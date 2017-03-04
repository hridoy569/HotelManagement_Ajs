/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Service;
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
import service.ServiceService;

/**
 *
 * @author hridoy
 */
@Path("/services")
public class ServiceCtrl {
    ServiceService ss = new ServiceService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getServices() {

        List<Map<String, String>> listOfCountries = ss.getAllServices();
        return listOfCountries;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Service getCountryById(@PathParam("id") int id) {
        return ss.getService(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Service addCountry(Service s) {
        return ss.addService(s);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Service updateCountry(Service s) {
        return ss.updateService(s);

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("id") int id) {
        ss.deleteService(id);

    }

}
