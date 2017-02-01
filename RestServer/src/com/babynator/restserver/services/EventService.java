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
import com.babynator.restserver.Event;
import com.babynator.restserver.db.EventDAO;

@Path("/events")
public class EventService {
	
	@PostConstruct
	public void init() {
	  // init instance
	}
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEvent( @PathParam("id") int id ) {
    	return EventDAO.getEventById(id);
    }
    
    //liste des events
    @POST
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Event> postEvent(BabyNatorUser user) {
    	ArrayList<Event> list = EventDAO.getAllByUser(user);
    	System.out.println(list);
        return list; 
    }
    
    //ajout d'un event
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEvent(Event event) {
    	System.out.println(event.toString());
    	boolean testRegister = EventDAO.addEvent(event);
    	System.out.println(event);
    	if (!testRegister)
    		return Response.status(Response.Status.CONFLICT).build();
    	else 
    		return Response.ok(event, MediaType.APPLICATION_JSON).build();
    }
}

