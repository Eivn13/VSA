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
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dominik
 */
@Path("union")
@Singleton
public class UnionResource {

    @Context
    private UriInfo context;
    private Map<String, Zmluva> zmluvy = new HashMap();
    /**
     * Creates a new instance of UnionResource
     */
    public UnionResource() {
        Zmluva z1 = new Zmluva();
        Zmluva z2 = new Zmluva();
        
        Osoba osoba1 = new Osoba();
        Osoba osoba2 = new Osoba();
        Osoba osoba3 = new Osoba();
        osoba1.setMeno("Dominik");
        osoba2.setMeno("Evka");
        osoba3.setMeno("Marcel");
        osoba1.setVek(25);
        osoba2.setVek(23);
        osoba3.setVek(111);
        
        z1.setCislo_zmluvy("u1111");
        z2.setCislo_zmluvy("123");
        z1.setDruh("cestovne");
        z2.setDruh("zivotne");
        z1.getOsoby().add(osoba1);
        z1.getOsoby().add(osoba2);
        z2.getOsoby().add(osoba3);
        
        zmluvy.put(z1.getCislo_zmluvy(), z1);
        zmluvy.put(z2.getCislo_zmluvy(), z2);
    }

    /**
     * Retrieves representation of an instance of rest.UnionResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        return String.valueOf(zmluvy.size());
    }

    /**
     * PUT method for updating or creating an instance of UnionResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(Zmluva content) {
        if(!zmluvy.containsKey(content.getCislo_zmluvy())){
            zmluvy.put(content.getCislo_zmluvy(), content);
        }
    }
    
    /**
     * Retrieves representation of an instance of rest.UnionResource
     * @param cislo
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/cislo")
    @Produces(MediaType.APPLICATION_XML)
    public Zmluva getZmluva(@QueryParam("cislo") String cislo){
        if(zmluvy.containsKey(cislo)){
            return zmluvy.get(cislo);
        }
        return null;
    }
    
     /**
     * PUT method for updating or creating an instance of UnionResource
     * @param cislo
     * @param content representation for the resource
     */
    @POST
    @Path("{cislo}")
    @Consumes(MediaType.APPLICATION_XML)
    public void postZmluva(@PathParam("cislo") String cislo, Osoba content) {
        if(zmluvy.containsKey(cislo)){
            if(!zmluvy.get(cislo).getOsoby().contains(content)){
                zmluvy.get(cislo).getOsoby().add(content);
            }
        }
    }
}
