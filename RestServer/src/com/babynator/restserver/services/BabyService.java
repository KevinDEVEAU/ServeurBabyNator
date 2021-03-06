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
import com.babynator.restserver.db.EventDAO;

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
    	return BabyDAO.getBabyById(id);
    }
    
    //liste des b�b�s
    @POST
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Baby> postEvent(int user) {
    	ArrayList<Baby> list = BabyDAO.getAllByUser(user);
    	return list; 
    }
    
    //ajout d'un b�b�
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEvent(Baby baby) {
    	boolean testRegister = BabyDAO.addBaby(baby);
    	if (!testRegister)
    		return Response.status(Response.Status.CONFLICT).build();
    	else 
    		return Response.ok(BabyDAO.getLastInsertBaby(baby.getId_user()), MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeBaby(int id) {    	
    	boolean test = BabyDAO.removeBaby(id);
    	if (!test)
    		return Response.status(Response.Status.CONFLICT).build();
    	else 
    		return Response.ok(test, MediaType.APPLICATION_JSON).build();
    }
}

