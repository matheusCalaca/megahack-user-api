package br.com.natheuscalaca.timemaluco;

import br.com.natheuscalaca.timemaluco.perfil.model.Perfil;
import br.com.natheuscalaca.timemaluco.perfil.service.PerfilService;
import br.com.natheuscalaca.timemaluco.utill.Util;
import org.apache.http.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilControl {

    @Inject
    private PerfilService perfilService;

    @Inject
    private Util util;

    @GET
    public String hello() {
        return "{ \"hello\":0}";
    }

    @POST
    public Response cadastrar(Perfil perfil) {
        try {
            Perfil cadastro = perfilService.cadastrar(perfil);
            return Response.ok(cadastro).status(HttpStatus.SC_CREATED).build();
        } catch (Exception e) {
            return util.TratarErro(e.getMessage(), e);
        }

    }
}
