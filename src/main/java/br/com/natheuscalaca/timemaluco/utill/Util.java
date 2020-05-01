package br.com.natheuscalaca.timemaluco.utill;

import br.com.natheuscalaca.timemaluco.utill.model.Filtro;
import org.apache.http.HttpStatus;

import javax.ws.rs.core.Response;

public final class Util {
    /**
     * Fazer a tratativa dos erros e retorna a menssagem
     * @param msg messagem de erro
     * @param e exception
     * @return Response com 422
     */
    public static Response TRATARERRO(String msg, Exception e){
        e.printStackTrace();
        return Response.ok(new Error(msg)).status(HttpStatus.SC_UNPROCESSABLE_ENTITY).build();
    }

    /**
     * filtro gera o sql para o filtro
     * @param filtro objeto para filtrar
     * @return string com o filtro
     */
    public static String SQL_FILTRO(Filtro filtro) {
        StringBuilder sql = new StringBuilder();
        sql.append(" 1 = 1");
        if (filtro.getFilter() != null) {
            filtro.getFilter().forEach((k, v) -> {
                sql.append("and " + k.trim() + " = :" + k.trim() + " ");
            });
        }
        return sql.toString();
    }



    /**
     * gera estrutura de string order by
     *
     * @param filtro filtro sql
     * @return string para retorno order by
     */
    public static String ORDER_BY_STRING(Filtro filtro) {
        StringBuilder sort = new StringBuilder();
        if (filtro.getSort() != null) {
            for (int i = 0; i < filtro.getSort().size(); i++) {
                if (i == 0) {
                    sort.append("order by " + filtro.getSort().get(i).trim() + " ");
                } else {
                    sort.append(", " + filtro.getSort().get(i).trim() + " ");
                }
            }
        }
        return sort.toString();
    }
}
