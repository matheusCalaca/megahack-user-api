package br.com.natheuscalaca.timemaluco.perfil.service;

import br.com.natheuscalaca.timemaluco.perfil.model.Perfil;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
public class PerfilService {

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

        //salvar no BD
        Perfil.persist(perfil);

        // verificar se foi salvo

        return perfil;
    }
}
