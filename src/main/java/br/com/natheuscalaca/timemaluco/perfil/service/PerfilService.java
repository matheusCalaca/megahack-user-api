package br.com.natheuscalaca.timemaluco.perfil.service;

import br.com.natheuscalaca.timemaluco.perfil.model.Perfil;
import br.com.natheuscalaca.timemaluco.utill.model.Filtro;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PerfilService {

    private static final Logger LOGGER = Logger.getLogger(PerfilService.class);

    /**
     * Faz o Cadastro de prefil
     *
     * @param perfil de interação do usuario
     * @return perfil salvo
     */
    @Transactional
    public Perfil cadastrar(@Valid Perfil perfil) {
        // upper case para o nome do perfil
        perfil.setNome(perfil.getNome().toUpperCase());

        //salvar no BD
        return Perfil.saveAndReturn(perfil);
    }

    /**
     * deleta o perfil pelo ID
     *
     * @param id id do perfil
     */
    @Transactional
    public void delete(Long id) {
        boolean isDelete = Perfil.deleteById(id);

        if (!isDelete) {
            Perfil perfil = Perfil.findById(id);
            if (perfil == null) {
                throw new IllegalArgumentException("Não foi localizado nenhum perfil para o ID: " + id);
            }
            throw new RuntimeException("Falha ao deletar o Perfil de ID" + id);
        }

    }

    /**
     * atualiza o perfil
     *
     * @param id
     * @param perfil
     * @return
     */
    @Transactional
    public Perfil update(Long id, @Valid Perfil perfil) {

        Perfil perfilBD = Perfil.findById(id);
        // valida se perfil e null
        //uppercase para nome


        perfilBD.setNome(perfil.getNome().toUpperCase());
        perfilBD.setCor(perfil.getCor());

        return perfilBD;

    }

    public List<Perfil> buscar(Integer size, Integer page, Filtro filtro) {

        PanacheQuery<Perfil> panacheQuery = null;


        String sort = orderByString(filtro);

        StringBuilder sql = sqlFiltro(filtro);

        String sqlFilter = sql.toString();
        panacheQuery = Perfil.find(sqlFilter + " " + sort, filtro.getFilter());


        int init = 0;
        if (page != 0) {
            init = (page * size) - 1;
        }
        panacheQuery.page(init, size);


        ArrayList<String> strings = new ArrayList<>();
        strings.add("nome");
        strings.add("cor");
        List<Perfil> perfils = panacheQuery.list();


        return perfils;
    }

    private StringBuilder sqlFiltro(Filtro filtro) {
        StringBuilder sql = new StringBuilder();
        sql.append(" 1 = 1");
        if (filtro.getFilter() != null) {
            filtro.getFilter().forEach((k, v) -> {
                sql.append("and " + k.trim() + " = :" + k.trim() + " ");
            });
        }
        return sql;
    }

    private String orderByString(Filtro filtro) {
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
