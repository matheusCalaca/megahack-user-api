package br.com.natheuscalaca.timemaluco;

import br.com.natheuscalaca.timemaluco.model.Perfil;
import br.com.natheuscalaca.timemaluco.service.PerfilService;
import br.com.natheuscalaca.timemaluco.utill.Util;
import br.com.natheuscalaca.timemaluco.utill.model.Filtro;
import org.apache.http.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/perfil")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilControl {

    @Inject
    private PerfilService perfilService;

    @GET
    public Response teste() {
        return Response.ok("TESTE").build();
    }


    @POST
    @Path("/busca")
    public Response buscar(Filtro filtro, @QueryParam("size") Integer size, @QueryParam("page") Integer page) {
        try {
            List<Perfil> perfils = perfilService.buscar(size, page, filtro);
            return Response.ok(perfils).status(HttpStatus.SC_OK).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }
    }

    @POST
    public Response cadastrar(Perfil perfil) {
        try {
            Perfil cadastro = perfilService.cadastrar(perfil);
            return Response.ok(cadastro).status(HttpStatus.SC_CREATED).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            perfilService.delete(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Perfil perfil) {
        try {
            Perfil cadastrado = perfilService.update(id, perfil);
            return Response.ok(cadastrado).status(HttpStatus.SC_OK).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }
    }
}
