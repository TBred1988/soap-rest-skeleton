package com.example.rest;

/**
 * Created by Márta on 2014.07.26..
 */

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Path("/user-service/")
@Produces({"application/xml","text/plain","text/html"})
@Provider
public class UserRestService {

    @GET
    @Path("/users/login/{userId}")
    @Produces("text/plain")
    public Response loginUser(@PathParam("userId") String userId){
        System.out.println("called");
        Response result = Response.ok("login").build();
        return result;
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

}
