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
    private final Map<String, String> slovnik;  //SK
    private final Map<String, String> leksikon; //RU
    private final Map<String, Map> suppLanguages;
    /**
     * Creates a new instance of SlovnikResource
     */
    public SlovnikResource() {
        slovnik = new HashMap();
        slovnik.put("Hello", "Ahoj");
        slovnik.put("Car", "Auto");
        slovnik.put("Sloth", "Ivana");
        
        leksikon = new HashMap();
        leksikon.put("Hello", "Privet");
        leksikon.put("Car", "Avtomobiľ");
        leksikon.put("Sloth", "Ivana");
        
        suppLanguages = new HashMap();
        suppLanguages.put("SK", slovnik);
        suppLanguages.put("RU", leksikon);
    }

    /**
     * Retrieves representation of an instance of rest.SlovnikResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "Current number of lexicons: " + suppLanguages.keySet();
        /*return "Hello, this is online translator,"
                + " paste word you want translated"
                + " into the URI. Current size of dictionary: " + dictionary.values().toString();*/
    }
    
    @GET
    @Path("{lang: [A-Z].*}/{word: [A-Z].*}")
    @Produces(MediaType.TEXT_HTML)
    public String getWord(@PathParam("lang") String lang, @PathParam("word") String word) {
        if(suppLanguages.containsKey(lang)){
            if(suppLanguages.get(lang).containsKey(word)){
                return suppLanguages.get(lang).get(word).toString();
            }
            else {
                return word + " not found";
            }
        }
        else{
            return lang + " not supported!";
        }
    }

    /**
     * PUT method for updating or creating an instance of SlovnikResource
     * @param lang
     * @param word
     * @param slovo
     */
    @PUT
    @Path("{lang: [A-Z].*}/{word: [A-Z].*}")
    @Consumes(MediaType.TEXT_HTML)
    public void putWord(@PathParam("lang") String lang, @PathParam("word") String word, String slovo) {
        if(suppLanguages.containsKey(lang)){
            suppLanguages.get(lang).put(word, slovo);
        }
        else {
            Map <String, String> newLang = new HashMap();
            suppLanguages.put(lang, newLang);
            suppLanguages.get(lang).put(word, slovo);
        }
    }
    
    /**
     * DELETE method for deleting an instance of SlovnikResource
     * @param lang
     */
    @DELETE
    @Path("{lang: [A-Z].*}")
    public void deleteLang(@PathParam("lang") String lang) {
        if(suppLanguages.containsKey(lang)){
            suppLanguages.remove(lang);
        }
    }
    
    /**
     * DELETE method for deleting an instance of SlovnikResource
     * @param lang
     * @param word
     */
    @DELETE
    @Path("{lang: [A-Z].*}/{word: [A-Z].*}")
    public void deleteWord(@PathParam("lang") String lang, @PathParam("word") String word) {
        if(suppLanguages.containsKey(lang)){
            if(suppLanguages.get(lang).containsKey(word)){
                suppLanguages.get(lang).remove(word);
            }
        }
    }
}
