package com.babynator.restserver.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.babynator.restserver.BabyNatorUser;
import com.babynator.restserver.db.UserBabynatorDAO;

@Path("/users")
public class BabyNatorUserService {
	
	@PostConstruct
	public void init() {
	  // init instance
	}
   
    //service pour se connecter
    @POST
    @Path("/connect")
    @Produces(MediaType.APPLICATION_JSON)
    public BabyNatorUser postUser(BabyNatorUser baby) {
    	baby = UserBabynatorDAO.seConnecter(baby);
    	return baby; 
    }
    
    //service pour se connecter
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(BabyNatorUser baby) {
    	boolean testRegister = UserBabynatorDAO.registerUser(baby);
    	if (!testRegister)
    		return Response.status(Response.Status.CONFLICT).build();
    	else 
    		return Response.ok(baby, MediaType.APPLICATION_JSON).build();
    }
}

