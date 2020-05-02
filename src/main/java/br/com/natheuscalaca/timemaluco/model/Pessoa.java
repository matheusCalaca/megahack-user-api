package br.com.natheuscalaca.timemaluco.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PESSOA")
public class Pessoa extends PanacheEntity {

    @Column(name = "PESSOA_NOME")
    private String nome;
    @Column(name = "PESSOA_SOBRENOME")
    private String sobreNome;
    @Column(name = "PESSOA_CPF")
    private String cpf;
    @Column(name = "PESSOA_DATANASCIMENTO")
    private Date dataNascimento;
    @Column(name = "PESSOA_RG")
    private String rg;
    @OneToMany
    @Column(name = "PESSOA_ENDERECOS")
    private List<Endereco> enderecos;
    @OneToMany
    @Column(name = "PESSOA_TELEFONES")
    private List<Telefone> telefones;
    @Column(name = "PESSOA_EMAIL")
    private String email;
    @ManyToOne
    @Column(name = "PESSOA_PERFILS")
    private Perfil perfils;
    @Column(name = "PESSOA_LINKEDIN")
    private String linkedin;
    @Column(name = "PESSOA_SITEPESSOAL")
    private String sitePessoal;


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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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
