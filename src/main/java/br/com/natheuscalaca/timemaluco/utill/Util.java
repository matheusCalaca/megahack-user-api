package br.com.natheuscalaca.timemaluco.utill;

import org.apache.http.HttpStatus;

import javax.ws.rs.core.Response;

public class Util {
    /**
     * Fazer a tratativa dos erros e retorna a menssagem
     * @param msg messagem de erro
     * @param e exception
     * @return Response com 422
     */
    public Response TratarErro(String msg, Exception e){
        return Response.ok(msg).status(HttpStatus.SC_UNPROCESSABLE_ENTITY).build();
    }
}
