package br.com.natheuscalaca.timemaluco.service;

import br.com.natheuscalaca.timemaluco.model.Perfil;
import br.com.natheuscalaca.timemaluco.model.Pessoa;
import br.com.natheuscalaca.timemaluco.model.Telefone;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

@ApplicationScoped
public class TelefoneServices {

    /**
     * atualiza os dados de Telefone
     *
     * @param id do telefone para atualizar
     * @param telefone objeto de telefone para atualizar
     * @return telefone atualizado
     */
    @Transactional
    public Telefone update(Long id, @Valid Telefone telefone) {

        Telefone telefoneBD = Telefone.findById(id);

        telefoneBD.setDdd(telefone.getDdd());
        telefoneBD.setNumero(telefone.getNumero());
        telefoneBD.setTipo(telefone.getTipo());


        return telefoneBD;

    }

}
