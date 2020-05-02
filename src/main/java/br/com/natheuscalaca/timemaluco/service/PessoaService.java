package br.com.natheuscalaca.timemaluco.service;

import br.com.natheuscalaca.timemaluco.model.Endereco;
import br.com.natheuscalaca.timemaluco.model.Perfil;
import br.com.natheuscalaca.timemaluco.model.Pessoa;
import br.com.natheuscalaca.timemaluco.model.Telefone;
import br.com.natheuscalaca.timemaluco.utill.Util;
import br.com.natheuscalaca.timemaluco.utill.model.Filtro;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    private static final Logger LOGGER = Logger.getLogger(PessoaService.class);

    @Inject
    private TelefoneServices telefoneServices;

    @Inject
    private EnderecosServices enderecosServices;

    /**
     * Faz o Cadastro de Pessoas para o site
     *
     * @param pessoa cadastrada no site
     * @return perfil salvo
     */
    @Transactional
    public Pessoa cadastrar(@Valid Pessoa pessoa) {
        pessoa.setCpf(pessoa.getCpf().trim().replaceAll("[.-]", ""));
        //TODO:
        //validar
        // perfil tem que ser um ja existente, colocar na entidade para não adicionar
        // tipo upper case (verificar se coloca um enum com os tipos ja existentes)

        //salvar no BD
        return Pessoa.saveAndReturn(pessoa);
    }


    /**
     * atualiza o Pessoa
     *
     * @param id     da pessoa para atualizar
     * @param pessoa
     * @return
     */
    @Transactional
    public Pessoa update(Long id, @Valid Pessoa pessoa) {

        Pessoa pessoaBD = Pessoa.findById(id);

        pessoaBD.setNome(pessoa.getNome());
        pessoaBD.setSobreNome(pessoa.getSobreNome());
        pessoaBD.setCpf(pessoa.getCpf());
        pessoaBD.setDataNascimento(pessoa.getDataNascimento());
        pessoaBD.setRg(pessoa.getRg());
        pessoaBD.setEmail(pessoa.getEmail());
        pessoaBD.setPerfils(pessoa.getPerfils());
        pessoaBD.setLinkedin(pessoa.getLinkedin());
        pessoaBD.setSitePessoal(pessoa.getSitePessoal());

        List<Telefone> telefones = new ArrayList<>();
        for (int i = 0; i < pessoa.getTelefones().size(); i++) {
            Telefone update = telefoneServices.update(pessoa.getTelefones().get(i).id, pessoa.getTelefones().get(i));
            telefones.add(update);
        }
        pessoaBD.setTelefones(telefones);

        List<Endereco> enderecos = new ArrayList<>();
        for (int i = 0; i < pessoa.getEnderecos().size(); i++) {
            Endereco update = enderecosServices.update(pessoa.getEnderecos().get(i).id, pessoa.getEnderecos().get(i));
            enderecos.add(update);
        }
        pessoaBD.setEnderecos(enderecos);

        return pessoaBD;

    }

    /**
     *  faz a busca com base o obejeto de filtro
     * @param size tamanho que ira retornar
     * @param page inicio do retorno
     * @param filtro filtros nome da entidade
     * @return List<Pessoa> retorna a lista de Pessoa
     */
    public List<Pessoa> buscar(Integer size, Integer page, Filtro filtro) {

        PanacheQuery<Pessoa> panacheQuery = null;

        String sort = Util.ORDER_BY_STRING(filtro);
        String sqlFilter = Util.SQL_FILTRO(filtro);

        panacheQuery = Pessoa.find(sqlFilter + " " + sort, filtro.getFilter());

        int init = 0;
        if (page != 0) {
            init = (page * size) - 1;
        }
        panacheQuery.page(init, size);
        List<Pessoa> pessoas = panacheQuery.list();

        return pessoas;
    }

    /**
     * deleta a pessoa pelo ID
     *
     * @param id id da pessoa
     */
    @Transactional
    public void delete(Long id) {
        boolean isDelete = Pessoa.deleteById(id);

        if (!isDelete) {
            Pessoa pessoa = Pessoa.findById(id);
            if (pessoa == null) {
                throw new IllegalArgumentException("Não foi localizado nenhuma pessoa para o ID: " + id);
            }
            throw new RuntimeException("Falha ao deletar a pessoa de ID" + id);
        }

    }
}
