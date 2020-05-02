package br.com.natheuscalaca.timemaluco.service;

import br.com.natheuscalaca.timemaluco.model.Endereco;
import br.com.natheuscalaca.timemaluco.model.Telefone;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Map.Entry;

@ApplicationScoped
public class EnderecosServices {

    /**
     * atualiza os dados de endereco
     *
     * @param id do endereço para atualizar
     * @param endereco objeto de endereço para atualizar
     * @return telefone atualizado
     */
    @Transactional
    public Endereco update(Long id, @Valid Endereco endereco) {

        Endereco enderecoDB = Endereco.findById(id);
        enderecoDB.setCep(endereco.getCep());
        enderecoDB.setLogradouro(endereco.getLogradouro());
        enderecoDB.setNumero(endereco.getNumero());
        enderecoDB.setComplemento(endereco.getComplemento());
        enderecoDB.setBairro(endereco.getBairro());
        enderecoDB.setCidade(endereco.getCidade());
        enderecoDB.setEstado(endereco.getEstado());
        enderecoDB.setPais(endereco.getPais());
        enderecoDB.setTipo(endereco.getTipo());

        return enderecoDB;
    }

}
