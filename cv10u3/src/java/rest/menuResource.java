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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author xpruzinsky
 */
@Path("menu")
@Singleton
public class MenuResource {

    @Context
    private UriInfo context;
    private Map<String, Menu> menus = new HashMap();
    private final Menu PON;
    private final Menu UT;
    private final Menu STR;
    private final Menu STV;
    private final Menu PIA;

    /**
     * Creates a new instance of MenuResource
     */
    public MenuResource() {
        PON = new Menu();
        UT = new Menu();
        STR = new Menu();
        STV = new Menu();
        PIA = new Menu();
        
        Jedlo j0 = new Jedlo();
        Jedlo j1 = new Jedlo();
        Jedlo j2 = new Jedlo();
        Jedlo j3 = new Jedlo();
        Jedlo j4 = new Jedlo();
        
        j0.setNazov("Vyprazany syr");
        j0.setCena((double) 3.20);
        j1.setNazov("Hamburger");
        j1.setCena((double) 6.66);
        j2.setNazov("Rezen");
        j2.setCena((double) 3.99);
        j3.setNazov("Halusky");
        j3.setCena((double) 2.99);
        j4.setNazov("Spagety");
        j4.setCena((double) 4.99);
        
        PON.setDen("PON");
        PON.getPonuka().put(1, j0);
        PON.getPonuka().put(2, j1);
        PON.getPonuka().put(3, j2);
        UT.setDen("UT");
        UT.getPonuka().put(1, j0);
        UT.getPonuka().put(2, j2);
        UT.getPonuka().put(3, j4);
        STR.setDen("STR");
        STR.getPonuka().put(1, j0);
        STR.getPonuka().put(2, j1);
        STR.getPonuka().put(3, j3);
        STV.setDen("STV");
        STV.getPonuka().put(1, j0);
        STV.getPonuka().put(2, j1);
        STV.getPonuka().put(3, j4);
        PIA.setDen("PIA");
        PIA.getPonuka().put(1, j0);
        PIA.getPonuka().put(2, j3);
        PIA.getPonuka().put(3, j4);
        
        menus.put(PON.getDen(), PON);
        menus.put(UT.getDen(), UT);
        menus.put(STR.getDen(), STR);
        menus.put(STV.getDen(), STV);
        menus.put(PIA.getDen(), PIA);
    }

    /**
     * Retrieves representation of an instance of rest.MenuResource
     * @param den
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{den: [A-Z].*}")
    @Produces(MediaType.APPLICATION_XML)
    public Menu getDen(@PathParam("den") String den) {
        return menus.get(den);
    }
    
    /**
     * Retrieves representation of an instance of rest.MenuResource
     * @param den
     * @param jedlo
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{den}/{index}") //REGEXY AZ NAKONIEC lebo to nejde s nimi
    @Produces(MediaType.APPLICATION_XML)
    public Jedlo getJedlo(@PathParam("den") String den, @PathParam("index") Integer jedlo) {
        return menus.get(den).getPonuka().get(jedlo);
    }

    /**
     * PUT method for updating or creating an instance of MenuResource
     * @param content representation for the resource
     * @param den
     * @param jedlo
     */
    @PUT
    @Path("{den}/{index}")
    @Consumes(MediaType.APPLICATION_XML)
    public void putJedlo(Jedlo content, @PathParam("den") String den, @PathParam("index") Integer jedlo) {
        menus.get(den).getPonuka().put(jedlo, content);
    }
    
    /**
     * DELETE method for updating or creating an instance of MenuResource
     * @param den
     * @param jedlo
     */
    @DELETE
    @Path("{den}/{index}")
    public void deleteJedlo(@PathParam("den") String den, @PathParam("index") Integer jedlo) {
        menus.get(den).getPonuka().remove(jedlo);
    }
    
    
}
