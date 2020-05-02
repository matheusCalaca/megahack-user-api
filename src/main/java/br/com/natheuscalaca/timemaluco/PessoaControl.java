package br.com.natheuscalaca.timemaluco;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaControl {



    @GET
    public Response teste() {
        return Response.ok("TESTE").build();
    }


}
