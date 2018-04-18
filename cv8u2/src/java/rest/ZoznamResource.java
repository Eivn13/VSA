/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dominik
 */
@Singleton
@Path("zoznam")
public class ZoznamResource {

    @Context
    private UriInfo context;
    private List<String> zoznam;

    /**
     * Creates a new instance of ZoznamResource
     */
    public ZoznamResource() {
        zoznam = new ArrayList();
        zoznam.add("Ahoj");
        zoznam.add("Cau");
    }

    /**
     * Retrieves representation of an instance of rest.ZoznamResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        StringBuilder sb = new StringBuilder(20);
        for(String s : zoznam){
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * PUT method for updating or creating an instance of ZoznamResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
        zoznam.add(content);
    }
}
