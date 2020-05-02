package br.com.natheuscalaca.timemaluco.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "EMPRESA")
public class Empresa extends PanacheEntity {

    @NotNull(message = "Nome não pode ser NUll")
    @NotBlank(message = "Nome não pode ser Vazio")
    @Column(name = "EMPRESA_NOME")
    private String nome;

    @NotNull(message = "CNPJ não pode ser NUll")
    @NotBlank(message = "CNPJ não pode ser Vazio")
    @Column(name = "EMPRESA_CNPJ")
    private String cnpj;

    @Column(name = "EMPRESA_RAZAOSOCIAL")
    private String razaoSocial;

    @Column(name = "EMPRESA_REGISTORCOMERCIAL")
    private String registorComercial;

    @NotNull(message = "Nome Fantasia não pode ser NUll")
    @NotBlank(message = "Nome Fantasia não pode ser Vazio")
    @Column(name = "EMPRESA_NOME_FANTASIA")
    private String nomeFantasia;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMEPRESA_ENDERECO_ID")
    private List<Endereco> enderecos;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMEPRESA_TELEFONE_ID")
    private List<Telefone> telefones;

    @NotNull(message = "e-mail não pode ser NUll")
    @NotBlank(message = "e-mail não pode ser Vazio")
    @Column(name = "EMEPRESA_EMAIL")
    private String email;

    @Column(name = "EMPRESA_ATIVIDADE_ECONOMICA")
    private String atividadeEconomica;

    @Column(name = "EMPRESA_QT_FUNCIONARIOS")
    private String qtFuncionarios;

    public static Empresa saveAndReturn(Empresa empresa) {
        persist(empresa);
        Empresa empresaSalve = find("EMPRESA_CNPJ", empresa.getCnpj()).firstResult();
        return empresaSalve;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String CNPJ) {
        this.cnpj = CNPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRegistorComercial() {
        return registorComercial;
    }

    public void setRegistorComercial(String registorComercial) {
        this.registorComercial = registorComercial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAtividadeEconomica() {
        return atividadeEconomica;
    }

    public void setAtividadeEconomica(String atividadeEconomica) {
        this.atividadeEconomica = atividadeEconomica;
    }

    public String getQtFuncionarios() {
        return qtFuncionarios;
    }

    public void setQtFuncionarios(String qtFuncionarios) {
        this.qtFuncionarios = qtFuncionarios;
    }
}
