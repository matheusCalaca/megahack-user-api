package br.com.natheuscalaca.timemaluco.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco extends PanacheEntity {

    @Column(name = "ENDERECO_CEP")
    private String cep;
    @Column(name = "ENDERECO_LOGRADOUR")
    private String logradouro;
    @Column(name = "ENDERECO_NUMERO")
    private String numero;
    @Column(name = "ENDERECO_COMPLEMEN")
    private String complemento;
    @Column(name = "ENDERECO_BAIRRO")
    private String bairro;
    @Column(name = "ENDERECO_CIDADE")
    private String cidade;
    @Column(name = "ENDERECO_ESTADO")
    private String estado;
    @Column(name = "ENDERECO_PAIS")
    private String pais;


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
