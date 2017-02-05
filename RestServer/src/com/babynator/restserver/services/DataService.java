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

import com.babynator.restserver.Baby;
import com.babynator.restserver.BabyNatorUser;
import com.babynator.restserver.Data;
import com.babynator.restserver.db.BabyDAO;
import com.babynator.restserver.db.DataDAO;

@Path("/datas")
public class DataService {

	@PostConstruct
	public void init() {
	  // init instance
	}
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Data getData( @PathParam("id") int id ) {
    	return new Data();
    }
    
    //liste des bébés
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addData(Data data) {
    	System.out.println(data.toString());
    	boolean testAddData = DataDAO.addDataBirthday(data);
    	if (!testAddData)
    		return Response.status(Response.Status.CONFLICT).build();
    	else 
    		return Response.status(Response.Status.ACCEPTED).build();
    }
}
