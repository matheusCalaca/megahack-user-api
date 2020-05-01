package br.com.natheuscalaca.timemaluco;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilControl {

    @GET
    public String hello() {
        return "{ \"hello\":0}";
    }

    @POST
    public void cadastrar() {
        System.out.println("POST");
    }
}
