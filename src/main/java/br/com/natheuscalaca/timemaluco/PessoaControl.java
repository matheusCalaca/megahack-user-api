package br.com.natheuscalaca.timemaluco;

import br.com.natheuscalaca.timemaluco.model.Perfil;
import br.com.natheuscalaca.timemaluco.model.Pessoa;
import br.com.natheuscalaca.timemaluco.service.PessoaService;
import br.com.natheuscalaca.timemaluco.utill.Util;
import org.apache.http.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

}
