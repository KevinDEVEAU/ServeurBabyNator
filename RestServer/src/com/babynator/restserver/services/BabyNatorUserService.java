package com.babynator.restserver.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.babynator.restserver.BabyNatorUser;

@Path("/users")
public class BabyNatorUserService {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BabyNatorUser getUser( @PathParam("id") int id ) {
    	BabyNatorUser user = new BabyNatorUser(id, "jdoe", 22);
        return user;
    }
    
    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BabyNatorUser postUser(BabyNatorUser baby) {
    	System.out.println(baby.toString());
    	return baby;
       // return null; 
    }
}

