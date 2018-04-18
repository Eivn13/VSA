/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.File;
import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Dominik
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.MULTIPART_FORM_DATA)
    public Response getDokument() {
        File f = new File("D:\\skola\\LS 2017-2018\\VSA\\cv8u4\\src\\java\\rest\\doggo.gif");
        if (!f.exists()) {
            throw new WebApplicationException(404);
        }
        String mt = new MimetypesFileTypeMap().getContentType(f);
        System.out.println(mt);              // vypisanie media-typu odosielaneho suboru
        return Response.ok(f, mt).build();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
