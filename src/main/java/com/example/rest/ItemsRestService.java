package com.example.rest;

import com.example.controllers.business.ItemsService;
import com.example.controllers.business.UserService;
import com.example.orm.entities.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("/items-service/")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN})
@Provider
@Service
public class ItemsRestService {

    @Autowired
    private ItemsService itemsService;

    @GET
    @Path("/items/list-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Items> listItems(){
        return itemsService.getAllItems();
    }

}
