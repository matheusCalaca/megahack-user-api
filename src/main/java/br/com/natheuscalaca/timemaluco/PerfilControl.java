package br.com.natheuscalaca.timemaluco;

import br.com.natheuscalaca.timemaluco.perfil.model.Perfil;
import br.com.natheuscalaca.timemaluco.perfil.service.PerfilService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilControl {

    @Inject
    private PerfilService perfilService;

    @GET
    public String hello() {
        return "{ \"hello\":0}";
    }

    @POST
    public Perfil cadastrar(Perfil perfil) {
        System.out.println(perfil);
        perfilService.cadastrar(perfil);
        return perfil;
    }
}
