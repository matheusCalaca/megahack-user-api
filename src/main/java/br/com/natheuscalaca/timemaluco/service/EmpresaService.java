package br.com.natheuscalaca.timemaluco.service;

import br.com.natheuscalaca.timemaluco.model.Endereco;
import br.com.natheuscalaca.timemaluco.model.Empresa;
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
public class EmpresaService {

    private static final Logger LOGGER = Logger.getLogger(EmpresaService.class);

    @Inject
    private TelefoneServices telefoneServices;

    @Inject
    private EnderecosServices enderecosServices;

    /**
     * Faz o Cadastro de Empresa para o site
     *
     * @param empresa cadastrada no site
     * @return perfil salvo
     */
    @Transactional
    public Empresa cadastrar(@Valid Empresa empresa) {
        empresa.setCnpj(empresa.getCnpj().trim().replaceAll("[.-]", ""));
        //TODO:
        //validar
        // perfil tem que ser um ja existente, colocar na entidade para não adicionar
        // tipo upper case (verificar se coloca um enum com os tipos ja existentes)

        //salvar no BD
        return Empresa.saveAndReturn(empresa);
    }


    /**
     * atualiza o Empresa
     *
     * @param id     da empresa para atualizar
     * @param empresa
     * @return
     */
    @Transactional
    public Empresa update(Long id, @Valid Empresa empresa) {

        Empresa empresaBD = Empresa.findById(id);

        empresaBD.setNome(empresa.getNome());
        empresaBD.setCnpj(empresa.getCnpj());
        empresaBD.setRazaoSocial(empresa.getRazaoSocial());
        empresaBD.setRegistorComercial(empresa.getRegistorComercial());
        empresaBD.setNomeFantasia(empresa.getNomeFantasia());
        empresaBD.setEmail(empresa.getEmail());
        empresaBD.setAtividadeEconomica(empresa.getAtividadeEconomica());
        empresaBD.setQtFuncionarios(empresa.getQtFuncionarios());

        List<Telefone> telefones = new ArrayList<>();
        for (int i = 0; i < empresa.getTelefones().size(); i++) {
            Telefone update = telefoneServices.update(empresa.getTelefones().get(i).id, empresa.getTelefones().get(i));
            telefones.add(update);
        }
        empresaBD.setTelefones(telefones);

        List<Endereco> enderecos = new ArrayList<>();
        for (int i = 0; i < empresa.getEnderecos().size(); i++) {
            Endereco update = enderecosServices.update(empresa.getEnderecos().get(i).id, empresa.getEnderecos().get(i));
            enderecos.add(update);
        }
        empresaBD.setEnderecos(enderecos);

        return empresaBD;

    }

    /**
     *  faz a busca com base o obejeto de filtro
     * @param size tamanho que ira retornar
     * @param page inicio do retorno
     * @param filtro filtros nome da entidade
     * @return List<Empresa> retorna a lista de Empresa
     */
    public List<Empresa> buscar(Integer size, Integer page, Filtro filtro) {

        PanacheQuery<Empresa> panacheQuery = null;

        String sort = Util.ORDER_BY_STRING(filtro);
        String sqlFilter = Util.SQL_FILTRO(filtro);

        panacheQuery = Empresa.find(sqlFilter + " " + sort, filtro.getFilter());

        int init = 0;
        if (page != 0) {
            init = (page * size) - 1;
        }
        panacheQuery.page(init, size);
        List<Empresa> empresas = panacheQuery.list();

        return empresas;
    }
}
