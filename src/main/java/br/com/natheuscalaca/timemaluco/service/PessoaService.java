package br.com.natheuscalaca.timemaluco.service;

import br.com.natheuscalaca.timemaluco.model.Perfil;
import br.com.natheuscalaca.timemaluco.model.Pessoa;
import br.com.natheuscalaca.timemaluco.utill.Util;
import br.com.natheuscalaca.timemaluco.utill.model.Filtro;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    private static final Logger LOGGER = Logger.getLogger(PessoaService.class);

    /**
     * Faz o Cadastro de Pessoas para o site
     *
     *
     * @param pessoa cadastrada no site
     * @return perfil salvo
     */
    @Transactional
    public Pessoa cadastrar(@Valid Pessoa pessoa) {
        //validar
            // remover mascara de cpf
            // CPF obrigatorio
            // Data de Nascimento menor que a data atual (Vai ser permitido somente para maiores de idade)
            // cidade, bairro, cep, estado, pais, logradouro obrigatorio caso tenha endereço
            // perfil tem que ser um ja existente, colocar na entidade para não adicionar
            // tipo upper case (verificar se coloca um enum com os tipos ja existentes)




        //salvar no BD
        return Pessoa.saveAndReturn(pessoa);
    }


}
