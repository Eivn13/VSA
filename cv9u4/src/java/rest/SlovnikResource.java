/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


/**
 * REST Web Service
 *
 * @author Dominik
 */
@Path("slovnik")
@Singleton
public class SlovnikResource {

    @Context
    private UriInfo context;
    private final Map<String, String> dictionary;

    /**
     * Creates a new instance of SlovnikResource
     */
    public SlovnikResource() {
        dictionary = new HashMap();
        dictionary.put("Hello", "Ahoj");
        dictionary.put("Car", "Auto");
        dictionary.put("Sloth", "Ivana");
    }

    /**
     * Retrieves representation of an instance of rest.SlovnikResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "Hello, this is online translator,"
                + " paste word you want translated"
                + " into the URI. Current size of dictionary: " + dictionary.values().toString();
    }
    
    @GET
    @Path("{word: [A-Z].*}")
    @Produces(MediaType.TEXT_HTML)
    public String getWord(@PathParam("word") String content) {
        if(dictionary.containsKey(content)){
            return dictionary.get(content);
        }
        return "Not found";
    }

    /**
     * PUT method for updating or creating an instance of SlovnikResource
     * @param content
     * @param slovo
     */
    @PUT
    @Path("{word: [A-Z].*}/{slovo: [A-Z].*}")
    @Consumes(MediaType.TEXT_HTML)
    public void putWord(@PathParam("word") String content, @PathParam("slovo") String slovo) {
        if(dictionary.containsKey(content)){
            dictionary.replace(content, slovo);
        }
        else{
            dictionary.put(content, slovo);
        }
    }
    
    /**
     * DELETE method for deleting an instance of SlovnikResource
     * @param word
     */
    @DELETE
    @Path("{word: [A-Z].*}")
    public void deleteWord(@PathParam("word") String word) {
        if(dictionary.containsKey(word)){
            dictionary.remove(word);
        }
    }
}
