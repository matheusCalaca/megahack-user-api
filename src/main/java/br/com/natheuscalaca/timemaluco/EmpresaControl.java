package br.com.natheuscalaca.timemaluco;

import br.com.natheuscalaca.timemaluco.model.Empresa;
import br.com.natheuscalaca.timemaluco.model.Pessoa;
import br.com.natheuscalaca.timemaluco.service.EmpresaService;
import br.com.natheuscalaca.timemaluco.service.PessoaService;
import br.com.natheuscalaca.timemaluco.utill.Util;
import br.com.natheuscalaca.timemaluco.utill.model.Filtro;
import org.apache.http.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/empresa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpresaControl {

@Inject
private EmpresaService empresaService;

    @GET
    public Response teste() {
        return Response.ok("TESTE").build();
    }

    @POST
    public Response cadastrar(Empresa empresa) {
        try {
            Empresa cadastro = empresaService.cadastrar(empresa);
            return Response.ok(cadastro).status(HttpStatus.SC_CREATED).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Empresa empresa) {
        try {
            Empresa cadastrado = empresaService.update(id, empresa);
            return Response.ok(cadastrado).status(HttpStatus.SC_OK).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }
    }

    @POST
    @Path("/busca")
    public Response buscar(Filtro filtro, @QueryParam("size") Integer size, @QueryParam("page") Integer page) {
        try {
            List<Empresa> empresas = empresaService.buscar(size, page, filtro);
            return Response.ok(empresas).status(HttpStatus.SC_OK).build();
        } catch (Exception e) {
            return Util.TRATARERRO(e.getMessage(), e);
        }
    }

}
