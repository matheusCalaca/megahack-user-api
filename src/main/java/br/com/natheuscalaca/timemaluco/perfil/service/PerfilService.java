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
        // upper case para o nome do perfil
        perfil.setNome(perfil.getNome().toUpperCase());

        //salvar no BD

        Perfil.persist(perfil);

        return perfil;
    }
}
