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
    public ArrayList<Event> postEvent(int id_user) {
    	ArrayList<Event> list = EventDAO.getAllByUser(id_user);
    	System.out.println(list);
        return list; 
    }
    
    //ajout d'un event
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEvent(Event event) {
    	System.out.println(event.toString());
    	boolean test = EventDAO.addEvent(event);
    	System.out.println(event);
    	if (!test)
    		return Response.status(Response.Status.CONFLICT).build();
    	else 
    		return Response.ok(event, MediaType.APPLICATION_JSON).build();
    }
  
    //maj d'un event
    @POST
    @Path("/set")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setEvent(Event event) {
    	boolean test = EventDAO.setEvent(event);
    	if (!test)
    		return Response.status(Response.Status.CONFLICT).build();
    	else 
    		return Response.ok(event, MediaType.APPLICATION_JSON).build();
    }
    
    //get un event
    @POST
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEventById(int id) {
    	return EventDAO.getEventById(id);
    }    
}

