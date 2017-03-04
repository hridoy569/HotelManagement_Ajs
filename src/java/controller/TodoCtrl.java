/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Todo;
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
import service.TodoService;

/**
 *
 * @author hridoy
 */
@Path("/todos")
public class TodoCtrl {
    TodoService td = new TodoService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getCountries() {

        List<Map<String, String>> listOfCountries = td.getAllTodos();
        return listOfCountries;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getCountryById(@PathParam("id") int id) {
        return td.getTodo(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Todo addCountry(Todo t) {
        return td.addTodo(t);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Todo updateCountry(Todo t) {
        return td.updateTodo(t);

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("id") int id) {
        td.deleteTodo(id);

    }

}


