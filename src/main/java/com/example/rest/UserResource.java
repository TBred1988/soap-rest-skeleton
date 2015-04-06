package com.example.rest;

import com.example.controllers.business.UserService;
import com.example.orm.entities.UserPoint;
import com.example.orm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;


@Path("/user-service/")
@Produces({"application/xml","text/plain","text/html"})
@Provider
@Service
public class UserResource {

    @Autowired
    private UserService userService;

    @GET
    @Path("/users/login/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(@PathParam("email") String email, @PathParam("password") String password){
        String result = userService.getUserJson(password, email);
        if(result != null) {
            return Response.status(200).entity(result).build();
        }else{
            return Response.status(500).entity("Login problem with data").build();
        }
    }

    @GET
    @Path("/users/hello")
    @Produces("text/html")
    public Response getHelloUser(){
        System.out.println("get hello called");
        Response result = Response.ok("hello").build();
        return result;
    }

    @POST
    @Path("/users/hello")
    public Response postHelloUser(){
        System.out.println("post hello called");
        Response result = Response.ok("hello").build();
        return result;
    }

    @GET
    @Path("/users/points/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserPoint getUserPoints(@PathParam("email") String email, @PathParam("password") String password){
        return userService.getUserPoints(password, email);
    }
}
