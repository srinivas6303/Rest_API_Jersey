package com.srinivas.Restdemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alienresource")
public class AlienResource {

    private AlienRepository repo = new AlienRepository();

    @GET
    @Path("/getAliens")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Alien> getAliens() {
        System.out.println("getAliens called.....");
        return repo.getAliens();
    }
    
    
    @GET
    @Path("/getAlien/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Alien getAlien(@PathParam("id") int id) {
        System.out.println("getAlien called.....");
        return repo.getAlien(id);
    }

    @POST
    @Path("/createAlien")
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    //@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Alien createAlien(Alien a1) {
        System.out.println(a1);
        repo.create(a1);
        return a1;
    }
    
    
    
    
    
    @PUT
    @Path("/updateAlien")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Alien updateAlien(Alien a1) {
        System.out.println("updateAlien called.....");
        System.out.println(a1);
        if(   repo.getAlien(a1.getAlienid()).getAlienid()==0  ) {
        	repo.create(a1);
        }
        else {
        	repo.updateAlien(a1);
        }
        return a1;
    }
    
    
    @DELETE
    @Path("/deleteAlien/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Alien deletelien(@PathParam("id") int id) {
        System.out.println("deleteAlien called.....");
        Alien a=repo.getAlien(id);
        
        if(a.getAlienid()!=0 ) {
        	repo.deleteAlien(id);
        }
       
        return a;
    }
    
}
