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
    @Column(name = "EMPRENOMESA_NOME")
    private String Nome;

    @NotNull(message = "CNPJ não pode ser NUll")
    @NotBlank(message = "CNPJ não pode ser Vazio")
    @Column(name = "EMPRECNPJSA_CNPJ")
    private String CNPJ;

    @Column(name = "EMPRESA_RAZAOSOCIAL")
    private String RazaoSocial;

    @Column(name = "EMPRESA_REGISTORCOMERCIAL")
    private String RegistorComercial;

    @NotNull(message = "Nome Fantasia não pode ser NUll")
    @NotBlank(message = "Nome Fantasia não pode ser Vazio")
    @Column(name = "EMPRESA_NOME_FANTASIA")
    private String NomeFantasia;

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
    private String AtividadeEconomica;

    @Column(name = "EMPRESA_QT_FUNCIONARIOS")
    private String qtFuncionarios;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        RazaoSocial = razaoSocial;
    }

    public String getRegistorComercial() {
        return RegistorComercial;
    }

    public void setRegistorComercial(String registorComercial) {
        RegistorComercial = registorComercial;
    }

    public String getNomeFantasia() {
        return NomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        NomeFantasia = nomeFantasia;
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
        return AtividadeEconomica;
    }

    public void setAtividadeEconomica(String atividadeEconomica) {
        AtividadeEconomica = atividadeEconomica;
    }

    public String getQtFuncionarios() {
        return qtFuncionarios;
    }

    public void setQtFuncionarios(String qtFuncionarios) {
        this.qtFuncionarios = qtFuncionarios;
    }
}
