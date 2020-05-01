package br.com.natheuscalaca.timemaluco.perfil.service;

import br.com.natheuscalaca.timemaluco.perfil.model.Perfil;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

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
        // validar os perfils
        // se perfil ja existir return error
        // se a cor não for em hexadeimal retorna erros
        // nome do perfil não pode ser null
        // cor não pode ser null

        // upper case para o nome do perfil
        perfil.setNome(perfil.getNome().toUpperCase());


        //salvar no BD
        try {
            Perfil.persist(perfil);
        } catch (Exception e) {
            PerfilService.LOGGER.error(e.getMessage(),
                    e);
            return null;
        }
        // verificar se foi salvo

        return perfil;
    }
}
