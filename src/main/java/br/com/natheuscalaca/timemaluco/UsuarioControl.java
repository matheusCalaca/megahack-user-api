package br.com.natheuscalaca.timemaluco;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioControl {



    @GET
    public Response teste() {
        return Response.ok("TESTE").build();
    }


}
