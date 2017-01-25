package com.babynator.restserver.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.babynator.restserver.BabyNatorUser;
import com.babynator.restserver.db.UserBabynatorDAO;

@Path("/users")
public class BabyNatorUserService {
	
	@PostConstruct
	public void init() {
	  // init instance
	}
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BabyNatorUser getUser( @PathParam("id") int id ) {
    	//BabyNatorUser user = new BabyNatorUser(id, "jdoe", 22);
        return null;
    }
    
    //service pour se connecter
    @POST
    @Path("/connect")
    @Produces(MediaType.APPLICATION_JSON)
    public BabyNatorUser postUser(BabyNatorUser baby) {
    	System.out.println(baby.toString());
    	baby = UserBabynatorDAO.seConnecter(baby);
    	System.out.println(baby);
        return baby; 
    }
}

