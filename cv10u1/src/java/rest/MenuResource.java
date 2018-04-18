/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dominik
 * par slov od autora, nie je to vobec vypracovane podla zadania ale beha to
 * s objektami, cize whatever
 */
@Path("menu")
@Singleton
public class MenuResource {

    @Context
    private UriInfo context;
    private final Map<Integer, Jedlo> menu;

    /**
     * Creates a new instance of MenuResource
     */
    public MenuResource() {
        Jedlo jedlo1 = new Jedlo("Halusky", (double) 0.99);
        Jedlo jedlo2 = new Jedlo("Rezen", (double) 1.99);
        Jedlo jedlo3 = new Jedlo("Gulas", (double) 2.99);
        menu = new HashMap();
        menu.put(0, jedlo1);
        menu.put(1, jedlo2);
        menu.put(2, jedlo3);
    }

    /**
     * Retrieves representation of an instance of rest.MenuResource
     * @return an instance of java.lang.String
     */
    @GET 
    @Produces(MediaType.APPLICATION_XML)
    public String getMenu() {
        StringBuilder sb = new StringBuilder(32);
        for(Integer key : menu.keySet()){
            sb.append(menu.get(key).getNazov());
            sb.append(" = ");
            sb.append(menu.get(key).getCena());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * PUT method for updating or creating an instance of MenuResource
     * @param content
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void postJedlo(Jedlo content) {
        int max = 0;
        for(Integer key : menu.keySet()){
            if(max < key){
                max = key;
            }
        }
        System.out.println(max);
        menu.put(max+1, content);
    }
    
    /**
     * Retrieves representation of an instance of rest.MenuResource
     * @param index
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{index: [0-9]+}")    
    @Produces(MediaType.APPLICATION_XML)
    public Jedlo getJedlo(@PathParam("index") int index) {
        if(menu.containsKey(index)){
            return menu.get(index);
            //ako to mam vratit ako jedlo, ked mi to hadze MessageBodyWriter
            //not found error
        }
        Jedlo jedlo = new Jedlo("Nemame", (double) 0.00);
        return jedlo;
    }

    /**
     * PUT method for updating or creating an instance of MenuResource
     * @param index
     * @param content
     */
    @PUT
    @Path("{index: [0-9]+}")
    @Consumes(MediaType.APPLICATION_XML)
    public void putJedlo(@PathParam("index") int index, Jedlo content) {
        menu.put(index, content); //PUT aj POST
    }
    
    /**
     * DELETE method for deleting an instance of MenuResource
     * @param index
     */
    @DELETE
    @Path("{index: [0-9]+}")
    public void deleteJedlo(@PathParam("index") int index) {
        if(menu.containsKey(index)){
            menu.remove(index);
        }
    }
}
