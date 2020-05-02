package br.com.natheuscalaca.timemaluco;

import br.com.natheuscalaca.timemaluco.perfil.model.Perfil;
import br.com.natheuscalaca.timemaluco.perfil.service.PerfilService;
import br.com.natheuscalaca.timemaluco.utill.Util;
import br.com.natheuscalaca.timemaluco.utill.model.Filtro;
import org.apache.http.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioControl {



    @GET
    public Response teste() {
        return Response.ok("TESTE").build();
    }


}
