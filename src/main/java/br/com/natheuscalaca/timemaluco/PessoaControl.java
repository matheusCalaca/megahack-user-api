package br.com.natheuscalaca.timemaluco;

import br.com.natheuscalaca.timemaluco.model.Perfil;
import br.com.natheuscalaca.timemaluco.model.Pessoa;
import br.com.natheuscalaca.timemaluco.service.PessoaService;
import br.com.natheuscalaca.timemaluco.utill.Util;
import br.com.natheuscalaca.timemaluco.utill.model.Filtro;
import org.apache.http.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaControl {

@Inject
private PessoaService pessoaService;

    @GET
    public Response teste() {
        return Response.ok("TESTE").build();
    }

    @POST
    public Response cadastrar(Pessoa pessoa) {
        try {
            Pessoa cadastro = pessoaService.cadastrar(pessoa);
            return Response.ok(cadastro).status(HttpStatus.SC_CREATED).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Pessoa pessoa) {
        try {
            Pessoa cadastrado = pessoaService.update(id, pessoa);
            return Response.ok(cadastrado).status(HttpStatus.SC_OK).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }
    }

    @POST
    @Path("/busca")
    public Response buscar(Filtro filtro, @QueryParam("size") Integer size, @QueryParam("page") Integer page) {
        try {
            List<Pessoa> pessoas = pessoaService.buscar(size, page, filtro);
            return Response.ok(pessoas).status(HttpStatus.SC_OK).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        try {
            pessoaService.delete(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }
    }

}
