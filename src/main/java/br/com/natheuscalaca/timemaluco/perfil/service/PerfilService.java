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
     *  atualiza o perfil
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
}
