package com.babynator.restserver.services;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.babynator.restserver.BabyNatorUser;
import com.babynator.restserver.Data;
import com.babynator.restserver.Baby;
import com.babynator.restserver.db.BabyDAO;

@Path("/babies")
public class BabyService {
	
	@PostConstruct
	public void init() {
	  // init instance
	}
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Baby getEvent( @PathParam("id") int id ) {
    	System.out.println(BabyDAO.getBabyById(id).toString());
    	return BabyDAO.getBabyById(id);
    }
    
    //liste des bébés
    @POST
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Baby> postEvent(BabyNatorUser user) {
    	ArrayList<Baby> list = BabyDAO.getAllByUser(user);
    	System.out.println(list);
        return list; 
    }
    
    //ajout d'un bébé
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEvent(Baby baby) {
    	System.out.println(baby.toString());
    	boolean testRegister = BabyDAO.addBaby(baby);
    	System.out.println(baby);
    	if (!testRegister)
    		return Response.status(Response.Status.CONFLICT).build();
    	else 
    		return Response.ok(BabyDAO.getLastInsertBaby(baby.getId_user()), MediaType.APPLICATION_JSON).build();
    }
}

