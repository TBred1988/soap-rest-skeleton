package com.example.rest;

import com.example.controllers.business.ItemsService;
import com.example.controllers.business.UserService;
import com.example.orm.entities.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("/items-service/")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
@Provider
@Service
public class ItemsResource {

    @Autowired
    private ItemsService itemsService;

    @GET
    @Path("/items/list-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Items> listItems(){
        return itemsService.getAllItems();
    }

    @POST
    @Path("/items/create/{name}/{shortName}/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    public Boolean createItem(@PathParam("name") String name, @PathParam("price") Double price, @PathParam("shortName") String shortName){
        return itemsService.createItem(name, price, shortName);
    }

}
