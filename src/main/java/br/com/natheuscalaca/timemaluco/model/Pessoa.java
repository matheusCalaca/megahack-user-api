package br.com.natheuscalaca.timemaluco.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PESSOA")
public class Pessoa extends PanacheEntity {
    @NotNull(message = "Nome não pode ser NUll")
    @NotBlank(message = "Nome não pode ser Vazio")
    @Column(name = "PESSOA_NOME")
    private String nome;

    @Column(name = "PESSOA_SOBRENOME")
    private String sobreNome;

    @NotNull(message = "CPF não pode ser NUll")
    @NotBlank(message = "CPF não pode ser Vazio")
    @Column(name = "PESSOA_CPF", unique = true)
    private String cpf;

    @Column(name = "PESSOA_DATANASCIMENTO")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @Column(name = "PESSOA_RG")
    private String rg;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PESSOA_ENDERECO_ID")
    private List<Endereco> enderecos;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PESSOA_TELEFONE_ID")
    private List<Telefone> telefones;

    @NotNull(message = "e-mail não pode ser NUll")
    @NotBlank(message = "e-mail não pode ser Vazio")
    @Column(name = "PESSOA_EMAIL", unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "PESSOA_PERFIL_ID")
    private Perfil perfils;

    @Column(name = "PESSOA_LINKEDIN")
    private String linkedin;

    @Column(name = "PESSOA_SITEPESSOAL")
    private String sitePessoal;

    public static Pessoa saveAndReturn(Pessoa pessoa) {
        persist(pessoa);
        Pessoa pessoaSalve = find("PESSOA_CPF", pessoa.cpf).firstResult();
        return pessoaSalve;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public Perfil getPerfils() {
        return perfils;
    }

    public void setPerfils(Perfil perfils) {
        this.perfils = perfils;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getSitePessoal() {
        return sitePessoal;
    }

    public void setSitePessoal(String sitePessoal) {
        this.sitePessoal = sitePessoal;
    }
}
